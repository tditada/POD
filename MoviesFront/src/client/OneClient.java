package client;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;

import model.ActorCount;
import model.ModelObject;
import model.PopularMetascoreMovie;
import service.ModelObjectReader;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.mapreduce.Job;
import com.hazelcast.mapreduce.JobCompletableFuture;
import com.hazelcast.mapreduce.JobTracker;
import com.hazelcast.mapreduce.KeyValueSource;

import core.CoupleActorsCollator;
import core.CoupleActorsMapper;
import core.CoupleActorsReducer;
import core.DirectorsFavoritesMapper;
import core.DirectorsFavoritesReducer;
import core.PopularActorsCollator;
import core.PopularActorsMapper;
import core.PopularActorsReducer;
import core.PopularMetascoreMapper;
import core.PopularMetascoreReducer;


public class OneClient {

	private static final String MAP_NAME = "first_query";
	
	private static int query = 0;
	private static int n = 0;
	private static int tope = 0;
	private static String path = null;

	public static void main(String[] args) throws InterruptedException, ExecutionException 
	{
		String name= System.getProperty("name");
		String pass= System.getProperty("pass");
		if (pass == null)
		{
			pass="dev-pass";
		}
		System.out.println(String.format("Connecting with cluster dev-name [%s]", name));

		ClientConfig ccfg= new ClientConfig();
		ccfg.getGroupConfig().setName(name).setPassword(pass);

		String addresses= System.getProperty("addresses");
		if (addresses != null)
		{		
			String[] arrayAddresses= addresses.split("[,;]");
			ClientNetworkConfig net= new ClientNetworkConfig();
			net.addAddress(arrayAddresses);
			ccfg.setNetworkConfig(net);
		}
		HazelcastInstance client = HazelcastClient.newHazelcastClient(ccfg);


		System.out.println(client.getCluster() );

		// Lectura de parametros de entrada
		if (!parseParameters(args)) {
			return;
		}

		// Preparar la particion de datos y distribuirla en el cluster a trav�s del IMap
		IMap<String, ModelObject> myMap = client.getMap(MAP_NAME);

		try 
		{
			ModelObjectReader.readModelObject(myMap, path);
		} 
		catch (Exception e) 
		{
			throw new RuntimeException(e);
		}

		// Ahora el JobTracker y los Workers!
		JobTracker tracker = client.getJobTracker("default");

		// Ahora el Job desde los pares(key, Value) que precisa MapReduce
		KeyValueSource<String, ModelObject> source = KeyValueSource.fromMap(myMap);
		Job<String, ModelObject> job = tracker.newJob(source);

		// Orquestacion de Jobs y lanzamiento
		long inicio = System.currentTimeMillis();
		System.out.println("Inicio del trabajo map/reduce: " + String.valueOf(inicio));
		if (query == 1) {
			executeFirstQuery(job);
		} else if (query == 2) {
			executeSecondQuery(job);
		} else if (query == 3) {
			executeThirdQuery(job);
		} else if (query == 4) {
			executeFourthQuery(job);
		}
		long fin = System.currentTimeMillis();
		System.out.println("Fin del trabajo map/reduce: " + String.valueOf(fin));
		System.out.println("Tiempo del trabajo map/reduce: " + String.valueOf(fin - inicio));
		System.exit(0);
	}
	
	private static void executeFirstQuery(Job<String, ModelObject> job) 
			throws InterruptedException, ExecutionException {
		JobCompletableFuture<List<String>> future = job 
				.mapper(new PopularActorsMapper()) 
				.reducer(new PopularActorsReducer())
				.submit(new PopularActorsCollator(n)); //aca metemos new collator 

		List<String> l  = future.get();
		for (String s: l) {
			System.out.println(s);
			System.out.println('\n');
		}
	}
	
	private static void executeSecondQuery(Job<String, ModelObject> job) 
			throws InterruptedException, ExecutionException {
		JobCompletableFuture<Map<Integer, PopularMetascoreMovie>> future = job
				.mapper(new PopularMetascoreMapper(tope))
				.reducer(new PopularMetascoreReducer())
				.submit();

		Map<Integer, PopularMetascoreMovie> rta = future.get();
		for (Entry<Integer, PopularMetascoreMovie> e : rta.entrySet()) {
			System.out.println(String.format("Year %d =>  %s",
					e.getKey(), e.getValue() ));
		}
	}
	
	private static void executeThirdQuery(Job<String, ModelObject> job) 
			throws InterruptedException, ExecutionException {
		JobCompletableFuture<List<String>> future = job
				.mapper(new CoupleActorsMapper())
				.reducer(new CoupleActorsReducer())
				.submit(new CoupleActorsCollator());
		List<String> l  = future.get();
		for (String s: l) {
			System.out.println(s);
			System.out.println('\n');
		}
	}
	
	private static void executeFourthQuery(Job<String, ModelObject> job) 
			throws InterruptedException, ExecutionException {
		JobCompletableFuture<Map<String, ActorCount>> future = job
				.mapper(new DirectorsFavoritesMapper())
				.reducer(new DirectorsFavoritesReducer())
				.submit();

		Map<String, ActorCount> rta = future.get();
		for (Entry<String, ActorCount> e : rta.entrySet()) {
			System.out.println(String.format("Director %s =>  %s",
					e.getKey(), e.getValue() ));
		}
	}
	
	private static boolean parseComand(String s, String comand, String errorMessage) {
		if (!s.equals(comand)) {
			System.out.println(errorMessage);
			return false;
		}
		return true;
	}
	
	private static boolean parseParameters(String[] args) {
		if (args.length < 2) {
			System.out.println("missing params");
			return false;
		}
		String firstParam = args[0];
		List<String> comandQuery = Arrays.asList(firstParam.split("="));
		if (!parseComand(comandQuery.get(0), "query", "invalid first param"))
			return false;
		try {
			query = Integer.valueOf(comandQuery.get(1));
			if (query < 1 || query > 4) {
				System.out.println("invalid param query");
				return false;
			}
		} catch (NumberFormatException e) {
			System.out.println("invalid param query");
			return false;
		}
		String secondParam = args[1];
		List<String> comandSecondParam = Arrays.asList(secondParam.split("="));
		if (query == 1) {
			if (!parseComand(comandSecondParam.get(0), "n", "invalid second param"))
				return false;
			try {
				n = Integer.valueOf(comandSecondParam.get(1));
			} catch (NumberFormatException e) {
				System.out.println("invalid param N");
				return false;
			}
			String thirdParam = null;
			if (args.length != 3) {
				System.out.println("invalid params");
				return false;
			}
			thirdParam = args[2];
			List<String> comandThirdParam = Arrays.asList(thirdParam.split("="));
			if (!parseComand(comandThirdParam.get(0), "path", "invalid third param"))
				return false;
			path = comandThirdParam.get(1);
		} else if (query == 2) {
			if (!parseComand(comandSecondParam.get(0), "tope", "invalid second param"))
				return false;
			try {
				tope = Integer.valueOf(comandSecondParam.get(1));
			} catch (NumberFormatException e) {
				System.out.println("invalid param tope");
				return false;
			}
			String thirdParam = null;
			if (args.length != 3) {
				System.out.println("invalid params");
				return false;
			}
			thirdParam = args[2];
			List<String> comandThirdParam = Arrays.asList(thirdParam.split("="));
			if (!parseComand(comandThirdParam.get(0), "path", "invalid third param"))
				return false;
			path = comandThirdParam.get(1);
		} else {
			if (!parseComand(comandSecondParam.get(0), "path", "invalid second param"))
				return false;
			path = comandSecondParam.get(1);
		}
		
		if (args.length > 3) {
			System.out.println("invalid params");
			return false;
		}
		return true;
	}
	
	
}

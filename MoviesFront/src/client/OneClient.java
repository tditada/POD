package client;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;

import model.FormulaAvgTupla;
import model.ModelObject;
import model.Votacion;
import service.ModelObjectReader;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ICompletableFuture;
import com.hazelcast.core.IMap;
import com.hazelcast.mapreduce.Job;
import com.hazelcast.mapreduce.JobTracker;
import com.hazelcast.mapreduce.KeyValueSource;
import com.hazelcast.query.SqlPredicate;

import core.BasicMapper;
import core.BasicReducer;

public class OneClient {

	private static final String MAP_NAME = "first_query";

	public static void main(String[] args) throws InterruptedException, ExecutionException 
	{
//		String name= System.getProperty("name");
//		String pass= System.getProperty("pass");
//		if (pass == null)
//		{
//			pass="dev-pass";
//		}
//		System.out.println(String.format("Connecting with cluster dev-name [%s]", name));
//
//		String name = "52345-51021";
//		String pass ="dev-pass";
//		ClientConfig ccfg= new ClientConfig();
//		ccfg.getGroupConfig().setName(name).setPassword(pass);
//
//		// no hay descubrimiento automatico, 
//		// pero si no decimos nada intentar� usar LOCALHOST
//		String addresses= System.getProperty("addresses");
//		if (addresses != null)
//		{		
//			String[] arrayAddresses= addresses.split("[,;]");
//			ClientNetworkConfig net= new ClientNetworkConfig();
//			net.addAddress(arrayAddresses);
//			ccfg.setNetworkConfig(net);
//		}
//		HazelcastInstance client = HazelcastClient.newHazelcastClient(ccfg);
//
//
//		System.out.println(client.getCluster() );




//		// Preparar la particion de datos y distribuirla en el cluster a trav�s del IMap
//		IMap<String, ModelObject> myMap = client.getMap(MAP_NAME);

		try 
		{
			String filename = "";
			ModelObjectReader.readModelObject(filename);
		} 
		catch (Exception e) 
		{
			throw new RuntimeException(e);
		}

//
//		// Ahora el JobTracker y los Workers!
//		JobTracker tracker = client.getJobTracker("default");
//
//		// Ahora el Job desde los pares(key, Value) que precisa MapReduce
//		KeyValueSource<String, Votacion> source = KeyValueSource.fromMap(myMap);
//		Job<String, Votacion> job = tracker.newJob(source);
//
//		//		    // Orquestacion de Jobs y lanzamiento
//		ICompletableFuture<Map<String, FormulaAvgTupla>> future = job 
//				.mapper(new BasicMapper()) 
//				.reducer(new BasicReducer())
//				.submit(); //aca metemos new collator 
//
//		// Tomar resultado e Imprimirlo
//		Map<String, FormulaAvgTupla> rta = future.get();
//
//		for (Entry<String, FormulaAvgTupla> e : rta.entrySet()) 
//		{
//			System.out.println(String.format("Distrito %s => Ganador %s",
//					e.getKey(), e.getValue() ));
//		}
//
//
//		System.exit(0);

	}
}

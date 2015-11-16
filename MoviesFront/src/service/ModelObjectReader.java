package service;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.ModelObject;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.hazelcast.core.IMap;

public class ModelObjectReader {
	
	public static void readModelObject(IMap<String, ModelObject> theIMap, String filename) throws Exception
	{
		long inicio = System.currentTimeMillis();
		printTimestamp(inicio, "Inicio de la lectura del archivo: ");

		Gson sGson = new GsonBuilder()
					.serializeNulls()
					.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
					.registerTypeAdapter(ModelObject.class, new ModelObjectDeserializer())
					.create();

		JsonReader reader = new JsonReader(new FileReader(filename));
		
		Type listType = new TypeToken<ArrayList<ModelObject>>() {}.getType();
		
        List<ModelObject> modelObjectList = sGson.fromJson(reader, listType);
        
        for (ModelObject o : modelObjectList) {
        	if (o != null)
        		theIMap.set(o.getTitle(), o);
        }
        
		long fin = System.currentTimeMillis();
		printTimestamp(fin, "Fin de la lectura del archivo: ");
		System.out.println("Tiempo de lectura del archivo en milisegundos: " + String.valueOf(fin - inicio));
		System.out.println('\n');
	}

	private static void printTimestamp(long timestamp, String message) {
		Timestamp stamp = new Timestamp(timestamp);
		Date date = new Date(stamp.getTime());
		SimpleDateFormat output = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSSS");
		String formattedTime = output.format(date);
		System.out.println(message + formattedTime);
		System.out.println('\n');
	}
}

package service;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.ModelObject;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.hazelcast.core.IMap;

public class ModelObjectReader {
	
	//primer parametro IMap<String, ModelObject> theIMap, 
	public static void readModelObject(IMap<String, ModelObject> theIMap, String filename) throws Exception
	{
		long inicio = System.currentTimeMillis();
		System.out.println("Inicio de la lectura del archivo: " + String.valueOf(inicio));

		Gson sGson = new GsonBuilder()
					.serializeNulls()
					.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
					.registerTypeAdapter(ModelObject.class, new ModelObjectDeserializer())
					.create();

		JsonReader reader = new JsonReader(new FileReader(filename));
		
		Type listType = new TypeToken<ArrayList<ModelObject>>() {}.getType();
		
        List<ModelObject> modelObjectList = sGson.fromJson(reader, listType);
        modelObjectList.removeAll(Collections.singleton(null));
        
        //luego agregar cuando este el imap
        for (ModelObject o : modelObjectList) {
        	if (o != null)
        		theIMap.set(o.getTitle(), o);
        }
//
        
		long fin = System.currentTimeMillis();
		System.out.println("Fin de la lectura del archivo: " + String.valueOf(fin));
		System.out.println("Tiempo de lectura del archivo: " + String.valueOf(fin - inicio));
		//40k --> 187
		//200k --> 198
		//20 k --> 1036


//		ModelObject m = modelObjectList.get(0);
//        System.out.println(m.toString());
//        List<String> l = m.getActorsList();
//        
//        System.out.println("");
//        ModelObject m2 = modelObjectList.get(1);
//        System.out.println(m2.toString());
//        List<String> l1 =  m2.getActorsList();
//        
//        System.out.println("");
//        ModelObject m3 = modelObjectList.get(2);
//        System.out.println(m3.toString());
//        List<String> l2 = m3.getActorsList();
        
//        System.out.println(modelObjectList.get(33));
        
		
	}

}

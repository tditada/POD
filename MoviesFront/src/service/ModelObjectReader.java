package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.ModelObject;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class ModelObjectReader {
	
	//primer parametro IMap<String, ModelObject> theIMap, 
	public static void readModelObject(String filename) throws Exception
	{
		
		Gson sGson = new GsonBuilder()
					.serializeNulls()
					.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
					.registerTypeAdapter(ModelObject.class, new ModelObjectDeserializer())
					.create();

		JsonReader reader = new JsonReader(new FileReader("../resources/imdb-20K.json"));
		
		Type listType = new TypeToken<ArrayList<ModelObject>>() {}.getType();
		
        List<ModelObject> modelObjectList = sGson.fromJson(reader, listType);
        
        ModelObject m = modelObjectList.get(0);
        System.out.println(m.toString());
        
        System.out.println("");
        ModelObject m2 = modelObjectList.get(1);
        System.out.println(m2.toString());
        
        System.out.println("");
        ModelObject m3 = modelObjectList.get(2);
        System.out.println(m3.toString());
		
	}

}

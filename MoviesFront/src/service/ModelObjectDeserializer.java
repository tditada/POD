package service;

import java.lang.reflect.Type;

import model.ModelObject;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class ModelObjectDeserializer implements JsonDeserializer<ModelObject>{
	
	@Override
	public ModelObject deserialize(JsonElement json, Type typeofT,
			JsonDeserializationContext context) throws JsonParseException {
		
		final JsonObject jsonObject = json.getAsJsonObject();
//		JsonElement titleElement = jsonObject.get("Title");
		String title = jsonObject.get("Title").getAsString();
		
		
		ModelObject o = new ModelObject();
		o.setTitle(title);
		return o;
	}

}

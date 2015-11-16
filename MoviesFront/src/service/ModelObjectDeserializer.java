package service;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

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
		
		String type = jsonObject.get("Type").getAsString();
		if (type.equals(ModelObject.TYPE_SERIE)) {
			return null;
		}
		
		String title = jsonObject.get("Title").getAsString();
		
		Integer year = ModelObject.INVALID_YEAR;
		Integer startYear = ModelObject.INVALID_YEAR;
		Integer endYear = ModelObject.INVALID_YEAR;
		if (!jsonObject.get("Year").getAsString().equals(ModelObject.NOT_A_VALUE)) {
			try {
				year = jsonObject.get("Year").getAsInt();
			} catch (NumberFormatException e) {
				String s = jsonObject.get("Year").getAsString();
				List<String> yearList = Arrays.asList(s.split("–"));
				startYear = Integer.valueOf(yearList.get(0));
				if (yearList.size() == 2) {
					endYear = Integer.valueOf(yearList.get(1));
				}
			}
		}
		
		String director = jsonObject.get("Director").getAsString();
		String actors = jsonObject.get("Actors").getAsString();
		
		Double metascore = ModelObject.INVALID_METASCORE;
		if (!jsonObject.get("Metascore").getAsString().equals(ModelObject.NOT_A_VALUE)) {
			metascore = jsonObject.get("Metascore").getAsDouble();
		}
		
		Long imdbVotes = ModelObject.INVALID_IMDB_VOTES;
		if (!jsonObject.get("imdbVotes").getAsString().equals(ModelObject.NOT_A_VALUE)) {
			try {
				imdbVotes = jsonObject.get("imdbVotes").getAsLong();
			} catch (NumberFormatException e) {
				String s = jsonObject.get("imdbVotes").getAsString();
				List<String> numbers = Arrays.asList(s.split(","));
				Long aux = 0L;
				for (int i = 0; i < numbers.size(); i++) {
					int a = (int) Math.pow(1000.0, numbers.size() - 1.0 - i);
					aux += Long.valueOf(numbers.get(i)) * Long.valueOf(a);
				}
				imdbVotes = aux;
			}
		}
		
		ModelObject o = new ModelObject(title,
				year,
				startYear,
				endYear,
				director,
				actors,
				metascore,
				imdbVotes,
				type);
		return o;
	}

}

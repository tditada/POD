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
		
		String title = jsonObject.get("Title").getAsString();
		
		Integer startYear = ModelObject.INVALID_YEAR;
		Integer endYear = ModelObject.INVALID_YEAR;
		if (!jsonObject.get("Year").getAsString().equals(ModelObject.NOT_A_VALUE)) {
			try {
				startYear = jsonObject.get("Year").getAsInt();
			} catch (NumberFormatException e) {
				String s = jsonObject.get("Year").getAsString();
				List<String> yearList = Arrays.asList(s.split("–"));
				startYear = Integer.valueOf(yearList.get(0));
				if (yearList.size() == 2) {
					endYear = Integer.valueOf(yearList.get(1));
				}
			}
		}
		
		String rated = jsonObject.get("Rated").getAsString();
		String released = jsonObject.get("Released").getAsString();
		String runtime = jsonObject.get("Runtime").getAsString();
		String genre = jsonObject.get("Genre").getAsString();
		String director = jsonObject.get("Director").getAsString();
		String writer = jsonObject.get("Writer").getAsString();
		String actors = jsonObject.get("Actors").getAsString();
		String plot = jsonObject.get("Plot").getAsString();
		String language = jsonObject.get("Language").getAsString();
		String country = jsonObject.get("Country").getAsString();
		String awards = jsonObject.get("Awards").getAsString();
		String poster = jsonObject.get("Poster").getAsString();
		
		Double metascore = ModelObject.INVALID_METASCORE;
		if (!jsonObject.get("Metascore").getAsString().equals(ModelObject.NOT_A_VALUE)) {
			metascore = jsonObject.get("Metascore").getAsDouble();
		}
		
		ModelObject o = new ModelObject();
		o.setTitle(title);
		o.setStartYear(startYear);
		o.setEndYear(endYear);
		o.setRated(rated);
		o.setReleased(released);
		o.setRuntime(runtime);
		o.setGenre(genre);
		o.setDirector(director);
		o.setWriter(writer);
		o.setActors(actors);
		o.setPlot(plot);
		o.setLanguage(language);
		o.setCountry(country);
		o.setAwards(awards);
		o.setPoster(poster);
		o.setMetascore(metascore);
		return o;
	}

}

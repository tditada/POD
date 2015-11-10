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
		
		Double imdbRating = ModelObject.INVALID_IMDB_RATING;
		if (!jsonObject.get("imdbRating").getAsString().equals(ModelObject.NOT_A_VALUE)) {
			imdbRating = jsonObject.get("imdbRating").getAsDouble();
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
		
		String imdbID = jsonObject.get("imdbID").getAsString();
		
		Integer tomatoMeter = ModelObject.INVALID_TOMATO_METER;
		if (!jsonObject.get("tomatoMeter").getAsString().equals(ModelObject.NOT_A_VALUE)) {
			tomatoMeter = jsonObject.get("tomatoMeter").getAsInt();
		}
		
		String tomatoImage = jsonObject.get("tomatoImage").getAsString();
		
		ModelObject o = new ModelObject();
		o.setTitle(title);
		o.setYear(year);
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
		o.setImdbRating(imdbRating);
		o.setImdbVotes(imdbVotes);
		o.setImdbId(imdbID);
		o.setType(type);
		o.setTomatoMeter(tomatoMeter);
		o.setTomatoImage(tomatoImage);
		return o;
	}

}

package core;

import java.util.List;

import model.ModelObject;

import com.hazelcast.mapreduce.Context;
import com.hazelcast.mapreduce.Mapper;

public class DirectorsFavoritesMapper implements Mapper<String, ModelObject, String, String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -530355625367185377L;

	@Override
	public void map(String keyValue, ModelObject inputValue, Context<String, String> context) {

		List<String> actors = inputValue.getActorsList();
		for (String actor: actors) {
			context.emit(inputValue.getDirector(), actor);	
			System.out.println(String.format("Se emite (%s, %s)", 
					inputValue.getDirector(), actor));
		}
	}


}

package core;

import java.util.List;

import model.ModelObject;

import com.hazelcast.mapreduce.Context;
import com.hazelcast.mapreduce.Mapper;


public class PopularActorsMapper implements Mapper<String, ModelObject, String, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5599527647878149694L;

	@Override
	public void map(String keyinput, ModelObject valueinput, Context<String, Long> context) {

//		System.out.println(String.format("Llega KeyInput: %s con ValueInput: %s", 
//				keyinput, valueinput));

		if (valueinput.getType().equals(ModelObject.TYPE_MOVIE)) {
			Long votes = valueinput.getImdbVotes();
			List<String> actors = valueinput.getActorsList();
			for (String actor: actors) {
				context.emit(actor, votes);	
				System.out.println(String.format("Se emite (%s, %d)", 
						actor, votes));
			}
		}
	}

}

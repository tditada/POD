package core;

import model.Actor;

import com.hazelcast.mapreduce.Reducer;
import com.hazelcast.mapreduce.ReducerFactory;

public class PopularActorsReducer implements ReducerFactory<String, Long, Actor> {

	private static final long serialVersionUID = -6565278695533690894L;

	@Override
	public Reducer<Long, Actor> newReducer(final String inputKey) {
		
		return new Reducer<Long, Actor>() {
			
			private Actor actor;

			@Override
			public void beginReduce() {
				super.beginReduce();
				actor = new Actor(inputKey, 0L);
			}

			@Override
			public void reduce(Long votes) {
				actor.addVotes(votes);
			}

			@Override
			public Actor finalizeReduce() {
				return actor;
			}

		};
	}

}

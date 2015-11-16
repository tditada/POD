package core;

import model.ActorsCouple;

import com.hazelcast.mapreduce.Reducer;
import com.hazelcast.mapreduce.ReducerFactory;

public class CoupleActorsReducer implements ReducerFactory<String, ActorsCouple, ActorsCouple> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2699322588579672112L;

	@Override
	public Reducer<ActorsCouple, ActorsCouple> newReducer(final String inputKey) {
		return new Reducer<ActorsCouple, ActorsCouple>() {

			private ActorsCouple actors;

			@Override
			public void beginReduce() {
				super.beginReduce();
				actors = new ActorsCouple(inputKey);
			}

			@Override
			public void reduce(ActorsCouple couple) {
				actors.addMovie(couple.getMovies());
			}

			@Override
			public ActorsCouple finalizeReduce() {
				System.out.println("count "+actors.getCount());
				return actors;
			}

		};
	}

}

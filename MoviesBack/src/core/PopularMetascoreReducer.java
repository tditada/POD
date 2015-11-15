package core;

import model.Movie;
import model.PopularMetascoreMovie;

import com.hazelcast.mapreduce.Reducer;
import com.hazelcast.mapreduce.ReducerFactory;

public class PopularMetascoreReducer implements ReducerFactory<Integer, Movie, PopularMetascoreMovie> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7232692105193642070L;

	@Override
	public Reducer<Movie, PopularMetascoreMovie> newReducer(final Integer inputKey) {
		
		return new Reducer<Movie, PopularMetascoreMovie>() {
			
			private PopularMetascoreMovie popularMovie;

			@Override
			public void beginReduce() {
				super.beginReduce();
				popularMovie = new PopularMetascoreMovie(inputKey);
			}

			@Override
			public void reduce(Movie movie) {
				if (movie == null) {
					System.out.println("movie null");
					return;
				}
				System.out.println(movie.getMetaScore());
				System.out.println(popularMovie.getMetaScore());
				if (movie.getMetaScore() > popularMovie.getMetaScore()) {
					popularMovie.setMetaScore(movie.getMetaScore());
					popularMovie.resetTitles();
					popularMovie.addTitle(movie.getTitle());
				} else if (movie.getMetaScore().equals(popularMovie.getMetaScore())) {
					popularMovie.addTitle(movie.getTitle());
				}
			}

			@Override
			public PopularMetascoreMovie finalizeReduce() {
				return popularMovie;
			}

		};
	}

}

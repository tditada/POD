package core;

import model.ModelObject;
import model.Movie;

import com.hazelcast.mapreduce.Context;
import com.hazelcast.mapreduce.Mapper;

public class PopularMetascoreMapper implements Mapper<String, ModelObject, Integer, Movie> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 809238633346113262L;
	private int maxYear;

	public PopularMetascoreMapper(int maxYear) {
		this.maxYear = maxYear;
	}

	@Override
	public void map(String keyinput, ModelObject valueinput, Context<Integer, Movie> context) {

		System.out.println(String.format("Llega KeyInput: %s con ValueInput: %s", 
				keyinput, valueinput));

		int year = valueinput.getYear();
		if (year > maxYear) {
			Movie movie = new Movie(valueinput.getTitle(), valueinput.getMetascore(), year);
			context.emit(year, movie);
			System.out.println(String.format("Se emite (year %d, %s)",
					year, movie.getTitle()));
		}
	}

}

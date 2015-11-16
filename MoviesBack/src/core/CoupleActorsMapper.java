package core;

import java.util.ArrayList;
import java.util.List;

import model.ActorsCouple;
import model.ModelObject;

import com.hazelcast.mapreduce.Context;
import com.hazelcast.mapreduce.Mapper;

public class CoupleActorsMapper implements Mapper<String, ModelObject, String, ActorsCouple> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5305683347560924201L;

	@Override
	public void map(String keyinput, ModelObject valueinput, Context<String, ActorsCouple> context) {
		//		System.out.println(String.format("Llega KeyInput: %s con ValueInput: %s", 
		//				keyinput, valueinput));

		if (valueinput.getType().equals(ModelObject.TYPE_MOVIE)) {

			List<String> list = valueinput.getActorsList();
			List<String> combinations = combinations(list);

			for (String couple: combinations) {
				ActorsCouple c = new ActorsCouple(couple, 0);
				c.addMovie(valueinput.getTitle());
				context.emit(couple, c);
				System.out.println(String.format("Se emite (%s, %s)", 
						couple, valueinput.getTitle()));
			}
		}
	}
	
	private List<String> combinations(List<String> list) {
		List<String> combin = new ArrayList<>();
		for (int i = 0; i< list.size(); i++) {
			for (int j = i+1 ; j < list.size(); j++) {
				String one = list.get(i);
				String two = list.get(j);
				String c = "";
				if (one.compareTo(two) <= 0) {
					c = one + " + " + two;
				} else if (one.compareTo(two) > 0) {
					c = two + " + " + one;
				}
				combin.add(c);
			}
		}
		return combin;
	}

}

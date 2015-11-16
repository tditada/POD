package test;

import java.util.ArrayList;
import java.util.List;

import model.Actor;
import utils.FixedPriorityQueue;

public class MainTest {
	
	public static void main(String[] args) {
		FixedPriorityQueue<Actor> queue = new FixedPriorityQueue<Actor>(2);
		queue.add(new Actor("pepe", 400L));
		queue.add(new Actor("lara", 300L));
		queue.add(new Actor("juan", 500L));
		queue.add(new Actor("lala", 400L));
		
		List<String> l = new ArrayList<String>();
		l.add("pepe");
		l.add("juan");
		l.add("gonzalo");
		l.add("monica");
		l.add("juan");
		
		List<String> s = combinations(l);
		for(String string : s) {
			System.out.println(string);
		}
	}

	private static List<String> combinations(List<String> list) {
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

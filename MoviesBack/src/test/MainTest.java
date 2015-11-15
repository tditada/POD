package test;

import model.Actor;
import utils.FixedPriorityQueue;

public class MainTest {
	
	public static void main(String[] args) {
		FixedPriorityQueue<Actor> queue = new FixedPriorityQueue<Actor>(2);
		queue.add(new Actor("pepe", 400L));
		queue.add(new Actor("lara", 300L));
		queue.add(new Actor("juan", 500L));
		queue.add(new Actor("lala", 400L));
		System.out.println("holis");
	}

}

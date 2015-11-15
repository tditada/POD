package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import utils.FixedPriorityQueue;
import model.Actor;

import com.hazelcast.mapreduce.Collator;

//revisar si recibe el map
public class PopularActorsCollator implements Collator<Map.Entry<String, Actor>, List<String>> {
	
	private int amount;
	private List<Actor> result;

	public PopularActorsCollator(int amount) {
		this.amount = amount;
		this.result = new LinkedList<>();
	}

	@Override
	public List<String> collate(Iterable<Map.Entry<String, Actor>> values) {
		System.out.println("amount");
		System.out.println(amount);
		FixedPriorityQueue<Actor> queue = new FixedPriorityQueue<>(amount);
		
		for (Map.Entry<String, Actor> entry: values) {
			queue.add(entry.getValue());
		}
		
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < amount; i++) {
			list.add(queue.poll().toString());
		}
		System.out.println("lista del collate size: "+list.size());
		return list;
	}



}

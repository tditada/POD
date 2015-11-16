package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import utils.FixedPriorityQueue;
import model.Actor;

import com.hazelcast.mapreduce.Collator;

public class PopularActorsCollator implements Collator<Map.Entry<String, Actor>, List<String>> {
	
	private int amount;

	public PopularActorsCollator(int amount) {
		this.amount = amount;
	}

	@Override
	public List<String> collate(Iterable<Map.Entry<String, Actor>> values) {
		FixedPriorityQueue<Actor> queue = new FixedPriorityQueue<>(amount);
		
		for (Map.Entry<String, Actor> entry: values) {
			queue.add(entry.getValue());
		}
		
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < amount; i++) {
			list.add(queue.poll().toString());
		}
		return list;
	}



}

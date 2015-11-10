package core;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import model.Actor;

import com.hazelcast.map.impl.MapEntrySimple;
import com.hazelcast.mapreduce.Collator;

//revisar si recibe el map
public class PopularActorsCollator implements Collator<Entry<String, Actor>, List<String>> {
	
	private int amount;
	private List<Actor> result;

	public PopularActorsCollator(int amount) {
		this.amount = amount;
		this.result = new LinkedList<>();
	}

	@Override
	public List<String> collate(Iterable<Entry<String, Actor>> values) {
		Iterator iterator = values.iterator();
		if (iterator.hasNext()) {
			Actor a = (Actor) iterator.next();
			//vemos si lo guardamos en la lista o no
		}
		//lista con nombres de actores
		return new LinkedList<>();
	}



}

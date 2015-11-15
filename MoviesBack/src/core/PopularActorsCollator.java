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
		LinkedList<String> result = new LinkedList<>();
		Iterator<Entry<String, Actor>> iterator = values.iterator();
		if (iterator.hasNext()) {
			Entry<String, Actor> a = iterator.next();
			//vemos si lo guardamos en la lista o no
		}
		//lista con nombres de actores
		result.add("holis");
		return result;
	}



}

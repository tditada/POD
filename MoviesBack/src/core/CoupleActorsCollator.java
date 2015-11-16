package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import model.ActorsCouple;

import com.hazelcast.mapreduce.Collator;

public class CoupleActorsCollator implements Collator<Map.Entry<String, ActorsCouple>, List<String>> {

	private int maxCount = 0;
	
	@Override
	public List<String> collate(Iterable<Entry<String, ActorsCouple>> values) {
		
		List<String> result = new ArrayList<>();
		
		for (Map.Entry<String, ActorsCouple> entry: values) {
			ActorsCouple couple = entry.getValue();
			System.out.println("en collator, count " + couple.getCount());
			
			if (couple.getCount() == maxCount) {
				result.add(couple.toString() + " count: " + String.valueOf(maxCount));
			} else if (couple.getCount() > maxCount) {
				result.clear();
				maxCount = couple.getCount();
				result.add(couple.toString() + " count: " + String.valueOf(maxCount));
			}
		}
		
		return result;
	}

}

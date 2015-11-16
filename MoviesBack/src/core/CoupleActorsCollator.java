package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import model.ActorsCouple;

import com.hazelcast.mapreduce.Collator;

public class CoupleActorsCollator implements Collator<Map.Entry<String, ActorsCouple>, List<String>> {

	private Integer maxCount = 0;
	
	@Override
	public List<String> collate(Iterable<Entry<String, ActorsCouple>> values) {
		
		List<String> result = new ArrayList<>();
		
		for (Map.Entry<String, ActorsCouple> entry: values) {
			ActorsCouple couple = entry.getValue();
			if (couple.getCount().equals(maxCount)) {
				StringBuilder builder = new StringBuilder();
				builder.append(couple.toString());
				builder.append(" count: ");
				builder.append(maxCount);
				result.add(builder.toString());
			} else if (couple.getCount() > maxCount) {
				result.clear();
				maxCount = couple.getCount();
				StringBuilder builder = new StringBuilder();
				builder.append(couple.toString());
				builder.append(" count: ");
				builder.append(maxCount);
				result.add(builder.toString());
			}
		}
		
		return result;
	}

}

package core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import model.ActorCount;

import com.hazelcast.mapreduce.Reducer;
import com.hazelcast.mapreduce.ReducerFactory;

public class DirectorsFavoritesReducer implements ReducerFactory<String, String, ActorCount> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4025006461467611564L;

	@Override
	public Reducer<String, ActorCount> newReducer(final String inputKey) {
			return new Reducer<String, ActorCount>() {

				Map<String, Integer> actorsCountMap;
				Integer maxCount;
				StringBuilder names;

				@Override
				public void beginReduce() {
					super.beginReduce();
					actorsCountMap = new HashMap<>();
					maxCount = 0;
					names = new StringBuilder();
				}

				@Override
				public void reduce(String actor) {
					if (!actorsCountMap.containsKey(actor)) {
						actorsCountMap.put(actor, 1);
					} else {
						int previous = actorsCountMap.get(actor);
						actorsCountMap.put(actor, previous + 1);
					}
				}

				@Override
				public ActorCount finalizeReduce() {
					Set<String> actors = actorsCountMap.keySet();
					for (String actor: actors) {
						int count = actorsCountMap.get(actor);
						if (count > maxCount) {
							maxCount = count;
							names = new StringBuilder();
							names.append(actor);
						} else if (count == maxCount) {
							names.append(" - ");
							names.append(actor);
						}
					}
					return new ActorCount(names.toString(), maxCount);
				}

			};
	}

}

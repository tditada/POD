package utils;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
	
	public static List<String> separateActors(String string) {
		List<String> actors = Arrays.asList(string.split(","));
		return actors;
	}

}

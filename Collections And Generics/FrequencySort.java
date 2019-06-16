import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FrequencySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"abc","xyz","pqr","xyz","pqr","pqr"};
		
		FrequencySorter.sort(input);
	}
}

class FrequencySorter{
	public static void sort(String[] input) {
		HashMap<String, Integer> counts = new HashMap<String, Integer>();
		
		for(String i : input) {
			counts.put(i, counts.getOrDefault(i, 0) + 1);
		}
		
		Map<String, Integer> sortedCounts = counts.
				entrySet().
				stream().
				sorted(Collections.reverseOrder(Entry.comparingByValue()))
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
		                LinkedHashMap::new));
		
		System.out.println(sortedCounts.keySet());
	}
}

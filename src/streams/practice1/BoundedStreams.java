package streams.practice1;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class BoundedStreams {

	public static void main(String[] args) {
		
		Map<Integer, String> map = Map.of(1, "One", 2, "Two", 3, "Three", 4, "Four", 5, "five");
			Stream<Entry<Integer, String>> streamOfEntry = map.entrySet().stream();
			Stream<String> streamOfValues = map.values().stream();
			Stream<Integer> streamOfKey = map.keySet().stream();
			
			
			Builder<Integer> builder = Stream.builder();
			builder.add(1);
			builder.add(2);
			
			Stream<Integer> streamOfInteger = builder.build();
	}
}

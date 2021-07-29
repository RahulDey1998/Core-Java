package streams.practice1.collectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public class CustomCollectors {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(1,4,3,5,6,4,65,7,34,23,25,76);
		
		Collector<Integer, List<Integer>, List<Integer>> toListCollector =
				Collector.of(
					ArrayList :: new, // Supplier
					(list, currentStreamElement) -> list.add(currentStreamElement), //Accumulator(BiConsumer)
					(list1, list2) -> { // BiFunction
						list1.addAll(list2);
						return list1;
					},
				    Collector.Characteristics.IDENTITY_FINISH);
			
		List<Integer> evenNumbers = numbers.stream().filter(e -> e % 2 == 0).collect(toListCollector);
//		evenNumbers.forEach(System.out::println);
		
		// Sorted Collector
		Collector<Integer, ArrayList<Integer>, ArrayList<Integer>> sortedNumbersCollector = 
				Collector
			       .of(ArrayList<Integer> :: new, // Supplier
					     (list, currentStreamElement) -> list.add(currentStreamElement), //Accumulator(BiConsumer)
					     (list1, list2) -> { // BiFunction
							list1.addAll(list2);
							return list1;
						},
					    (list) -> { //Finisher
					    	Collections.sort(list);
						    return list;
					    },
					    Collector.Characteristics.UNORDERED
					   );
		ArrayList<Integer> sortedNumbers = numbers.stream().collect(sortedNumbersCollector);
		sortedNumbers.forEach(System.out :: println);
		
			    	
		
		
	}

}

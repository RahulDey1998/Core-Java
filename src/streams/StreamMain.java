package streams;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {

	public static void main(String[] args) {
		
		//Filtering even number
		
		List<Integer> list = List.of(2,13,4,3,7,5,9,10); 
		List<Integer> list1 = new ArrayList<>();
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("1", "Rahul Dey", "Kolkata"));
		employees.add(new Employee("2", "Snehal", "Mumbai"));
		employees.add(new Employee("3", "Sourav", "Bangalore"));
		employees.add(new Employee("4", "Suman", "Hyderabad"));
		employees.add(new Employee("5", "Arpan", "Indore"));
		
		list.forEach(list1::add);
		int temp = 0;
		int sum = (int) list1.stream().filter(number -> number % 2 == 0)
		.reduce(0,Integer::sum);
		 Function<String, Integer> func;
		 
		
//		forEach(System.out::println);
		System.out.println(sum);
		
//		Collections.sort(list1,(o1,o2) -> (o1 > o2) ? 1 : (o1 < o2) ? -1 : 0);
	    list1.forEach(System.out::println);
	    
//	    list1.stream().
		
		employees.stream().
		collect(Collectors.toMap(null, null, null));
		
    
		
	}
}

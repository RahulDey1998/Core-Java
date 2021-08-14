package streams.practice1.collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CollectorsInAction {
	
	public static void main(String[] args) {
		
		Path path = Paths.get("C:\\Users\\rahdey\\eclipse-workspace\\Core_Java\\src\\streams\\practice1\\collectors\\EmployeeData.txt");
		try(Stream<String> lines = Files.lines(path)) {
			
			Stream<String> wordStream = lines.flatMap(line -> Arrays.stream(line.split(",")));
			Spliterator<String> wordSpliterator = wordStream.spliterator();
			EmployeeSpliterator employeeSpliterator = new EmployeeSpliterator(wordSpliterator);
			Stream<Employee> employeeStream = StreamSupport.stream(employeeSpliterator, false);
			
			List<Employee> empList = employeeStream.collect(Collectors.toList());
//			empList.forEach(System.out::println);
			
			//Collecting to Set
			TreeSet<Employee> empSet = empList.stream()
					.collect(Collectors.toCollection(TreeSet :: new));
			
		    empSet.forEach(System.out::println);
			
			//collecting to map
			Map<String, Employee> empMap = empList.stream()
			.collect(
					 Collectors.toMap(emp -> emp.getId(), emp -> emp)
		     );
			
//			empMap.entrySet().forEach(System.out::println);
			
			//Collecting by a group
			
			Map<String, List<Employee>> empGroupByDesignation = empList.stream()
			  .collect(
					  Collectors.groupingBy(emp -> emp.getDesignation())
					 );
//			empGroupByDesignation.entrySet().stream().forEach(System.out::println);
			
			//sorting a map
			LinkedHashMap<String, List<Employee>> sortedEmployeeMap = 
					        empGroupByDesignation
					        .entrySet()
					        .stream()
			                .sorted(Map.Entry.comparingByKey())
			                .collect(
			                		Collectors.toMap(
			                				e -> e.getKey(),e ->  e.getValue(),
			                		          (oldValue, newValue) -> oldValue, LinkedHashMap :: new)
			                		);
			
			sortedEmployeeMap.entrySet().forEach(System.out :: println);
			
			//collecting as a String
			String EmpNames = empList.stream()
			       .map(emp -> emp.getName())
			       .collect(Collectors.joining(","));
			
			System.out.println(EmpNames);
			
			//Cascading collectors
			
			
			
			  
			
			
			
		}
		catch(IOException e) {
			
		}
	}

}

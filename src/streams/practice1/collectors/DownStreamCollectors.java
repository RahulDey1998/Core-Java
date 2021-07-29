package streams.practice1.collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class DownStreamCollectors {
	
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("C:\\Users\\rahdey\\eclipse-workspace\\Core_Java\\src\\streams\\practice1\\collectors\\EmployeeData.txt");
		try(Stream<String> lines = Files.lines(path)) {
			
			Stream<String> wordStream = lines.flatMap(line -> Arrays.stream(line.split(",")));
			Spliterator<String> wordSpliterator = wordStream.spliterator();
			EmployeeSpliterator employeeSpliterator = new EmployeeSpliterator(wordSpliterator);
			Stream<Employee> employeeStream = StreamSupport.stream(employeeSpliterator, false);
			
			List<Employee> empList = employeeStream.collect(Collectors.toList());
//			
			//Count by Employee Designation
			Map<String, Long> empCountByDesignation = empList.stream()
			   .collect(
					     Collectors.groupingBy(emp -> emp.getDesignation(), 
					    		              Collectors.counting())
					   );
//			empCountByDesignation.entrySet().forEach(System.out :: println);
			
			//Count by Employee Designation
			Map<String, Double> fundDistributionByDesingation = empList.stream()
					.collect(
							Collectors.groupingBy(emp -> emp.getDesignation(), 
									Collectors.summingDouble(emp -> Double.parseDouble(emp.getSalary())))
							);
			fundDistributionByDesingation.entrySet().forEach(System.out :: println);
			
			//Count by Employee Designation
			Map<String, Long> countEmpByDesination = empList.stream()
					.collect(
							Collectors.groupingBy(emp -> emp.getDesignation(), 
									Collectors.counting())
							);
			System.out.println(countEmpByDesination);
			
			//Count by Employee Designation
			Map<String, Double> fundSumByDesingation = empList.stream()
					.collect(
							Collectors.groupingBy(emp -> emp.getDesignation(), 
									Collectors.summingDouble(emp -> Double.parseDouble(emp.getSalary())))
							);
	        System.out.println(fundSumByDesingation);
			
			//Count by Employee Designation
	        
			Map<Object, Optional<Employee>> maxFundByDesination = empList.stream()
					.collect(
							Collectors.groupingBy(emp -> emp.getDesignation(), 
									Collectors.maxBy(Comparator.comparing(emp -> emp.getSalary())))
							);
			System.out.println(maxFundByDesination);
			
			//Cascading Collectors
			Map<String, Optional<String>> maxSalaryByDesignation =
					empList.stream()
			         .collect(
			    	   	Collectors.groupingBy(
			    	   			e -> e.getDesignation(),
			    				Collectors.mapping(
			    						e -> e.getSalary(), 
			    						Collectors.maxBy(Comparator.comparing(Function.identity()))))
			    		);
			
			System.out.println(maxSalaryByDesignation);
			
			
	      }

	}
}

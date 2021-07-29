package streams.practice1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {

	public static void main(String[] args) throws IOException {
		
		Stream<String> a = Stream.of("Kolkata", "Mumbai");
		Stream<String> b = Stream.of("Bangalore", "Hyderabad");
		
		Stream<String> flatMap = Stream.of(a,b).flatMap(s -> s); 
		
		Path path = Paths.get("C:\\Users\\rahdey\\eclipse-workspace\\Core_Java\\src\\streams\\practice1\\data.txt"); 
		try(Stream<String> data = Files.lines(path);) {
			List<String> words = data
			.flatMap(line -> Arrays.stream(line.split(" ")))
			.collect(Collectors.toList());
			
		   words.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
        		
		
	}
}

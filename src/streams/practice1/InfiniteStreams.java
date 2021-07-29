package streams.practice1;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStreams {

	public static void main(String[] args) {
		
		IntStream.iterate(0, i -> i - 1)
		 .limit(15)
		 .forEach(System.out::println);
		
		
		Stream.generate( () -> Math.random())
		   .limit(15)
		   .forEach(System.out::println);
	}
}

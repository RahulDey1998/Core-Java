package streams;

import java.util.stream.IntStream;

public class DeclarativeVSImperative {
	
	//Impritive is old style of taking for loops and ifs
	
	// Taking sum of even number in Declarative Programming Style
	
	public static void main(String[] args) {
		
		int sum = IntStream.rangeClosed(0, 100)
		.filter(i -> i%2 == 0)
		.reduce((a,b) -> a+b)
		.getAsInt();
		
		System.out.println(sum);
	}

}

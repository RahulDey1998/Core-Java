package functionalProgramming.chaining;

import java.util.function.Function;

public class Currying {
	
	public static void main(String[] args) {
		
		Function<Integer, Function<Integer, Function<Integer, Integer>>> s = 
				 a -> b-> c-> a+b+c;
				 
				 
	    int sum = s.apply(10).apply(15).apply(25);
	    
	    System.out.println(sum);
				 
				 
	}

	
			 
	
			 
}

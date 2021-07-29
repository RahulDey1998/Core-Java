package functionalProgramming.chaining;

public class Chaining {
	
	public static void main(String[] args) {
		
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2= System.out::println;
		
		Consumer<String> c3 = s ->
		{
			c1.accept(s);
			c2.accept(s);
		};
		
		c1.thenAccept(c2).accept("Hello");;
	}

}

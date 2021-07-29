package functionalProgramming.composition;

public class Composition {
	
	public static void main(String[] args) {
		
		Function<Square, Integer> fun1 = s -> s.getArea();
		Function<Integer, Double> fun2 = area -> Math.sqrt(area);
		
		Square square = new Square(100);
		Function<Square, Double> fun3 = fun2.compose(fun1);
		Double d= fun3.apply(square);
		System.out.println(d);
	}

}

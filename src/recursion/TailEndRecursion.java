package recursion;

public class TailEndRecursion {
	
	public static void main(String[] args) {
		
		System.out.println(factTail(6, 1));
		
		
	}
	
	public static int factTail(int num, int accumulator) {
		
		if(num <= 1) {
			return accumulator;
		}
		else {
			return factTail(num-1, accumulator * num);
		}
		
	}

}

package functionalProgramming.closure;

public class Closure {

	public static void main(String[] args) {
		
		int x = 10;
		
		Task<Integer> task = t -> {
			System.out.println(x);
			System.out.println("Task completed.");
		};
		
		printValue(task);
		
		
		
	}

	private static void printValue(Task t) {
		t.doTask(9);
	}
}

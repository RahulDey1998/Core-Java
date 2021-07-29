package recursion;

public class SumOfFirstNnumber {
	
	public static void main(String[] args) {
		
		System.out.println(sum1(6));
	}
	
	public static int sum(int num, int acc) {
		if(num == 0) {
			return acc;
		}
		else {
			return sum(num-1, acc+num);
		}
	}
	
	public static int sum1(int num) {
		if(num == 0) {
			return 0;
		}
		else {
			return num + sum1(num-1);
		}
	}

}

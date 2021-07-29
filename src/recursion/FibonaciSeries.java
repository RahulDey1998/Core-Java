package recursion;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FibonaciSeries {


	
	
	public static void main(String[] args) {
		
		IntStream.range(0, 20).map(FibonaciSeries::fibonaciSeries).forEach(System.out::println);
		System.gc();
		
	}
	public static int fibonaciSeries(int count) {
		
		
		if(count == 0) {
			return 0;
		}
		else if(count == 1 || count == 2){
			return 1;
		}
		else {
			return fibonaciSeries(count  - 1) + fibonaciSeries(count - 2);
 		}
	}
	
	
}

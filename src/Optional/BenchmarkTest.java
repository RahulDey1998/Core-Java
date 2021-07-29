package Optional;

import java.util.Optional;

public class BenchmarkTest {

	public static void main(String[] args) {
		
		Optional<String> name = Optional.ofNullable(null);
		
		String result = name.orElse(getRandomName());
		String result1 = name.orElseGet(() -> getRandomName());
		
	}
	

	   static String getRandomName() {
			System.out.println(" RandomName method called");
			return "Default Name";
		}
		
	
}

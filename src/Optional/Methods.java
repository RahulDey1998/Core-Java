package Optional;

import java.util.Optional;

public class Methods {
	
	public static void main(String[] args) {
		
		Optional<String> s1 = Optional.ofNullable(null);
		Optional<String> s2 = Optional.ofNullable(null);
		
//		String s = s1.get();
		
		System.out.println(s1.orElse("orElse"));
		System.out.println(s2.orElseGet(() -> "supplier"));
		System.out.println(s2.orElseThrow( () -> new RuntimeException("Custom Exception")));
	}

}

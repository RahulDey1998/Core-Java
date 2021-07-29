package functionalProgramming;

public class Factory {
	
	
	public static void main(String[] args) {
		IFactory<Integer> factory = createFactory(() -> Math.random()*100, r -> r.intValue());
		Integer product = factory.create();
		System.out.println(product);
		
	}
	
	
	
	public static <T,R> IFactory<R> createFactory(Producer<T> producer,
			Operation<T, R> operation) {
		return () -> {
			T t= producer.produce();
			return operation.perform(t);
		};
		 
		
	}

}

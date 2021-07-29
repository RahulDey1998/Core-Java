package functionalProgramming.composition;

public interface Function<T,R> {
	
	R apply(T t);

	default <V> Function<V,R> compose(Function<V, T> fun1) {
		return (V v) -> {
			return this.apply(fun1.apply(v));
		};
	}

}

package functionalProgramming.chaining;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@FunctionalInterface
public interface Consumer<T> {
	
	void accept(T t);
	
    default Consumer<T> thenAccept(Consumer<T> next) {
    	
    	Objects.requireNonNull(next);
		return (T t) -> {
			this.accept(t);
			next.accept(t);
		};
	}

}

package functionalProgramming.closure;

@FunctionalInterface
public interface Task<T> {

	void doTask(T t);
}

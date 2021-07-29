package streams.practice1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.IntStream;

public class Parallelism {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Runtime runtime = Runtime.getRuntime();
		System.out.println(runtime.availableProcessors());
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "4");
		System.out.println(ForkJoinPool.getCommonPoolParallelism());
		
		List<Book> books = new ArrayList<>();
		IntStream.range(0, 10000)
		.forEach( i -> {
			books.add(new Book("book5", "author5", "horror", 4.5));
			books.add(new Book("book1", "author1", "genre1", 4.1));
			books.add(new Book("book2", "author2", "horror", 4.0));
			books.add(new Book("book3", "author3", "genre3", 2.1));
			books.add( new Book("book4", "author4", "horror", 3.6));
		});
		
		
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
		 long count =  forkJoinPool.submit(() -> 
			books
			.parallelStream()
			.filter(book -> book.getRating() > 4)
			.count()
		).get();
		 
		 System.out.println(count);
		
		
		
		
		
	}

}

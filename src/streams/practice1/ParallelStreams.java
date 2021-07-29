package streams.practice1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreams {
	
	public static void main(String[] args) {
		
		List<Book> books = new ArrayList<>();
		IntStream.range(0, 1000000)
		.forEach( i -> {
			books.add(new Book("book5", "author5", "horror", 4.5));
			books.add(new Book("book1", "author1", "genre1", 4.1));
			books.add(new Book("book2", "author2", "horror", 4.0));
			books.add(new Book("book3", "author3", "genre3", 2.1));
			books.add( new Book("book4", "author4", "horror", 3.6));
		});
//		System.out.println(books.size());
		long startTime;
		long endTime;
		long count;
		
		startTime = System.currentTimeMillis();
		count = books.stream().filter(book -> book.getRating() > 4).count();
	
		endTime = System.currentTimeMillis();
		System.out.println("Time taken with Sequential Stream - " + (endTime - startTime)+ "ms. count - " + count);
		
		startTime = System.currentTimeMillis();
		 count = books.parallelStream().filter(book -> book.getRating() > 4).count();
		endTime = System.currentTimeMillis();
		System.out.println("Time taken with Parallel Stream - " + (endTime - startTime)+ "ms. count - " + count);
	}

}

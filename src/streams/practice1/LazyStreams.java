package streams.practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class LazyStreams {
	
	public static void main(String[] args) {
		
	
		Book book1 =  new Book("book1", "author1", "genre1", 4.1);
				
		List<Book> books = Arrays.asList(
				 new Book("book1", "author1", "genre1", 4.1),
				 new Book("book2", "author2", "horror", 4.0),
				 new Book("book3", "author3", "genre3", 2.1),
				 new Book("book4", "author4", "horror", 3.6));
	
		List<Book> horrorBooks = new ArrayList<>();
		
		Stream<Book> filteredBooks = books.stream().parallel()
		      .filter(book -> book.getGenre().equalsIgnoreCase("horror"))
		      .peek(book -> System.out.println("Inside intermediate filter op " + book))
		      .filter(book -> book.getRating() > 3);
		
		
		filteredBooks.forEach(System.out::println);
		
		OptionalDouble averageRating = books.stream()
		.mapToDouble(book -> book.getRating())  // mapToDouble convert Object Double to primitive type to leverage average() method
		.average();
		
		System.out.println("Average Rating :- "+ averageRating.getAsDouble() ); 
		
		DoubleSummaryStatistics summaryStatictics = books.stream()
				.mapToDouble(book -> book.getRating())
				.summaryStatistics();
				
		System.out.println("Min Rating :- "+ summaryStatictics); 

		     
	}
	

}

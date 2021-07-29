package streams.practice1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Client {

	public static void main(String[] args) {
		
		List<Book> books = new ArrayList<>();
//		Book[] booksArray = (Book[]) books.toArray();
		List<Book> horrorBooks = new ArrayList<>();
		
		books.stream().parallel()
		      .filter(book -> book.getGenre().equalsIgnoreCase("horror") && book.getRating() > 3)
		      .forEach(horrorBooks::add);
		
		int sumOfEvenNo = Stream.of(12,34,2,23,43,23,34,65)
		.filter(i -> i%2 == 0)
		.reduce(0, (a,b) -> a+b);
		
//		System.out.println(sumOfEvenNo);
		
		Optional<Integer> secondBigNo =
				Stream.of(12,34,2,23,43,43,34,65)
				.sorted(Comparator.reverseOrder())
				.skip(1)
				.max(Comparator.naturalOrder());
		
		System.out.println(secondBigNo.get());
				
		
	}
}

package streams.practice1.spliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import streams.practice1.Book;

public class CustomSplitIterator {

	
	public static void main(String[] args) {
		
		Path path = Paths.get("C:\\Users\\rahdey\\eclipse-workspace\\Core_Java\\src\\streams\\practice1\\Books.txt"); 
		try(Stream<String> lines = Files.lines(path);) {
			Spliterator<String> baseSpliterator = lines.spliterator();
			Spliterator<Book> bookSpliterator = new BookSpliterator(baseSpliterator);
			Stream<Book> bookStream = StreamSupport.stream(bookSpliterator, false);
			
			bookStream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

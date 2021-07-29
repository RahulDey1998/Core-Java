package streams.practice1.spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

import streams.practice1.Book;

public class BookSpliterator implements Spliterator<Book> {
	
	private String name;
	private String author;
	private String genre;
	private double rating;
	
	private Spliterator<String> baseSpliterator;

	public BookSpliterator(Spliterator<String> baseSpliterator) {
		this.baseSpliterator = baseSpliterator;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Book> action) {
		 if( baseSpliterator.tryAdvance(line -> this.name = line) &&
			 baseSpliterator.tryAdvance(line -> this.author = line) &&
			 baseSpliterator.tryAdvance(line -> this.genre = line) &&
			 baseSpliterator.tryAdvance(line -> this.rating = Double.valueOf(rating))) {
			
			action.accept(new Book(this.name, this.author, this.genre, this.rating));
			return true;
		}
		 
		 return false;
	
	}

	@Override
	public Spliterator<Book> trySplit() {
		return null;
	}

	@Override
	public long estimateSize() {
		return baseSpliterator.estimateSize() / 4;
	}

	@Override
	public int characteristics() {
		return baseSpliterator.characteristics();
	}

}

package reactive.observer.example1;

public class ObserverDesignPattern {
	
	public static void main(String[] args) {
		
		Book book = new Book("Learn Java", 120.0, 0);
		
		Observer user1 = new EndUser1("Rahul Dey", book);
		Observer user2 = new EndUser1("Suman Ghosh", book);
		Observer user3 = new EndUser1("Soumen Das", book);
		
		book.setStockQty(30);
		
		
	}

}

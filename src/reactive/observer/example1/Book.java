package reactive.observer.example1;

import java.util.ArrayList;

public class Book implements SubjectLibrary {
	
	private String name;
	private ArrayList<Observer> observerList = new ArrayList<>();
	private Double price;
	private int stockQty;
	
	
	public Book() {}

	public Book(String name, Double price, int stockQty) {
		super();
		this.name = name;
		this.observerList = observerList;
		this.price = price;
		this.stockQty = stockQty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Observer> getObserverList() {
		return observerList;
	}

	public void setObserverList(ArrayList<Observer> observerList) {
		this.observerList = observerList;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getStockQty() {
		return stockQty;
	}

	public void setStockQty(int stockQty) {
		this.stockQty = stockQty;
		if(stockQty > 0) {
			System.out.println("Stock came in, notifying all observer.");
			notifyObserver();
		}
	}

	@Override
	public void subscribeObserver(Observer ob) {
		this.observerList.add(ob);
		
	}

	@Override
	public void unsubscribeObserver(Observer ob) {
		this.observerList.remove(ob);
		
	}

	@Override
	public void notifyObserver() {
		observerList.forEach(observer -> {
			observer.update("Book [name=" + name + ", observerList=" + observerList + ", price=" + price + ", stockQty=" + stockQty + " is available now");
		});
		
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", observerList=" + observerList + ", price=" + price + ", stockQty=" + stockQty
				+ "]";
	}
	
	
	

}

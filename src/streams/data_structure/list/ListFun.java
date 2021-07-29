package streams.data_structure.list;

import java.util.Collection;
import java.util.function.Consumer;

public abstract class ListFun<T> {
	
	public abstract T head();
	
	public abstract ListFun<T> tail();
	
	public abstract boolean isEmpty();
	
	public static final ListFun NIL = new Nil();
	
	private static class Nil<T> extends ListFun<T> {
		
		private Nil() {}

		@Override
		public T head() {
			return null;
		}

		@Override
		public boolean isEmpty() {
			return true;
		}

		@Override
		public ListFun<T> tail() {
			
			return null;
		}
		
	}
	
	public int length() {
		int l = 0;
		
		ListFun<T> temp = this;
		while(!temp.equals(NIL)) {
			l++;
			temp = temp.tail();
		}
		return l;
	}
	
	private static class Const<T> extends ListFun<T> {
		
		private final T head;
		private final ListFun<T> tail;

		public Const(T head, ListFun<T> list) {
			super();
			this.head = head;
			this.tail = list;
		}

		@Override
		public T head() {	
			return this.head;
		}

		@Override
		public ListFun<T> tail() {
			return this.tail;
		}

		@Override
		public boolean isEmpty() {
			return length() == 0 ? true : false;
		}
		
	}
	
	public static <T> ListFun<T> list() {
		return NIL;
	}
	
	public static <T> ListFun<T> list(T...  t) {
		ListFun<T> temp = list();
		for(int i =  t.length -1 ; i >= 0 ; i--) {
			temp = new Const<T>(t[i], temp);
		}
		
		return temp; 
	}
	
	public ListFun<T> add(T e) {
		return new Const<T>(e, this); 
	}
	
	public void forEach(Consumer<? super T> action) {
		T current = this.head();
		ListFun<T> temp = this;
		
		for(int i = 0 ; i < this.length() ; i++) {
			action.accept(current);
			temp = temp.tail();
			current = temp.head();
		}
	}
	
	public ListFun<T> remove(T e) {
		if(this.length() == 0) {
			return this;
		} 		
		else if(head().equals(e)) {
			return tail();
		}      
		else {
	    	ListFun<T> newTail =  tail().remove(e);
	    	return new Const<T>(head(), newTail);		
		}	
	}
	
	public ListFun<T> removebyIndex(int index) {
		
		if(index < 0 || index > this.length()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		else if(index == 0) {
			return tail();
		}
		
		return new Const<T>(head(), tail().removebyIndex(index-1));		
	}
	
	public ListFun<T> add(int index, T e) { 
	
		if(index < 0 || index > this.length()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else if(index == 1) {
			return this.tail().add(e);
		}
		
		return new Const<T>(head(), tail().add(index-1, e));		
		
	}
	
	public ListFun<T> reverse() {
		ListFun<T> newList = list();
		ListFun<T> temp = this;
		
		while(!temp.equals(NIL)) {
			newList = newList.add(temp.head());
			temp = temp.tail();
		}
		
		return newList;
	}
	
	public ListFun<T> concat(ListFun<T> list1, ListFun<T> list2) {
		return list1.isEmpty()
				? list2 :
				  new Const<T>(list1.head(), concat(list1.tail(), list2));
	}
	
	public ListFun<T> addAll(final Collection<? extends T> list) {
		ListFun<T> result = this;
		
		for(T t : list) {
			result = result.add(t);
		}
		
		return result;
	}
	
	public ListFun<T> addLast(T e) {
		ListFun<T> result = this;
		
		if(tail().equals(NIL)) {
			return new Const<T>(this.head(), new Const<T>(e, list()));
		}
		
		return new Const<T>(head(), tail().addLast(e));
		
	}

}

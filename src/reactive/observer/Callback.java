package reactive.observer;

public interface Callback {
	
	 void pushComplete();
	 void pushData(String data);
	 void pushError(Exception e);
//	void call();

}

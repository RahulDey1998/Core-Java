package reactive.observer;

public class CallbackDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Main thread is running.");
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				new CallbackDemo().runningAsync(new Callback() {
					
					@Override
					public void pushError(Exception e) {
						System.out.println("Callback Exception occured " + e);
						
					}
					
					@Override
					public void pushData(String data) {
						System.out.println("Callback data - " + data);
						
					}
					
					@Override
					public void pushComplete() {
						System.out.println("Callback completed.");
						
					}
				});
				
				
			}
		};
		
		Thread t = new Thread(r);
		t.start();
		
		Thread.sleep(2000);
		System.out.println("Main thread completed.");
	}
	
	public void runningAsync(Callback callback) {
		System.out.println("running async method called.");
		sleep(1000);
		callback.pushData("Data 1");
		callback.pushData("Data 2");
		callback.pushData("Data 3");
		
		callback.pushError(new RuntimeException("oops!!"));
		callback.pushComplete();
		
	}

	private void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}

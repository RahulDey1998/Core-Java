package reactive.observer.example1;

public class EndUser1 implements Observer{
	
	private String name;
	
	public EndUser1(String name, SubjectLibrary subject) {
		super();
		this.name = name;
		subject.subscribeObserver(this);
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public void update(String message) {
		System.out.println(message);
		
	}

}

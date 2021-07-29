package streams.practice1.collectors;

import java.util.Spliterator;
import java.util.function.Consumer;

public class EmployeeSpliterator implements Spliterator<Employee>{
	
	private Spliterator<String> baseSpliterator;
	
	private String empId;
	private String empName;
	private String empDesignation;
	private String empSalary;
	private String empDob;
	private String empDOJ;
	private String empGender;
	private String city;
	
	
	public EmployeeSpliterator(Spliterator<String> baseSpliterator) {
		this.baseSpliterator = baseSpliterator;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Employee> action) {
		if(baseSpliterator.tryAdvance(word -> this.empId = word) &&
		baseSpliterator.tryAdvance(word -> this.empName= word) &&
		baseSpliterator.tryAdvance(word -> this.empGender = word) &&
		baseSpliterator.tryAdvance(word -> this.empDob = word) &&
		baseSpliterator.tryAdvance(word -> this.city = word) &&
		baseSpliterator.tryAdvance(word -> this.empDesignation = word) &&
		baseSpliterator.tryAdvance(word -> this.empDOJ = word) &&
		baseSpliterator.tryAdvance(word -> this.empSalary = word)) {
			
			 Employee employee = new Employee(this.empId, this.empName, this.empGender, this.empDob,
					                          this.city, this.empDesignation, this.empDOJ, this.empSalary);
			action.accept(employee);
			return true;
		}
	 
		return false;
	}

	@Override
	public Spliterator<Employee> trySplit() {
		return null;
	}

	@Override
	public long estimateSize() {
		return baseSpliterator.estimateSize() / 8;
	}

	@Override
	public int characteristics() {
		return baseSpliterator.characteristics();
	}

}

package streams.practice1.collectors;

public class Employee implements Comparable<Employee>{

	private String id;
	private String name;
	private String gender;
	private String dob;
	private String city;
	private String designation;
	private String joiningDate;
	private String salary;
	
	
	public Employee(String id, String name, String gender, String dob, String city, String designation,
			String joiningDate, String salary) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.city = city;
		this.designation = designation;
		this.joiningDate = joiningDate;
		this.salary = salary;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", city=" + city
				+ ", designation=" + designation + ", joiningDate=" + joiningDate + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee o) {
		int id = Integer.parseInt(this.id);
		int otherId = Integer.parseInt(o.getId());
		
		if(id > otherId) {
			return 1;
		}
		else if(id < otherId) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	
	
	
}


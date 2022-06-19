package petcure;

public class Person {
	private String name;
	private String phone;

	public Person(String name) {
		this.name = name;
		this.phone = null;
	}

	public Person(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return this.name;
	}

	public String getPhone() {
		return this.phone;
	}
}

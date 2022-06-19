package petcure;

import java.io.Serializable;

public class Customer implements Serializable {
	private String name;

	public Customer(String name, String address) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + "]";
	}
}

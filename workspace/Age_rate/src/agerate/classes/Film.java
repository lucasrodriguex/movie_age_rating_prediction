package agerate.classes;

public class Film {

	private String name;
	private String age;

	public Film (String name, String age) {
		this.name = name;
		this.age = age;
	}

	public Film(){

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

//	public String toString() {
//		return name + "\n" + age;
//	}
}

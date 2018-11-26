package App.Test;

public class User {
	private String name;
	private String age;
	private String title;
	
	public User(String name, String age, String title) {
		super();
		this.name = name;
		this.age = age;
		this.title = title;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", title=" + title + "]";
	}

	
}

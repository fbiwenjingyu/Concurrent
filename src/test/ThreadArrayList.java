package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ThreadArrayList {
	public static void main(String[] args) {
		Collection list=new ArrayList<User>();
		list.add(new User("张三", 22));
		list.add(new User("李四", 22));
		list.add(new User("王五", 22));
		Iterator lists=list.iterator();
		while(lists.hasNext()) {
			System.out.println("11111");
			lists.remove();
		}
	}
	
}

class User{
	
	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
	
	
}

package oops;

import java.util.*;

class Student
{
	int id;
	String name,city;
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + "]";
	}	
}
public class StudentDemo 
{
	static List<Student> list = new ArrayList<>(Arrays.asList(
			new Student(1,"Tarunjeet","Brampton"),
			new Student(2,"Inderjit","Jalandhar"),
			new Student(3,"Amarjit","Jalandhar"),
			new Student(4,"Rajinder","Jammu")
			));
	
	public static void main(String[] args) 
	{
		list.forEach(System.out::println);
	}
}
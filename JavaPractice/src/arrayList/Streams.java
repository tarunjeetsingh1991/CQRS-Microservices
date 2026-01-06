package arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student
{
	int id;
	String name, city;
	
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
public class Streams 
{
	public static void main(String[] args) 
	{
		Student s1 = new Student(33,"Bob","Toronto");
		Student s2 = new Student(15,"Alice","Winnipeg");
		Student s3 = new Student(96,"Drake","Edmonton");
		Student s4 = new Student(51,"Charlie","Vancouver");
		
		ArrayList<Student> al = new ArrayList<>(Arrays.asList(s1, s2, s3, s4));
		//System.out.println(al);
		
		//al.forEach(s -> s.setName(s.getName().toUpperCase()));
		//System.out.println(al);
		
		
		List<Student> sortedName = al.stream()
							.sorted((a,b) -> a.getName().compareTo(b.getName()))
							.collect(Collectors.toList());
		//System.out.println(sortedName);
		
		sortedName.forEach(System.out::println);
		
	}

}

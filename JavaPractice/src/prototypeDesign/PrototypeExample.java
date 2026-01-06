package prototypeDesign;

class Student
{
	int id;
	String name;
	
	Student(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public Student getClone()
	{
		return new Student(this.id,this.name);
	}
}
public class PrototypeExample 
{
	public static void main(String[] args) 
	{
		Student s1 = new Student(101,"Amarjit");
		System.out.println(s1.id + " : "+ s1.name);
		
		Student s2 = s1.getClone();
		System.out.println(s2.id + " : "+ s2.name);
		
	}

}

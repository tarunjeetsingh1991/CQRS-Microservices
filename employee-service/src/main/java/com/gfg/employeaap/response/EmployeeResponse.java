package com.gfg.employeaap.response;

public class EmployeeResponse {

    private int id;
    private String name;
    private String email;
    private String age;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

	public EmployeeResponse(int id, String name, String email, String age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
	}

	public EmployeeResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmployeeResponse [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + "]";
	}
    
}
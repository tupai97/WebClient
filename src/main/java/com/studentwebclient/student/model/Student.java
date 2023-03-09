package com.studentwebclient.student.model;

import java.util.List;

								
/*Lombok is used to reduce boilerplate code for model/data objects, e.g., 
 * it can generate getters and setters for those object automatically by
 *  using Lombok annotations
*/
//@Getter    
//@Setter					
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@EqualsAndHashCode
//@EqualsAndHashCode.Exclude
//@Data -- This annotation is a shortcut annotation and bundles @ToString, @Getter, @Setter, @EqualsAndHashCode and @RequiredArgsConstructor annotations into a single annotation.
//

public class Student implements Comparable<Student> {
	private Integer id;
	private String name;
	private String email;
	private String dob;
	private Integer age;
	
	
	//mappedby is used to give control to other class , join cloum does the same , so both cannot used 
	//simultaniously 
	//@OneToMany(cascade = CascadeType.ALL , mappedBy = "stu"  )
	
	
	
	public Student() {}
	
	public Student(Integer id, String name, String email, String dob, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		if(this.age > o.age) {
			return -1;
		}
		else if(this.age< o.age) {
			return 1;
		}
		return 0;
	}
	

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", age=" + age + "]";
	}

	
	

}

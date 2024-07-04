package com.Fyndus.DTO;

import java.util.List;

import com.Fyndus.entity.Student;
import com.Fyndus.entity.Tutor;

public class SchoolDataResponse {
	private List<Student> students;
	private List<Tutor> staff;

	public SchoolDataResponse(List<Student> students, List<Tutor> staff) {
		this.students = students;
		this.staff = staff;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Tutor> getStaff() {
		return staff;
	}

	public void setStaff(List<Tutor> staff) {
		this.staff = staff;
	}
}

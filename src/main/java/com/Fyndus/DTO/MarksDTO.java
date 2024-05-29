package com.Fyndus.DTO;

public class MarksDTO {

	private long studentId;
	private String studentName;
	private long totalMarks;

	public MarksDTO(Long studentId, String studentName, Long totalMarks) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.totalMarks = totalMarks;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public long getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(long totalMarks) {
		this.totalMarks = totalMarks;
	}

}

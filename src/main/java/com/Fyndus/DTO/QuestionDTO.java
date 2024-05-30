package com.Fyndus.DTO;

public class QuestionDTO {

	private long id;
	private String text;
	private long tutorId;
	private String tutorName;

	public QuestionDTO(long id, String text, long tutorId, String tutorName) {
		this.id = id;
		this.text = text;
		this.tutorId = tutorId;
		this.tutorName = tutorName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getTutorId() {
		return tutorId;
	}

	public void setTutorId(long tutorId) {
		this.tutorId = tutorId;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}
}

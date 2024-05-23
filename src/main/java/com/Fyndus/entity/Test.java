	package com.Fyndus.entity;
	
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.ManyToOne;
	
	@Entity
	public class Test {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
		private long id;
	
		private Boolean answer;
	
		public long getId() {
			return id;
		}
		
		public Integer getMarks() {
			return marks;
		}
	
		public void setMarks(Integer marks) {
			this.marks = marks;
		}
	
		public Integer marks;
	
		public void setId(long id) {
			this.id = id;
		}
	
		public Boolean getAnswer() {
			return answer;
		}
	
		public void setAnswer(Boolean answer) {
			this.answer = answer;
		}
	
		public Student getStudent() {
			return student;
		}
	
		public void setStudent(Student student) {
			this.student = student;
		}
	
		public Question getQuestion() {
			return question;
		}
	
		public void setQuestion(Question question) {
			this.question = question;
		}
	
		public Choice getChoice() {
			return choice;
		}
	
		public void setChoice(Choice choice) {
			this.choice = choice;
		}
	
		@ManyToOne
		private Student student;
	
		@ManyToOne
		private Question question;
	
		@ManyToOne
		private Choice choice;
	}

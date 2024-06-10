package com.Fyndus.DTO;

public class ChoiceDTO {

	private long id;
	private String choices;
	private Boolean isCorrect;

	public ChoiceDTO(long id, String choices, Boolean isCorrect) {
		this.id = id;
		this.choices = choices;
		this.isCorrect = isCorrect;
	}

	public long getId() {
		return id;	
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getChoices() {
		return choices;
	}

	public void setChoices(String choices) {
		this.choices = choices;
	}

	public Boolean getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
}

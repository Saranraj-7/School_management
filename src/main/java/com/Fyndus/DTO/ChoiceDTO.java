package com.Fyndus.DTO;

public class ChoiceDTO {

	private long id;
	private String choices;

	public ChoiceDTO(long id, String choices) {
		this.id = id;
		this.choices = choices;
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
}

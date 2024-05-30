package com.Fyndus.DTO;

public class TestDTO {

	private long id;
	private QuestionDTO questionDTO;
	private ChoiceDTO choiceDTO;

	public TestDTO(long id, QuestionDTO questionDTO, ChoiceDTO choiceDTO) {
		this.id = id;
		this.questionDTO = questionDTO;
		this.choiceDTO = choiceDTO;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public QuestionDTO getQuestionDTO() {
		return questionDTO;
	}

	public void setQuestionDTO(QuestionDTO questionDTO) {
		this.questionDTO = questionDTO;
	}

	public ChoiceDTO getChoiceDTO() {
		return choiceDTO;
	}

	public void setChoiceDTO(ChoiceDTO choiceDTO) {
		this.choiceDTO = choiceDTO;
	}
}

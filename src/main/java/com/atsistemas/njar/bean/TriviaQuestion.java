package com.atsistemas.njar.bean;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;

//@Entity
final public class TriviaQuestion extends AbstractBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final private Long id;
	final private String question;
	final private String answerA;
	final private String answerB;
	final private String answerC;
	final private String answerD;
	final private String correctAnswer;
	final private String hint;
	final private Date lastUpdated;
	
	public TriviaQuestion(Long id, String question, String answerA, String answerB, String answerC, String answerD,
			String correctAnswer, String hint, Date lastUpdated) {
		super();
		this.id = id;
		this.question = question;
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.answerD = answerD;
		this.correctAnswer = correctAnswer;
		this.hint = hint;
		this.lastUpdated = lastUpdated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswerA() {
		return answerA;
	}

	public String getAnswerB() {
		return answerB;
	}

	public String getAnswerC() {
		return answerC;
	}

	public String getAnswerD() {
		return answerD;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public String getHint() {
		return hint;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerA == null) ? 0 : answerA.hashCode());
		result = prime * result + ((answerB == null) ? 0 : answerB.hashCode());
		result = prime * result + ((answerC == null) ? 0 : answerC.hashCode());
		result = prime * result + ((answerD == null) ? 0 : answerD.hashCode());
		result = prime * result + ((correctAnswer == null) ? 0 : correctAnswer.hashCode());
		result = prime * result + ((hint == null) ? 0 : hint.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastUpdated == null) ? 0 : lastUpdated.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TriviaQuestion)
			return EqualsBuilder.reflectionEquals(this.getId(), ((TriviaQuestion)obj).getId());
		return false;
	}
	
	
}

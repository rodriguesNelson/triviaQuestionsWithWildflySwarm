package com.atsistemas.njar.builder;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.atsistemas.njar.bean.TriviaQuestion;

public class TriviaQuestionBuilder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String question;
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	private String correctAnswer;
	private String hint;
	private Date lastUpdated;

	public TriviaQuestionBuilder id(Long id) {
		if (id < 0) {
			throw new IllegalArgumentException("Id cannot be less than zero.");
		}

		this.id = id;
		return this;
	}

	public TriviaQuestionBuilder answerA(String answerA) {
		if (StringUtils.isBlank(StringUtils.defaultIfBlank(answerA, StringUtils.EMPTY).trim())) {
			throw new IllegalArgumentException("Answer A cannot be null or empty");
		}

		this.answerA = answerA;
		return this;
	}
	
	public TriviaQuestionBuilder answerB(String answerB) {
		if (StringUtils.isBlank(StringUtils.defaultIfBlank(answerB, StringUtils.EMPTY).trim())) {
			throw new IllegalArgumentException("Answer B cannot be null or empty");
		}

		this.answerB = answerB;
		return this;
	}
	
	public TriviaQuestionBuilder answerC(String answerC) {
		if (StringUtils.isBlank(StringUtils.defaultIfBlank(answerC, StringUtils.EMPTY).trim())) {
			throw new IllegalArgumentException("Answer C cannot be null or empty");
		}

		this.answerC = answerC;
		return this;
	}
	
	public TriviaQuestionBuilder answerD(String answerD) {
		if (StringUtils.isBlank(StringUtils.defaultIfBlank(answerD, StringUtils.EMPTY).trim())) {
			throw new IllegalArgumentException("Answer D cannot be null or empty");
		}

		this.answerD = answerD;
		return this;
	}
	
	public TriviaQuestionBuilder correctAnswer(String correctAnswer) {
		if (StringUtils.isBlank(StringUtils.defaultIfBlank(correctAnswer, StringUtils.EMPTY).trim())) {
			throw new IllegalArgumentException("Correct answer cannot be null or empty");
		}

		this.correctAnswer = correctAnswer;
		return this;
	}
	
	public TriviaQuestionBuilder hint(String hint) {
		if (StringUtils.isBlank(StringUtils.defaultIfBlank(hint, StringUtils.EMPTY).trim())) {
			throw new IllegalArgumentException("Hint cannot be null or empty");
		}

		this.hint = hint;
		return this;
	}
	
	public TriviaQuestionBuilder question(String question) {
		if (null == question) {
			throw new IllegalArgumentException("Question cannot be null or empty");
		}

		this.question = question;
		return this;
	}
	
	public TriviaQuestionBuilder lastUpdated(Date lastUpdated) {
		if (null == lastUpdated) {
			throw new IllegalArgumentException("Last updated date cannot be null");
		}

		this.lastUpdated = lastUpdated;
		return this;
	}
	
	public TriviaQuestion build() {
		if ((null == this.id) || (this.id < 0) || StringUtils.isBlank(StringUtils.defaultIfBlank(this.question, StringUtils.EMPTY).trim())
				|| StringUtils.isBlank(StringUtils.defaultIfBlank(this.answerA, StringUtils.EMPTY).trim())
				|| StringUtils.isBlank(StringUtils.defaultIfBlank(this.answerB, StringUtils.EMPTY).trim())
				|| StringUtils.isBlank(StringUtils.defaultIfBlank(this.answerC, StringUtils.EMPTY).trim())
				|| StringUtils.isBlank(StringUtils.defaultIfBlank(this.answerD, StringUtils.EMPTY).trim())
				|| StringUtils.isBlank(StringUtils.defaultIfBlank(this.correctAnswer, StringUtils.EMPTY).trim())
				|| StringUtils.isBlank(StringUtils.defaultIfBlank(this.hint, StringUtils.EMPTY).trim())
				|| null == this.lastUpdated) {
			throw new IllegalStateException("TriviaQuestion builder not in suitable state.");
		}
		return new TriviaQuestion(this.id, this.question, this.answerA, this.answerB, this.answerC, this.answerD, this.correctAnswer, this.hint,
				this.lastUpdated);
	}

}

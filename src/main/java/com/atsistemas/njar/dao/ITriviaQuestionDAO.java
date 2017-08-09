package com.atsistemas.njar.dao;

import java.util.List;

import javax.annotation.CheckForNull;

import com.atsistemas.njar.bean.TriviaQuestion;
import com.atsistemas.njar.exception.NoDataFoundException;

public interface ITriviaQuestionDAO {
	@CheckForNull
	TriviaQuestion getQuestionByIndex(@CheckForNull Long index) throws NoDataFoundException;

	@CheckForNull
	TriviaQuestion getQuestionById(@CheckForNull Long id) throws NoDataFoundException;

	@CheckForNull
	TriviaQuestion getRandomQuestion() throws NoDataFoundException;

	List<TriviaQuestion> getQuestionList(@CheckForNull Long offset) throws NoDataFoundException;

	List<TriviaQuestion> getSpecifiedQuestionList(@CheckForNull Long... ids) throws NoDataFoundException;

	Long getQuestionListSize() throws NoDataFoundException;
}

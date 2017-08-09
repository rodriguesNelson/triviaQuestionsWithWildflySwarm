package com.atsistemas.njar.manager;

import java.util.List;

import javax.annotation.CheckForNull;

import com.atsistemas.njar.bean.TriviaQuestion;
import com.atsistemas.njar.exception.ManagerException;

public interface IManagerTriviaQuestion {
	@CheckForNull
	TriviaQuestion getQuestionByIndex(@CheckForNull Long index) throws ManagerException;
	
	@CheckForNull
	TriviaQuestion getQuestionById(@CheckForNull Long id) throws ManagerException;
	
	@CheckForNull
	TriviaQuestion getRandomQuestion() throws ManagerException;
	
	List<TriviaQuestion> getQuestionList(@CheckForNull Long offset) throws ManagerException;
	
	List<TriviaQuestion> getSpecifiedQuestionList(@CheckForNull Long... ids) throws ManagerException;
	
	Long getQuestionListSize() throws ManagerException;
}

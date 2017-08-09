package com.atsistemas.njar.manager;

import java.util.List;

import javax.annotation.CheckForNull;

import com.atsistemas.njar.bean.TriviaQuestion;
import com.atsistemas.njar.dao.ITriviaQuestionDAO;
import com.atsistemas.njar.dao.TriviaQuestionDaoImpl;
import com.atsistemas.njar.exception.ManagerException;
import com.atsistemas.njar.exception.NoDataFoundException;
import com.atsistemas.njar.exception.ResourceNotFoundException;

public class ManagerTriviaQuestionImpl implements IManagerTriviaQuestion {

	private static IManagerTriviaQuestion managerTriviaQuestion;
	private static ITriviaQuestionDAO triviaQuestionDao;

	public static IManagerTriviaQuestion init() {
		if (null == managerTriviaQuestion) {
			managerTriviaQuestion = new ManagerTriviaQuestionImpl();
		}
		loadTriviaQuestionDao();
		return managerTriviaQuestion;
	}

	private static void loadTriviaQuestionDao() {
		if (null == triviaQuestionDao) {
			triviaQuestionDao = TriviaQuestionDaoImpl.init();
		}
	}

	@Override
	public TriviaQuestion getQuestionByIndex(@CheckForNull Long index) throws ManagerException {
		try {
			return triviaQuestionDao.getQuestionByIndex(index);
		} catch (NullPointerException e) {
			throw new ManagerException(
					"Some exception occured when it tries to get a question by the index " + index);
		} catch (NoDataFoundException e) {
			throw new ResourceNotFoundException(
					"Resource not found when it tries to get a question by the index " + index);
		}
	}

	@Override
	public TriviaQuestion getQuestionById(@CheckForNull Long id) throws ManagerException {
		try {
			return triviaQuestionDao.getQuestionById(id);
		} catch (NullPointerException e) {
			throw new ManagerException(
					"Some exception occured when it tries to get a question by it's identifier " + id);
		} catch (NoDataFoundException e) {
			throw new ResourceNotFoundException(
					"Resource not found when it tries to get a question by it's identifier " + id);
		}
	}

	@Override
	public TriviaQuestion getRandomQuestion() throws ManagerException {
		try {
			return triviaQuestionDao.getRandomQuestion();
		} catch (NullPointerException e) {
			throw new ManagerException(
					"Some exception occured when it tries to get a ramdom question");
		} catch (NoDataFoundException e) {
			throw new ResourceNotFoundException(
					"Resource not found when it tries to get a ramdom question");
		}
	}

	@Override
	public List<TriviaQuestion> getQuestionList(@CheckForNull Long offset) throws ManagerException {
		try {
			return triviaQuestionDao.getQuestionList(offset);
		} catch (NoDataFoundException e) {
			throw new ResourceNotFoundException(
					"Some exception occured when it tries to get all the questions list");
		}
	}

	@Override
	public List<TriviaQuestion> getSpecifiedQuestionList(@CheckForNull Long... ids) throws ManagerException {
		try {
			return triviaQuestionDao.getSpecifiedQuestionList(ids);
		} catch (NoDataFoundException e) {
			throw new ResourceNotFoundException(
					"Some exception occured when it tries to get the questions list for the provided identifiers "
							+ ids.toString());
		}
	}

	@Override
	public Long getQuestionListSize() throws ManagerException {
		try {
			return triviaQuestionDao.getQuestionListSize();
		} catch (NoDataFoundException e) {
			throw new ResourceNotFoundException("Some exception occured when it tries to get a ramdom question");
		}
	}
}

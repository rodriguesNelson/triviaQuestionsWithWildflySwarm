package com.atsistemas.njar.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.CheckForNull;

import com.atsistemas.njar.bean.TriviaQuestion;
import com.atsistemas.njar.builder.TriviaQuestionBuilder;
import com.atsistemas.njar.exception.NoDataFoundException;
public class TriviaQuestionDaoImpl implements ITriviaQuestionDAO {

	private static ITriviaQuestionDAO triviaQuestionDao;
	
	private List<TriviaQuestion> questionList;
	
	private static final Long MAX_NUMBER_OF_QUESTIONS_PER_PAGE = 10L;

	public TriviaQuestionDaoImpl() {
		loadQuestionList();
	}
	
	public static ITriviaQuestionDAO init() {
		if (null == triviaQuestionDao) {
			triviaQuestionDao = new TriviaQuestionDaoImpl();
			return triviaQuestionDao;
		}
		return triviaQuestionDao;
	}
	
	private void loadQuestionList() {
		questionList = new ArrayList<>();
		TriviaQuestionBuilder tqbuilder = new TriviaQuestionBuilder();
		questionList.add((tqbuilder).id(0L).question("How many feet are in a mile?").answerA("5260").answerB("5270")
				.answerC("5280").answerD("5290").correctAnswer("C").hint("The altitude of Denver, Colorado")
				.lastUpdated(new Date()).build());
		questionList.add((tqbuilder).id(1L).question("How many feet are in a mile 2?").answerA("5260").answerB("5270")
				.answerC("5280").answerD("5290").correctAnswer("C").hint("The altitude of Denver, Colorado 2")
				.lastUpdated(new Date()).build());
		questionList.add((tqbuilder).id(2L).question("How many feet are in a mile 3?").answerA("5260").answerB("5270")
				.answerC("5280").answerD("5290").correctAnswer("C").hint("The altitude of Denver, Colorado 3")
				.lastUpdated(new Date()).build());
		questionList.add((tqbuilder).id(3L).question("How many feet are in a mile 4?").answerA("5260").answerB("5270")
				.answerC("5280").answerD("5290").correctAnswer("C").hint("The altitude of Denver, Colorado 4")
				.lastUpdated(new Date()).build());
		questionList.add((tqbuilder).id(4L).question("How many feet are in a mile 5?").answerA("5260").answerB("5270")
				.answerC("5280").answerD("5290").correctAnswer("C").hint("The altitude of Denver, Colorado 5")
				.lastUpdated(new Date()).build());
		questionList.add((tqbuilder).id(5L).question("How many feet are in a mile 6?").answerA("5260").answerB("5270")
				.answerC("5280").answerD("5290").correctAnswer("C").hint("The altitude of Denver, Colorado 6")
				.lastUpdated(new Date()).build());
		questionList.add((tqbuilder).id(6L).question("How many feet are in a mile 7?").answerA("5260").answerB("5270")
				.answerC("5280").answerD("5290").correctAnswer("C").hint("The altitude of Denver, Colorado 7")
				.lastUpdated(new Date()).build());
		questionList.add((tqbuilder).id(7L).question("How many feet are in a mile 8?").answerA("5260").answerB("5270")
				.answerC("5280").answerD("5290").correctAnswer("C").hint("The altitude of Denver, Colorado 8")
				.lastUpdated(new Date()).build());
		questionList.add((tqbuilder).id(8L).question("How many feet are in a mile 9?").answerA("5260").answerB("5270")
				.answerC("5280").answerD("5290").correctAnswer("C").hint("The altitude of Denver, Colorado 9")
				.lastUpdated(new Date()).build());
		questionList.add((tqbuilder).id(9L).question("How many feet are in a mile 10?").answerA("5260").answerB("5270")
				.answerC("5280").answerD("5290").correctAnswer("C").hint("The altitude of Denver, Colorado 10")
				.lastUpdated(new Date()).build());
	}

	@Override
	public TriviaQuestion getQuestionByIndex(@CheckForNull Long index) throws NoDataFoundException {
		if (index.intValue() >= questionList.size()) {
			throw new NoDataFoundException("No data found for the provide index " + index);
		}
		return questionList.get(index.intValue());
	}

	@Override
	public TriviaQuestion getQuestionById(@CheckForNull Long id) throws NoDataFoundException {
		for (TriviaQuestion triviaQuestion : questionList) {
			if (null != triviaQuestion && triviaQuestion.getId().equals(id)) {
				return triviaQuestion;
			}
		}
		throw new NoDataFoundException("No data found for the provide id " + id);
	}

	@Override
	public TriviaQuestion getRandomQuestion() throws NoDataFoundException {
		int randomIndex = new Random().nextInt(questionList.size());
		return questionList.get(randomIndex);
	}

	@Override
	public List<TriviaQuestion> getQuestionList(@CheckForNull Long offset) throws NoDataFoundException {
		Long start = offset;
		if (start < 0L) {
			start = 0L;
		} else if(start.intValue() >= questionList.size()) {
			start = getQuestionListSize();
		}
		
		Long end = start + MAX_NUMBER_OF_QUESTIONS_PER_PAGE;
		if(end.intValue() >= questionList.size()) {
			end = getQuestionListSize();
		}
		
		return questionList.subList(start.intValue(), end.intValue());
	}

	@Override
	public List<TriviaQuestion> getSpecifiedQuestionList(@CheckForNull Long... ids) throws NoDataFoundException {
		List<TriviaQuestion> returnList = new ArrayList<>();
		for (Long id : ids) {
			returnList.add(getQuestionById(id));			
		}
		return returnList;
	}

	@Override
	public Long getQuestionListSize() throws NoDataFoundException {
		Long size =  null != questionList ?(long) questionList.size() : 0L;
		if(0L != size) {
			return size;
		}
		throw new NoDataFoundException("There are no questions available.");
	}
}

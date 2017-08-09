package com.atsistemas.njar.dao;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.atsistemas.njar.bean.TriviaQuestion;
import com.atsistemas.njar.builder.TriviaQuestionBuilder;

public class ITriviaQuestionDAOTest {

	private ITriviaQuestionDAO triviaQuestionDao;

	@Before
	public void setUp() {
		triviaQuestionDao = TriviaQuestionDaoImpl.init();
	}

	@Test
	public void testGetQuestionByIndex() {
		System.out.println("testGetQuestionByIndex");
		TriviaQuestionBuilder tqbuilder = new TriviaQuestionBuilder();
		TriviaQuestion expectedTriviaQuestion = tqbuilder.id(0L).question("How many feet are in a mile?").answerA("5260").answerB("5270")
				.answerC("5280").answerD("5290").correctAnswer("C").hint("The altitude of Denver, Colorado")
				.lastUpdated(new Date()).build();
		TriviaQuestion returnedTriviaQuestion = triviaQuestionDao.getQuestionByIndex(0L);
		assertNotNull("Trivia question by index not returned in ::getQuestionByIndex.", returnedTriviaQuestion);
		assertEquals(expectedTriviaQuestion, returnedTriviaQuestion);
	}

	@Test
	public void testGetQuestionById() {
		System.out.println("testGetQuestionById");
		TriviaQuestionBuilder tqbuilder = new TriviaQuestionBuilder();
		TriviaQuestion expectedTriviaQuestion = tqbuilder.id(0L).question("How many feet are in a mile?").answerA("5260").answerB("5270")
				.answerC("5280").answerD("5290").correctAnswer("C").hint("The altitude of Denver, Colorado")
				.lastUpdated(new Date()).build();
		TriviaQuestion returnedTriviaQuestion = triviaQuestionDao.getQuestionById(0L);
		assertNotNull("Trivia question by id not returned in ::getQuestionById.", returnedTriviaQuestion);
		assertEquals(expectedTriviaQuestion, returnedTriviaQuestion);
	}

	@Test
	public void testGetRandomQuestion() {
		System.out.println("testGetRandomQuestion");
		TriviaQuestion returnedTriviaQuestion = triviaQuestionDao.getRandomQuestion();
		assertNotNull("Trivia question by id not returned in ::getRandomQuestion.", returnedTriviaQuestion);
	}

	@Test
	public void testGetQuestionList() {
		System.out.println("testGetQuestionList");
		Long offset = 0L;
		List<TriviaQuestion> triviaQuestions = triviaQuestionDao.getQuestionList(offset);

		assertNotNull("Trivia question list not returned in ::getQuestionsList.", triviaQuestions);
		assertEquals(10, triviaQuestions.size());
	}

	@Test
	public void testGetSpecifiedQuestionList() {
		System.out.println("testGetSpecifiedQuestionList");
		TriviaQuestionBuilder tqbuilder = new TriviaQuestionBuilder();
		List<TriviaQuestion> expectedTriviaQuestions = Arrays.asList(tqbuilder.id(0L).question("How many feet are in a mile?").answerA("5260").answerB("5270")
				.answerC("5280").answerD("5290").correctAnswer("C").hint("The altitude of Denver, Colorado")
				.lastUpdated(new Date()).build(), tqbuilder.id(5L).question("How many feet are in a mile 6?").answerA("5260").answerB("5270")
				.answerC("5280").answerD("5290").correctAnswer("C").hint("The altitude of Denver, Colorado 6")
				.lastUpdated(new Date()).build(), tqbuilder.id(9L).question("How many feet are in a mile 10?").answerA("5260").answerB("5270")
				.answerC("5280").answerD("5290").correctAnswer("C").hint("The altitude of Denver, Colorado 10")
				.lastUpdated(new Date()).build());
		List<TriviaQuestion> returnedTriviaQuestions = triviaQuestionDao.getSpecifiedQuestionList(new Long[] {0L, 5L, 9L});
		assertNotNull("Trivia specified question list not returned in ::getSpecifiedQuestionList.", returnedTriviaQuestions);
		assertEquals(3, returnedTriviaQuestions.size());
		assertEquals(returnedTriviaQuestions, expectedTriviaQuestions);
		assertArrayEquals(returnedTriviaQuestions.toArray(), expectedTriviaQuestions.toArray());
	}

	@Test
	public void testGetQuestionListSize() {
		System.out.println("testGetQuestionListSize");
		Long returnedSize = triviaQuestionDao.getQuestionListSize();
		assertNotNull("Trivia questions list size not returned in ::getRandomQuestion.", returnedSize);
		assertTrue(returnedSize == 10L);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testBuildIdFail() {
		System.out.println("testBuildIdFail");
		new TriviaQuestionBuilder().id(-1L).build();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testBuildQuestionFail() {
		System.out.println("testBuildQuestionFail");
		new TriviaQuestionBuilder().question(null).build();
	}
}

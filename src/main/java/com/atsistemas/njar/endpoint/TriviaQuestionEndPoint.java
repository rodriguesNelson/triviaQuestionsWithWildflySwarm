package com.atsistemas.njar.endpoint;

import java.util.Date;
import java.util.List;

//import javax.ws.rs.ApplicationPath;
//import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
//import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang.StringUtils;

//import com.atsistemas.njar.bean.Pager;
import com.atsistemas.njar.bean.TriviaQuestion;
import com.atsistemas.njar.exception.ManagerException;
import com.atsistemas.njar.exception.ResourceNotFoundException;
import com.atsistemas.njar.manager.IManagerTriviaQuestion;
import com.atsistemas.njar.manager.ManagerTriviaQuestionImpl;

@Path("/questions")
final public class TriviaQuestionEndPoint {

	private final IManagerTriviaQuestion managerTriviaQuestion = new ManagerTriviaQuestionImpl();
	private final Date questionsUpdatedDate = new Date();
	private static final Long STARTING_OFFSET = 0L;
	private static final Long PAGE_SIZE = 10L;

	// @POST
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.APPLICATION_JSON)
	// public Response listQuestions(@Context UriInfo uri, Pager pager) {
	// Link seftLink =
	// Link.fromUri(uri.getBaseUri()).rel("self").type(MediaType.APPLICATION_JSON).build();
	// Link questionsLink = Link.fromUri(uri.getBaseUri() +
	// "questions").rel("questions")
	// .type(MediaType.APPLICATION_JSON).build();
	// return Response.ok().lastModified(new
	// Date()).location(uri.getRequestUri()).links(seftLink, questionsLink)
	// .build();
	// }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestions(@Context UriInfo uri, @QueryParam("offset") @DefaultValue("0") Long offset) {
		Long datasetSize;
		try {
			datasetSize = managerTriviaQuestion.getQuestionListSize();
		} catch (ManagerException e1) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Long start = offset;

		start = start < STARTING_OFFSET ? STARTING_OFFSET : start >= datasetSize ? datasetSize : start;

		// Setup the navigation links
		Link selfLink = Link.fromUri(uri.getBaseUri() + "questions?offset=(offset)").rel("self")
				.type(MediaType.APPLICATION_JSON).build(offset);

		Long nextOffset = (offset + PAGE_SIZE < datasetSize) ? offset + PAGE_SIZE
				: PAGE_SIZE * (datasetSize / PAGE_SIZE);
		Link nextLink = Link.fromUri(uri.getBaseUri() + "questions?offset=(offset)").rel("next")
				.type(MediaType.APPLICATION_JSON).build(nextOffset);

		Long previousOffset = (offset - PAGE_SIZE > STARTING_OFFSET) ? offset - PAGE_SIZE : STARTING_OFFSET;
		Link previousLink = Link.fromUri(uri.getBaseUri() + "questions?offset=(offset)").rel("previous")
				.type(MediaType.APPLICATION_JSON).build(previousOffset);

		Link firstLink = Link.fromUri(uri.getBaseUri() + "questions?offset=(offset)").rel("first")
				.type(MediaType.APPLICATION_JSON).build(STARTING_OFFSET);
		Link lastLink = Link.fromUri(uri.getBaseUri() + "questions?offset=(offset)").rel("last")
				.type(MediaType.APPLICATION_JSON).build(PAGE_SIZE * (datasetSize / PAGE_SIZE));

		Link countLink = Link.fromUri(uri.getBaseUri() + "questions/count").rel("count")
				.type(MediaType.APPLICATION_JSON).build();
		Link randomLink = Link.fromUri(uri.getBaseUri() + "questions/random").rel("random")
				.type(MediaType.APPLICATION_JSON).build();

		// Get the list of questions from starting point	
		try {
			List<TriviaQuestion> triviaQuestions = managerTriviaQuestion.getQuestionList(start);
			return Response.ok(triviaQuestions).header("question-count", datasetSize)
					.header("current-question-list-size", triviaQuestions.size()).header("offset", start)
					.links(selfLink, nextLink, previousLink, firstLink, lastLink, countLink, randomLink)
					.lastModified(questionsUpdatedDate).location(uri.getRequestUri()).build();
		} catch (ManagerException e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionsCount(@Context UriInfo uri) {
		Long numberOfQuestions;
		try {
			numberOfQuestions = managerTriviaQuestion.getQuestionListSize();
			return Response.ok(numberOfQuestions).header("question-count", numberOfQuestions)
					.lastModified(questionsUpdatedDate).location(uri.getRequestUri()).build();
		} catch (ManagerException e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestion(@Context UriInfo uri, @PathParam("id") String id) {
		if ("random".equalsIgnoreCase(StringUtils.defaultIfBlank(id, StringUtils.EMPTY).trim())) {
			try {
				TriviaQuestion triviaQuestion = managerTriviaQuestion.getRandomQuestion();
				return Response.ok(triviaQuestion).lastModified(triviaQuestion.getLastUpdated())
						.location(uri.getRequestUri()).build();
			} catch (ResourceNotFoundException rnfe) {
				return Response.status(Response.Status.NOT_FOUND).build();
			} catch (ManagerException e) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			}
		} else {
			try {
				Long identifier = Long.parseLong(id);
				TriviaQuestion triviaQuestion = managerTriviaQuestion.getQuestionById(identifier);
				return Response.ok(triviaQuestion).lastModified(triviaQuestion.getLastUpdated())
						.location(uri.getRequestUri()).build();
			} catch (NumberFormatException nfe) {
				return Response.status(Response.Status.BAD_REQUEST).build();
			} catch (ResourceNotFoundException rnfe) {
				return Response.status(Response.Status.NOT_FOUND).build();
			} catch (ManagerException e) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			}
		}
	}
}

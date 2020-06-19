package com.cos.baseball.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.baseball.model.TeamList;
import com.cos.baseball.repository.BaseballRepository;

public class BaseballHomeAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseballRepository baseballRepository = BaseballRepository.getInstance();
		
		List<TeamList> teamLists = baseballRepository.findTeamAll();
		
		request.setAttribute("teamLists", teamLists);
		
		RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
		dis.forward(request, response);
		
		
	}
}

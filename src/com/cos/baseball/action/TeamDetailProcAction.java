package com.cos.baseball.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.baseball.model.Player;
import com.cos.baseball.repository.BaseballRepository;
import com.cos.baseball.util.Script;
import com.google.gson.Gson;

public class TeamDetailProcAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();

		String selectTeam = request.getParameter("teamName");

		BaseballRepository baseballRepository = BaseballRepository.getInstance();

		List<Player> playerLists = baseballRepository.findbyTeam(selectTeam);

		//request.setAttribute("playerLists", playerLists);
		System.out.println("TeamDetailProcAction: " + playerLists);

	
		String playerListJson = gson.toJson(playerLists);
		System.out.println("playerListJson : " + playerListJson);
		Script.outJson(playerListJson, response);
		
		
	}
}

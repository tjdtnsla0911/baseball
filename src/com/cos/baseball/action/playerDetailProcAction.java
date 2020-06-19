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

public class playerDetailProcAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();

		String selectPlayer = request.getParameter("id");

		BaseballRepository baseballRepository = BaseballRepository.getInstance();

		List<Player> detailPlayerLists = baseballRepository.findbyPlayer(selectPlayer);

		//request.setAttribute("playerLists", playerLists);
		System.out.println("playerDetailProcAction: " + detailPlayerLists);

	
		String detailPlayerListJson = gson.toJson(detailPlayerLists);
		System.out.println("playerListJson : " + detailPlayerListJson);
		Script.outJson(detailPlayerListJson, response);
		
		
	}
}

package com.cos.baseball.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.baseball.action.Action;
import com.cos.baseball.action.BaseballHomeAction;
import com.cos.baseball.action.TeamDetailProcAction;
import com.cos.baseball.action.playerDetailProcAction;


@WebServlet("/baseball")
public class BaseballController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BaseballController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		Action action = router(cmd);
		action.execute(request, response);
		
	}


	public Action router(String cmd) {
		if(cmd.equals("home")) {
			// Home 페이지로 이동
			return new BaseballHomeAction(); //Board 의 목록
		}else if(cmd.equals("teamDetailProc")) {
			return new TeamDetailProcAction();
		}else if(cmd.equals("playerDetailProc")) {
			return new playerDetailProcAction();
		}
		return null;
	}
}

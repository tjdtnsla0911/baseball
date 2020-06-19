package com.cos.baseball.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.baseball.db.DBConn;
import com.cos.baseball.model.TeamList;
import com.cos.baseball.model.Player;
import com.sun.media.jfxmedia.events.PlayerEvent;

public class BaseballRepository {
	
	private static final String TAG = "BaseballRepository : ";
	private static BaseballRepository instance = new BaseballRepository();
	private BaseballRepository() {}
	public static BaseballRepository getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	public List<TeamList> findTeamAll(){
		final String SQL = "SELECT * FROM teamList";
		List<TeamList> teamLists = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				TeamList teamList = new TeamList(
						rs.getInt("id"),
						rs.getString("teamname")
				);
				teamLists.add(teamList);
		
			}
			return teamLists;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findTeamAll() : "+e.getMessage());
			
		} finally {
			DBConn.close(conn, pstmt ,rs);
		}
		
		return null;
		
	}
	
	public List<Player> findbyTeam(String teamName){
		final String SQL = "SELECT * FROM PLAYER WHERE teamname=?";
		List<Player> players = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, teamName);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Player player = new Player(
						rs.getInt("id"),
						rs.getString("playerid"),
						rs.getString("teamname"),
						rs.getString("playername"),
						rs.getString("position")
				);
				players.add(player);
		
			}
			return players;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findTeamAll() : "+e.getMessage());
			
		} finally {
			DBConn.close(conn, pstmt ,rs);
		}
		
		return null;
		
	}
	
	public List<Player> findbyPlayer(String id){
		final String SQL = "SELECT * FROM PLAYER WHERE id=?";
		List<Player> players = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Player player = new Player(
						rs.getInt("id"),
						rs.getString("playerid"),
						rs.getString("teamname"),
						rs.getString("playername"),
						rs.getString("position")
				);
				players.add(player);
		
			}
			return players;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findTeamAll() : "+e.getMessage());
			
		} finally {
			DBConn.close(conn, pstmt ,rs);
		}
		
		return null;
		
	}
}

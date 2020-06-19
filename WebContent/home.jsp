<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

  <title>baseball</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
 <style>
 body{
 background-img:url('/baseball/img/neko.gif')
 }
 </style>
</head>
<body>
<br/>
<div class="container">
	<div class="d-flex">
  <table class="table table-dark  table-hover mr-1">
    <thead>
      <tr>
        <th colspan="2">팀목록</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="teamList" items="${teamLists}">
      <tr>
        <td onclick="teamdetail('${teamList.teamName}')">${teamList.id}</td>
        <td onclick="teamdetail('${teamList.teamName}')">${teamList.teamName}</td>
      </tr>
     </c:forEach>
    </tbody>
  </table>

  <table class="table table-dark table-hover mr-1">
    <thead>
      <tr>
        <th>선수 번호</th>
        <th>선수 목록</th>
      </tr>
    </thead>
    <tbody id="table__playerList">
      <tr>

      </tr>
    </tbody>
  </table>

  <table class="table table-dark table-hover mr-1">
    <thead>
      <tr>
        <th>선수 번호</th>
        <th>선수 이름</th>
        <th>선수 포지션</th>
      </tr>
    </thead>
    <tbody id="table__detailPlayerList">
      <tr>

      </tr>
    </tbody>
  </table>
  </div>
</div>

<script src="/baseball/js/baseball.js"></script>
</body>
</html>
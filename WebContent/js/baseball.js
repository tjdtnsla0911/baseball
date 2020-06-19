function teamdetail(teamName) {
	console.log(teamName);
	$.ajax({
		type: "post",
		url: "/baseball/baseball?cmd=teamDetailProc",
		data: "teamName="+teamName, //request.getparameter 로 받을수있음
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType: "json"
	}).done(function(playerListJson){
		console.log(playerListJson);
		$("#table__playerList").empty();
		renderTableList(playerListJson);
		$("#table__playerList").val("");

	}).fail(function(error){
		alert("실패");
	});
}



function renderTableList(playerListJson){
	for(var playerList of playerListJson){
		$("#table__playerList").append(makeItem(playerList));
	}
}


function makeItem(playerList){

var teamItem = `<tr>`;
teamItem += `<td onclick="playerdetail('${playerList.id}')">${playerList.playerId}</td>`;
teamItem += `<td onclick="playerdetail('${playerList.id}')">${playerList.playerName}</td>`;
teamItem +=`</tr>`;

return teamItem;
}



function playerdetail(id) {
	console.log(id);
	$.ajax({
		type: "post",
		url: "/baseball/baseball?cmd=playerDetailProc",
		data: "id="+id, //request.getparameter 로 받을수있음
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType: "json"
	}).done(function(detailPlayerListJson){
		//console.log(detailPlayerListJson);
		$("#table__detailPlayerList").empty();
		renderPlayerTableList(detailPlayerListJson);
		//$("#table__playerList").val("");

	}).fail(function(error){
		alert("실패");
	});
}


function renderPlayerTableList(detailPlayerListJson){
	for(var detailPlayer of detailPlayerListJson){
		$("#table__detailPlayerList").append(playerMakeItem(detailPlayer));
	}
}


function playerMakeItem(detailPlayer){
console.log(detailPlayer);
var plyerItem = `<tr>`
plyerItem += `<td>${detailPlayer.playerId}</td>`
plyerItem += `<td>${detailPlayer.playerName}</td>`
plyerItem += `<td>${detailPlayer.position}</td>`
plyerItem +=`</tr>`

return plyerItem;
}





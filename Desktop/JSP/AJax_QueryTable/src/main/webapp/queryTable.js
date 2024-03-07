window.onload = function(){
	// AJax 요청
		$.ajax({
		type: "POST",
		url: "QueryServlet",
		data: {name : name},
		success: function(response) {
			/* 서버에서 받은 응답 처리 */
			createTable(response)
		}
	})
}

function createTable(data){
	let table = "<table border='1'>"
	table += "<tr><th>Code</th><th>Name</th><th>Dept</th><th>Phone</th><th>Address</th></tr>"
	// 데이터 행 추가
	for(let i = 0; i < data.length; i++){
		table += "<tr>" +
		"<td>" +data[i].scode + "</td>" +
		"<td>" +data[i].sname + "</td>" +
		"<td>" +data[i].sdept + "</td>" +
		"<td>" +data[i].sphone + "</td>" +
		"<td>" +data[i].saddress + "</td>" +
		"</tr>"
		
		
		
	}
	table += "</table>"
	$("#result").html(table);
	
}








$(document).ready(function() {
		/* 버튼 클릭시 AJAX 요청 */
		$("#queryButton").click(function() {
			/* 입력된 데이터 가져오기 */
			let name = $("#name").val()
			/* AJAX 요청 */
			$.ajax({
				type: "POST",
				url: "QueryServlet",
				data: {name : name},
				success: function(response) {
					/* 서버에서 받은 응답 처리 */
					createTable(response)

				}
			})
		})
		
	})
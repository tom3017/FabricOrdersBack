window.onload = function() {
	//AJAX요청
	$.ajax({
		type: "POST",
		url: "UpdateServlet",
		data: { name: "" },
		success: function(response) {
			/* 서버에서 받은 응답 처리 */
			createTable(response)
		}
	})

}
// update
function createTable(data) {
	
	// 검색해온 데이터를 다른 function에서 사용하기 위해 전역변수의 배열변수로 복사
	dataReal = Array.from(data)
	
	
	let table = "<table border='1'>"
	table += "<tr><th>Code</th><th>Name</th><th>Dept</th><th>Phone</th><th>Address</th></tr>"
	//데이터 행 추가
	for (let i = 0; i < data.length; i++) {
		table += "<tr>" +
			"<td id='" + data[i].scode + "'>" +
			//#은 하이퍼링크 구동 하지 않게 함							 //HTML 
			"<a href='#' onclick='handleClick(" + i + ")'>" + data[i].scode + "</a>"  +
			"</td>" +
			"<td>" + data[i].sname + "</td>" +
			"<td>" + data[i].sdept + "</td>" +
			"<td>" + data[i].sphone + "</td>" +
			"<td>" + data[i].saddress + "</td>" +
			"</tr>"

	}
	table += "</table>"
	$("#result").html(table);  //result 는 index에 있는 div id="result"

}

function handleClick(index){
	let inputScode = document.getElementById("scode")
	let inputSname = document.getElementById("sname")
	let inputSdept = document.getElementById("sdept")
	let inputSphone = document.getElementById("sphone")
	let inputSaddress = document.getElementById("saddress")
	
	
	inputScode.value = dataReal[index].scode
	inputSname.value = dataReal[index].sname
	inputSdept.value = dataReal[index].sdept
	inputSphone.value = dataReal[index].sphone
	inputSaddress.value = dataReal[index].saddress
	
	
}







$(document).ready(function() {
	/* 버튼 클릭시 AJAX 요청 */
	$("#queryButton").click(function() {
		/* 입력된 데이터 가져오기 */
		let name = $("#name").val()
		/* AJAX 요청 */
		$.ajax({
			type: "POST",
			url: "UpdateServlet",
			data: { name: name },
			success: function(response) {
				/* 서버에서 받은 응답 처리 */
				//$("#result").html(response)
				createTable(response)
			}
		})
	})

})


// update
$(document).ready(function() {
	/* 버튼 클릭시 AJAX 요청 */
	$("#submitBtn").click(function() {
		/* 입력된 데이터 가져오기 */
		let code = $("#scode").val()
		let name = $("#sname").val()
		let dept = $("#sdept").val()
		let phone = $("#sphone").val()
		let address = $("#saddress").val()
		
		/* AJAX 요청 */
		$.ajax({
			type: "POST",
			url: "UpdateAction",
			data: {
				code: code,
				name: name,
				dept: dept,
				phone: phone,
				address: address 
			},
			success: function(response) {
				/* 서버에서 받은 응답 처리 */
				//$("#result").html(response)
					$.ajax({
						type: "POST",
						url: "UpdateServlet",
						data: { name: "" },
						success: function(response) {
							/* 서버에서 받은 응답 처리 */
							createTable(response)
							 // 텍스트 필드 초기화
                  			$("#scode, #sname, #sdept, #sphone, #saddress").val("");
						}
					})
				alert("수정 되었습니다.")

			},
			error : function(xhr, status, error){
				alert("수정시 문제가 발생하였습니다." + error)
			}
		})
	})

})

//insert
$(document).ready(function() {
	/* 버튼 클릭시 AJAX 요청 */
	$("#insertBtn").click(function() {
		/* 입력된 데이터 가져오기 */
		let code = $("#scode").val()
		let name = $("#sname").val()
		let dept = $("#sdept").val()
		let phone = $("#sphone").val()
		let address = $("#saddress").val()
		
		/* AJAX 요청 */
		$.ajax({
			type: "POST",
			url: "InsertAction",
			data: {
				code: code,
				name: name,
				dept: dept,
				phone: phone,
				address: address 
			},
			success: function(response) {
				/* 서버에서 받은 응답 처리 */
				//$("#result").html(response)
					$.ajax({
						type: "POST",
						url: "UpdateServlet",
						data: { name: "" },
						success: function(response) {
							/* 서버에서 받은 응답 처리 */
							createTable(response)
							 // 텍스트 필드 초기화
                  			$("#scode, #sname, #sdept, #sphone, #saddress").val("");
						}
					})
				alert("입력 되었습니다.")

			},
			error : function(xhr, status, error){
				alert("입력시 문제가 발생하였습니다." + error)
			}
		})
	})

})

$(document).ready(function() {
	/* 버튼 클릭시 AJAX 요청 */
	$("#deleteBtn").click(function() {
		/* 입력된 데이터 가져오기 */
		let code = $("#scode").val()
		let name = $("#sname").val()
		let dept = $("#sdept").val()
		let phone = $("#sphone").val()
		let address = $("#saddress").val()
		
		/* AJAX 요청 */
		$.ajax({
			type: "POST",
			url: "DeleteAction",
			data: {
				code: code,
				name: name,
				dept: dept,
				phone: phone,
				address: address 
			},
			success: function(response) {
				/* 서버에서 받은 응답 처리 */
				//$("#result").html(response)
					$.ajax({
						type: "POST",
						url: "UpdateServlet",
						data: { name: "" },
						success: function(response) {
							/* 서버에서 받은 응답 처리 */
							createTable(response)
							 // 텍스트 필드 초기화
                  			$("#scode, #sname, #sdept, #sphone, #saddress").val("");
						}
					})
				alert("삭제 되었습니다.")

			},
			error : function(xhr, status, error){
				alert("삭제시 문제가 발생하였습니다." + error)
			}
		})
	})

})



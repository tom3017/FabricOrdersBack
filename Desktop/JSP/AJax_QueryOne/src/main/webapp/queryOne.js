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
					$("#result").html(response)
				}
			})
		})
		
	})
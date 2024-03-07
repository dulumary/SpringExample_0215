<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 입력</title>
</head>
<body>
	<h2>사용자 추가</h2>
	
	<label>이름 : </label> <input type="text" id="nameInput"> <br>
	<label>생년월일 : </label> <input type="text" id="birthdayInput"> <br>
	<label>이메일 : </label><input type="text" id="emailInput"> <button type="button" id="duplicateBtn">중복확인</button> <br>
	<label>자기소개</label> <br>
	<textarea cols="30" rows="7" id="introduceInput"></textarea> <br>
	<button type="button" id="addBtn">추가</button>
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	
	<script>
		$(document).ready(function() {
			
			$("#duplicateBtn").on("click", function() {
				
				let email = $("#emailInput").val();
				
				if(email == "") {
					alert("이메일을 입력해주세요!");
					return ;
				}
				
				$.ajax({
					type:"get"
					, url:"/ajax/user/duplicate-email"
					, data:{"email":email}
					, success:function(data) {
						// 중복됨 :  {"isDuplicate":true}
						// 중복안됨 :{"isDuplicate":false}
						
						if(data.isDuplicate) {
							// 중복
							alert("이메일이 중복되었습니다!");
						} else {
							//중복 아님
							alert("사용가능한 이메일 입니다");
							
						}
						
					}
					, error:function() {
						alert("중복 확인 에러");
					}
				});
				
			});
			
			
			
			// 추가 버튼을 클릭하면
			
			$("#addBtn").on("click", function() {
				// 사용자가 입력한 내용을 얻어 오고
				let name = $("#nameInput").val();
				let birthday = $("#birthdayInput").val();
				let email = $("#emailInput").val();
				let introduce = $("#introduceInput").val();
				
				// ajax를 통해서 사용자 추가 API를 요청한다. 
				$.ajax({
					type:"get"
					, url:"/ajax/user/create"
					, data:{"name":name, "birthday":birthday, "email":email, "introduce":introduce}
					, success:function(data) {
						// 응답으로 전달된 값을 통해 다음 과정을 처리한다. 
						// 성공시 : {"result":"success"}
						// 실패시 : {"result":"fail"}
						if(data.result == "success") {
							// 성공
							// 리스트 페이지로 이동
							location.href = "/ajax/user/list";
						} else {
							// 실패
							alert("추가 실패!!");
						}
						
					}
					, error:function() {
						alert("추가 에러");
					}
				});
				
				
				
			});
			
			
			
			
			
		});
	
	</script>
</body>
</html>
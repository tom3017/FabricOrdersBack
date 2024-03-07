<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>회원가입</title>
    <!-- 부트스트랩 CSS 링크 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        /* 이하 스타일 부분은 생략 */
    </style>
    <script type="text/javascript">
    function checkLogin() {
        let form = document.loginForm;
        let profileImage = form.profileImage;

        // 파일이 선택되었는지 확인
        if (profileImage.files.length === 0) {
            alert("프로필 이미지를 선택하세요.");
            return false;
        }

        form.enctype = "multipart/form-data";
        form.submit();
        return true;
    }
    </script>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h2>회원가입</h2>
                    </div>
                    <div class="card-body">
                        <form name="loginForm" action="signInsert.do" method="post" enctype="multipart/form-data">
                            <div class="form-group">
                                <label for="id" class="animated-border">아이디</label>
                                <input type="text" class="form-control" id="id" name="id" required>
                            </div>
                            <div class="form-group">
                                <label for="passwd" class="animated-border">패스워드</label>
                                <input type="password" class="form-control" id="passwd" name="pw" required>
                            </div>
                            <div class="form-group">
                                <label for="name" class="animated-border">성명</label>
                                <input type="text" class="form-control" id="name" name="name" required>
                            </div>
                            <div class="form-group">
                                <label for="profileImage" class="animated-border">프로필 이미지 업로드</label>
                                <input type="file" class="form-control" id="profileImage" name="profileImage" accept="image/*">
                            </div>
                            <button type="button" class="btn btn-primary btn-block" onclick="checkLogin()">회원가입</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 부트스트랩 JS 및 Popper.js, jQuery 스크립트 링크 -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>

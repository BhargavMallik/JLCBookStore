<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>BookStore-V1.0</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f5f5f5;
        }
        .container {
            margin-top: 50px;
        }
        .login-container {
            max-width: 400px;
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .login-container h1, h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .login-container .form-group input {
            font-size: 16px;
        }
        .alert-message {
            text-align: center;
            margin-bottom: 15px;
        }
        .btn-primary {
            width: 100%;
        }
        .links {
            text-align: center;
            margin-top: 20px;
        }
        .links a {
            margin: 0 10px;
            color: #007bff;
        }
        h4{
        	text-align: center;
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="login-container mx-auto">
        	<h4>BookStore-V1.0</h4>
            <h1>JLC BookStore</h1>
            <h2>Login Form</h2>

            <!-- Display any registration, login, or logout messages -->
            <div class="alert-message">
                <font color="red" size="4">${RegMsg}</font> 
                <font color="red" size="4">${LoginMsg}</font> 
                <font color="red" size="4">${LogoutMsg}</font>
            </div>

            <!-- Login form -->
            <form action="mylogin.jlc" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="Enter username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" required>
                </div>
                <button type="submit" class="btn btn-primary">Login Now</button>
            </form>

            <!-- Links for new user signup and forgot password -->
            <div class="links">
                <a href="register.jsp">New User Signup</a> ||
                <a href="forgotpw.jsp">Forgot My Password</a>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

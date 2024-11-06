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
        .profile-container {
            max-width: 600px;
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .profile-container h1, .profile-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group input {
            font-size: 16px;
        }
        .alert-message {
            text-align: center;
            margin-bottom: 15px;
            font-size: 18px;
            color: red;
        }
        .btn-primary {
            width: 100%;
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="profile-container mx-auto">
            <h1>JLC BookStore</h1>
            <h2>Update Profile Form</h2>

            <!-- Display update message if any -->
            <div class="alert-message">${UpdateMsg}</div>

            <!-- Update profile form -->
            <form action="updateProfile.jlc" method="post">
                <div class="form-group">
                    <label for="userId">User ID</label>
                    <input type="text" class="form-control" id="userId" value="${MyUserInfo.userId}" readonly>
                    <input type="hidden" name="userId" value="${MyUserInfo.userId}">
                </div>
                <div class="form-group">
                    <label for="fullName">Full Name</label>
                    <input type="text" class="form-control" id="fullName" name="fullName" value="${MyUserInfo.fullName}" required>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" value="${MyUserInfo.email}" required>
                </div>
                <div class="form-group">
                    <label for="phone">Phone</label>
                    <input type="tel" class="form-control" id="phone" name="phone" value="${MyUserInfo.phone}" required>
                </div>
                <div class="form-group">
                    <label for="dob">Date of Birth</label>
                    <input type="text" class="form-control" id="dob" value="${MyUserInfo.dob}" readonly>
                </div>
                <div class="form-group">
                    <label for="gender">Gender</label>
                    <input type="text" class="form-control" id="gender" value="${MyUserInfo.gender}" readonly>
                </div>
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" name="username" value="${MyUserInfo.userName}" readonly>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" value="${MyUserInfo.password}" readonly>
                </div>
                <button type="submit" class="btn btn-primary">Update My Profile</button>
            </form>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

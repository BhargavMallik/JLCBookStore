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
            background-color: #f8f9fa;
        }
        .form-container {
            margin-top: 50px;
            max-width: 600px;
            padding: 30px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1, h2 {
            text-align: center;
            color: #007bff;
        }
        .alert-message {
            color: red;
            text-align: center;
            font-size: 18px;
            margin-bottom: 20px;
        }
        .form-group input {
            font-size: 16px;
        }
        .btn-primary {
            width: 100%;
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="form-container mx-auto">
            <h1>JLC BookStore</h1>
            <h2>Password Change Form</h2>
            
            <!-- Display message if any -->
            <div class="alert-message">${PwMsg}</div>

            <!-- Password change form -->
            <form action="changepw.jlc" method="post">
                <div class="form-group">
                    <label for="currentpw">Current Password</label>
                    <input type="password" class="form-control" id="currentpw" name="currentpw" required>
                </div>
                <div class="form-group">
                    <label for="newpw">New Password</label>
                    <input type="password" class="form-control" id="newpw" name="newpw" required>
                </div>
                <div class="form-group">
                    <label for="confirmpw">Confirm New Password</label>
                    <input type="password" class="form-control" id="confirmpw" name="confirmpw" required>
                </div>
                <button type="submit" class="btn btn-primary">Change Now</button>
            </form>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmation</title>
    <!-- Bootstrap CSS for styling -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
            text-align: center;
        }
        .message {
            font-size: 24px;
            font-weight: bold;
            color: #28a745; /* Green color for success message */
        }
        .links {
            margin-top: 20px;
        }
        .links a {
            margin: 0 10px;
            color: #007bff;
            text-decoration: none;
            font-size: 18px;
        }
        .links a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Order Confirmation</h2>
        <div class="message">
            <%= request.getAttribute("message") %>
        </div>

        <div class="links">
            <a href="showBooks.jsp">Continue Shopping</a> |
            <a href="orderHistory.jlc">View Order History</a> |
            <a href="home.jsp">Return to Home</a>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

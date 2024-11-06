<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Order Confirmation - JLC BookStore</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Poppins', sans-serif;
        }
        .container {
            margin-top: 50px;
            text-align: center;
        }
        .container h2 {
            color: #007bff;
            margin-bottom: 20px;
        }
        .container h3 {
            color: #28a745;
            margin-bottom: 30px;
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .order-icon {
            font-size: 5rem;
            color: #28a745;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

    <div class="container">
        <!-- Order confirmation message -->
        <i class="order-icon">&#10003;</i>
        <h2>Welcome to JLC BookStore!!!</h2>
        <h3>Your Order is Placed Successfully</h3>

        <!-- Navigation buttons -->
        <a href="showBooks.jsp" class="btn btn-primary">Continue Shopping</a>
        <a href="home.jsp" class="btn btn-primary">Return to Home</a>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.jlcindia.bookstore.to.Order"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order History - JLC BookStore</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Poppins', sans-serif;
        }
        .container {
            margin-top: 50px;
        }
        h2 {
            text-align: center;
            color: #007bff;
            margin-bottom: 30px;
        }
        table {
            width: 100%;
            margin-top: 20px;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        td {
            text-align: center;
        }
        .no-orders {
            text-align: center;
            font-size: 1.2rem;
            color: #dc3545;
        }
        .btn-home {
            display: block;
            margin: 20px auto;
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            text-align: center;
            text-decoration: none;
            transition: background-color 0.3s;
        }
        .btn-home:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Your Order History</h2>
        <%
            List<Order> orderHistory = (List<Order>) request.getAttribute("orderHistory");
            if (orderHistory != null && !orderHistory.isEmpty()) {
        %>
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>User ID</th>
                        <th>Book Names</th>
                        <th>Total Amount</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Order order : orderHistory) {
                    %>
                    <tr>
                        <td><%= order.getOrderId() %></td>
                        <td><%= order.getUserId() %></td>
                        <td><%= String.join(", ", order.getBookNames(order.getOrderId())) %></td>
                        <td>Rs. <%= order.getTotalAmount() %></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        <%
            } else {
        %>
            <p class="no-orders">No orders found.</p>
        <%
            }
        %>

        <!-- Home Button -->
        <a href="home.jsp" class="btn-home">Go to Home</a>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

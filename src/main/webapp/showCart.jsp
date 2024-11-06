<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.jlcindia.bookstore.to.Book"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>BookStore-V1.0 - Your Cart</title>
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
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #dee2e6;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        td {
            background-color: #f8f9fa;
        }
        .action-btn input[type="submit"] {
            background-color: #dc3545;
            color: white;
            border: none;
            padding: 7px 15px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .action-btn input[type="submit"]:hover {
            background-color: #c82333;
        }
        .shopping-links {
            text-align: center;
            margin-top: 20px;
        }
        .shopping-links a {
            margin: 0 15px;
            color: #007bff;
            text-decoration: none;
        }
        .shopping-links a:hover {
            text-decoration: underline;
        }
        .empty-cart {
            text-align: center;
            color: #dc3545;
            font-size: 1.5rem;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Welcome to JLC BookStore!!!</h2>
        <h2>Your Cart</h2>

        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Book Name</th>
                    <th>Price</th>
                    <th>Discount</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Book> cartList = (List<Book>) session.getAttribute("MyCart");
                    if (cartList != null && !cartList.isEmpty()) {
                        int count = 1;
                        for (Book book : cartList) {
                %>
                <tr>
                    <td><%= count++ %></td>
                    <td><%= book.getTitle() %></td> <!-- Assuming BookTO has a getTitle() method -->
                    <td>Rs. <%= book.getPrice() %></td> <!-- Assuming BookTO has a getPrice() method -->
                    <td>10% off</td> <!-- Assuming BookTO has a getDiscount() method -->
                    <td class="action-btn">
                        <form action="removeFromCart.jlc" method="post">
                            <input type="hidden" name="bname" value="<%= book.getTitle() %>"/>
                            <input type="submit" value="Remove From Cart"/>
                        </form>
                    </td>
                </tr>
                <% 
                        }
                    } else {
                %>
                <tr>
                    <td colspan="5" class="empty-cart">No Books in your Cart, Shop now</td>
                </tr>
                <% 
                    }
                %>
            </tbody>
        </table>

        <div class="shopping-links">
            <h3>
                <a href="showBooks.jsp">Continue Shopping</a> |
                <a href="placeOrder.jlc">Place Order</a> |
                <a href="home.jsp">Search More</a>
            </h3>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

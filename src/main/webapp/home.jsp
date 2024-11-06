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
            font-family: 'Poppins', sans-serif;
        }
        .container {
            margin-top: 50px;
            max-width: 800px;
            background: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
        }
        .header h1, .header h4 {
            text-align: center;
            color: #333;
        }
        .nav-links {
            text-align: center;
            margin-bottom: 20px;
        }
        .nav-links a {
            margin: 0 15px;
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
            transition: color 0.3s;
        }
        .nav-links a:hover {
            color: #0056b3;
        }
        .home-content h2 {
            text-align: center;
            color: #6c757d;
            margin: 20px 0;
        }
        table {
            margin: 0 auto;
            border-spacing: 10px;
        }
        input[type="submit"] {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
        hr {
            border-top: 1px solid #dee2e6;
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="header">
            <h4>BookStore-V1.0</h4>
            <h1>JLC BookStore</h1>
        </div>
        
        <!-- Welcome message and navigation links -->
        <div class="nav-links">
            <h3>Welcome, ${MyUserInfo.fullName}</h3>
            <a href="editProfile.jlc">Update My Profile</a> ||
            <a href="changepw.jsp">Change My Password</a> ||
            <a href="mylogout.jlc">Logout</a> ||
            <a href="orderHistory.jlc">View Order History</a>
        </div>

        <hr />

        <!-- Home page content -->
        <div class="home-content">
            <h2>Search Books Here</h2> 
            <form action="searchBooks.jlc"> 
                <font color="red" size="5"> ${MSG} </font> 
                <table> 
                    <tr> 
                        <td> Select Category</td> 
                    </tr> 
                    <tr> 
                        <td> 
                            <select class="form-control" name="category"> 
                                <option value="">-----Select Category-----</option> 
                                <option value="Java">Java Programming</option> 
                                <option value="Python">Python Programming</option> 
                                <option value="Web">Web Development</option> 
                                <option value="DataBase">DataBase</option>
                                <option value ="All">All Books</option>
                            </select> 
                        </td> 
                    </tr> 
                    <tr> 
                        <td class="text-center"> 
                            <input type="submit" value="Show Books"/> 
                        </td> 
                    </tr> 
                </table> 
            </form>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

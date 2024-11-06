<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8d7da;
            color: #721c24;
            text-align: center;
            padding: 50px;
            animation: fadeIn 1s ease-in-out;
        }
        .container {
            background-color: #f5c6cb;
            padding: 20px;
            border: 1px solid #f5c6cb;
            border-radius: 10px;
            display: inline-block;
            animation: shake 0.5s;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            font-size: 2.5em;
            margin-bottom: 10px;
        }
        p {
            font-size: 1.2em;
        }
        a {
            color: #fff;
            background-color: #721c24;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            font-size: 1.1em;
            display: inline-block;
            margin-top: 20px;
            transition: background-color 0.3s ease;
        }
        a:hover {
            background-color: #a94442;
        }
        /* Animations */
        @keyframes fadeIn {
            from { opacity: 0; }
            to { opacity: 1; }
        }
        @keyframes shake {
            0%, 100% { transform: translateX(0); }
            25% { transform: translateX(-5px); }
            50% { transform: translateX(5px); }
            75% { transform: translateX(-5px); }
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Error Occurred</h1>
        <p>
            <% 
                // Display the error message if it exists, otherwise show a default message
                String errorMessage = (String) request.getAttribute("errorMessage");
                if (errorMessage == null) {
                    out.println("An unexpected error occurred. Please try again later.");
                } else {
                    out.println(errorMessage);
                }
            %>
        </p>
        <a href="home.jsp">Go back to home</a>
    </div>

</body>
</html>

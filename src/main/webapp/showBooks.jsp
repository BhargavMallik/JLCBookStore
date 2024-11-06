<%@page import="java.util.List"%>
<%@page import="com.jlcindia.bookstore.to.Book"%>
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
        }
        h2 {
            color: #007bff;
            text-align: center;
            margin-bottom: 30px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
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
        .add-to-cart {
            text-align: center;
        }
        .add-to-cart input[type="submit"] {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 7px 15px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .add-to-cart input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Welcome to JLC BookStore!!!</h2>
        <h2>Books available for <span class="text-info"><%= session.getAttribute("CAT") %></span> Category</h2>

        <div class="text-right mb-3">
            <form action="showMyCart.jlc">
                <input type="submit" value="Show My Cart" class="btn btn-primary">
            </form>
        </div>

        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Price</th>
                    <th>Category</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Book> books = (List<Book>) session.getAttribute("BooksList");
                    if (books != null && !books.isEmpty()) {
                        int count = 1;
                        for (Book book : books) {
                %>
                <tr>
                    <td><%= count++ %></td>
                    <td><%= book.getTitle() %></td>
                    <td><%= book.getAuthor() %></td>
                    <td>Rs. <%= book.getPrice() %></td>
                    <td><%= book.getCategory() %></td>
                    <td class="add-to-cart">
                        <form action="addToCart.jlc" method="post" onsubmit="updateCartCount(event, '<%= book.getTitle() %>')">
                            <input type="hidden" name="bname" value="<%= book.getTitle() %>"/>
                                <input type="number" name="quantity" min="1" value="1" required />
                            <input type="submit" value="Add To Cart"/>
                        </form>
                    </td>
                </tr>
                <% 
                        }
                    } else {
                %>
                <tr>
                    <td colspan="6">No books available</td>
                </tr>
                <% 
                    }
                %>
            </tbody>
        </table>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <!-- Modal for showing the added books -->
    <div class="modal fade" id="cartModal" tabindex="-1" aria-labelledby="cartModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="cartModalLabel">Books Added to Cart</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    You have added <span id="cartCount">0</span> book(s) to your cart.
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <script>
        let cartCount = 0; // Initialize the cart count

        function updateCartCount(event, bookTitle) {
            event.preventDefault(); // Prevent form submission
            const form = event.target; // Get the form element
            cartCount++; // Increase the count

            // Update the modal text
            document.getElementById('cartCount').textContent = cartCount;

            // Show the modal
            $('#cartModal').modal('show');

            // Submit the form after displaying the modal
            setTimeout(() => {
                form.submit(); // Proceed with the form submission
            }, 1000); // Adjust the delay as needed
        }
    </script>
</body>
</html>

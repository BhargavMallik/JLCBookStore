# JLCBookStore

## Overview
The BookStore application is a Java-based web application designed to manage a bookstore's operations. It allows users to register, log in, search for books, manage their shopping cart, place orders, and view their order history. This application utilizes Java Servlets, Java Server Pages (JSP), and Hibernate for database interactions.

## Features
- User registration and authentication
- Book search by category
- Shopping cart management (add, remove, and view items)
- Order placement and order history retrieval
- User profile management (update profile and change password)
- Responsive design using Bootstrap for a better user experience

## Technologies Used
- Java EE (Servlets and JSP)
- Hibernate (for ORM)
- MySQL (as the database)
- Bootstrap (for front-end styling)
- Apache Tomcat (as the web server)

## Project Structure


## Installation Instructions

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Apache Tomcat 9 or higher
- MySQL Database Server
- Maven (optional, for dependency management)

### Steps to Set Up
1. **Clone the Repository**:
   ```bash
   git clone \<repository-url>
   cd BookStore
2. **Set Up the Database**:
   Create a new MySQL database named bookstore.
   Update the database connection settings in HibernateUtil.java with your MySQL credentials.
3. **Build the Project (if using Maven)**:
   ````bash
   mvn clean install
4. **Deploy the Application**:
  Copy the BookStore.war file (if built) or the project folder to the webapps directory of your Apache Tomcat server.

5. **Start Apache Tomcat**:
  Navigate to the Tomcat installation directory and run:
  ````bash
  bin/startup.sh (Linux/Mac)
  bin/startup.bat (Windows)
   ````
6. **Access the Application**:
  Open your web browser and navigate to http://localhost:8080/BookStore.

## Usage
1.**User Registration**:
  Navigate to the registration page and fill out the form to create a new account.
2. **User Login**:
  Use your registered credentials to log in.
3. **Search for Books**:
  Use the search functionality to browse books by category.
4. **Manage Cart**:
  Add books to your cart and view or modify your cart as needed.
5. **Place Orders**:
  Proceed to checkout to place your order and view order confirmations.
6. **View Order History**:
  Access your order history to see past purchases.

## Contributing
  Contributions are welcome! If you have suggestions for improvements or new features, please open an issue or submit a pull request.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.

   

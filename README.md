# Warehouse-Management-System

I made this application for learning Test Driven Development (TDD).

It is Pure Java and CLI based application.  

INFORMATION OF WAREHOUSE MANAGEMENT SYSTEM:

Every Warehouse has 2 entities , Product and It's Location
An employee can log in to the system through provided PIN, Which is 3569 throughout this assignment.
An employee can manage products in the system through option 1, in which the employee can add a product, Search for a Product and delete the product from the warehouse.
Here we have 2 cases for Locations.

Case: 1
Single product has multiple locations in the warehouse.
Case: 2
Single Products have multiple locations in the warehouse.

Both cases can be done through option 2, Which performs add the location of the product, delete Location, and change location.
In addition to that, the employee can view all the products of the warehouse and its location.
Lastly, Employee can view his/her profile from option 4.


HOW TO INSTALL AND RUN:

git clone https://github.com/jainilsevalia/Warehouse-Management-System.git

cd src

<!-- TO COMPILE CODE -->
javac *.java

<!-- TO RUN THE APPLICATION -->
java Main

<!-- TO RUN THE TEST CASES -->
java Main Test

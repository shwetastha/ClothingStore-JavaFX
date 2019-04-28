<h1> Clothing Store Inventory System </h1>
<h3>Author: Shweta Shrestha</h3>

This project is for the submission of the final assignment of JAV745. 
This application is a small demo that works as an inventory system for a Clothing Store to keep track
of the Products.

<h4>Assumptions</h4>
While building this applicaiton following assumptions were made:
1. The store deals with two product types: Clothing and Accessories.
2. The application is used to add or modify items in the inventory.

<h4>Features</h4>
This application has the following features:
1. The application reads and writes from the csv file productsInventory.csv.
2. The user can add a new product by filling up the form with the details and then pressing the add button.
3. The user can modify an existing product by clicking on the product in the table view 
and then modifying any values in the form. Pressing the Update button(same as the Add button) will modify the values.
4. While the user adds and updates the product new report will be generated in the text area under the Generate Report button.
5. The Generate Report button will also generate report of the current products.

<h4>Instructions</h4>
Instructions to run the program:
Compile all the classes with the following commands:
javac Products.java
javac Clothing.java
javac Accessories.java
javac Consts.java
javac LogUtil.java
javac Controller.java
javac Home.java
Then run the program using the following command:
java Home

Alternatively, rename the <strong>run.txt</strong> file to run.bat. And then run the command <strong>./run.bat</strong>.

<h3>Classes</h3>
The detail and purpose of each class is as follows:
Java Classes:
Products.java : Superclass
Clothing.java : Subclass. Use of Inheritance.
Accessories.java : Subclass. Use of Inheritance.
Consts.java : Class with all the important and repititive constants being used throughout the program. 
    The purpose of this class is to centralise all the constants used in the application for ease of modification and consistency.
LogUtil.java : Class that contains functions for printing out in log console for debuggin purpose.
Controller.java : Class that controls the layout.
javac Home.java : Main function exists here. The window and scene is generated in this class. The whole programs starts here. File read and write is accomplished here.
inventory.fxml : The layout file, which is a fxml file.
productsInventory.csv : the csv file with the data information.

<h1> Clothing Store Inventory System </h1>
<h3>Author: Shweta Shrestha</h3>

This project is for the submission of the final assignment of JAV745. 
This application is a small demo that works as an inventory system for a Clothing Store to keep track
of the Products.

<h4>Assumptions</h4>
While building this applicaiton following assumptions were made:
<ol>
    <li>The store deals with two product types: Clothing and Accessories.</li>
    <li>The application is used to add or modify items in the inventory.</li>
</ol>

<h4>Features</h4>
This application has the following features:
<ol>
    <li>The application reads and writes from the csv file productsInventory.csv.</li>
    <li>The user can add a new product by filling up the form with the details and then pressing the add button.</li> 
    <li>The user can modify an existing product by clicking on the product in the table view 
and then modifying any values in the form. Pressing the Update button(same as the Add button) will modify the values.</li>
    <li>While the user adds and updates the product new report will be generated in the text area under the Generate Report button.</li>
    <li>The Generate Report button will also generate report of the current products.</li>
</ol>

<h4>Instructions</h4>
Instructions to run the program:
<ol>
    <li>Compile all the classes with the following commands:
        <ul>
            <li>javac Products.java</li>
            <li>javac Clothing.java</li>
            <li>javac Accessories.java</li>
            <li>javac Consts.java</li>
            <li>javac LogUtil.java</li>
            <li>javac Controller.java</li>
            <li>javac Home.java</li>
        </ul>
    </li>
    <li>
    Then run the program using the following command:
        <ul><li>java Home</li></ul>
    </li>
</ol>

Alternatively, rename the <strong>run.txt</strong> file to run.bat. And then run the command <strong>./run.bat</strong>.

<h4>Classes</h4>
The detail and purpose of each class is as follows:
<ol>
    <li>Products.java : Superclass</li>
    <li>Clothing.java : Subclass. Use of Inheritance.</li>
    <li>Accessories.java : Subclass. Use of Inheritance.</li>
    <li>Consts.java : Class with all the important and repititive constants being used throughout the program. 
    The purpose of this class is to centralise all the constants used in the application for ease of modification and consistency.</li>
    <li>LogUtil.java : Class that contains functions for printing out in log console for debuggin purpose.</li>
    <li>Controller.java : Class that controls the layout.</li>
    <li>javac Home.java : Main function exists here. The window and scene is generated in this class. The whole programs starts here. File read and write is accomplished here.</li>
    <li>inventory.fxml : The layout file, which is a fxml file.</li>
    <li>productsInventory.csv : the csv file with the data information.</li>
</ol>

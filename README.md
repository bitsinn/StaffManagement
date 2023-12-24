# Staff management 

## This project is about assigning projects to employees. The target is to get the employees who worked together on the same project and the time that they worked together.

## For this project I used Spring Boot framework and Postgres database. The languages I used are Java and HTML.

## How to use:

### When you start the application and everything is loaded you have to go in you browser and enter localhost with port 8081. This will lead you to the "Home page" of the application. When you are on the "Home page" there will be some fields and buttons. On the fields you have to type the employee identity number, project identity number, when they started the project and when they finished doing it. There is a button "Assign project" this button will assign project to employee but you before that you had to enter the values in the field before. When you assign the project in the table below the button will show the employee.
#### EXAMPLE:
<nav>
    <ul>
        <form>
            <div>
                <label>Employee ID</label>
                <div>
                    <input type="number">
                </div>
            </div>
            <p></p>
            <div>
                <label>Project ID</label>
                <div>
                    <input type="number">
                </div>
            </div>
            <p></p>
            <div>
                <label>Joined project</label>
                <div>
                    <input type="datetime-local">
                </div>
            </div>
            <p></p>
            <div>
                <label>Left project</label>
                <div>
                    <input type="datetime-local">
                </div>
            </div>
            <p></p>
            <div>
                <input type="submit" value="Assign project">
            </div>
        </form>
    </ul>
</nav>
<div>
    <ul>
        <table border="1px" style="width: 1000px">
            <tr>
                <th style="width: 200px; text-align: center;">Employee ID</th>
                <th style="width: 200px; text-align: center;">Project ID</th>
                <th style="width: 200px; text-align: center;">Joined project at</th>
                <th style="width: 200px; text-align: center;">Left project at</th>
                <th style="width: 200px; text-align: center;">Days worked on project</th>
            </tr>
            <tr style="text-align: center;">
                <td>
                    <span></span>
                </td>
                <td>
                    <span></span>
                </td>
                <td>
                    <span></span>
                </td>
                <td>
                    <span></span>
                </td>
                <td>
                    <span></span>
                </td>
                <td>
                    <a>Delete</a>
                </td>
            </tr>
        </table>
        <a>Filter by project</a>
    </ul>
</div>

### If you want to see the time all the employees that work or worked together you have to click the link below the table. This link will send you to another page where there is a table with the information.
#### NOTE: The table is little difficult to understand. Employees are in pairs of two, so two rows of the table are for those employees. Employees identity number must be different, project identity number must be the same.

#### EXAMPLE:

<table border="1px" style="width: 600px">
        <tr>
            <th style="width: 200px; text-align: center;">Employee ID</th>
            <th style="width: 200px; text-align: center;">Project ID</th>
            <th style="width: 200px; text-align: center;">Days worked on project</th>
        </tr>
        <tr style="text-align: center;">
            <td>1</td>
            <td>2</td> 
            <td>9</td>
        </tr>
        <tr style="text-align: center;">
            <td>2</td>
            <td>2</td> 
            <td>9</td>
        </tr>
        <tr style="text-align: center;">
            <td>3</td>
            <td>1</td> 
            <td>5</td>
        </tr>
        <tr style="text-align: center;">
            <td>4</td>
            <td>1</td> 
            <td>5</td>
        </tr>
    </table> 

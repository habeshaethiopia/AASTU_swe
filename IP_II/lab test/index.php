<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>index</title>
</head>

<body>
    <div class="header">
        <h1>Welcome to <span>PHP lab DEMO</span></h1>
        <nav>
            <ul>
                <li><a href="insert.php">Insert  <span>To Database</span></a></li>
                
                </ul>
        </nav>
    </div>
    <div class="content">
        <h2>Data list</h2>
    <table border="2px" padding=2px>
        <tr>
            <td>ID</td>
            <td>Fname</td>
            <td>Lname</td>
            <td>Department</td>
            <td>Update/Delete</td>
        </tr>
        <?php
        include "class.php";
        $r = $obj->fetchdata();
        while ($result = mysqli_fetch_assoc($r)) {
            echo "<tr><td>" . $result['id'] . "</td>" . "<td>" . $result['fName'] . "</td>" . "<td>" . $result['lName'] . "</td>"
                . "<td>" . $result['Depart0'] . "</td>" . "<td>" . "<a href='update.php?id=" . $result['id'] .
                "'>Update</a>/<a href='delete.php?id=" . $result['id'] . "'>Delete</a>" . "</td>";
        }
        $obj->close();
        ?>


        </tr>
    </table>
    </div>
    <div class="footer">
        <p>Copyright &copy; 2021 <a href="https://github.com/habeshaethioopia">Adane Moges Ets0079/13 Section A</a>.</p>
        </div>      
</body>

</html>
<style>
/* Set default font family and size */
body {
  font-family: Arial, sans-serif;
  font-size: 14px;
  margin: 0;
}

/* Style the header */
.header {
  background-color: #333;
  color: white;
  padding: 20px;
}
.header h1 {
  margin: 0;
}
.header span {
  color: #FFA500;
}
.header nav ul {
  margin: 0;
  padding: 0;
  list-style: none;
}
.header nav li {
  display: inline-block;
  margin-right: 20px;
}
.header nav li:last-child {
  margin-right: 0;
}

/* Style the content */
.content {
  padding: 20px;
}
.content h2 {
  margin-top: 0;
}

/* Style the table */
table {
  border-collapse: collapse;
  width: 100%;
  max-width: 800px;
  margin: 20px 0;
}
table td, table th {
  border: 2px solid black;
  padding: 8px;
}
table th {
  background-color: #ccc;
  font-weight: bold;
  text-align: left;
}
table tr:nth-child(even) {
  background-color: #f2f2f2;
}

/* Style the links */
a {
  color:#007bff;
  text-decoration: none;
}
a:hover {
  text-decoration: underline;
}

/* Style the footer */
.footer {
  background-color: #333;
  color: white;
  padding: 20px;
  text-align: center;
}

</style>
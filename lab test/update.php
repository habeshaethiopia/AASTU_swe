<?php
include("class.php");
if (isset($_POST["submit"])) {
  $fname = $_POST["name"];
  $lname = $_POST["lname"];
  $department = $_POST["department"];
  $id = $_POST['id'];

  if ($obj->update($id, $fname, $lname, $department)) {

    header('location: index.php'); // redirect
  } else
    die("error occured not updated");
}
$id = $_GET['id'];
$row = $obj->fetchonrecord($id);
if ($row)
  echo "Id :" . $row["id"] . "  | Fname :" . $row["fName"] . "  | lName : " . $row["lName"] . " | Department :" . $row["Depart0"];

$obj->close();
?>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>

<body>
  <div class="header">
    <h1>Welcome to <span>PHP lab DEMO</span></h1>
    <nav>
      <ul>
        <li><a href="insert.php">Insert <span>To Database</span></a></li>
        <li><a href="index.php"> Diaplay All<span>Database Data</span></a></li>

      </ul>
    </nav>
  </div>
  <div class="content">
    <h2>Update Data</h2>
    <form action='update.php' method="post">
      <input type="hidden" name="id" value="<?php echo $row['id']; ?>">
      <labdl for="name">Name :</labdl>
      <input type="text" name="name" value="" placeholder="<?php echo $row["fName"] ?>" required width="40px">
      <br>
      <label for="lname">Surname :</label>
      <input type="text" name="lname" value="" placeholder="<?php echo $row["lName"] ?>" required width="40px">
      <br>
      <label for="Department">Department :</label>
      <input type="text" name="department" value="" placeholder="<?php echo $row["Depart0"] ?>" required width="40px">
      <br>
      <input type="submit" name="submit" value="UPDATE">
    </form>
  </div>
  <div class="footer">
    <p>Copyright &copy; 2021 <a href="https://github.com/habeshaethioopia">Adane Moges</a>.</p>
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

  a {
    text-decoration: none;
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
    color: aliceblue;
  }

  .header nav li:hover {
    .header nav li
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

  .content form {
    max-width: 600px;
    margin: 0 auto;
  }

  .content label {
    display: block;
    margin-bottom: 10px;
    font-weight: bold;
  }

  .content input[type=text],
  .content input[type=email],
  .content input[type=password] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-bottom: 20px;
    font-size: 16px;
  }

  .content input[type=submit] {
    background-color: #333;
    color: white;
    border: none;
    border-radius: 4px;
    padding: 10px 20px;
    font-size: 16px;
    cursor: pointer;
  }

  .content input[type=submit]:hover {
    background-color: #555;
  }

  /* Style the footer */
  .footer {
    background-color: #333;
    color: white;
    padding: 20px;
    text-align: center;
  }

  .footer a {
    color: #FFA500;
  }
</style>
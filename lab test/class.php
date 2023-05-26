<?php
class DB_con
{
    public $db_host = "localhost";
    public $db_user = "root";
    public $db_pass = "";
    public $db_name = "Lab_test";
    public $db_conn;
    public function __construct()
    {
        $this->db_conn = new mysqli($this->db_host, $this->db_user, $this->db_pass, $this->db_name);
        if ($erro = $this->db_conn->connect_error)
            die("<scri>alert('Error when try to connect ')</script> $erro");
        else
            echo '<script>
            console.log("Successfully connected to database");
        </script>';
    }
    public function insert($fname, $lname, $depart)
    {
        $sql = "INSERT INTO `mydata` (`id`, `fName`, `lName`, `Depart0`) VALUES (NULL, '$fname', '$lname', '$depart')";
        $result = $this->db_conn->query($sql);
        if ($result)
            return 1;
        else
            return 0;
    }
    public function fetchdata()
    {
        $sql = "SELECT * FROM myData";
        $result = $this->db_conn->query($sql);
        if ($result)
            return $result;
        else
            return null;
    }
    public function fetchonrecord($id)
    {
        $sql = "SELECT * FROM `mydata` WHERE `id`= $id";
        $result = $this->db_conn->query($sql);
        $re = mysqli_fetch_assoc($result);
        if ($re)
            return $re;
        else
            return null;
    }
    public function update($id, $fname, $lname, $depatr)
    {
        $sql = "UPDATE `mydata` SET `fName` = '$fname', `lName` = '$lname', `Depart0` = '$depatr' WHERE `mydata`.`id` = $id;";
        $result = $this->db_conn->query($sql);
        if ($result) {
            print "<script> 
            console.log("."successfully updated".");
            </script>";
            return 1;
        } else
            return 0;

    }
    public function delete($id)
    {
        $sql = "DELETE FROM myData WHERE id = $id";
        $result = $this->db_conn->query($sql);
        if ($result)
            return 1;
        else
            return 0;
    }
    public function close()
    {
        $this->db_conn->close();
    }

}

$obj = new DB_con();
?>
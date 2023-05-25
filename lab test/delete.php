
<script>
    function confirmDelete() {//js function
  var result = confirm("Are you sure you want to delete this row?");
  if (result) {
    <?php
include "class.php";
$id = $_GET['id'];
$obj->delete($id);
header('location:index.php');
?>
  }
}
</script>
<?php
if (isset($_GET['id']))
    echo "<script>
confirmDelete()   
</script>";/// call js function from php 
$obj->close();

?>
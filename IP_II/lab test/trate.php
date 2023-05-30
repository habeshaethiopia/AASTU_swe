<?php
/**
 * 
 */
trait tr1
{
    function ft1()
    {
        echo "this is from trate parent 1\n";

    }
}
/**
 * 
 */
trait tr2
{
    function ft1()
    {
        echo "this is from trate parent 2\n";

    }   
}

class W
{
    private $ar = array();

    function __set($ar, $val)
    {
        $this->ar = $ar . array_push($val);
    }
    use tr1, tr2{
        tr1::ft1 insteadof tr2;
        tr2::ft1 as ft2;
    }

}

$obj = new W();
$obj->ft1();
$obj->ft2();
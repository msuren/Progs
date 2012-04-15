<?php

/*
There is an array A[N] of N numbers. You have to compose an array Output[N] such that Output[i] will be equal to multiplication of all the elements of A[N] except A[i]. For example Output[0] will be multiplication of A[1] to A[N-1] and Output[1] will be multiplication of A[0] and from A[2] to A[N-1]. Solve it without division operator and in O(n).
*/
$arr = array(3,4,5,6,7,8,9);
$result = array();
$pro = 1;
print_r($arr);
$result[0] = $arr[0];
foreach($arr as $index => $ele) {
    if($index == 0) {
        continue;
    }
    if($index == (count($arr) - 1)) {
        $result[$index] = $result[$index-1];
        $pro = 1;
        break;
    }
    $result[$index] = $result[$index-1] * $ele;
}
print_r($result);
$index = count($arr)-2;
while($index >= 0) {
    $pro = $pro * $arr[$index+1];
    if($index == 0) {
        $result[$index] = $pro;
        break;
    }

    $result[$index] = $result[$index - 1] * $pro;
    $index--;
}

print_r($result);

?>

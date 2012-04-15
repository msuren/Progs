<?php
/* Given an array of integer find the maximum sum of consecutive integers */

$arr = array('-3','15','7','9','-28','4','8','9','3','-5');

$bt = 0; $be = 0;
$maxsum = 0;
$buy = 0;
$curr = 0;

foreach($arr as $index => $ele) {
    if($index == 0) {
        continue;
    }

    $curr += $ele;
    if($curr < 0) {
        $curr = $ele;
    }
    if($curr > $maxsum) {
        $maxsum = $curr;
    }
    print "$index , $ele \n";
}

print_r($arr);
print "maxsum = $maxsum \n";

?>

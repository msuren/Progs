<?php

    $str = "surendran";

    $str = str_split($str);
    print_r($str);
    $last = count($str) - 1;
    foreach($str as $index => $ele) {
        if($index > count($str)/2) {
            break;
        }
        $str[$index] = $str[$last];
        $str[$last] = $ele;
        $last--;
    }

    print_r($str);
?>

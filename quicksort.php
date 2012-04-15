<?php
    $arr = Array('5','2','9','6','1','12','67','33','43','7');
    quickSort(0, count($arr)-1, floor(count($arr)/2));
        print_r($arr);
    function quickSort($left, $right, $pivot) {
        global $arr;
        if($left >=$right) {
            return;
        }
        $pivot = partition($left,$right,$pivot);
            quickSort($left,$pivot-1, $left + floor(($pivot-$left)/2));
            quickSort($pivot+1, $right, $pivot+1 + floor(($right - $pivot)/2) );
    }

    function partition($left,$right, $pivot) {
        global $arr;
        $pivotVal = $arr[$pivot];
        //print "pivotVal => $pivotVal\n";
        $swap = $right - 1;
        $t = $arr[$pivot];
        $arr[$pivot] = $arr[$right];
        $arr[$right] = $t;

        for($i=$left;$i<=$right-1;) {
            if($i >= $swap) {
                break;
            }
            //print "comparing $i  {$arr[$i]}\n";
            if($arr[$i] > $pivotVal) {
        //        print "swapping $i and $swap\n";
                $t = $arr[$i];
                $arr[$i] = $arr[$swap];
                $arr[$swap] = $t;
                $swap--;
            } else {
                $i++;
            }
        }
        if($arr[$swap] > $arr[$right]) {
            $t = $arr[$swap];
            $arr[$swap] = $arr[$right];
            $arr[$right] = $t;
        }
        return $swap;

    }
?>

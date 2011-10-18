#!/usr/bin/php
<?php
  error_reporting(0);
  $in = fopen("php://stdin", "r");
  while ($line = fgets($in, 40960)) {
    list($key, $value) = preg_split("/\t/", trim($line), 2);
    $words = preg_split("/\W/", $value, 0, PREG_SPLIT_NO_EMPTY);
    foreach ($words as $word) {
      print "$word\t$key\n";
    }
  }
  fclose($in);
?>


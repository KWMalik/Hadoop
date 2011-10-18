#!/usr/bin/php
<?php
  error_reporting(0);
  $in = fopen("php://stdin", "r");
  $old_key = "";
  while ($line = fgets($in, 40960)) {
    list($key, $value) = preg_split("/\t/", trim($line), 2);
    if ($old_key != $key) {
      if ($old_key != "") {
        print "\n";
      }
      $old_key = $key;
      print "$key\t";
      $first_word = 1;
    }
    if ($first_word == 1) {
      $first_word = 0;
    } else {
      print ",";
    }
    print "$value";
  }
  print "\n";
  fclose($in);
?>


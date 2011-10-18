#!/usr/bin/awk -f
BEGIN {
 FS=",|!| "
}
{
 c=split($0,words);
 for (n=1;n<=c;++n)
  if (words[n] != "")
   print words[n]"\t"1
}

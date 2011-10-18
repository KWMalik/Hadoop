#!/usr/bin/awk -f
{
 c=split($0,words,",|!| ");
 for (n=1;n<=c;++n) {
  if (words[n] != "")
   printf "%s\t%s\n", substr(words[n],0,1), length(words[n]);
 }
}

#!/usr/bin/awk -f
BEGIN {
 sum=0;
 cnt=0;
 oldkey="";
}
{
 split($0,line,"\t");
 key=line[1];
 value=line[2];
 if ((oldkey != "") && (oldkey != key)) {
  printf "%s\t%.1f\n",  oldkey, sum/cnt;
  sum=0;
  cnt=0;
 }
 oldkey=key;
 sum+=value;
 cnt+=1;
}
END {
 printf "%s\t%.1f\n",  oldkey, sum/cnt;
}


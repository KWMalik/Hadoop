#!/bin/sh
javac -Xlint -classpath /usr/lib/hadoop//lib/junit-4.5.jar:/usr/lib/hadoop//contrib/mrunit/hadoop-mrunit-0.20.2-cdh3u1.jar:/usr/lib/hadoop/hadoop-core-0.20.2-cdh3u1.jar -d . com/cloudera/training/*/*.java
jar -cvf training.jar -C . com/cloudera/training/*/*.class
rm com/cloudera/training/*/*.class

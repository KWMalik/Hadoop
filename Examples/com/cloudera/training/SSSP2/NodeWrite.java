package com.cloudera.training.SSSP2;

import java.io.IOException;
import java.util.Arrays;  
import java.util.List;  
import java.util.ArrayList;  


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.*;
import java.net.URI;

public class NodeWrite {

  public static void main(String[] args) throws IOException {
    String uri = args[0];
    Configuration conf = new Configuration();
    FileSystem fs = FileSystem.get(URI.create(uri), conf);
    Path path = new Path(uri);
    IntWritable key = new IntWritable();
    Node value = new Node();
    SequenceFile.Writer writer = null;
    ArrayList<ArrayList<Integer>> Neighbours = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> ndt = new ArrayList<Integer>();
    try {
/*
      int[] keys = {1,2,3,4,5};
      int[][][] values = { {{2,3,2},{3,2,6}}, {{4,4,3}}, {{5,3,5}}, {{5,3,4}}, {} };
      writer = SequenceFile.createWriter(fs, conf, path, key.getClass(), value.getClass());
      for (int i=0; i<keys.length; i++) {
        key.set(keys[i]);
	if (keys[i]==1) {
          int[] p = {i};
          value.set(new ArrayList(Arrays.asList(values[i])), 0, new ArrayList(Arrays.asList(p)), 0, new ArrayList(Arrays.asList(p)));
        } else {
          value.set(new ArrayList(Arrays.asList(values[i])));
        }
        writer.append(key, value);
      }

*/
      writer = SequenceFile.createWriter(fs, conf, path, key.getClass(), value.getClass());
      key.set(1);
      ndt.add(0,2); ndt.add(1,3); ndt.add(2,2); Neighbours.add(ndt); System.out.println(ndt.get(0)); ndt.clear();
      ndt.add(0,3); ndt.add(1,2); ndt.add(2,6); Neighbours.add(ndt); ndt.clear();
      value.set(Neighbours);
      writer.append(key, value);
      Neighbours.clear();
      
    } finally {
      IOUtils.closeStream(writer);
    }
  }
}

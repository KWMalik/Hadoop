package com.cloudera.training.SSSP;

import java.io.IOException;
import org.apache.hadoop.io.*;


// xxx Import type for input and output keys and values.

import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class SSSPMapper extends MapReduceBase 
		implements Mapper<IntWritable, Node, IntWritable, Node> {
	
	private Node n = new Node();
	private int[] neighb = {};

	public void map(IntWritable key, 
			Node value, 
			OutputCollector<IntWritable, Node> output, 
			Reporter reporter) 
	throws IOException {
		
		// xxx Consume input.  For output(s):
		// xxx    output.collect(xxxOutputKey, xxxOutputValue);

		int distance;
		output.collect(key, value);
		for (int i=0; i<value.neighbours.length; i++) {
			n.set(neighb, value.shortest+1);
			output.collect(new IntWritable(value.neighbours[i]), n);
		}
	}
}

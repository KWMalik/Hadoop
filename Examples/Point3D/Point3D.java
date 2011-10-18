import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.io.*;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class Point3D implements Writable {
  public float x;
  public float y;
  public float z;

  public Point3D(float x, float y, float z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public Point3D() {
    this(0.0f, 0.0f, 0.0f);
  }

  public void write(DataOutput out) throws IOException {
    out.writeFloat(x);
    out.writeFloat(y);
    out.writeFloat(z);
  }

  public void readFields(DataInput in) throws IOException {
    x = in.readFloat();
    y = in.readFloat();
    z = in.readFloat();
  }

  public String toString() {
    return Float.toString(x) + ", "
        + Float.toString(y) + ", "
        + Float.toString(z);
  }
}
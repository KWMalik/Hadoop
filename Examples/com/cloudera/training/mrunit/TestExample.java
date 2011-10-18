package com.cloudera.training.mrunit;

import junit.framework.TestCase;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.lib.IdentityMapper;
import org.junit.Before;
import org.junit.Test;

import org.apache.hadoop.mrunit.*;

public class TestExample extends TestCase {

  private Mapper mapper;
  private MapDriver driver;

  @Before
  public void setUp() {
    mapper = new IdentityMapper();
    driver = new MapDriver(mapper);
  }

  @Test
  public void testIdentityMapper() {
    driver.withInput(new Text("foo"), new Text("bar"))
            .withOutput(new Text("foo"), new Text("bar123"))
            .runTest();
  }
}


package com.flnn.spark.kafka;

import org.junit.Test;

import java.net.URI;

/**
 *
 */
public class NetworkTest {

    @Test
    public void uriTest(){
        String addressStr = "hdfs://0.0.0.0:8020";
        URI uri = URI.create(addressStr);
        System.out.println(uri.getHost());
        System.out.println(uri.getAuthority());
        System.out.println(uri.getPort());
    }
}

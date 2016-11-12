package com.ycw.photosystem.es;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import static org.elasticsearch.common.xcontent.XContentFactory.*;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;

/**
 * Created by liuyang on 2016/11/10 0010.
 */
public class TestES {
    public static void main(String[] args) throws IOException {


        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        XContentBuilder builder = jsonBuilder().startObject()
                .field("user","kimchy")
                .field("postData",System.currentTimeMillis())
                .field("message","test Elasticsearch")
                .endObject();
        System.out.print(builder.string());
        IndexResponse response =client.prepareIndex("myindex","type1","1").setSource(builder).get();
    }
}

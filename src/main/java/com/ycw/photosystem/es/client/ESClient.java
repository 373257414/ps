package com.ycw.photosystem.es.client;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.inject.Injector;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by liurunze on 2016/11/13.
 */
@Configuration
public class ESClient {
    public static final String HOST = "101.200.87.22";
    public static final Integer PORT = 9300;
    @Bean(name = "esClient")
    public TransportClient getClient(){
        Settings settings = Settings.settingsBuilder()
                .put("cluster.name","liurunze's_cluster")
                .put("client.transport.sniff",true)
                .build();
        TransportClient client = null;
        try {
            client = TransportClient.builder().settings(settings).build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(HOST), PORT));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }
}

package com.ycw.photosystem.dao.es.client;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.shield.ShieldPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.net.InetAddress;
import java.net.UnknownHostException;


@Configuration
public class ESClient {
    public static final String HOST = "101.200.87.22";
    public static final Integer PORT = 9300;
    public static final String SHIELD = "liuyang:910526";

    @Bean(name = "client")
    @Scope("singleton")
    public TransportClient getClient() {
        Settings settings = Settings.settingsBuilder()
                .put("cluster.name", "liurunze's_cluster")
                .put("client.transport.sniff", true)
                .put("shield.user",SHIELD)
                .build();
        TransportClient client = null;
        try {
            client = TransportClient.builder().addPlugin(ShieldPlugin.class).settings(settings).build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(HOST), PORT));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }
}

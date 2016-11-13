package com.ycw.photosystem.es;



import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static javafx.scene.input.KeyCode.T;
import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

/**
 * Created by liuyang on 2016/11/10 0010.
 */
public class TestES {

    public static final String SERVER_IP = "101.200.87.22";

    public static void main(String[] args) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        TransportClient client= (TransportClient) context.getBean("esClient");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        XContentBuilder builder = jsonBuilder().startObject()
                .field("user","kimchy")
                .field("postData",dateFormat.format(new Date()))
                .field("message","test Elasticsearch")
                .field("number",0L)
                .endObject();
        System.out.print(builder.string());

        //index
        IndexResponse response =client.prepareIndex("myindex","type1","1").setSource(builder).get();
        //get
        GetResponse getResponse = client.prepareGet("myindex","type1","1").get();
        Map map =getResponse.getSourceAsMap();
        //delete
        //DeleteResponse deleteResponse = client.prepareDelete("myindex","type1","1").get();
        //update
        map.put("user","liurunze");
        Long number = 261538L;
        map.put("number",number);
        UpdateResponse updateResponse=client.prepareUpdate("myindex","type1","1").setDoc(map).get();
        //query
        QueryBuilder queryBuilder = matchAllQuery();
        //search
        SearchResponse searchResponse = client.prepareSearch("myindex").setTypes("type1").setQuery(queryBuilder).execute().actionGet();
        SearchHits searchHits=searchResponse.getHits();
        Map map1 = new HashMap();
        for (SearchHit searchHit:searchHits){
            map1=searchHit.getSource();
        }
    }
}

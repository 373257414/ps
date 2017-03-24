package com.ycw.photosystem.dao.es;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycw.photosystem.bean.es.PictureEsBean;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.spanMultiTermQueryBuilder;

@Component
public class PictureEsDAO {

    @Autowired
    private TransportClient client;
    private final static String INDEX_NAME = "picture";
    private final static String TYPE = "picture";

    public void index(PictureEsBean pictureEsBean) throws JsonProcessingException {
        String id = String.valueOf(pictureEsBean.getId());
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] json = objectMapper.writeValueAsBytes(pictureEsBean);
        client.prepareIndex(INDEX_NAME, TYPE, id).setSource(json).get();
    }

    public void delete(Long deleteId) {
        String id = String.valueOf(deleteId);
        client.prepareDelete(INDEX_NAME, TYPE, id).get();
    }

    public void update(PictureEsBean pictureEsBean) throws Exception {
        String id = String.valueOf(pictureEsBean.getId());
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] json = objectMapper.writeValueAsBytes(pictureEsBean);
        client.prepareUpdate(INDEX_NAME, TYPE, id).setSource(json).get();
    }


    public List findIdsByMatchQuery(String field, String text) {
        QueryBuilder qb = matchQuery(field, text).operator(MatchQueryBuilder.Operator.AND);
        SearchResponse searchResponse = client.prepareSearch(INDEX_NAME)
                .setTypes(TYPE)
                .setQuery(qb).execute().actionGet();
        SearchHits searchHits = searchResponse.getHits();
        List ids = new ArrayList(Math.toIntExact(searchHits.getTotalHits()));
        for (SearchHit searchHit : searchHits) {
            ids.add(Long.valueOf(searchHit.getId()));
        }
        return ids;
    }

    public List findIdsByMatchQuery(Map<String, String> conditionMap) {
        SearchRequestBuilder srb = client.prepareSearch(INDEX_NAME).setTypes(TYPE);
        Set<Map.Entry<String, String>> entrySet = conditionMap.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            if (StringUtils.isEmpty(entry.getValue())){
                continue;
            }
            QueryBuilder qb = matchQuery(entry.getKey(), entry.getValue()).operator(MatchQueryBuilder.Operator.AND);
            srb.setQuery(qb);
        }
        SearchResponse searchResponse = srb.execute().actionGet();
        SearchHits searchHits = searchResponse.getHits();
        List ids = new ArrayList(Math.toIntExact(searchHits.getTotalHits()));
        for (SearchHit searchHit : searchHits) {
            ids.add(Long.valueOf(searchHit.getId()));
        }
        return ids;
    }



    /*public void search(){
        QueryBuilder queryBuilde
        SearchResponse searchResponse = client.prepareSearch(INDEX_NAME).setTypes(TYPE).setQuery(queryBuilder).execute().actionGet();
    }*/
    //index


        /*//get
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
        }*/
}

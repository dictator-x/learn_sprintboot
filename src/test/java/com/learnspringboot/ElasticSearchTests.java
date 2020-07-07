package com.learnspringboot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnspringboot.bean.User;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ElasticSearchTests {

  @Autowired
  @Qualifier("esClient")
  RestHighLevelClient client;

  @Test
  public void testCreateIndex() throws Exception {
    CreateIndexRequest request = new CreateIndexRequest("test_index");
    CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
    System.out.println(response);
  }

  @Test
  public void testExistIndex() throws Exception {
    GetIndexRequest request = new GetIndexRequest("test_index");
    boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
    System.out.println(exists);
  }

  @Test
  public void testDeleteIndex() throws Exception {
    DeleteIndexRequest request = new DeleteIndexRequest("test_index");
    AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
    System.out.println(response.isAcknowledged());
  }

  @Test
  public void testAddDocument() throws Exception {
    User user = new User("Jordan", 19);
    IndexRequest request = new IndexRequest("test_index");
    request.id("1");
    request.timeout(TimeValue.timeValueSeconds(1));
    request.timeout("1s");
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(user);
    request.source(json, XContentType.JSON);

    IndexResponse response = client.index(request, RequestOptions.DEFAULT);
    System.out.println(response);
    System.out.println(response.status());
  }

  @Test
  public void testIsExists() throws Exception {
    GetRequest request = new GetRequest("test_index", "1");
    request.fetchSourceContext(new FetchSourceContext(false));
    request.storedFields("_none_");

    boolean exists = client.exists(request, RequestOptions.DEFAULT);
    System.out.println(exists);
  }

  @Test
  public void testGetDocument() throws Exception {
    GetRequest request = new GetRequest("test_index", "1");
    GetResponse response = client.get(request, RequestOptions.DEFAULT);
    System.out.println(response.getSourceAsString());
    System.out.println(response);
  }

  @Test
  public void testUpdateDocument() throws Exception {
    UpdateRequest request = new UpdateRequest("test_index", "1");
    request.timeout("1s");
    User user = new User("Kobe", 40);
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(user);
    request.doc(json, XContentType.JSON);
    UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
    System.out.println(response);
  }

  @Test
  public void testDeleteDocument() throws Exception {
    DeleteRequest request = new DeleteRequest("test_index", "1");
    request.timeout("1s");

    DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
    System.out.println(response);

  }

  @Test
  public void testBulkRequest() throws Exception {
    BulkRequest bulkRequest = new BulkRequest();
    bulkRequest.timeout("10s");

    List<User> users = Arrays.asList(
            new User("Jordan", 20),
            new User("Messi", 30),
            new User("Kobe", 25),
            new User("Bolt", 20)
    );

    for ( int i = 0 ; i < users.size(); i++ ) {
      bulkRequest.add(
              new IndexRequest("test_index")
                .id(""+(i+1))
                .source(new ObjectMapper().writeValueAsString(users.get(i)), XContentType.JSON)
      );
    }

    BulkResponse response = client.bulk(bulkRequest, RequestOptions.DEFAULT);
    System.out.println(response.hasFailures());
  }

  @Test
  public void testSearch() throws Exception {
    SearchRequest request = new SearchRequest("test_index");
    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "Jordan");
    sourceBuilder.query(termQueryBuilder);
    sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
    sourceBuilder.from();
    sourceBuilder.size();

    request.source(sourceBuilder);

    SearchResponse response = client.search(request, RequestOptions.DEFAULT);
    System.out.println(response.getHits());

    for (SearchHit documentFields : response.getHits().getHits()) {
      System.out.println(documentFields.getSourceAsMap());
    }
  }

}

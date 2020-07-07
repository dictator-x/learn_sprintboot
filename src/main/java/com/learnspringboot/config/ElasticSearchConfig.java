package com.learnspringboot.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {

	@Bean("esClient")
	public RestHighLevelClient customizeESClient() {
		System.out.println("ElasticSearchConfig init......");
		RestHighLevelClient client = new RestHighLevelClient(
																	RestClient.builder(
																	new HttpHost("localhost", 9200, "http")));
		return client;
	}

}

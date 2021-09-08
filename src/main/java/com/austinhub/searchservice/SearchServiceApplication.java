package com.austinhub.searchservice;

import com.austinhub.searchservice.models.dto.BoothDTO;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

@SpringBootApplication
public class SearchServiceApplication {

    private ElasticsearchOperations elasticsearchTemplate2;

    public static void main(String[] args) {
        SpringApplication.run(SearchServiceApplication.class);
    }

    @PostConstruct
    public void postConstruct() {
    }
}

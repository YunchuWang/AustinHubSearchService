//package com.austinhub.searchservice.controllers;
//
//import static org.junit.Assert.*;
//
//import com.austinhub.searchservice.models.dto.BoothDTO;
//import com.austinhub.searchservice.models.dto.Category;
//import com.austinhub.searchservice.repositories.BoothRepository;
//import java.util.List;
//import org.apache.lucene.search.join.ScoreMode;
//import org.elasticsearch.ElasticsearchException;
//import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
//import org.elasticsearch.client.RequestOptions;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.rest.RestStatus;
//import org.elasticsearch.search.sort.SortBuilders;
//import org.elasticsearch.search.sort.SortOrder;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SearchControllerTest {
//    @Autowired
//    private BoothRepository boothRepository;
//
//    @Autowired
//    private RestHighLevelClient elasticsearchClient;
//
//    @After
//    public void tearDown() throws Exception {
////        try {
////            DeleteIndexRequest request = new DeleteIndexRequest("booth");
////            elasticsearchClient.indices().delete(request, RequestOptions.DEFAULT);
////        } catch (ElasticsearchException exception) {
////            if (exception.status() == RestStatus.NOT_FOUND) {
////
////            }
////        }
//        Category foodCate = Category.builder().name("food").build();
//        Category restCate = Category.builder().name("restaurant").build();
//
//        boothRepository.saveAll(List.of(BoothDTO.builder()
//                                                       .id(1)
//                                                       .name("food1")
//                                                       .num(22)
//                                                       .category(foodCate)
//                                                       .address(
//                                                               "food1 addr")
//                                                       .description("food1 desc")
//                                                       .email("food1email@gmail.com")
//                                                       .build(),
//                                               BoothDTO.builder()
//                                                       .id(2)
//                                                       .name("food2")
//                                                       .num(23)
//                                                       .category(foodCate)
//                                                       .address(
//                                                               "food2 addr")
//                                                       .description("food2 desc")
//                                                       .email("food2email@gmail.com")
//                                                       .build(),
//                                               BoothDTO.builder()
//                                                       .id(3)
//                                                       .name("food3")
//                                                       .num(24)
//                                                       .category(restCate)
//                                                       .address(
//                                                               "food3 addr")
//                                                       .description("food3 desc")
//                                                       .email("food3email@gmail.com")
//                                                       .build(),
//                                               BoothDTO.builder()
//                                                       .id(4)
//                                                       .name("food4")
//                                                       .num(25)
//                                                       .category(restCate)
//                                                       .address(
//                                                               "food4 addr")
//                                                       .description("food4 desc")
//                                                       .email("food4email@gmail.com")
//                                                       .build()));
//    }
//
//    @Test
//    public void testNested() {
//        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
//        builder.withQuery(QueryBuilders.nestedQuery("category", QueryBuilders.termQuery("category"
//                                                                                                + ".name",
//                                                                                        "food"),
//                                                    ScoreMode.None));
//        builder.withSort(SortBuilders.fieldSort("num")
//                                     .order(SortOrder.ASC));
//        Page<BoothDTO> booths = boothRepository.search(builder.build());
//    }
//
//
//}
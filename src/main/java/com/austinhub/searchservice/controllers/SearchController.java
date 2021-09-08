package com.austinhub.searchservice.controllers;

import com.austinhub.searchservice.models.dto.BoothDTO;
import com.austinhub.searchservice.models.dto.Category;
import com.austinhub.searchservice.models.enums.SortOrder;
import com.austinhub.searchservice.repositories.BoothRepository;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/search/booths")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class SearchController {

    private BoothRepository boothRepository;
//    private ElasticsearchOperations elasticsearchTemplate2;

    @GetMapping
    public Page<BoothDTO> findByCategory(@Valid @NotNull @RequestParam("category") String category,
                                         @Valid @NotNull @RequestParam("sortBy") String sortBy,
                                         @Valid @NotNull @RequestParam("sortOrder") SortOrder sortOrder) {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withQuery(QueryBuilders.nestedQuery("category", QueryBuilders.termQuery("category"
                                                                                                + ".name",
                                                                                        category),
                                                    ScoreMode.None));
        builder.withSort(SortBuilders.fieldSort(sortBy)
                                     .order(sortOrder == SortOrder.ASC ?
                                                    org.elasticsearch.search.sort.SortOrder.ASC
                                                    : org.elasticsearch.search.sort.SortOrder.DESC));
        Page<BoothDTO> booths = boothRepository.search(builder.build());

        return booths;
    }

    @GetMapping("/saveAll")
    public Iterable<BoothDTO> saveAll() {
//        elasticsearchTemplate2.putMapping(BoothDTO.class);
        Category foodCate = Category.builder()
                                    .name("food")
                                    .build();
        Category restCate = Category.builder()
                                    .name("restaurant")
                                    .build();

        return boothRepository.saveAll(List.of(BoothDTO.builder()
                                                       .id(1)
                                                       .name("food1")
                                                       .category(foodCate)
                                                       .address(
                                                               "food1 addr")
                                                       .description("food1 desc")
                                                       .email("food1email@gmail.com")
                                                       .build(),
                                               BoothDTO.builder()
                                                       .id(2)
                                                       .name("food2")
                                                       .category(foodCate)
                                                       .address(
                                                               "food2 addr")
                                                       .description("food2 desc")
                                                       .email("food2email@gmail.com")
                                                       .build(),
                                               BoothDTO.builder()
                                                       .id(3)
                                                       .name("food3")
                                                       .category(restCate)
                                                       .address(
                                                               "food3 addr")
                                                       .description("food3 desc")
                                                       .email("food3email@gmail.com")
                                                       .build(),
                                               BoothDTO.builder()
                                                       .id(4)
                                                       .name("food4")
                                                       .category(restCate)
                                                       .address(
                                                               "food4 addr")
                                                       .description("food4 desc")
                                                       .email("food4email@gmail.com")
                                                       .build()));
    }
}

package com.austinhub.searchservice.models.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Author: bill wang
 * @Date: 2021/04/16 10:19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Document(indexName = "category", shards = 3, replicas = 1)
public class Category implements Serializable {
    private Integer id;
    private String name;
    private String link;
    private String displayName;
    private CategoryType categoryType;
}

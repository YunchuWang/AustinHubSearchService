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
 * @Date: 2021/04/16 09:21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "booth", shards = 3, replicas = 1)
public class BoothDTO implements Serializable {
    @Id
    private Integer id;
//    private ResourceDTO resource;

    @Field(type = FieldType.Keyword)
    private String name;
    @Field(type = FieldType.Keyword)
    private String address;
    private String phone;
    private String email;
    @Field(type = FieldType.Text)
    private String description;
    private String webLink;

    @Field(type=FieldType.Nested)
    private Category category;
}

//package com.austinhub.searchservice.models.dto;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.Set;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.validation.constraints.NotBlank;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//import org.springframework.data.elasticsearch.annotations.Document;
//
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Document(indexName = "resource", shards = 3, replicas = 1)
//public class ResourceDTO implements Serializable {
//    private Integer id;
//
//    private Account account;
//
//    private String name;
//
//    private String categoryName;
//
//    private Integer membershipId;
//
//    private Date expirationTimestamp;
//
//    private Date createdTimestamp;
//
//    private Boolean isArchived;
//
//    private ResourceType resourceType;
//}

package com.austinhub.searchservice.repositories;

import com.austinhub.searchservice.models.dto.BoothDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoothRepository extends ElasticsearchRepository<BoothDTO, Long> {
}

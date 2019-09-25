package com.sdstc.elsearch.dao;

import com.sdstc.elsearch.document.UserDoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository("userDocDao")
public interface UserDocDao extends ElasticsearchRepository<UserDoc, String> {
    Page<UserDoc> findByName(String name, Pageable pageable);

}

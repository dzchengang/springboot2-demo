package com.sdstc.elsearch.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.sdstc.elsearch.document.NewsDoc;

@Repository("newsDocDao")
public interface NewsDocDao extends ElasticsearchRepository<NewsDoc, String> {

}

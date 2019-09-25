package com.sdstc.elsearch.service.impl;

import com.sdstc.elsearch.dao.UserDocDao;
import com.sdstc.elsearch.document.UserDoc;
import com.sdstc.elsearch.service.UserDocService;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service("userDocService")
public class UserDocServiceImpl implements UserDocService {
    @Autowired
    private UserDocDao userDocDao;

    @Override
    public void save(UserDoc userDoc) {
        userDocDao.save(userDoc);
    }


    @Override
    public void query() {

        //根据条件查询
        //SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchQuery("name", "hello")).build();
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("name", "hello"))
                .withQuery(QueryBuilders.matchQuery("address", "hello")).build();
        //SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery("张华","name","address")).build();

        System.out.println(searchQuery.toString());
        Page<UserDoc> docPage=userDocDao.search(searchQuery);
        Iterator<UserDoc> userDocs=docPage.iterator();

       /* //查询所有
       Iterator<UserDoc> userDocs= userDocDao.findAll().iterator();*/
       while (userDocs.hasNext()){
           System.out.println(userDocs.next().getName());
       }
    }
}

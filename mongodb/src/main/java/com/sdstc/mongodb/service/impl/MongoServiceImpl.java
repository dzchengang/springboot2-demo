package com.sdstc.mongodb.service.impl;

import com.sdstc.mongodb.model.Book;
import com.sdstc.mongodb.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service("mongoService")
public class MongoServiceImpl implements MongoService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(Book book) {
        mongoTemplate.insert(book);
    }
}

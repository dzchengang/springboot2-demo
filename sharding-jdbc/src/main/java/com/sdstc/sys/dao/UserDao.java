package com.sdstc.sys.dao;

import com.sdstc.sys.model.User;

public interface UserDao {
   void insert(User dto);
   
   User getUser(User dto);
}

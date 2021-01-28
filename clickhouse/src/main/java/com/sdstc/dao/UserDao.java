package com.sdstc.dao;


import com.sdstc.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserDao {
    @Insert(" INSERT INTO `user` " +
            "(`userId`, `appId`, `version`, `regTime`) " +
            "VALUES " +
            "(#{userId}, #{appId}, #{version}, #{regTime})")
    public void insert(User user);

    @Select("select userId,appId,version,regTime from user")
   /* @Results(id = "user", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(id = true, column = "name", property = "name"),
            @Result(id = true, column = "create_date", property = "createDate",javaType = Date.class)
    })*/
    public List<User> selectAll();

    @Delete("ALTER TABLE user DELETE where 1=1")
    void deleteAll();
}

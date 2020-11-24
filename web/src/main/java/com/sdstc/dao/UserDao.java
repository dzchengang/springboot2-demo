package com.sdstc.dao;

import com.sdstc.model.Org;
import com.sdstc.model.User;

public interface UserDao {
    Integer insertUser(User dto);
    Integer insertOrg(Org org);

    Integer selUser();
}

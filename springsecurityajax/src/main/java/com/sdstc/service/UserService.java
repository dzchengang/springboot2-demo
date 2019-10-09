package com.sdstc.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
	UserDetails getUserDetailByPhone(String phone);
}

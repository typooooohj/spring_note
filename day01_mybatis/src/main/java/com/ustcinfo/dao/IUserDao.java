package com.ustcinfo.dao;

import com.ustcinfo.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
}

package com.zkml.dao;

import com.zkml.bean.Student;

public interface StudentDao {
    public void save(Student student);
    public Integer getUser(String id);
}

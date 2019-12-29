package com.ihrm.system.dao;


import com.ihrm.domain.system.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 自定义dao接口继承
 *      JpaRepository<实体类，主键类型>
 *      JpaSpecificationExecutor<实体类>
 */
public interface UserDao extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {
}

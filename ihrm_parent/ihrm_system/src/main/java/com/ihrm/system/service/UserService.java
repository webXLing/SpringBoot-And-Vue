package com.ihrm.system.service;

import com.ihrm.commom.utils.IdWorker;
import com.ihrm.domain.system.User;
import com.ihrm.system.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class UserService {


    @Autowired
    private UserDao userDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 1.保存用户
     */
    public void save(User user) {
        //设置主键的值
        String id = idWorker.nextId()+"";
        user.setPassword("123456");//设置初始密码
        user.setEnableState(1);
        user.setId(id);
        //调用dao保存部门
        userDao.save(user);
    }


    /**
     * 2.更新用户
     */
    public void update(User user) {
        //1.根据id查询部门
        User target = userDao.findById(user.getId()).get();
        //2.设置部门属性
        target.setUsername(user.getUsername());
        target.setPassword(user.getPassword());
        target.setDepartmentId(user.getDepartmentId());
        target.setDepartmentName(user.getDepartmentName());
        //3.更新部门
        userDao.save(target);
    }


    /**
     * 3.根据id查询用户
     */
    public User findById(String id) {
        return userDao.findById(id).get();
    }



    /**
     * 4.查询全部用户列表
     *      参数：map集合的形式
     *          hasDept
     *          departmentId
     *          companyId
     *
     */
    public Page findAll(Map<String,Object> map, int page, int size) {
        //1.查询条件

        Specification<User> spec = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //Predicate 这个是  拼接 api  要用的
                List<Predicate> list = new ArrayList<>();
                // companyId 有值
                if(!StringUtils.isEmpty(map.get("companyId"))){
                    list.add(criteriaBuilder.equal(root.get("companyId").as(String.class),(String)map.get("companyId")));
                }

                // departmentId 有值
                if(!StringUtils.isEmpty(map.get("departmentId"))){
                    list.add(criteriaBuilder.equal(root.get("departmentId").as(String.class),(String)map.get("departmentId")));
                }

                //根据请求的hasDept判断  是否分配部门 0未分配（departmentId = null || 0），1 已分配 （departmentId ！= null）
                if(StringUtils.isEmpty(map.get("hasDept")) || "0".equals(map.get("hasDept"))){
                    list.add(criteriaBuilder.isNull(root.get("departmentId")));
                    System.out.println(1);
                }else{
                    list.add(criteriaBuilder.isNotNull(root.get("departmentId")));
                    System.out.println(2);

                }
                return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
            }
        };
        System.out.println(spec);

        //2.分页
        Page<User> all = userDao.findAll(spec, new PageRequest(page, size));

        System.out.println(all);
        return all;
    }
    /**
     * 5.根据id删除用户
     */
    public void deleteById(String id) {
        userDao.deleteById(id);
    }


}

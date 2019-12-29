package com.ihrm.commom.service;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


/**
 * 抽取一个公共类
 * 用于通过 companyId 查询 部门列表
 */
public class BaseService<T> {
    protected Specification<T> getSpec(String companyId){


        /**
         * 用户构造查询条件
         *      1.只查询companyId
         *      2.很多的地方都需要根据companyId查询
         *      3.很多的对象中都具有companyId
         *
         */
        Specification<T> spec = new Specification(){
            /**
             //             * 用户构造查询条件
             //             *      root   ：包含了所有的对象数据
             //             *      cq     ：一般不用
             //             *      cb     ：构造查询条件
             where companyId = id
             //             */
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                //根据企业id查询
                return cb.equal(root.get("companyId").as(String.class),companyId);
            }
        };
        return spec;
    }
}

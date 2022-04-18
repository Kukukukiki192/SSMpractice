package com.dao;

import com.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {

    /**
     * 查询所有产品信息
     * @return
     * @throws Exception
     */
    @Select("select * from product")
    public List<Product> findAll() throws Exception;
}

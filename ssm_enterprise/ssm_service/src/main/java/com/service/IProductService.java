package com.service;

import com.domain.Product;

import java.util.List;

public interface IProductService {

    /**
     * 查询所有产品信息
     * @return
     * @throws Exception
     */
    public List<Product> findAll() throws Exception;
}

package com.dao;

import com.domain.IpFilter;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ip拦截 dao 接口
 */
@Repository
public interface IIpFilterDao {
    List<IpFilter> selectList(IpFilter ipFilter);
}

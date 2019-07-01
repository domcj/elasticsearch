package com.huarun.elasticsearch.mapper;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.huarun.elasticsearch.model.GoodsInfo;

/**
 * @description: This is a class!
 * @author: chenjian
 * @date: 2019/06/28 16:06
 */
public interface GoodsInfoMapper extends ElasticsearchRepository<GoodsInfo, Long> {

}

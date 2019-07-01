package com.huarun.elasticsearch.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.huarun.elasticsearch.mapper.GoodsInfoMapper;
import com.huarun.elasticsearch.model.GoodsInfo;

/**
 * @description: This is a class!
 * @author: chenjian
 * @date: 2019/06/28 16:07
 */
@RestController
public class LocalController {

	@Resource
	private GoodsInfoMapper goodsInfoMapper;

	private static Logger logger = LoggerFactory.getLogger(LocalController.class);

	@GetMapping("/local")
	public Object local() {
		GoodsInfo goodsInfo = new GoodsInfo();
		goodsInfo.setGoodsId(1000L);
		goodsInfo.setTags("热门");
		goodsInfo.setDay("1204");
		goodsInfo.setGoodsName("elasticsearch入门指南");
		goodsInfo.setFitGender("男");
		Optional<GoodsInfo> dbGoodsInfo = null;
		try {
			GoodsInfo save = goodsInfoMapper.save(goodsInfo);
			dbGoodsInfo = goodsInfoMapper.findById(save.getGoodsId());
		} catch (Exception e) {
			logger.error("操作es出错", e);
		}
		logger.info(dbGoodsInfo.toString());
		return dbGoodsInfo;
	}

	@GetMapping("/search/{key}")
	public List<GoodsInfo> search(@PathVariable("key") String key) {
		List<GoodsInfo> goodsInfos = new ArrayList<>();
		TermQueryBuilder queryBuilder = QueryBuilders.termQuery("goodsName", key);
		Iterable<GoodsInfo> search = goodsInfoMapper.search(queryBuilder);
		search.forEach(goodsInfo -> {
			goodsInfos.add(goodsInfo);
		});
		return goodsInfos;
	}


}

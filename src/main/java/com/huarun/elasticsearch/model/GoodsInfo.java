package com.huarun.elasticsearch.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Data
@Document(indexName = "b2b-product",type = "goodsInfo")
public class GoodsInfo {

    @Id
    private Long goodsId ;

    private String goodsName;
    /**
     * 一级分类
     */
    private String cateLev1;
    private String cateLev2;
    private String fitAge;
    private String fitProfession;
    private String fitGender;
    /**
     * 排期
     */
    private String day;
    private String tags;
    private String sellerShop;

}
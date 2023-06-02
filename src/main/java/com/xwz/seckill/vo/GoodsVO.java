package com.xwz.seckill.vo;

import com.xwz.seckill.pojo.Goods;
import com.xwz.seckill.pojo.SeckillGoods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsVO{
    private Long id;
    private String goodsName;
    private String goodsTitle;
    private String goodsImg;
    private String goodsDetail;
    private BigDecimal goodsPrice;
    private Integer goodsStock;
//    private BigDecimal seckillPrice;
//    private Integer stockCount;
//    private Date startDate;
//    private Date endDate;
    private SeckillGoods seckillGoods;
}

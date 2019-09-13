package com.wj.mail.api.domin;

import io.swagger.annotations.ApiModelProperty;

/**
 * @program: springLearnDemo <br>
 * @Description: 商品详情 <br>
 * @author: Wu.Jiang <br>
 * @create: 2019-06-20 14:45
 **/
public class ProductDetails {

    private Long prodId;

    @ApiModelProperty(value = "产品名称")
    private String prodName;

    @ApiModelProperty(value = "产品描述")
    private String prodDec;

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDec() {
        return prodDec;
    }

    public void setProdDec(String prodDec) {
        this.prodDec = prodDec;
    }
}

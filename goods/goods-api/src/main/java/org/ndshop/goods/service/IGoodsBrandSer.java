package org.ndshop.goods.service;

import org.ndshop.dbs.jpa.exception.SerException;
import org.ndshop.dbs.jpa.service.IService;
import org.ndshop.goods.dto.GoodsBrandDto;
import org.ndshop.goods.entity.GoodsBrand;

/**
 * Created by ike on 16-11-14.
 */
public interface IGoodsBrandSer extends IService<GoodsBrand , GoodsBrandDto>{

    void addBrand(String brandName ) throws SerException;

    void updateBrand (GoodsBrand gb )throws SerException;

    void findBrand() throws SerException;
}
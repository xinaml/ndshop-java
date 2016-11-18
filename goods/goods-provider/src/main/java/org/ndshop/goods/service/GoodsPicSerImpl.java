package org.ndshop.goods.service;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.ndshop.dbs.jpa.dto.Condition;
import org.ndshop.dbs.jpa.enums.DataType;
import org.ndshop.dbs.jpa.enums.RestrictionType;
import org.ndshop.dbs.jpa.exception.SerException;
import org.ndshop.dbs.jpa.service.ServiceImpl;
import org.ndshop.goods.dto.GoodsPicDto;
import org.ndshop.goods.entity.Goods;
import org.ndshop.goods.entity.GoodsPic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by ike on 16-11-12.
 */
@Service
public class GoodsPicSerImpl extends ServiceImpl<GoodsPic,GoodsPicDto> implements IGoodsPicSer{

    private static Logger logger = Logger.getLogger(GoodsPicSerImpl.class);

    @Autowired
    private IGoodsSer goodsSer;

    @Transactional
    @Override
    public  void addGoodsPic ( Goods goods ,String picStrs ,String flag) throws SerException {
        goods = goodsSer.findById( goods.getId() );
        GoodsPic goodsPic = new GoodsPic();
        String time = goodsPic.getCreateTime().minusSeconds(0).format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        goodsPic.setPicUrl("/home/xx/xx"+time+".jpg");
        goodsPic.setFlag("详情图片");
        goodsPic.setGoods( goods );
        save(  goodsPic );
        logger.info(JSON.toJSONString( goodsPic ) );

    }

    @Cacheable("serviceCache")
    @Override
    public void findGoodsPic( String goodsId ) throws  SerException{
        Condition condition = new Condition("id", DataType.STRING , goodsId);
        condition.fieldToModels(Goods.class);
        GoodsPicDto goodsPicDto = new GoodsPicDto();
        condition.setRestrict(RestrictionType.EQ);
        goodsPicDto.getConditions().add( condition );
        List<GoodsPic> gp = findByCis( goodsPicDto );
        logger.info( JSON.toJSONString( gp ));
    }
}
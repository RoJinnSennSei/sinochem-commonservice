package com.sinochem.mq.kafka.listener;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
//import com.sinochem.gateway.wms.api.constant.WmsConstant;
//import com.sinochem.gateway.wms.api.to.service.MsGood;
//import com.sinochem.gateway.wms.api.to.service.MsGoodResourceRecode;
import com.sinochem.goods.api.feign.GoodsFeignClient;
import com.sinochem.goods.api.feign.ResourceBuyerPriceFeignClient;
import com.sinochem.goods.api.feign.ResourceFeignClient;
import com.sinochem.goods.api.vo.*;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author zhang.xing01
 * @description 商品系统数据消费监听
 * @date 2018/8/15
 */
@Component
public class GoodsListener {
//
//    private final static Logger logger = LoggerFactory.getLogger(GoodsListener.class);
//
//    /**
//     * 资源中心远程接口
//     */
//    @Resource
//    private ResourceFeignClient resoucreFeignClient;
//
//    @Resource
//    private GoodsFeignClient goodsFeignClient;
//
//    @Resource
//    private ResourceBuyerPriceFeignClient resourceBuyerPriceFeignClient;
//
//
//    /**
//     * 商品信息同步
//     * @param record
//     */
//    @KafkaListener(topics = WmsConstant.GOOD_SYNC_TOPIC)
//    public void receiveGoodsSync(ConsumerRecord<?, ?> record) {
//        Gson gson = new Gson();
//        logger.info("[商品] 商品信息同步：{}" + gson.toJson(record));
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//        if (kafkaMessage.isPresent()) {
//            Object message = kafkaMessage.get();
//            try {
//                //商品数据转换
//                MsGood msGood = gson.fromJson(message.toString(), MsGood.class);
//                GoodsSpuVO goodsSpuVO = this.assembleGoodsSpuVO(msGood);
//                //商品数据更新
//                goodsFeignClient.goodsSkuSync(goodsSpuVO);
//            } catch (Exception e) {
//                logger.error("[商品] 商品信息同步失败", e);
//                throw e;
//            }
//        }
//    }
//
//    /**
//     * 资源信息同步
//     * @param record
//     */
//    @KafkaListener(topics = WmsConstant.RESOURCES_SYNC_TOPIC)
//    public void receiveResourceSync(ConsumerRecord<?, ?> record) {
//        Gson gson = new Gson();
//        logger.info("[商品] 资源信息同步：{}" + gson.toJson(record));
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//        if (kafkaMessage.isPresent()) {
//            Object message = kafkaMessage.get();
//            try {
//                //资源数据转换
//                List<MsGoodResourceRecode> msGoodResourceRecodeList = gson.fromJson(message.toString(), new TypeToken<List<MsGoodResourceRecode>>(){}.getType());
//                List<ResourceVO> resourceVOList = this.assembleResourceVOList(msGoodResourceRecodeList);
//                resoucreFeignClient.resourceSync(resourceVOList);
//            } catch (Exception e) {
//                logger.error("[商品] 资源信息同步失败", e);
//                throw e;
//            }
//        }
//    }
//
//    /**
//     * 买家资源价格信息同步
//     * @param record
//     */
//    @KafkaListener(topics = WmsConstant.RESOURCES_PRICE_SCHEMA_SYNC_TOPIC)
//    public void receiveBuyerResourcePriceSync(ConsumerRecord<?, ?> record) {
//        Gson gson = new Gson();
//        logger.info("[商品] 买家资源价格信息同步：{}" + gson.toJson(record));
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//        if (kafkaMessage.isPresent()) {
//            Object message = kafkaMessage.get();
//            try {
//                //买家资源价格数据转换
//                List<ResourceBuyerPriceVO> resourceBuyerPriceVOList = gson.fromJson(message.toString(), new TypeToken<List<ResourceBuyerPriceVO>>(){}.getType());
//                resourceBuyerPriceFeignClient.resourceBuyerPriceSync(resourceBuyerPriceVOList);
//            } catch (Exception e) {
//                logger.error("[商品] 买家资源价格信息同步失败", e);
//                throw e;
//            }
//        }
//    }
//
//    private GoodsSpuVO assembleGoodsSpuVO(MsGood msGood) {
//        GoodsSpuVO goodsSpuVO = new GoodsSpuVO();
//        goodsSpuVO.setGoodsSpuId(msGood.getGoodsId());
//        goodsSpuVO.setGoodsCateName(msGood.getGoodsCateName());
//        goodsSpuVO.setUnit(msGood.getUnit());
//        goodsSpuVO.setStandard(msGood.getStandard());
//        goodsSpuVO.setManufacturerName(msGood.getManufacturerName());
//        goodsSpuVO.setGoodsSpuName(msGood.getGoodsSpuName());
//        goodsSpuVO.setEnglishName(msGood.getEnglishName());
//        goodsSpuVO.setStatus(msGood.getStatus());
//        goodsSpuVO.setCreateTime(new Date());
//        goodsSpuVO.setUpdateTime(new Date());
//        return goodsSpuVO;
//    }
//
//    private List<ResourceVO> assembleResourceVOList(List<MsGoodResourceRecode> msGoodResourceRecodeList) {
//        List<ResourceVO> resourceVOList = new ArrayList<>();
//        if(msGoodResourceRecodeList!=null && msGoodResourceRecodeList.size()>0){
//            for (MsGoodResourceRecode msGoodResourceRecode : msGoodResourceRecodeList){
//                ResourceVO resourceVO = new ResourceVO();
//                resourceVO.setResourceId(msGoodResourceRecode.getResourceId());
//                resourceVO.setGoodsSpuId(msGoodResourceRecode.getGoodsId());
//                resourceVO.setGoodsSkuId(msGoodResourceRecode.getGoodsId());
//                resourceVO.setGoodsCateName(msGoodResourceRecode.getGoodsCateName());
//                resourceVO.setStorePlaceId(msGoodResourceRecode.getStoreId());
//                resourceVO.setAddress(msGoodResourceRecode.getAddress());
//                resourceVO.setStoreName(msGoodResourceRecode.getStoreName());
//                resourceVO.setContactPerson(msGoodResourceRecode.getContactPerson());
//                resourceVO.setPhone(msGoodResourceRecode.getPhone());
//                StoreVO storeVO = new StoreVO();
//                BigDecimal storeNum = new BigDecimal(msGoodResourceRecode.getStoreNum());
//                storeVO.setStoreNum(storeNum);
//                storeVO.setEnterpriseId(msGoodResourceRecode.getEnterpriseId());
//                storeVO.setGoodsSkuId(msGoodResourceRecode.getGoodsId());
//                storeVO.setCreateTime(new Date());
//                storeVO.setUnit(msGoodResourceRecode.getUnit());
//                storeVO.setEnabled(1);
//                storeVO.setStorePlaceId(msGoodResourceRecode.getStoreId());
//                storeVO.setUpdateTime(new Date());
//                resourceVO.setStoreVO(storeVO);
//                resourceVO.setChineseName(msGoodResourceRecode.getChineseName());
//                resourceVO.setEnglishName(msGoodResourceRecode.getEnglishName());
//                resourceVO.setIntroduce(msGoodResourceRecode.getIntroduce());
//                resourceVO.setStatus(msGoodResourceRecode.getStatus());
//                BigDecimal price = new BigDecimal(msGoodResourceRecode.getPrice());
//                resourceVO.setPrice(price);
//                BigDecimal canSellNum = new BigDecimal(msGoodResourceRecode.getCanSellNum());
//                resourceVO.setCanSellNum(canSellNum);
//                BigDecimal singlePurchaseUnit = new BigDecimal(msGoodResourceRecode.getSinglePurchaseUnit());
//                resourceVO.setSinglePurchaseUnit(singlePurchaseUnit);
//                resourceVO.setUom(msGoodResourceRecode.getUom());
//                BigDecimal maxNumLimit = new BigDecimal(msGoodResourceRecode.getMaxNumLimit());
//                resourceVO.setMaxNumLimit(maxNumLimit);
//                BigDecimal minNumLimit = new BigDecimal(msGoodResourceRecode.getMinNumLimit());
//                resourceVO.setMinNumLimit(minNumLimit);
//                resourceVO.setTradeType(msGoodResourceRecode.getTradeType());
//                resourceVO.setUpStatus(msGoodResourceRecode.getUpStatus());
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                try {
//                    resourceVO.setUpdateTime(sdf.parse(msGoodResourceRecode.getUpTime()));
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    resourceVO.setRemoveTime(sdf.parse(msGoodResourceRecode.getRemoveTime()));
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                resourceVO.setConcactPerson(msGoodResourceRecode.getConcactPerson());
//                resourceVO.setConcactPhone(msGoodResourceRecode.getConcactPhone());
//                resourceVO.setRemoveComment(msGoodResourceRecode.getRemoveComment());
//                resourceVO.setDeliveryTimes(Integer.parseInt(msGoodResourceRecode.getDeliveryTimes()));
//                resourceVOList.add(resourceVO);
//            }
//        }
//        return resourceVOList;
//    }

}

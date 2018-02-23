package com.py.intergration.controller;

import com.mongodb.client.model.Filters;
import com.py.common.utils.GsonUtil;
import com.py.common.utils.ParamUtil;
import com.py.intergration.util.mongodb.MongoDBUtil;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jzl on 17/12/19.
 */
@RestController
@RequestMapping(value = "/mongo", method = {RequestMethod.POST, RequestMethod.GET})
public class MongoController {

    private static Logger logger = LoggerFactory.getLogger(MongoController.class);

    /**
     * 查询接口
     * @param dbName
     * @param collectionName
     * @param
     * @return
     */
    @RequestMapping(value = "/find", method = {RequestMethod.POST, RequestMethod.GET})
    public String find(String dbName, String collectionName, String key, String value) {
        Bson filter;
        if ("user_id".equals(key)) {
            filter = Filters.eq(key, Long.valueOf(value));
        }else {
            filter = Filters.eq(key, value);
        }
        try {
            return GsonUtil.toJson(MongoDBUtil.find(dbName, collectionName, filter));
        }catch (Exception e) {
            logger.error("mongo服务find方法出现异常,e:{}", e);
            return null;
        }
    }

    /**
     * 查询一个
     * @param dbName
     * @param collectionName
     * @param
     * @return
     */
    @RequestMapping(value = "/findOne", method = {RequestMethod.POST, RequestMethod.GET})
    public String findOne(String dbName, String collectionName, String key, String value) {
        Bson filter;
        if ("user_id".equals(key)) {
            filter = Filters.eq(key, Long.valueOf(value));
        }else {
            filter = Filters.eq(key, value);
        }
        logger.info("findOne方法收到的参数：dbName:{},collecName:{},key:{},value:{}", dbName,collectionName,key,value);
        try {
            Document document = MongoDBUtil.findOne(dbName, collectionName, filter);
            if (ParamUtil.isEmpty(document) || document.isEmpty()) {
                logger.info("findOne方法查询到的数据为空");
            }else {
                logger.info("findOne方法查询到的数据为document:{}", document.toString());
            }
            return GsonUtil.toJson(document);
        }catch (Exception e) {
            logger.error("mongo服务findOne方法出现异常,e:{}", e);
            return null;
        }
    }

    /**
     * 修改一个
     * @param dbName
     * @param collectionName
     * @param filterMapJson
     * @param updateMapJson
     * @return
     */
    @RequestMapping(value = "/updateOne", method = {RequestMethod.POST, RequestMethod.GET})
    public boolean updateOne(String dbName, String collectionName, String filterMapJson, String updateMapJson) {
        try {
            Map<String, Object> filterMap = GsonUtil.GsonToMaps(filterMapJson);
            Map<String, Object> updateMap = GsonUtil.GsonToMaps(updateMapJson);
            return MongoDBUtil.updateOne(dbName, collectionName, filterMap, updateMap);
        }catch (Exception e){
            logger.error("mongo服务updateOne方法出现异常,e:{}", e);
            return false;
        }
    }

    /**
     * 是否存在
     * @param dbName
     * @param collectionName
     * @param filterMapJson
     * @return
     */
    @RequestMapping(value = "/isExits", method = {RequestMethod.POST, RequestMethod.GET})
    public boolean isExits(String dbName, String collectionName, String filterMapJson) {
        try {
            Map<String, Object> filterMap = GsonUtil.GsonToMaps(filterMapJson);
            return MongoDBUtil.isExits(dbName, collectionName, filterMap);
        }catch (Exception e) {
            logger.error("mongo服务isExits方法出现异常,e:{}", e);
            return false;
        }
    }

    /**
     * 以map形式插入
     * @param dbName
     * @param collectionName
     * @param insertMapJson
     * @return
     */
    @RequestMapping(value = "/insertMap", method = {RequestMethod.POST, RequestMethod.GET})
    public boolean insertMap(String dbName, String collectionName, String insertMapJson) {
        try {
            Map<String, Object> insertMap = GsonUtil.GsonToMaps(insertMapJson);
            return MongoDBUtil.insert(dbName, collectionName, insertMap);
        }catch (Exception e) {
            logger.error("mongo服务insertMap方法出现异常,e:{}", e);
            return false;
        }
    }

    /**
     * 以Bson格式插入
     * @param dbName
     * @param collectionName
     * @param documentJson
     * @return
     */
    @RequestMapping(value = "/insertDocument", method = {RequestMethod.POST, RequestMethod.GET})
    public static boolean insertDocument(String dbName, String collectionName, String documentJson) {
        try {
            Document document = GsonUtil.GsonToBean(documentJson, Document.class);
            return MongoDBUtil.insert(dbName, collectionName, document);
        }catch (Exception e) {
            logger.error("mongo服务insertDocument方法出现异常,e:{}", e);
            return false;
        }
    }

    /**
     * 替换
     * @param dbName
     * @param collectionName
     * @param newDocumentJson
     * @param oldDocumentJson
     * @return
     */
    @RequestMapping(value = "/replaceOne", method = {RequestMethod.POST, RequestMethod.GET})
    public boolean replaceOne(String dbName, String collectionName, String newDocumentJson,
                                     String oldDocumentJson) {
        try {
            Document newdocument = GsonUtil.GsonToBean(newDocumentJson, Document.class);
            Document olddocument = GsonUtil.GsonToBean(oldDocumentJson, Document.class);
            return MongoDBUtil.replaceOne(dbName, collectionName, newdocument, olddocument);
        }catch (Exception e) {
            logger.error("mongo服务replaceOne方法出现异常,e:{}", e);
            return false;
        }
    }

    /**
     * 删除
     * @param dbName
     * @param collectionName
     * @param mapJson
     * @return
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET})
    public boolean delete(String dbName, String collectionName, String mapJson) {
        try {
            Map<String, Object> map = GsonUtil.GsonToMaps(mapJson);
            return MongoDBUtil.delete(dbName, collectionName, map);
        }catch (Exception e){
            logger.error("mongo服务delete方法出现异常,e:{}", e);
            return false;
        }
    }

    /**
     * 按id 删除
     * @param dbName
     * @param collectionName
     * @param _id
     * @return
     */
    @RequestMapping(value = "/deleteById", method = {RequestMethod.POST, RequestMethod.GET})
    public boolean deleteById(String dbName, String collectionName, String _id) {
        try {
            return MongoDBUtil.deleteById(dbName,collectionName, _id);
        }catch (Exception e) {
            logger.error("mongo服务deleteById方法出现异常,e:{}", e);
            return false;
        }
    }

}

package com.py.intergration.util.mongodb;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.WriteModel;

/**
 * Created by jzl on 17/8/23.
 */
public class MongoDBUtil {
    //public static final String DBNAME = "xinqiandai";

    private static Logger logger = LoggerFactory.getLogger(MongoDBUtil.class);
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
    private static final String MONGODBURI = resourceBundle.getString("mongodb.uri");

    /**
     * 查询方法
     * @param collectionName
     * @param filter
     * @return
     */
    public static List<Document> find(String dbName, String collectionName, Bson filter) {
        MongoDBDaoImpl mongoDBDaoImpl = init();
        List<Document> resultList = mongoDBDaoImpl.find(dbName,collectionName,filter);
        return resultList;
    }

    /**
     * 查询一个
     * @param collectionName
     * @param filter
     * @return
     */
    public static Document findOne(String dbName, String collectionName, Bson filter) {
        MongoDBDaoImpl mongoDBDaoImpl = init();

        return mongoDBDaoImpl.findOne(dbName,collectionName,filter);
    }

    /**
     * 修改一个
     * @param collectionName
     * @param filterMap
     * @param updateMap
     * @return
     */
    public static boolean updateOne(String dbName, String collectionName, Map<String, Object> filterMap, Map<String, Object> updateMap) {
        MongoDBDaoImpl mongoDBDaoImpl = init();
        return mongoDBDaoImpl.updateOne(dbName, collectionName, filterMap, updateMap);
    }

    /**
     * 是否存在
     * @param collectionName
     * @param filterMap
     * @return
     */
    public static boolean isExits(String dbName, String collectionName, Map<String, Object> filterMap) {
        MongoDBDaoImpl mongoDBDaoImpl = init();
        boolean res = mongoDBDaoImpl.isExits(dbName,collectionName,filterMap);
        return res;
    }

    /**
     * 插入
     * @param collectionName
     * @param insertMap
     * @return
     */
    public static boolean insert(String dbName, String collectionName, Map<String, Object> insertMap) {
        MongoDBDaoImpl mongoDBDaoImpl = init();
        boolean res = mongoDBDaoImpl.insert(dbName,collectionName,insertMap);
        return res;
    }

    /**
     * 插入document
     * @param collectionName
     * @return
     */
    public static boolean insert(String dbName, String collectionName, Document document) {
        MongoDBDaoImpl mongoDBDaoImpl = init();
        boolean res = mongoDBDaoImpl.insert(dbName,collectionName,document);
        return res;
    }

    /**
     * replace document
     * @param collectionName
     * @return
     */
    public static boolean replaceOne(String dbName, String collectionName, Document newdocument,
                                     Document olddocument) {
        MongoDBDaoImpl mongoDBDaoImpl = init();
        boolean res = mongoDBDaoImpl.replaceOne(dbName,collectionName,newdocument,olddocument);
        return res;
    }

    public static boolean bultWriteRecord(String dbName, String collectionName,List<WriteModel<Document>> requests){
        MongoDBDaoImpl mongoDBDaoImpl = init();
        boolean res=mongoDBDaoImpl.bultWriteRecord(dbName,collectionName,requests);
        return res;
    }

    /**
     * 删除
     * @param collectionName
     * @param map
     * @return
     */
    public static boolean delete(String dbName, String collectionName, Map<String, Object> map) {
        MongoDBDaoImpl mongoDBDao = init();
        boolean res = mongoDBDao.delete(dbName,collectionName,map);
        return res;
    }

    /**
     * 按id删除
     * @param collectionName
     * @param _id
     * @return
     */
    public static boolean deleteById(String dbName, String collectionName, String _id) {
        MongoDBDaoImpl mongoDBDao = init();
        return mongoDBDao.deleteById(dbName,collectionName,_id);
    }


    public static MongoDatabase getDataBase(String dbName) {
        return MongoDBDaoImpl.getInstance(MONGODBURI).getDatabase(dbName);
    }
    /**
     * 初始化
     * @return
     */
    public static MongoDBDaoImpl init() {
        return MongoDBDaoImpl.getInstance(MONGODBURI);
    }


}

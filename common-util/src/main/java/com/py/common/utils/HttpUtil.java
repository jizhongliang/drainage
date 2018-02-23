package com.py.common.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jzl on 17/2/24.
 */
public class HttpUtil {
    private static String ENCODE = "UTF-8";
    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public HttpUtil() {
    }

    public static String httpGet(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        return doGet(url, httpClient);
    }

    public static String httpPost(String url, Map<String, Object> params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        return doPost(url, params, httpClient);
    }

    public static String httpsPost(String url, Map<String, Object> params) {
        CloseableHttpClient httpClient = createSSLClientDefault();
        return doPost(url, params, httpClient);
    }

    private static String doPost(String url, Map<String, Object> params, CloseableHttpClient httpClient) {
        HttpClientContext httpContext = new HttpClientContext();
        HttpPost httpPost = new HttpPost(url);
        ArrayList formParams = new ArrayList();
        Set stringSet = params.keySet();
        Iterator iterator = stringSet.iterator();

        String urlEncodedFormEntity;
        while(iterator.hasNext()) {
            urlEncodedFormEntity = (String)iterator.next();
            formParams.add(new BasicNameValuePair(urlEncodedFormEntity, String.valueOf(params.get(urlEncodedFormEntity))));
        }

        urlEncodedFormEntity = null;
        String result = "";

        try {
            UrlEncodedFormEntity urlEncodedFormEntity1 = new UrlEncodedFormEntity(formParams, ENCODE);
            httpPost.setEntity(urlEncodedFormEntity1);
            logger.info("post {} ;request data is  {}", url, EntityUtils.toString(urlEncodedFormEntity1));
            CloseableHttpResponse e = httpClient.execute(httpPost, httpContext);
            //logger.debug("headers:{}", e.getAllHeaders());
            logger.debug("response status:{}", e.getStatusLine());
            HttpEntity entity = e.getEntity();
            result = EntityUtils.toString(entity);
            logger.info("post {} ;response status is {} ;response data is {}", new Object[]{url, e.getStatusLine(), result});
        } catch (UnsupportedEncodingException var22) {
            var22.printStackTrace();
        } catch (IOException var23) {
            logger.error(" post 请求 {} 出现异常:", url, var23);
        } finally {
            try {
                httpClient.close();
            } catch (IOException var21) {
                var21.printStackTrace();
            }

        }

        return result;
    }

    private static String doGet(String url, CloseableHttpClient httpClient) {
        String result = "";
        HttpGet httpGet = new HttpGet(url);

        try {
            HttpClientContext e = new HttpClientContext();
            CloseableHttpResponse response = httpClient.execute(httpGet, e);
            //logger.debug("headers:{}", response.getAllHeaders());
            logger.debug("response status:{}", response.getStatusLine());
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
            logger.info("get {} ;response status is {} ;response data is {}", new Object[]{url, response.getStatusLine(), result});
        } catch (IOException var15) {
            var15.printStackTrace();
            logger.error(" post 请求 {} 出现异常:", var15);
        } finally {
            try {
                httpClient.close();
            } catch (IOException var14) {
                var14.printStackTrace();
            }

        }

        return result;
    }

    public static CloseableHttpClient createSSLClientDefault() {
        try {
            SSLContext e = (new SSLContextBuilder()).loadTrustMaterial((KeyStore)null, new TrustStrategy() {
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(e);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException var2) {
            var2.printStackTrace();
        } catch (NoSuchAlgorithmException var3) {
            var3.printStackTrace();
        } catch (KeyStoreException var4) {
            var4.printStackTrace();
        }

        return null;
    }
    //获取客户端ip
    public static String getUserIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }
    /**
     13      * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
     14 *
     16      * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
     17      * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
     18      *
     19      * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130,
     20      * 192.168.1.100
     21      *
     22      * 用户真实IP为： 192.168.1.110
     23      *
     24      * @param request
     25      * @return
     26      */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * http request转为map
     * @param request
     * @return
     */
    public static Map<String,String> getParameterMap(HttpServletRequest request) {
        // 参数Map
        Map properties = request.getParameterMap();
        // 返回值Map
        Map<String,String> returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }
}

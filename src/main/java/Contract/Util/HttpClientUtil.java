package Contract.Util;

import ch.qos.logback.classic.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class HttpClientUtil {

    private static Logger logger = (Logger) LoggerFactory.getLogger(HttpClientUtil.class);

    /**
     * 无参 get http请求
     * @param HttpUrl
     * @return
     */
    public String doGetNonParam(String HttpUrl) {
        //获得http客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //创建get请求
        HttpGet httpGet = new HttpGet(HttpUrl);

        //响应模型
        CloseableHttpResponse response = null;

        try {
            //通过http客户端 发送get请求
            response = httpClient.execute(httpGet);

            //从响应模型中获取响应实体
            HttpEntity httpEntity = response.getEntity();

            logger.info("响应状态为:" + response.getStatusLine());
            if(httpEntity != null) {
                logger.info("响应内容长度为：" + httpEntity.getContentLength());
                logger.info("响应内容为：" + EntityUtils.toString(httpEntity));
                //返回响应结果
                return EntityUtils.toString(httpEntity);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(httpClient != null){
                    httpClient.close();
                }
                if(response !=null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    return null;
    }


    /**
     * http Get方法 有参
     * @param httpUrl
     * @return
     */
    public String doGetParam(String httpUrl) {
        //httpclient
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        //参数
        StringBuffer params = new StringBuffer();

        try {
            params.append("name=" + URLEncoder.encode("&","utf-8"));
            params.append("&");
            params.append("age=24");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        HttpGet httpGet = new HttpGet(httpUrl + "?"+ params);

        CloseableHttpResponse response = null;

        try {
            //配置信息
            RequestConfig requestConfig = RequestConfig.custom()
                    //设置连接超时时间
                    .setConnectTimeout(5000)
                    //设置请求超时时间
                    .setConnectionRequestTimeout(5000)
                    //Socket读写超时时间
                    .setSocketTimeout(5000)
                    //设置是否允许重定向（默认true）
                    .setRedirectsEnabled(true)
                    .build();

            //上面配置信息 配置到get请求里
            httpGet.setConfig(requestConfig);

            response = httpClient.execute(httpGet);
            HttpEntity responseEntity = response.getEntity();
            if(responseEntity != null) {
                logger.info("响应长度为：" + responseEntity.getContentLength());
                logger.info("响应内容为：" + EntityUtils.toString(responseEntity));
                return EntityUtils.toString(responseEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(httpClient != null){
                    httpClient.close();
                }
                if(response !=null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * http Post方法 无参
     * @param httpUrl
     * @return
     */
    public String doPostNonParam(String httpUrl) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost(httpUrl);

        CloseableHttpResponse httpResponse = null;

        try {
            httpResponse = httpClient.execute(httpPost);

            HttpEntity httpEntity = httpResponse.getEntity();

            if(httpEntity != null) {
                logger.info("post响应结果长度为：" + httpEntity.getContentLength());
                logger.info("post响应内容为：" + EntityUtils.toString(httpEntity));
                return EntityUtils.toString(httpEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(httpResponse != null) {
                    httpResponse.close();
                }
                if(httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}

package com.dlfc.services.auth.service.impl;

import com.dlfc.services.auth.dto.CreditAuthDTO;
import com.dlfc.services.auth.service.CreditService;
import com.housecenter.dlfc.framework.boot.stereotype.Service;
import com.housecenter.dlfc.framework.common.web.AjaxResult;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by walden on 17-6-30.
 */
@Getter
@Setter
@Service
public class CreditServiceImpl implements CreditService<CreditAuthDTO> {

    @Value(value = "${dlfc.user.ip}")
    private String ip;

    @Value(value = "${dlfc.user.path}")
    private String path;

    @Value(value = "${dlfc.user.port}")
    private String port;

    @Override
    public String auth(CreditAuthDTO creditAuthDTO) {
        String uri = ip+":"+port+path;
        HttpClient httpClient = HttpClients.createDefault();
        String ajaxResult = null;
        HttpPost httpPost = new HttpPost(uri);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("uId", creditAuthDTO.getUId()));
        params.add(new BasicNameValuePair("name", creditAuthDTO.getName()));
        params.add(new BasicNameValuePair("type", creditAuthDTO.getType()));
        params.add(new BasicNameValuePair("idCard", creditAuthDTO.getIdCard()));
        params.add(new BasicNameValuePair("bankMobile", creditAuthDTO.getBankMobile()));
        params.add(new BasicNameValuePair("bankNum", creditAuthDTO.getBankNum()));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            /*if(httpResponse.getStatusLine().getStatusCode() == 200)
            {*/
                HttpEntity httpEntity = httpResponse.getEntity();
                ajaxResult = EntityUtils.toString(httpEntity);
            //}
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ajaxResult;
    }
}

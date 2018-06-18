/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.example.store.v2;

import com.google.gson.JsonObject;
import com.vng.zalo.sdk.APIException;
import com.vng.zalo.sdk.oa.ZaloOaClient;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nguyenhc2
 */
public class TestAPIUploadPhoto {

    static String accessToken = "jCQCJ4UfJN6nn8TDGQvDTxJ7Xav1j0G7xwI5FLdF567FeeyR8iax8vN_X48vy2CZd-ZfNpNKV7cRo-C03EvtQgVS_mKCxK96ZVk57GZpFN2ox8L22-S1BeVAbnKBs39PbBQQ6ZkxN72ft_euCDjESAFsYnShz1rQe-wPOax5KoV3w-fvNEDV5zBTmNLWzm4TcEUNRY_zF3AewlmAFeHhBBISsnP1-MLExl7uAHlpEasgdgOL0PaBV8sfi4K2Xn8bj9Ic6oMB1I30NV8BHxLCSm";

    static ZaloOaClient oaClient = new ZaloOaClient();
//    static String API_DOMAIN = "https://openapi.zaloapp.com";
//    static String API_DOMAIN = "http://sandbox.openapi.zaloapp.com";
    static String API_DOMAIN = "http://localhost:8239";

    public static void main(String[] args) {
        try {
            oaClient.isDebug = true;
            System.out.println(uploadPhoto());
//            System.out.println(createCategory());
//            System.out.println(updateCategory());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.exit(0);
    }

    public static JsonObject uploadPhoto() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("access_token", accessToken);
        params.put("upload_type", "category");
        String endpoint = API_DOMAIN + "/store/v2.0/upload/photo";
        File file = new File("zalo_100m.jpeg");
        JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "POST", params, file);
        return excuteRequest;
    }

}

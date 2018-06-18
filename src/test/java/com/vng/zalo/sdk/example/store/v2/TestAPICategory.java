/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.example.store.v2;

import com.google.gson.JsonObject;
import com.vng.zalo.sdk.APIException;
import com.vng.zalo.sdk.oa.ZaloOaClient;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nguyenhc2
 */
public class TestAPICategory {

    static String accessToken = "jCQCJ4UfJN6nn8TDGQvDTxJ7Xav1j0G7xwI5FLdF567FeeyR8iax8vN_X48vy2CZd-ZfNpNKV7cRo-C03EvtQgVS_mKCxK96ZVk57GZpFN2ox8L22-S1BeVAbnKBs39PbBQQ6ZkxN72ft_euCDjESAFsYnShz1rQe-wPOax5KoV3w-fvNEDV5zBTmNLWzm4TcEUNRY_zF3AewlmAFeHhBBISsnP1-MLExl7uAHlpEasgdgOL0PaBV8sfi4K2Xn8bj9Ic6oMB1I30NV8BHxLCSm";

    static ZaloOaClient oaClient = new ZaloOaClient();
    static String API_DOMAIN = "https://openapi.zaloapp.com";
//    static String API_DOMAIN = "http://10.30.22.68:8239";
//    static String API_DOMAIN = "http://sandbox.openapi.zaloapp.com";
//    static String API_DOMAIN = "http://localhost:8239";

    public static void main(String[] args) {
        try {
            oaClient.isDebug = true;
            System.out.println(getListCategory());
//            System.out.println(createCategory());
//            System.out.println(updateCategory());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.exit(0);
    }

    public static JsonObject getListCategory() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("access_token", accessToken);
        String endpoint = API_DOMAIN + "/store/v2.0/category/getcategoryofoa";
        params.put("offset", 0);
        params.put("limit", 10);
        JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "GET", params, null);
        return excuteRequest;
    }

    public static JsonObject createCategory() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("access_token", accessToken);
        String endpoint = API_DOMAIN + "/store/v2.0/category/create";
        String strData = "{\n"
                + "        \"name\": \"Ahihi\",\n"
                + "        \"photo\": \"9cafc928d96d3033697c\",\n"
                + "        \"description\": \"▽✓  ✔  ☑  ✅  ✕  ✖  ✗  ✘\",\n"
                + "        \"status\": \"show\"\n"
                + "      }";
        JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "POST", params, strData);
        return excuteRequest;
    }

    public static JsonObject updateCategory() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("access_token", accessToken);
        String endpoint = API_DOMAIN + "/store/v2.0/category/update";
        String strData = "{\n"
                + "        \"id\": \"384eb7a98aec63b23afd\",\n"
                + "        \"name\": \"Ahihi haha\",\n"
                + "        \"photo\": \"9cafc928d96d3033697c\",\n"
                + "        \"description\": \"▽✓  ✔  ☑  ✅  ✕  ✖  ✗  ✘\",\n"
                + "        \"status\": \"hide\"\n"
                + "      }";
        JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "POST", params, strData);
        return excuteRequest;
    }

}

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
public class TestAPIProduct {

    static String accessToken = "jCQCJ4UfJN6nn8TDGQvDTxJ7Xav1j0G7xwI5FLdF567FeeyR8iax8vN_X48vy2CZd-ZfNpNKV7cRo-C03EvtQgVS_mKCxK96ZVk57GZpFN2ox8L22-S1BeVAbnKBs39PbBQQ6ZkxN72ft_euCDjESAFsYnShz1rQe-wPOax5KoV3w-fvNEDV5zBTmNLWzm4TcEUNRY_zF3AewlmAFeHhBBISsnP1-MLExl7uAHlpEasgdgOL0PaBV8sfi4K2Xn8bj9Ic6oMB1I30NV8BHxLCSm";

    static ZaloOaClient oaClient = new ZaloOaClient();
//    static String API_DOMAIN = "https://openapi.zaloapp.com";
//    static String API_DOMAIN = "http://sandbox.openapi.zaloapp.com";
    static String API_DOMAIN = "http://localhost:8239";

    public static void main(String[] args) {
        try {
            oaClient.isDebug = true;
//            System.out.println(getListProduct());
            System.out.println(getProduct());
//            System.out.println(createProduct());
//            System.out.println(updateProduct());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.exit(0);
    }

    public static JsonObject getListProduct() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("access_token", accessToken);
        String endpoint = API_DOMAIN + "/store/v2.0/product/getproductofoa";
        JsonObject data = new JsonObject();
        data.addProperty("offset", 0);
        data.addProperty("limit", 10);
        params.put("data", data.toString());
        JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "GET", params, null);
        return excuteRequest;
    }

    public static JsonObject getProduct() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("access_token", accessToken);
        String endpoint = API_DOMAIN + "/store/v2.0/product/getproduct";
        params.put("id", "c897bb69a32c4a72133d");
        JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "GET", params, null);
        return excuteRequest;
    }

    public static JsonObject createProduct() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("access_token", accessToken);
        String endpoint = API_DOMAIN + "/store/v2.0/product/create";
        String strData = "{\n"
                + "  \"categories\": [\n"
                + "    \"0f5f54ae6aeb83b5dafa\"\n"
                + "  ],\n"
                + "  \"code\": \"DC1540\",\n"
                + "  \"name\": \"Vườn Thú Châu Phi\",\n"
                + "  \"price\": 101234000,\n"
                + "  \"description\": \"DECAL DÁN TƯỜNG xuất khẩu , in bằng công nghệ cao, không viền trắng không bay màu theo \",\n"
                + "  \"photos\": [\n"
                + "    \"d2573d3086766f283667\",\n"
                + "    \"56e76cedd7ab3ef567ba\"\n"
                + "  ],\n"
                + "  \"status\": \"show\",\n"
                + "  \"packageSize\": {\n"
                + "    \"weight\": 0.1,\n"
                + "    \"length\": 1,\n"
                + "    \"width\": 1,\n"
                + "    \"height\": 1\n"
                + "  }\n"
                + "}";
        JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "POST", params, strData);
        return excuteRequest;
    }

    public static JsonObject updateProduct() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("access_token", accessToken);
        String endpoint = API_DOMAIN + "/store/v2.0/product/update";
        String strData = "{\n"
                + "  \"id\": \"817d98068143681d3152\",\n"
                + "  \"categories\": [\n"
                + "    \"0f5f54ae6aeb83b5dafa\"\n"
                + "  ],\n"
                + "  \"code\": \"DC1540\",\n"
                + "  \"name\": \"Phi DC1540\",\n"
                + "  \"price\": 101234000,\n"
                + "  \"description\": \"DECAL DÁN TƯỜNG xuất khẩu , in bằng công nghệ cao, không viền trắng không bay màu theo \",\n"
                + "  \"photos\": [\n"
                + "    \"d2573d3086766f283667\",\n"
                + "    \"56e76cedd7ab3ef567ba\"\n"
                + "  ],\n"
                + "  \"status\": \"show\",\n"
                + "  \"packageSize\": {\n"
                + "    \"weight\": 0.1,\n"
                + "    \"length\": 1,\n"
                + "    \"width\": 1,\n"
                + "    \"height\": 1\n"
                + "  }\n"
                + "}";
        JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "POST", params, strData);
        return excuteRequest;
    }

}

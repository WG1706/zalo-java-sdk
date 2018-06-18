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
public class TestAPIOrder {

    static String accessToken = "jCQCJ4UfJN6nn8TDGQvDTxJ7Xav1j0G7xwI5FLdF567FeeyR8iax8vN_X48vy2CZd-ZfNpNKV7cRo-C03EvtQgVS_mKCxK96ZVk57GZpFN2ox8L22-S1BeVAbnKBs39PbBQQ6ZkxN72ft_euCDjESAFsYnShz1rQe-wPOax5KoV3w-fvNEDV5zBTmNLWzm4TcEUNRY_zF3AewlmAFeHhBBISsnP1-MLExl7uAHlpEasgdgOL0PaBV8sfi4K2Xn8bj9Ic6oMB1I30NV8BHxLCSm";

    static ZaloOaClient oaClient = new ZaloOaClient();
//    static String API_DOMAIN = "https://openapi.zaloapp.com";
//    static String API_DOMAIN = "http://sandbox.openapi.zaloapp.com";
    static String API_DOMAIN = "http://localhost:8239";

    public static void main(String[] args) {
        try {
            oaClient.isDebug = true;
//            System.out.println(getOrder());
//            System.out.println(getListOrder());
//            System.out.println(updateOrder());
            System.out.println(createOrder());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.exit(0);
    }

    public static JsonObject getListOrder() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("access_token", accessToken);
        String endpoint = API_DOMAIN + "/store/v2.0/order/getorderofoa";
        params.put("status", 0);
        params.put("offset", 0);
        params.put("limit", 10);
        JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "GET", params, null);
        return excuteRequest;
    }

    public static JsonObject getOrder() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("access_token", accessToken);
        String endpoint = API_DOMAIN + "/store/v2.0/order/getorder";
        params.put("id", "e2daf51a525fbb01e24e");
        JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "GET", params, null);
        return excuteRequest;
    }

    public static JsonObject updateOrder() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("access_token", accessToken);
        String endpoint = API_DOMAIN + "/store/v2.0/order/update";
        JsonObject data = new JsonObject();
        data.addProperty("id", "e2daf51a525fbb01e24e");
        data.addProperty("status", "3");
        data.addProperty("editReason", "Thích thì edit thôi");
        JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "POST", params, data.toString());
        return excuteRequest;
    }

    public static JsonObject createOrder() throws APIException {
        Map<String, Object> params = new HashMap<>();
        params.put("access_token", accessToken);
        String endpoint = API_DOMAIN + "/store/v2.0/order/create";
        String strData = "{\n"
                + "  \"id\": \"c46e3c12985771092846\",\n"
                + "  \"code\": \"#9896ec\",\n"
                + "  \"status\": 4,\n"
                + "  \"totalAmount\": 57000,\n"
                + "  \"shipping\": {\n"
                + "          \"receiver_name\": \"Hồ Cao Nguyên\",\n"
                + "          \"receiver_phone\": \"841693922049\",\n"
                + "          \"shipping_fee\": \"25000.0\",\n"
                + "          \"expectedDeliveryTime\": \"24 Giờ\",\n"
                + "          \"deliverAddress\": \"180 Lê Đại Hành\",\n"
                + "          \"deliverDistrictId\": 1,\n"
                + "          \"deliverCityId\": 1,\n"
                + "          \"packageSize\": {\n"
                + "            \"totalWeight\": 0.35,\n"
                + "            \"length\": 0,\n"
                + "            \"width\": 0,\n"
                + "            \"height\": 0\n"
                + "          }\n"
                + "        },\n"
                + "  \"customer\": {\n"
                + "    \"name\": \"Hồ Cao Nguyên\",\n"
                + "    \"phone\": 841693922049,\n"
                + "    \"userId\": \"4606118662026516190\",\n"
                + "    \"address\": \"182 Lê Đại Hành\",\n"
                + "    \"districtName\": \"Quận 11\",\n"
                + "    \"cityName\": \"Hồ Chí Minh\"\n"
                + "  },\n"
                + "  \"payment\": {\n"
                + "    \"status\": 2,\n"
                + "    \"method\": 4\n"
                + "  },\n"
                + "  \"orderItems\": [\n"
                + "    {\n"
                + "      \"productId\": \"0419c791e0d4098a50c5\",\n"
                + "      \"quantity\": 2\n"
                + "    }\n"
                + "  ],\n"
                + "  \"cancelReason\": \"\",\n"
                + "  \"extraNote\": \"Cái này Nguyên tạo\",\n"
                + "  \"createdTime\": 1523858014196,\n"
                + "  \"updatedTime\": 1523880160629\n"
                + "}";
        JsonObject excuteRequest = oaClient.excuteRequest(endpoint, "POST", params, strData);
        return excuteRequest;
    }
}

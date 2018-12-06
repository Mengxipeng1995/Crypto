package com.mxp.controller;

import com.mxp.until.CryptoUntil;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CryptoController {

    @RequestMapping("/toDes")
    public String toDes(){
        return "desCrypto";
    }

    @ResponseBody
    @PostMapping("/getDesByEn")
    public Map getDesByEn(@RequestBody Map<String,String> map,HttpServletRequest request){
        String type = map.get("type");
        String key = map.get("key");
        String text = map.get("text");
        Map<String,String> result = new HashMap<>();
        String value = "";
        switch (type){
            case "3DES":
                value = CryptoUntil.encryptMode(key,text);
                break;
            case "Base64":
                value = new String(Base64Utils.encode(text.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
                break;
            case "MD5":
                break;
            default:
                System.out.println("无");
        }
        result.put("value",value);
        return result;
    }

    @ResponseBody
    @PostMapping("/getDesByDes")
    public Map getDesByDes(@RequestBody Map<String,String> map){
        Map<String,String> result = new HashMap();
        String key = map.get("key");
        String text = map.get("text");
        String value = CryptoUntil.decryptMode(key,text);
        result.put("value",value);
        return result;
    }


}

package com.mxp.controller;

import com.mxp.until.CryptoUntil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public Map getDesByEn(@RequestBody Map<String,String> map, HttpServletRequest request, HttpServletResponse response){
        Map<String,String> result = new HashMap();
        String key = map.get("key");
        String text = map.get("text");
        String value = CryptoUntil.encryptMode(key,text);
        result.put("value",value);
        return result;
    }

}

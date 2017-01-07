package com.cheney.gencode.gen.java.module;

import java.util.ArrayList;
import java.util.List;

import com.cheney.gencode.module.Method;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Moudle: GenMethod
 * @version:v1.0
 * @Description: 生成方法代码
 * @author: xuyushuai
 * @date: 2014年10月27日 下午3:16:47
 *
 */
public class GenMethod {
    /**
     *
     * <p>Title: getMethods</p>
     * <p>author : xuyushuai</p>
     * <p>date : 2014年10月27日 下午3:18:14</p>
     * @param methodList 
     * 
     * @return List<Method>
     */
    public static List<Method> getMethods(String json) {        
        List<Method> methodList = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			methodList = objectMapper.readValue(json,new TypeReference<ArrayList<Method>>(){});
		}catch (Exception e) {
			e.printStackTrace();
		}
		return methodList;
    }
}

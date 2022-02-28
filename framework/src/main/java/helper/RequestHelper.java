package helper;

import bean.Param;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 996Worker
 * @description 前端控制器接收到HTTP请求后, 从HTTP中获取请求参数, 然后封装到Param对象中.
 * @create 2022-02-28 15:14
 */
public class RequestHelper {

    /**
     * 获取请求参数
     */
    public static Param createParam(HttpServletRequest request) throws IOException {
        Map<String, Object> paramMap = new HashMap<>();
        Enumeration<String> paramNames = request.getParameterNames();

        // 无传入参数
        if (!paramNames.hasMoreElements()) {
            return null;
        }

        // 获取所有请求参数
        while (paramNames.hasMoreElements()) {
            String fieldName = paramNames.nextElement();
            String fieldValue = request.getParameter(fieldName);
            paramMap.put(fieldName, fieldValue);
        }

        return new Param(paramMap);
    }

}
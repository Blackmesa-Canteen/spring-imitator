package helper;

import annotation.RequestMapping;
import bean.Handler;
import bean.Request;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 996Worker
 * @description 助手类定义了一个"请求-处理器" 的映射 REQUEST_MAP, REQUEST_MAP 就相当于Spring MVC里的映射处理器, 接收到请求后返回对应的处理器.
 * @create 2022-02-28 14:52
 */
public class ControllerHelper {

    private static final Map<Request, Handler> REQUEST_MAP = new HashMap<>();

    static {
        // 遍历所有controller (通过扫包, 判断class文件是否带有@Controller注解得到)
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtils.isNotEmpty(controllerClassSet)) {
            for (Class<?> controllerClass : controllerClassSet) {
                Method[] methods = controllerClass.getDeclaredMethods();
                // 遍历当前controller里的所有方法
                if (ArrayUtils.isNotEmpty(methods)) {
                    for (Method method : methods) {
                        // 判断当前方法是否带有RequestMapping注解
                        if (method.isAnnotationPresent(RequestMapping.class)) {
                            RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                            // 请求路径取出
                            String requestPath = requestMapping.value();
                            // 请求的类型
                            String requestMethod = requestMapping.method().name();

                            // 封装请求+handler到映射
                            Request request = new Request(requestMethod, requestPath);
                            Handler handler = new Handler(controllerClass, method);
                            REQUEST_MAP.put(request, handler);
                        }
                    }
                }
            }
        }
    }

    /**
     * 根据请求类别和请求路径从映射中获得handler
     */
    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return REQUEST_MAP.get(request);
    }
}
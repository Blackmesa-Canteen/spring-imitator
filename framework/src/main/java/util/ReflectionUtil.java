package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 996Worker
 * @description
 * @create 2022-02-28 10:24
 */
public final class ReflectionUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * 基于之前通过包名等获得的Class对象, 实例化对应的对象
     * @param cls
     * @return
     */
    public static Object newInstance(Class<?> cls) {
        Object instance;

        try {
            instance = cls.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            LOGGER.error("new instance failure: ", e);
            throw new RuntimeException(e);
        }

        return instance;
    }

    /**
     * 基于类名创建实例
     * @param className
     * @return
     */
    public static Object newInstance(String className) {
        Class<?> cls = ClassUtil.loadClass(className);
        return newInstance(cls);
    }

    /**
     * 调用对象里头的方法
     */
    public static Object invokeMethod(Object obj, Method method, Object... args) {
        Object result;
        try {
            // 设置私有方法为可访问
            method.setAccessible(true);
            result = method.invoke(obj, args);
        } catch (Exception e) {
            LOGGER.error("invoke method failure", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 设置成员变量的值
     */
    public static void setField(Object obj, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(obj, value);

        } catch (Exception e) {
            LOGGER.error("set field failure", e);
            throw new RuntimeException(e);
        }
    }
}
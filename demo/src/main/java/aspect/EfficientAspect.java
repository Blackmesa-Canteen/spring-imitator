package aspect;

import annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proxy.AspectProxy;

import java.lang.reflect.Method;

/**
 * @author 996Worker
 * @description 性能切面, 获取接口执行时间
 * @create 2022-03-02 23:35
 */

@Aspect(pkg = "com.tyshawn.controller", cls = "UserController")
public class EfficientAspect extends AspectProxy {
    private static final Logger LOGGER = LoggerFactory.getLogger(EfficientAspect.class);

    private long begin;

    /**
     * 切入点判断
     */
    @Override
    public boolean intercept(Method method, Object[] params) throws Throwable {
        return method.getName().equals("getUserList");
    }

    @Override
    public void before(Method method, Object[] params) throws Throwable {
        LOGGER.debug("---------- begin ----------");
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Method method, Object[] params) throws Throwable {
        LOGGER.debug(String.format("time: %dms", System.currentTimeMillis() - begin));
        LOGGER.debug("----------- end -----------");
    }
}
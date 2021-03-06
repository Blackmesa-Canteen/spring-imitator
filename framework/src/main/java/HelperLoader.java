import helper.*;
import util.ClassUtil;

/**
 * @author 996Worker
 * @description used to Load all helper classes. Used by Servlet
 * @create 2022-02-28 15:28
 */
public class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class,
                AopHelper.class
        };

        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
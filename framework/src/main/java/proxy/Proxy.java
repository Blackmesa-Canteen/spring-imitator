package proxy;

public interface Proxy {

    /*
     * 链式代理: 多个代理通过一条链子能够一个一个去执行
     */
    Object doProxy (ProxyChain proxyChain) throws Throwable;
}

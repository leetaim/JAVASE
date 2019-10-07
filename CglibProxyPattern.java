package proxypattern;


import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib动态代理:
 * @author lee
 */
class HelloService {
	public HelloService() {
		System.out.println("HelloService()");
	}
	public void doSayHello(String name) {
		System.out.println("Hello ! "+name);
	}
}

class MyMethodInterceptor implements MethodInterceptor {
	Object target;
	public Object getInstance(Object object) {
		this.target = object;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}
	/**
	 * obj:cglib生成的代理对象
	 * method:被代理对象方法
	 * arg:方法参数
	 * methodProxy:代理方法
	 */
	public Object intercept(Object obj, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
		System.out.println("--织入前置通知--");
		Object result = methodProxy.invokeSuper(obj, arg);
		System.out.println("--织入后置通知--");
		return result;
	}
}

public class CglibProxyPattern {
	//测试cglib动态代理
	public static void main(String[] args) {
		MyMethodInterceptor myMethodInterceptor = new MyMethodInterceptor();
		HelloService helloServiceProxy = (HelloService)myMethodInterceptor.getInstance(new HelloService());
		helloServiceProxy.doSayHello("leetaim");
	}
}

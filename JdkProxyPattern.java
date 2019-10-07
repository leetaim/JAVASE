package proxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理:基于拦截器和反射
 *  实现HandlerInterceptor接口
 *  利用Proxy.newProxyInstance()产生代理对象
 *  目标对象要实现接口
 */
interface UserManager {
	void doRegist(String name,String password);
}
class UserManagerImpl implements UserManager {
	public void doRegist(String name, String password) {
		System.out.println("UserManagerImpl.doRegist()");
	}
}

/**
 * 动态代理:运行时通过反射机制来创建代理对象,分为jdk动态代理和cglib动态代理
 * jdk动态代理:目标对象实现接口
 * cglib动态代理:目标对象未实现接口
 * @author leetaim
 */
public class JdkProxyPattern {
	//测试jdk动态代理
	public static void main(String[] args) {
		UserManager proxy = (UserManager)getProxyObject(new UserManagerImpl());
		proxy.doRegist("leetaim", "123456");
	}
	
	static class MyInvocationHandler implements InvocationHandler {
		Object object;
		public MyInvocationHandler(Object object) {
			this.object = object;
		}
		public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
			doCheck();
			method.invoke(object, args);
			System.out.println("--注册成功!--");
			return null;
		}
		private boolean doCheck() {
			System.out.println("--校验成功!--");
			return true;
		}
	}
	
	private static Object getProxyObject(Object object) {
		ClassLoader classLoader = object.getClass().getClassLoader();
		Class<?>[] interfaces = object.getClass().getInterfaces();
		MyInvocationHandler handler = new MyInvocationHandler(object);
		return Proxy.newProxyInstance(classLoader, interfaces, handler);
	}
}

package proxypattern;

import java.util.Date;

/**
 * 静态代理:代理类实现业务接口,并持有实现类实例
 * @author leetaim
 */
//业务接口
interface SayService {
	void doSay();
}
//实现类
class SayServiceImpl implements SayService {
	public void doSay() {
		System.out.println("hello world");
	}
}
//代理类
class SayServiceProxy implements SayService {
	@SuppressWarnings("unused")
	private SayServiceImpl sayServiceImpl = new SayServiceImpl();
	public void doSay() {
		System.out.println("--开始--");
		long startTime = new Date().getTime();
		sayServiceImpl.doSay();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("--结束--");
		long endTime = new Date().getTime();
		System.out.println("--操作用时"+(endTime-startTime)+"毫秒--");
	}
}
/**
 * 代理模式:通过代理模式给目标对象提供一个代理对象,并由代理对象控制目标对象的引用.
 * 作用:不违背开闭原则的情况下,增加功能
 * 几种模式:静态代理和动态代理
 * 静态代理:人为创建或特定工具生成源码,再对其进行编译
 * 动态代理:运行时通过反射机制来动态创建 
 * @author leetaim
 */
public class StaticProxyPattern {
	//测试静态代理
	public static void main(String[] args) {
		SayServiceProxy obj = new SayServiceProxy();
		obj.doSay();
	}
}

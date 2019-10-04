package singleton;

class Singleton1 {
	//饿汉式
	//构造函数私有化,不允许直接构建对象
	private Singleton1() {}
	
	private static Singleton1 instance = new Singleton1();
	public static Singleton1 getInstance() {
		return instance;
	}
}

class Singleton2 {
	//懒汉式
	private Singleton2() {}
	private static Singleton2 instance = null;
	public static Singleton2 getInstance() {
		if(instance == null) {
			instance = new Singleton2();
		}
		return instance;
	}
}

class Singleton3 {
	private Singleton3() {}
	private static Singleton3 instance = null;
	public static synchronized Singleton3 getInstance() {
		if(instance == null) {
			instance = new Singleton3();
		}
		return instance;
	}
}

class Singleton4 {
	private Singleton4() {}
	private static volatile Singleton4 instance = null;
	public static Singleton4 getInstance() {
		if(instance == null) {
			synchronized(Singleton4.instance) {
				if(instance == null) {
					instance = new Singleton4();
				}
			}
		}
		return instance;
	}
}

class Singleton5 {
	//静态内部类
	private Singleton5() {}
	static class InnerClass {
		private static Singleton5 instance = new Singleton5();
	}
	public static Singleton5 getInstance() {
		return InnerClass.instance;
	}
}

/**
 * 单例设计模式,该对象实例在内存中只有一份
 * @author leetaim
 *
 */
public class SingletonPattern {
	public static void main(String[] args) {
		
		Singleton5 instance1 = Singleton5.getInstance();
		Singleton5 instance2 = Singleton5.getInstance();
		System.out.println(instance1 == instance2);
	}
}

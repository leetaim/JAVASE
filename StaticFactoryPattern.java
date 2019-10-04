package designpattern;

import java.util.Scanner;

/**
 * 简单工厂(静态工厂,不属于23种设计模式)
 * 角色:工厂角色,抽象产品角色,具体产品角色
 * 总结:工厂类中包含了必要的逻辑判断(if/else或是switch-case),根据客户端的输入条件动态实例化产品类.
 *  缺点:当需要扩展产品时,需要修改工厂类,违背开闭原则
 * @author leetaim
 *
 */
//工厂角色:简单工厂模式的核心,负责实现创建所有实例的内部逻辑
class ProductFactory {
	private ProductFactory() {}
	public static Product getProduct(String desc) {
		if("产品A".equals(desc)) {
			return new ProductA();
		}else if("产品B".equals(desc)) {
			return new ProductB();
		}else if("产品C".equals(desc)) {
			return new ProductC();
		}
		return null;
	}
}
//抽象产品角色
interface Product {
	void doDesc();
}
//具体产品
class ProductA implements Product {
	public void doDesc() {
		System.out.println("我是产品A");
	}
}
class ProductB implements Product {
	public void doDesc() {
		System.out.println("我是产品B");
	}
}
class ProductC implements Product {
	public void doDesc() {
		System.out.println("我是产品C");
	}
}

public class StaticFactoryPattern {
	public static void main(String[] args) {
		//测试静态工厂
		System.out.println("--请输入产品名称--");
		@SuppressWarnings("resource")
		String name = new Scanner(System.in).next();
		Product product = ProductFactory.getProduct(name);
		product.doDesc();
	}
}

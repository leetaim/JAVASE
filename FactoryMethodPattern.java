package factorymethod;

/**
 * 工厂方法(解决了简单工厂的缺点,把具体产品的创建从工厂类延迟到具体子类中.此时工厂类不再负责所有产品的创建)
 * 角色:抽象工厂类,具体工厂,抽象产品,具体产品
 * 总结:工厂方法弥补了简单工厂违背开闭原则的缺点.但是增加产品时,都需要增加产品工厂类,需要额外工作量
 * FactoryBean是工厂模式的实现
 * @author leetaim
 *
 */
//抽象工厂
interface ProductFactory {
	Product getProduct();
}
//具体工厂
class ProductAFactory implements ProductFactory {
	public Product getProduct() {
		return new ProductA();
	}
}
class ProductBFactory implements ProductFactory {
	public Product getProduct() {
		return new ProductB();
	}
}
class ProductCFactory implements ProductFactory {
	public Product getProduct() {
		return new ProductC();
	}
}
//抽象产品
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

public class FactoryMethodPattern {
	//测试工厂方法
	public static void main(String[] args) {
		ProductFactory fac1 = new ProductAFactory();
		Product pro1 = fac1.getProduct();
		pro1.doDesc();
		ProductFactory fac2 = new ProductBFactory();
		Product pro2 = fac2.getProduct();
		pro2.doDesc();
	}
	
}

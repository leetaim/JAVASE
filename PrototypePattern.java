package designpattern;

/**
 * 原型模式,通过给出一个原型对象来知名所创建的对象的类型,然后用复制的方法
 * 创建出更多同类型的对象
 * @author leetaim
 */
class Prototype implements Cloneable {
	public Prototype() {
		System.out.println("constructor");
	}
	
	public String name = "leetaim";
	public String gender = "male";
	
	public void doSay() {
		System.out.println("hello world");
	}
	
	@Override
	protected Object clone() {
		try {
			return super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

public class PrototypePattern {
	public static void main(String[] args) {
		
		//clone不执行构造方法
		Prototype p1 = new Prototype();
		Object o1 = p1.clone();
		Prototype p2 = null;
		
		if(o1 instanceof Prototype) {
			p2 = (Prototype)o1;
		}else return;
		
		p1.doSay();
		p2.doSay();
		System.out.println(p1 == p2);	//false
		System.out.println(p1.getClass() == p2.getClass());	//true
		
	}
}

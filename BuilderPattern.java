package designpattern;

/**
 * 创建者模式:将一个复杂对象的创建与它的表示分离,使得同样的构建过程可以创建不同的表示
 * 角色:Builder,ConcreteBuilder,Director,Product
 * Builder:为创建一个产品对象的各个部件指定抽象接口
 * ConcreteBuilder:实现Builder的接口以构造和装配该产品的各个部件,定义并明确它所创建的表示,并提供一个
 *                 检索产品的接口
 * Director:构造一个使用Builder接口的对象
 * Product:被构造的对象
 * @author leetaim
 */

//Builder
interface PersonBuilder {
	void buildHead();
	void buildBody();
	void buildFoot();
	Person buildPerson();
}
//ConcreteBuilder
class ManBuilder implements PersonBuilder {
	Person person;
	public ManBuilder() {
		person = new Man();
	}
	public void buildHead() {
		person.setHead("钛合金头");
	}
	public void buildBody() {
		person.setBody("金钢不败之躯");
	}
	public void buildFoot() {
		person.setFoot("忍者之足");
	}
	public Person buildPerson() {
		return person;
	}
}
//Director
class PersonDirector {
	public Person constructPerson(PersonBuilder pb) {
		pb.buildHead();
		pb.buildBody();
		pb.buildFoot();
		return pb.buildPerson();
	}
}
//Product
class Person {
	private String head;
	private String body;
	private String foot;
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getFoot() {
		return foot;
	}
	public void setFoot(String foot) {
		this.foot = foot;
	}
}
class Man extends Person{}

public class BuilderPattern {
	//测试建造者模式
	public static void main(String[] args) {
		PersonDirector pd = new PersonDirector();
		Person person = pd.constructPerson(new ManBuilder());
		System.out.println(person.getHead());
		System.out.println(person.getBody());
		System.out.println(person.getFoot());
		System.out.println(person.getClass());
	}
}

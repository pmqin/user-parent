package pmqin.com.desiger;

import pmqin.com.test.AbstractClassImp;
import pmqin.com.test.abstractClass;

public class ConcreteDecoratorB extends Decorator {

	public ConcreteDecoratorB(pmqin.com.test.abstractClass _abstractClass) {
		super(_abstractClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String AdressName() {
		addedBehavior();
		// 运行了原组件的方法，再执行本类的功能，相当于对原组件进行了装饰
		return super.AdressName() + "----ConcreteDecoratorB实现的AdressName";
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		addedBehavior();
		return super.getAge();
	}

	private void addedBehavior() {
		// 独有的方法 区别其他的具体装饰类
		System.out.println("ConcreteDecoratorB的addedBehavior");
	}

	public static void main(String[] args) {
		// 原始的实现
		abstractClass abstractClass = new AbstractClassImp();

		// 装饰者A实现
		abstractClass decoratorA = new ConcreteDecoratorA(abstractClass);
		System.out.println(decoratorA.AdressName());

		// 再装饰者B实现
		System.out.println("再装饰者B实现");
		 abstractClass decoratorB = new ConcreteDecoratorB(decoratorA);
		 System.out.println(decoratorB.AdressName());

	}

}

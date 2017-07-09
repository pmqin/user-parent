package pmqin.com.desiger;


public class ConcreteDecoratorA extends Decorator {

	public ConcreteDecoratorA(pmqin.com.test.abstractClass _abstractClass) {
		super(_abstractClass);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String AdressName() {
		
		//运行了原组件的方法，再执行本类的功能，相当于对原组件进行了装饰
		System.out.println(super.AdressName());
		
		addedBehavior();
		return "ConcreteDecoratorA实现AdressName方法";
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		addedBehavior();
		return super.getAge();
	}
	
	private void addedBehavior() {
		//独有的方法 区别其他的具体装饰类
		System.out.println("ConcreteDecoratorA的addedBehavior");
	}

	

}

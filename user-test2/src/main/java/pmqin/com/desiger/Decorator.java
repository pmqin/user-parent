package pmqin.com.desiger;

import pmqin.com.test.abstractClass;

public class Decorator extends abstractClass {
  
	private abstractClass abstractClass;
	//通过构造函数传递被修饰者
	public  Decorator(abstractClass _abstractClass) {
		this.abstractClass=_abstractClass;
	}
	
	//委托给被修饰者执行
	@Override
	public String AdressName() {
		//System.out.println("基类AdressName方法自己默认实现开始");
		return this.abstractClass.AdressName();
	}

	@Override
	public int getAge() {
		return this.abstractClass.getAge();
	}

}

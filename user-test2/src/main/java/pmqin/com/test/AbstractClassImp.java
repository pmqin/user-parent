/**
 * 
 */
package pmqin.com.test;

/** 
* @author : pmqin
* @date   : 2016年3月27日 下午3:43:52 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
// 子类的方法必须覆盖父类的抽象方法。方法才能够起作用
// Abstract和static不能放在一起，否则便会出现错误。（这是因为static不可被覆盖，而abstract为了生效必须被覆盖。）
public class AbstractClassImp extends abstractClass {

	@Override
	public String AdressName() {
		return "AbstractClassImp已经实现Itest的AdressName";

	}

	public AbstractClassImp() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pmqin.com.test.abstractClass#getAge()
	 */
	@Override
	public int getAge() {
		
		return 10;
	}

	// @Override
	// public void GetName()
	// {
	// System.out.println("AbstractClassImp了abstractClass");
	// }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractClassImp item = new AbstractClassImp();
		System.out.println(item.getAge());

		// 基类指向派生类的引用 ，即使子类没有abstract 子类也可以重载，但是有abstract的一定要实现
		abstractClass test111 = new AbstractClassImp();
		test111.GetName();
	}

}

/**
 * 
 */
package pmqin.com.test;

/** 
* @author : pmqin
* @date   : 2016年4月10日 上午11:51:28 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 * http://blog.csdn.net/yechaodechuntian/article/details/23561935
 */
public class EnumTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(FruitEnum.APPLE.value()); // 1
		System.out.println(FruitEnum.ORANGE.value()); // 2
		System.out.println(FruitEnum.valueOf(1)); // FruitEnum.APPLE
		System.out.println(FruitEnum.valueOf(2)); // FruitEnum.ORANGE
		// ordinal()//返回枚举常量在枚举类型中的位置，第一个枚举值序号为0，依次类推；
		// 0、enum枚举类型是一个不可以被继承的final类
		// 1、values()方法可用来返回接口中的一个数组，即该枚举中定义的常量枚举；
		// 2、name()方法会返回当前枚举值的名字。
		//实际上 enum 就是一个 class，enum 不能使用 extends 关键字继承其他类，因为 enum 已经继承了 java.lang.Enum（java是单一继承）。 
		//只不过 java 编译器帮我们做了语法的解析和编译而已。
		System.out.println(MyEnum.FIRST_ELEMENT.ordinal()); // 0
		System.out.println(MyEnum.SECOND_ELEMENT.name()); // SECOND_ELEMENT
		System.out.println(MyEnum.values()[0]); // MyEnum.FIRST_ELEMENT
		System.out.println(MyEnum.values()[1]); // MyEnum.SECOND_ELEMENT
		System.out.println(MyEnum.values()[2]); // MyEnum.SECOND_ELEMENT
		System.out.println(MyEnum.valueOf("FIRST_ELEMENT")); //根据枚举字符串获取枚举类型
	
	}

	enum MyEnum {
		FIRST_ELEMENT, SECOND_ELEMENT,KJKLJ_HKJKJ,
	}

	enum FruitEnum {
		APPLE(1), ORANGE(2); // 调用构造函数来构造枚举项

		private int value = 0;

		private FruitEnum(int value) { // 必须是private的，否则编译错误, 其实也可以去掉, 为什么是私有的,保证不被初始化,不可改变的
			this.value = value;
		}

		// 这个是枚举的值 外面会获取
		public int value() {
			return this.value;
		}

		public static FruitEnum valueOf(int value) { // 手写的从int到enum的转换函数
			switch (value) {
			case 1:
				return APPLE;
			case 2:
				return ORANGE;
			default:
				return null;
			}
		}

	}

	// WeekDay经过反编译(javap WeekDay命令)之后得到的内容如下(去掉了汇编代码)：
	// public final class WeekDay extends java.lang.Enum{
	// public static final WeekDay Mon;
	// public static final WeekDay Tue;
	// public static final WeekDay Wed;
	// public static final WeekDay Thu;
	// public static final WeekDay Fri;
	// public static final WeekDay Sat;
	// public static final WeekDay Sun;
	// static {};
	// public static void printDay(int);
	// public java.lang.String getDay();
	// public static WeekDay[] values();
	// public static WeekDay valueOf(java.lang.String);
	// }
	//向枚举中添加新方法 如果打算自定义自己的方法，那么必须在enum实例序列的最后添加一个分号。而且 Java 要求必须先定义 enum 实例。
	public enum WeekDay {
		Mon("Monday"), Tue("Tuesday"), Wed("Wednesday"), Thu("Thursday"), Fri("Friday"), Sat("Saturday"), Sun("Sunday");
		private final String day;

		private WeekDay(String day) {
			this.day = day;
		}

		public static void printDay(int i) {
			switch (i) {
			case 1:
				System.out.println(WeekDay.Mon);
				break;
			case 2:
				System.out.println(WeekDay.Tue);
				break;
			case 3:
				System.out.println(WeekDay.Wed);
				break;
			case 4:
				System.out.println(WeekDay.Thu);
				break;
			case 5:
				System.out.println(WeekDay.Fri);
				break;
			case 6:
				System.out.println(WeekDay.Sat);
				break;
			case 7:
				System.out.println(WeekDay.Sun);
				break;
			default:
				System.out.println("wrong number!");
			}
		}

		public String getDay() {
			return day;
		}
	}

	public class TrafficLight {
		TrafficLamp color = TrafficLamp.RED;

		public void change() {
			switch (color) {
			case RED:
				color = TrafficLamp.GREEN;
				break;
			case YELLOW:
				color = TrafficLamp.RED;
				break;
			case GREEN:
				color = TrafficLamp.YELLOW;
				break;
			}
		}
	}

	public enum TrafficLamp {
		RED(30) {
			@Override
			public TrafficLamp nextLamp() {

				return GREEN;
			}
		},
		GREEN(45) {
			@Override
			public TrafficLamp nextLamp() {

				return YELLOW;
			}
		},
		YELLOW(5) {
			@Override
			public TrafficLamp nextLamp() {

				return RED;
			}
		};
		public abstract TrafficLamp nextLamp();

		private int time;

		// 为了防止被实例
		private TrafficLamp() {
		}

		private TrafficLamp(int time) {
			this.time = time;
		}

	}

}

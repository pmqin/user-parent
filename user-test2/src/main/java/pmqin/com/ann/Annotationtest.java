package pmqin.com.ann;

@HelloAnnotation(color = "红色", value = "如果只有value属性！可以不写属性名和等于号，直接写值即可！", arrayAttr = { 1, 2, 3 })
public class Annotationtest {

	@HelloAnnotation("当为value属性时，可以省掉属性名和等于号。")
	public static void main(String[] args) {

		if (Annotationtest.class.isAnnotationPresent(HelloAnnotation.class)) {
			HelloAnnotation helloAnnotation = (HelloAnnotation) Annotationtest.class
					.getAnnotation(HelloAnnotation.class);
			System.out.println("color(): " + helloAnnotation.color());
			System.out.println("value(): " + helloAnnotation.value());
			System.out.println("author(): " + helloAnnotation.author());
			System.out.println("arrayAttr(): " + helloAnnotation.arrayAttr().length);

		}

	}

}

package springcloudtollintake;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@ComponentScan
public class CircularDIRun {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();// AppConfig.class);
		ac.register(ClassA.class, ClassB.class);
//		ac.scan("springcloudtollintake");

		ac.refresh();
		ClassA a = ac.getBean(ClassA.class);
		ClassB b = ac.getBean(ClassB.class);

		System.out.println(a);
		System.out.println(b);
//		
		System.out.println(a.getB());
		System.out.println(b.getA());
	}
}

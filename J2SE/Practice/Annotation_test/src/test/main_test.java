package test;

import java.lang.annotation.Annotation;

public class main_test {
	public static void main(String []args) throws Exception
	{
		Class<?> class1=Class.forName("test.Service");
		Annotation[] annotations=class1.getAnnotations();
		
		//≈–∂œ
		for (Annotation a:annotations) {
			System.out.println(a.annotationType());
		}
		
		//ªÒ»°
		if(class1.isAnnotationPresent(person.class))
		{
			person p=null;
			p=class1.getAnnotation(person.class);
			
			System.out.println("a:"+p.a()+"b:"+p.b()+"c:"+p.c());
		}
		
	}
}

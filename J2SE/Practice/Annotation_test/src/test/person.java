package test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})

public @interface person {
	public String a();
	public String []b ();
	public enum_t c() default enum_t.M;
	
}

											🔥🔥SpringBoot Annotations🔥🔥
											==============================

spring.main.log-startup-info to false in application.properties for not showing the logs info.
This will also turn off logging of the application’s active profiles.

Annotation Type Target @Target({ElementType.ANNOTATION_TYPE})
=============================================================
package java.lang.annotation;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE})
public @interface Target {
   ElementType[] value();
}	

Here ANNOTATION_TYPE comes from,
package java.lang.annotation;

public enum ElementType {
   TYPE,
   FIELD,
   METHOD,
   PARAMETER,
   CONSTRUCTOR,
   LOCAL_VARIABLE,
   ANNOTATION_TYPE,
   PACKAGE,
   TYPE_PARAMETER,
   TYPE_USE;
}


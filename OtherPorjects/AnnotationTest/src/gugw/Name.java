package gugw;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//ע�������@Target��@Description��Ĳ�ͬ,������ԱҲ��ͬ  
@Documented  
@Target(ElementType.METHOD)   
@Retention(RetentionPolicy.RUNTIME)   
public @interface Name {   
    String originate();   
    String community();   
} 
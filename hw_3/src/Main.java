import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
// Задание первое
        Class<Test> cls = Test.class;
        Object obj = cls.newInstance();
        Method method = cls.getMethod("test", int.class, int.class);
        Calc an = method.getAnnotation(Calc.class);
        int res = (int) method.invoke(obj,an.b(),an.a());
        System.out.println(res);
//Задание второе
        Class<TextContainer> tc = TextContainer.class;
        Field fld = tc.getDeclaredField("str");
        SaverSettings ann = fld.getAnnotation(SaverSettings.class);
        Class <Saver> sv = Saver.class;
        Method metod = sv.getMethod(ann.method(),String.class,String.class);
        metod.invoke(null, ann.fileName() ,fld.get("str"));
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Calc {
        int a();
        int b();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD})
    public  @interface  SaverSettings {
        String fileName() default "saver.txt";
        String method ();
    }
}

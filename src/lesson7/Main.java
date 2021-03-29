package lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Class c = MyTest.class;
        try {
            start(c);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
    public static void start(Class testClass) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Object cl = testClass.newInstance();
        Method[] methods = testClass.getDeclaredMethods();

        int countBefore = 0;
        int countAfter = 0;
        for (Method mt : methods) {
            if (mt.isAnnotationPresent(BeforeSuit.class)){
                countBefore ++;
            }
            if (mt.isAnnotationPresent(AfterSuit.class)) {
                countAfter ++;
            }
        }
        if (countBefore > 1){
            throw new RuntimeException("The number of BeforeSuit methods is more than one");
        }
        if (countAfter > 1){
            throw new RuntimeException("The number of AfterSuit methods is more than one");
        }
        List<Method> list = new ArrayList<>(Arrays.asList(methods));
        List<Method> subList = new ArrayList<>(Arrays.asList(methods));

        for (Method mt : list) {
            if (mt.isAnnotationPresent(BeforeSuit.class)) {
                System.out.println(mt.getAnnotation(BeforeSuit.class).description());
                mt.invoke(cl);
                subList.remove(mt);
            }
            if (mt.isAnnotationPresent(AfterSuit.class)) {
                subList.remove(mt);
            }
        }
        subList.sort((o1, o2) -> Integer.compare
                (o1.getAnnotation(Test.class).prioritet(), o2.getAnnotation(Test.class).prioritet()));
       // System.out.println(subList);
        for (Method mt: subList){
            if (mt.isAnnotationPresent(Test.class)){
                System.out.println(mt.getAnnotation(Test.class).description());
                mt.invoke(cl);
            }
        }
        for (Method mt : list) {
            if (mt.isAnnotationPresent(AfterSuit.class)){
                mt.invoke(cl);
            }
        }
    }
}

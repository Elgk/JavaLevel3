package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] arrStr = {"F","HJ","CC","UUU","A"};
        System.out.println("Initial array: "+ Arrays.toString(arrStr));
        changeArr(arrStr, 1,2);

        Integer[] arrInt = {11,3,67,88,3444,8,0};
        System.out.println("Initial array: "+ Arrays.toString(arrInt));
        changeArr(arrInt, 10,2);

        System.out.println("Преобразован в ArrayList");
        formToArrayList(arrInt);

    }
    public static void changeArr(Object[] arr, int i, int j){
        if (i >= arr.length || j >= arr.length){
            System.out.println( "Заданы некорректные аргументы");
        }else {
            Object element = arr[i];
            arr[i] = arr[j];
            arr[j] = element;
            System.out.println("New array: " + Arrays.toString(arr));
        }
    }
    public static <T> void formToArrayList(T[] arr){
        ArrayList<T> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println(list);
    }


}

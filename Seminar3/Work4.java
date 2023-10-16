/*
 * Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
 * если они одинаковые, и афдыу в противном случае. Массивы могут быть любого типа данных, но
 * должны иметь одинаковую длину и содержать элементы одного типа.
 */
package Seminar3;

public class Work4 {
    public static void main(String[] args) {
        String[] arr1 = {"a", "3", "h"};
        String[] arr2 = {"a", "3", "h"};
        System.out.println(compareArrays(arr1, arr2));

    }

    public static <T>boolean compareArrays(T[] array1, T[] array2) {
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }
        return true;
    }

}

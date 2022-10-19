/* Задача 1. Написать программу вычисления n-ого треугольного числа */

/* Задача 2. Реализовать алгоритм пирамидальной сортировки (HeapSort) */

import java.util.Scanner;

public class hw1 {
    public static void main(String[] args) {
        int[] my_array = {3, 8, 6, 5, 4, 9, 8, 5, 1, 0, 3, 4};
        int size = my_array.length - 1;
        HeapSort(my_array);
        Print_array(my_array);
        // Trian_Num();
    }

    public static void Trian_Num(){
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("n = ");
        int n = iScanner.nextInt();
        iScanner.close();
        double res = 0.5 * n * (n + 1);
        System.out.printf("Треугольное число от %d равно %.0f \n", n, res);
    }

    public static void Print_array(int array[]){
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }
    }

    /*public static void HeapSort(int array[]){
        void Change_el(int input_index, int size){
            int left_el_index = input_index * 2 + 1;
            int right_el_index = input_index * 2 + 2;
            int cur_index = input_index;

            if (left_el_index < size && array[cur_index] < array[left_el_index]){
                cur_index = left_el_index;
            }
            if ((right_el_index < size && array[cur_index] < array[right_el_index])){
                cur_index = right_el_index;
            }

            if (cur_index == input_index){
                return;
            }

            Swap(cur_index, input_index);
            Change_el(cur_index, size);
        }

        void Swap(int ind_1, int ind_2){
                int temp = array[ind_1];
                array[ind_1] = array[ind_2];
                array[ind_2] = temp;
                size -= 1;
        }

        for (int j = array.length / 2 - 1; j >= 0; j--) 
            Change_el(j, array.length);

        for (int j = array.length - 1; j >= 0; j--) {
            Swap(0, j);
            Change_el(0, j);
        }
    }*/

    public static void HeapSort(int array[]){
        int size = array.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            Change_el(array, size, i);
        }

        for (int i = size - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            
            Change_el(array, i, 0);
        }
    }
    static void Change_el(int array[], int size, int i){
        int max = i;
        int left_el_index = i * 2 + 1;
        int right_el_index = i * 2 + 2;

            if (left_el_index < size && array[max] < array[left_el_index]){
                max = left_el_index;
            }
            if ((right_el_index < size && array[max] < array[right_el_index])){
                max = right_el_index;
            }

            if (max != i){
                int temp = array[i];
                array[i] = array[max];
                array[max] = temp;
                Change_el(array, size, max);
            }
    }
}
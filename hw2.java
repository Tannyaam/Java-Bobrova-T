public class hw2 {
    public static void main(String[] args) {
        // System.out.println("Задача: перенести из A в B\n");
        // move_ring(3, 'A', 'B', 'C');
        int[] array = {8, 3, 4, 8, 7, 8, 0, 1, 9};
        insertion_sort(array);
        for (int i : array) {
            System.out.printf(i + " ");
        }
    }

// Задача 1. Написать программу, показывающую последовательность действий для игры “Ханойская башня”

    public static void move_description(char point_1, char point_2, int n){
        System.out.println("Переносим из " + point_1 + " в " + point_2);
    }

    public static void move_ring(int n, char from_point_1, char to_point_2, char temp_point){
        if (n == 0){
            return;
        }
        move_ring(n - 1, from_point_1, temp_point, to_point_2);
        move_description(from_point_1, to_point_2, n - 1);
        move_ring(n - 1, temp_point, to_point_2, from_point_1);
    }

// Задача 2. Реализовать алгоритм сортировки вставками.

    public static void insertion_sort(int[] array){
        int i = 1;
        while (i < array.length){
            int j = i;
            while ((j > 0) && (array[j] < array[j - 1])){
                int temp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = temp;
                j = j - 1;
            }
            i += 1;
        }
    }
}

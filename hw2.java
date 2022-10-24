// Задача 1. Написать программу, показывающую последовательность действий для игры “Ханойская башня”

public class hw2 {
    public static void main(String[] args) {
        System.out.println("Задача: перенести из A в B\n");
        move_ring(3, 'A', 'B', 'C');
    }

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
}



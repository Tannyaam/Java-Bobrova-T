import java.lang.reflect.Field;

public class hw3 {

    public static int wall = -1;
    public static int empty = -2;

    public static void voln(int x, int y, int cur, int width, int height, int [][] field){
        field[x][y] = cur;
        if (y + 1 < height){
            if ((field[x][y + 1] == empty) || ((field[x][y + 1] != wall) && (field[x][y + 1] > cur))){
                voln(x, y + 1, cur + 1, width, height, field);
            }
        }
        if (x + 1 < width){
            if ((field[x + 1][y] == empty) || ((field[x + 1][y] != wall) && (field[x + 1][y] > cur))){
                voln(x + 1, y, cur + 1, width, height, field);
            }
        }
        if (x - 1 >= 0){
            if ((field[x-1][y] == empty) || ((field[x-1][y] != wall) && (field[x-1][y] > cur))){
                voln(x-1, y, cur + 1, width, height, field);
            }
        }
        if (y - 1 >= 0){
            if ((field[x][y - 1] == empty) || ((field[x][y - 1] != wall) && (field[x][y - 1] > cur))){
                voln(x, y - 1,cur + 1, width, height, field);
            }
        }
    }

    public static void way(int x, int y, int width, int height, int [][] field, int [][] way_points, int i){
        int way_len = field[x][y];
        if (y + 1 < height){
            if ((field[x][y + 1] < way_len) && (field[x][y + 1] != wall)){
                if (way_points[0][i] == 0){
                    way_points[0][i] = x;
                    way_points[1][i] = y + 1;
                    i += 1;
                    way(x, y + 1, width, height, field, way_points, i);
                }
            }
        }
        if (x + 1 < width){
            if ((field[x + 1][y] < way_len) && (field[x + 1][y] != wall)){
                if (way_points[0][i] == 0){
                    way_points[0][i] = x + 1;
                    way_points[1][i] = y;
                    i += 1;
                    way(x + 1, y, width, height, field, way_points, i);
                }
            }
        }
        if (x - 1 >= 0){
            if ((field[x - 1][y] < way_len) && (field[x - 1][y] != wall)){
                if (way_points[0][i] == 0){
                    way_points[0][i] = x - 1;
                    way_points[1][i] = y;
                    i += 1;
                    way(x - 1, y, width, height, field, way_points, i);
                }
            }
        }
        if (y - 1 >= 0){
            if ((field[x][y - 1] < way_len) && (field[x][y - 1] != wall)){
                if (way_points[0][i] == 0){
                    way_points[0][i] = x;
                    way_points[1][i] = y - 1;
                    i += 1;
                    way(x, y - 1, width, height, field, way_points, i);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int height = 10;
        int width = 10;
        int [][] field = {{-2, -2, -2, -2, -2, -2, -2, -1, -1, -2},
                         {-2, -2, -1, -1, -1, -2, -2, -2, -2, -2},
                         {-2, -2, -1, -2, -2, -2, -2, -2, -2, -2},
                         {-2, -2, -1, -2, -2, -2, -2, -2, -2, -2},
                         {-2, -2, -1, -2, -1, -2, -2, -1, -2, -2},
                         {-2, -2, -2, -2, -2, -2, -2, -1, -2, -2},
                         {-2, -2, -1, -1, -2, -2, -2, -1, -1, -1},
                         {-2, -2, -2, -1, -2, -2, -2, -2, -2, -2},
                         {-2, -2, -2, -2, -2, -2, -1, -1, -2, -2},
                         {-2, -2, -1, -1, -2, -2, -2, -2, -2, -2}};
        int start_x = 2;
        int start_y = 1;
        int finish_x = 6;
        int finish_y = 6;
        voln(start_x, start_y, 0, width, height, field);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (field[i][j] == -1){
                    char c = '#';
                    System.out.printf(String.format("%-4c", c));
                }
                else{
                    System.out.printf(String.format("%-4d", field[i][j]));
                }
            }
            System.out.println();
        }
        int [][] way_points = new int [2][100];
        way(finish_x, finish_y, width, height, field, way_points, 0);

        int min_steps = field[finish_x][finish_y];
        System.out.println();

        for (int i = 0; i < 2; i++) {
            if (i == 0){
                String s = "row: ";
                System.out.printf(String.format("%-8s", s));
            }
            else{
                String s = "column: ";
                System.out.printf(String.format("%-8s", s));
            }
            for (int j = min_steps - 1; j > 0; j--) {
                System.out.printf(String.format("%-4d", way_points[i][j]));
            }
            System.out.println();
        }
    }
}
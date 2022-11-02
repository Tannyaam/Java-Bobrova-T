import java.lang.reflect.Field;

public class hw3 {

    public static int wall = -1;
    public static int empty = -2;

    public static int len;
    public static int[] px;
    public static int[] py;


/*    public static boolean way(int start_x, int start_y, int finish_x, int finish_y, int height, int width, int [][] field){
        int [] shift_x = {1, 0, -1, 0};
        int [] shift_y = {0, 1, 0, -1};
        int d, x, y;
        int [] px = new int[100];
        int [] py = new int[100];
        boolean stop = false;


        if (field[start_x][start_y] == wall || field[finish_x][finish_y] == wall){
            return false;
        }

        d = 0;
        field[start_x][start_y] = 0;

        do{
            stop = true;
            for (y = 0; y < height; ++y) {
                for (x = 0; x < width; ++x){
                    if (field[y][x] == d){
                        for (int k = 0; k < 4; ++k) {
                            int iy = y + shift_y[k];
                            int ix = x + shift_x[k];
                            if (iy >= 0 && iy < height && ix >= 0 && ix < width && field[iy][ix] == empty){
                                stop = false;
                                field[iy][ix] = d + 1;
                            }
                        }
                    }
                }
                d++;
            }
        } while (stop == false && field[finish_x][finish_y] == empty);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.printf(field[i][j] + " ");
            }
            System.out.println();
        }

        len = field[finish_x][finish_y];
        x = finish_x;
        y = finish_y;
        d = len;
        while(d > 0){
            px[d] = x;
            py[d] = y;
            d--;
            for (int k = 0; k < 4; ++k) {
                int iy = y + shift_y[k];
                int ix = x + shift_x[k];

                if (iy >= 0 && iy < height && ix >= 0 && ix < width && field[iy][ix] == d){
                    x = x + shift_x[k];
                    y = y + shift_y[k];
                    break;
                }
            }
        }
        px[0] = start_x;
        py[0] = start_y;

        return true;
    } */

    
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

    public static void way(int x, int y, int width, int height, int [][] field, int [][] way_points){
        int way_len = field[x][y];
        int i = 0;
        if (y + 1 < height){
            if ((field[x][y + 1] < way_len) && (field[x][y + 1] != wall)){
                i += 1;
                way_points[0][i] = x;
                way_points[1][i] = y + 1;
                way(x, y + 1, width, height, field, way_points);
            }
        }
        else{
            if (x + 1 < width){
                if ((field[x + 1][y] < way_len) && (field[x + 1][y] != wall)){
                    i += 1;
                    way_points[0][i] = x + 1;
                    way_points[1][i] = y;
                    way(x + 1, y, width, height, field, way_points);
                }
            }
            else{
                if (x - 1 >= 0){
                    if ((field[x - 1][y] < way_len) && (field[x - 1][y] != wall)){
                        i += 1;
                        way_points[0][i] = x - 1;
                        way_points[1][i] = y;
                        way(x - 1, y, width, height, field, way_points);
                    }
                }
                if (y - 1 >= 0){
                    if ((field[x][y - 1] < way_len) && (field[x][y - 1] != wall)){
                        i += 1;
                        way_points[0][i] = x;
                        way_points[1][i] = y - 1;
                        way(x, y - 1, width, height, field, way_points);
                    }
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
        way(finish_x, finish_y, width, height, field, way_points);

        int min_steps = field[finish_x][finish_y];

        for (int i = 0; i < 2; i++) {
            if (i == 0){
                String s = "x: ";
                System.out.printf(String.format("%-4s", s));
            }
            else{
                String s = "y: ";
                System.out.printf(String.format("%-4s", s));
            }
            for (int j = min_steps; j > 0; j--) {
                System.out.printf(String.format("%-4d", way_points[i][j]));
            }
            System.out.println();
        }
    }
}
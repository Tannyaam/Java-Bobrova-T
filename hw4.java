public class hw4 {
    public static void main(String[] args) {
        int [] array = {1, 8, 4, -3, 2, 8, 6, 4, 5};
        quicksort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.printf(array[i] + " ");
        }
    }

    public static int partition (int[] array, int start, int end) 
   {
       int marker = start;
       for ( int i = start; i <= end; i++ ) 
       {
           if ( array[i] <= array[end] ) 
           {
               int temp = array[marker]; // swap
               array[marker] = array[i];
               array[i] = temp;
               marker += 1;
           }
       }
       return marker - 1;
   }
  
   public static void quicksort (int[] array, int start, int end)
   {
       if (start >= end) 
       {
           return;
       }
       int pivot = partition (array, start, end);
       quicksort (array, start, pivot-1);
       quicksort (array, pivot+1, end);
   }
}

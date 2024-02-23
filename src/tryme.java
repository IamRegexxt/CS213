import java.util.Scanner;

public class tryme {

    public static void main(String[] args) {
      int arr [][]={ { 2, 7, 9 }, { 3, 6, 1 }, { 7, 4, 2 } };

      for(int i=0; i<3; i++) {
          for(int x=0; x<3; x++)
              System.out.print(arr[i][x] + " ");

          System.out.println();
      }
    }
}
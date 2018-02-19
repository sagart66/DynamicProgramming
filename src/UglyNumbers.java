/**
 *
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
 *This problem is to get nth ugly number
 */
//this is O(n) solution
import java.util.Scanner;


public class UglyNumbers {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int k=input.nextInt();
       System.out.println(fun(k));
    }
    static int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }


    public static int fun(int z){
        int memo[]=new int[z];
        memo[0]=1;
        int ptr2=0;
        int ptr3=0;
        int ptr5=0;
        int multipleOf3 = 3;
        int multipleOf2 = 2;
        int multipleOf5 = 5;

        for(int i=1;i<z;i++) {

            int d = min(multipleOf3, multipleOf2, multipleOf5);
            memo[i] = d;
            if (d == multipleOf2) {
                ptr2++;
                multipleOf2 = memo[ptr2] * 2;
            }
            if (d == multipleOf3){
                ptr3++;
                multipleOf3 = memo[ptr3] * 3;
            }
            if(d==multipleOf5) {
                ptr5++;
                multipleOf5 = memo[ptr5] * 5;
            }
        }
        return memo[z-1];



    }




}

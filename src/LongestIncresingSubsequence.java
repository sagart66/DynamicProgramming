/*
* The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all
 * elements of the subsequence are sorted in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6
  * and LIS is {10, 22, 33, 50, 60, 80}
* */
import java.util.Scanner;
public class LongestIncresingSubsequence {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=input.nextInt();
        System.out.println(Lis(a));
    }

    public static int Lis(int []a){
        int memo[]=new int[a.length];
        memo[0]=1;int ptr=0;
        for(int i=1;i<a.length;i++){
            if(a[ptr]<a[i]){
                memo[i]=1+memo[ptr];
                ptr=i;
            }
            else{
                int max1=-1;
                for(int j=i-1;j>0;j--){
                    if(a[j]<a[i] && memo[j]>max1){
                        max1=memo[j];
                    }
                }
                memo[i]=(max1>0)?(1+max1):1;
            }
            ptr=(memo[ptr]>memo[i])?ptr:i;
        }
            return memo[ptr];
    }
}

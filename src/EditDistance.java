/**
 *Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required
 *  to convert ‘str1’ into ‘str2’.

 Insert
 Remove
 Replace

 All of the above operations are of equal cost.
 *
 *
 */
import java.util.Scanner;
public class EditDistance{
    public static void main(String []args){
        Scanner input=new Scanner(System.in);
        String str1=input.next();
        String str2=input.next();
        System.out.println(EditDist(str1,str2,str1.length(),str2.length()));
    }
    public static int EditDist(String str1,String str2,int n,int m){
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n ;i++){
            for(int j=0;j<=m;j++){
                if(i==0)
                    dp[i][j]=j;
                else if(j==0)
                    dp[i][j]=i;
                else if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else {
                    dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));

                }
               // System.out.print(dp[i][j]+" ");
            }
            //System.out.println();
        }
        return dp[n][m];
    }
}
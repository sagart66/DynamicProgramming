/*
* iven a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n)
* from (0, 0). Each cell of the matrix represents a cost to traverse through that cell. Total cost of a path to reach (m, n) is sum of all
* the costs on that path (including both source and destination). You can only traverse down, right and diagonally lower cells from a given
 * cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.
* */
import java.util.Scanner;
public class MinimumCostPath {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        //System.out.println("Enter diamension of the matrix");
        int m=input.nextInt();
        int n=input.nextInt();
        //System.out.println("Enter the cost of the each element");
        int cost[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                cost[i][j]=input.nextInt();
        }
       // System.out.println("Enter the destination coardinates");
        int p=input.nextInt();
        int q=input.nextInt();
        System.out.println(fun(cost,p,q));
    }
    public static int fun(int cost[][], int p, int q){
        int n=cost[0].length;
        int m=cost.length;
        int memo[][]=new int[m][n];
        if(p<0 && q<0 && p>m && q>n)
            return Integer.MIN_VALUE;
        if(p==0 && q==0)
            return cost[0][0];
        memo[0][0]=cost[0][0];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) continue;
                int a=Integer.MAX_VALUE;int b=Integer.MAX_VALUE;int c=Integer.MAX_VALUE;
                if(i!=0 && j!=0)
                    a=memo[i-1][j-1];
                if(i!=0)
                    b=memo[i-1][j];
                if(j!=0)
                    c=memo[i][j-1];
                int d=Math.min(a,Math.min(b,c));
                memo[i][j]=d+cost[i][j];
                if(i==p && j==q)
                    return memo[i][j];
            }
        }
        return memo[p][q];
    }


}

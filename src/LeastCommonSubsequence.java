import java.util.Scanner;
public class LeastCommonSubsequence {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String a=input.next();
        String b=input.next();
        char[] a1=a.toCharArray();
        char[] b1=b.toCharArray();
        int n=a1.length;
        int m=b1.length;
        System.out.println("Length of Longest Common Subseqence is:"+lcs(a1,b1,n,m));
    }
    /*
    //time  complexity is exponential
    static int lcs(char[] a,char[] b, int n,int m){
        if(m==0 || n==0)
            return 0;
        if(a[n-1]==b[m-1])
            return 1+lcs(a,b,n-1,m-1);
        return max(lcs(a,b,n-1,m),lcs(a,b,n,m-1));
    }*/
    static int max(int a,int b){
        int m=(a>b)?a:b;
        return m;
    }
    //using tabulation and time complexity has decresed to O(mn)
    static int lcs(char[] a,char[] b,int m,int n){
        int l[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0)
                    l[i][j]=0;
                else if(a[i-1]==b[j-1])
                    l[i][j]=1+l[i-1][j-1];
                else
                            l[i][j]=max(l[i-1][j],l[i][j-1]);
            }
        }
        return l[m][n];
    }

}

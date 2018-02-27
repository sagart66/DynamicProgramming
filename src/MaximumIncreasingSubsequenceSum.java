import java.util.Arrays;

public class MaximumIncreasingSubsequenceSum {
    public static void main(String[] args) {
        int[] arr={1,101,8,2,3,100,4,5};
        System.out.println(sumlis(arr,0,arr.length));
        System.out.println(dpSumlis(arr));
    }
    //Naive Recursive algorithm
    static int sumlis(int arr[],int start,int end){
        if(start>=end)
            return 0;
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        for(int i=start+1;i<=end;i++){
             if(i==end || arr[i]>=arr[start]){
               int  l1=sumlis(arr,i,end);
                max1=Math.max(max1,l1);
            }
            else if(start==0){
                int l2=sumlis(arr,i,end);
                max2=Math.max(max2,l2);
            }
        }
        return (max1>max2)?(arr[start]+max1):max2;
    }
    //Dynamic programming algorithm
    static int dpSumlis(int arr[]){
        int z[]=new int[arr.length];
        z[0]=1;
        for(int i=1;i<arr.length;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j])
                    max=Math.max(max,z[j]);
            }
            z[i]=max+arr[i];
        }
        return  Arrays.stream(z).max().getAsInt();
    }

}

/*
 *find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
 * */
import java.util.LinkedList;
import java.util.Scanner;
public class MaxSubArraySum {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();//size of array
        int max_so_far=0;
        int max_ending_here=0;
        int s=0;
        int start=0;int end=0;
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=input.nextInt();
        }

int k;
        for(int i=0;i<n;i++){

             k=a[i];
          //  max_ending_here+=k;
            if(max_ending_here<0 && k>0) {
                max_ending_here = k;
                start=i;
            }
           else if(max_ending_here<0 && max_ending_here<k){
               max_ending_here=k;
               start=i;
            }
            else{
               max_ending_here+=k;
            }
            if(max_ending_here>max_so_far) {
                max_so_far = max_ending_here;
                end=i;
            }
        }
        System.out.println("max sum is "+max_so_far);
        LinkedList<Integer>l=new LinkedList<>();
        for(int i=start;i<=end;i++)
        l.add(a[i]);
        System.out.println("Content of max SubArray sum="+l);///
    }
}

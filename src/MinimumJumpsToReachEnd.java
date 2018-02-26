import java.util.LinkedList;

/*
* Given an array of integers where each element represents the max number of steps that can be made forward from that element.
* Write a function to return the minimum number of jumps to reach the
* end of the array (starting from the first element). If an element is 0, then cannot move through that element.
*
*
* */
/*
*/
public class MinimumJumpsToReachEnd {
    public static void main(String[] args) {
       int arr[]={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
      //  int arr[]={2,4,2,2,1,2,2,0,5};
        //System.out.println(fun(arr,0,arr[0])-1);
        //System.out.println("Path => "+elements(arr,0,arr[0]));
          System.out.println(Dfun(arr));
          System.out.println(Dpath(arr));
    }
    //Naive recurssive approach
    public static int fun(int arr[],int index,int val){
        if(val==0)
            return Integer.MAX_VALUE-5;
        if(index> arr.length)
            return 0;
        if(index==arr.length-1)
            return 1;
        int min=Integer.MAX_VALUE;
        for(int i=index;arr[index]<arr.length-1 && i<index+arr[index] && i< arr.length-1;i++){
            int l=fun(arr,i+1,arr[i+1]);
            if(min>l)
                min=l;
        }
        return 1+min;
    }
    //Naive recurssion path followed
    public static LinkedList<Integer> elements(int arr[],int index,int val){
        LinkedList<Integer> l=new LinkedList<Integer>();
        if(val==0){
            return null;
        }

        if(index>arr.length)
            return l;
        if(index==arr.length-1){
            l.add(val);
            return l;
        }


        int min=Integer.MAX_VALUE;
       LinkedList<Integer>l1;
       LinkedList<Integer>minl=new LinkedList<>();
        for(int i=index;arr[index]<arr.length-1 && i<index+arr[index] && i< arr.length-1;i++){
            l1=elements(arr,i+1,arr[i+1]);
            if(l1==null)
                continue;
            if(l1.size()<min){
                min=l1.size();
                minl=l1;
            }

        }
        l.add(val);
        l.addAll(minl);
        return l;
    }
    //Dynamic programming approach
    public static int Dfun(int arr[]){
    int jumps[]=new int[arr.length];
    if(arr.length==0 || arr[0]==0)
        return Integer.MAX_VALUE;
    jumps[0]=0;
    for(int i=1;i<arr.length;i++){
        for(int j=0;j<i;j++){
            if(i<=j+arr[j] && jumps[j]!=Integer.MAX_VALUE){
                jumps[i]=jumps[j]+1;
                        break;
            }
        }
    }
    return jumps[arr.length-1];
    }
    //Dynamic programming approach for path
    public static LinkedList<Integer>  Dpath(int arr[]){
        LinkedList<Integer>ele[]=new LinkedList[arr.length];
        if(arr.length==0 || arr[0]==0)
            return null;
        ele[0]=new LinkedList<>();
        ele[0].add(arr[0]);
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(i<=j+arr[j] && ele[j]!=null){
                   // jumps[i]=jumps[j]+1;
                    ele[i]=new LinkedList<>();
                    ele[i].addAll(ele[j]);
                    ele[i].add(arr[i]);
                    break;
                }
            }
        }


        return ele[arr.length-1];
    }
}

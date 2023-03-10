import java.util.*;
import java.io.*;
class Solution
{
    public static boolean isPossible(int n, int[]arr, int limit, int maxopt){
        int curropt=0;
        for(int i=0;i<n;i++){
            int currBalls=arr[i];
            int divider=currBalls/limit;
            if(currBalls%limit==0){
                divider--;
            }
            curropt+=divider;
        }
        return curropt<=maxopt;
    }
    public static int solve(int n,int m,int arr[])
    {
      int lo=1;
      int hi=0;
      for(int balls:arr){
        hi=Math.max(balls,hi);
      }
      int potentialAns=-1;
      while(lo<=hi){
        int mid=(lo+hi)/2;
        if(isPossible(n,arr,mid,m)==true){
            potentialAns=mid;
            hi=mid-1;
        }else{
            lo=mid+1;
        }
      }
      return potentialAns;
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int[] arr;
        arr= new int[n];
        for(int i = 0; i < n; i++)arr[i]=input.nextInt();
        System.out.println(Solution.solve(n,m,arr));
    }
}
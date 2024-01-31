import java.util.*;
public class Solution {
    public static int minSubsetSumDifference(int []arr, int n) {
        // Write your code here.
        int res= subset(arr,n);
        return res;
    }

   	public static int subset(int arr[],int n){
        int sum=0;
        for(int ele:arr)
           sum+=ele;
        int dp[][]=new int[n+1][sum+1];
        for(int ele[]:dp)
            Arrays.fill(ele,-1);
            
         for(int i=sum;i>=0;i--)
                 solve(arr,n-1,i,dp);
         for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++)
                 System.out.print(dp[i][j]+" ");
            System.out.println();
        }  
        int min = 100000009;
    for(int i=0;i<=dp[0].length/2;i++){
        if(dp[n-1][i]!= 0 && Math.abs(sum-(2*i))<min ){
                min=Math.abs(sum-2*i);
        }
    }
    return min;


        // int res= (sum%2==0 && sum/2 ==dp[n-1][dp[0].length/2])?0:(dp[n-1][dp[0].length/2+1]-dp[n-1][dp[0].length/2]);
        // return res;
        
    }
    public static int solve(int arr[],int n,int sum,int dp[][]){
        //base cond
        if(sum==0 && n>=-1){
             if(n==-1)  dp[n+1][sum]=1;
             else dp[n][sum]=1;
         return 1;
        }
        if(n<0)
            return 0;

        if(dp[n][sum]!=-1)
            return dp[n][sum];

            

        //choice 
        if(sum<arr[n]){
            dp[n][sum]=solve(arr,n-1,sum,dp);
        }
        else{
           dp[n][sum]= solve(arr,n-1,sum-arr[n],dp)+
            solve(arr,n-1,sum,dp);
        }
        return dp[n][sum];
    }
}

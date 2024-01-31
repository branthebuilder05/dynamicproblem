import java.util.*;
public class Main
{
	public static void main(String[] args) {
	
		int arr[]=new int[]{1,3,4,7};
		subset(arr,arr.length);
	}
	public static void subset(int arr[],int n){
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
    }
    public static int solve(int arr[],int n,int sum,int dp[][]){
        System.out.println("called for "+ n+" "+sum);
        //base cond
        if(sum==0 && n>=-1){
            
              dp[n+1][sum]=1;
         return 1;
        }
        if(n<0){
            dp[n+1][sum]=0;
            return 0;
        }
            

        if(dp[n+1][sum]!=-1)
            return dp[n+1][sum];

            

        //choice 
        if(sum<arr[n]){
            dp[n+1][sum]=solve(arr,n-1,sum,dp);
        }
        else{
           dp[n+1][sum]= solve(arr,n-1,sum-arr[n],dp)+
            solve(arr,n-1,sum,dp);
        }
        return dp[n+1][sum];
    }
}

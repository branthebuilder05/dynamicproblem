
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	
//	int arr[]= new int[]{5,6,4,5,3,3};
	int arr[]= new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,99};
	int n=arr.length;
	System.out.println(equalPartition(n,arr));
                
	}
	 static int equalPartition(int N, int arr[]) {
         return solve(N,arr);
        
        
    }
    public static int solve(int n, int arr[]){
        int sum=0;
        for(int ele:arr)
            sum+=ele;
          
        if(sum%2!=0)
            return 0;
        else{
           
            sum/=2;
             int dp[][] = new int[n+1][sum+1];
             for(int ele[]:dp)
                Arrays.fill(ele,-1);
            int res= part(arr,n-1,sum,dp);
            // for(int ele[]:dp){
            //     for(int x:ele){
            //         System.out.print(x+" ");}
            //     System.out.println();}
                return res;
            
        }
    }
    
    public static int part(int arr[],int len, int sum,int dp[][]){
     // System.out.println("called for " + len+" " +sum+" with val "+dp[len][sum]);
        if(sum==0 ){
            dp[len][sum] = 1;
            return dp[len][sum];
        }
            
        if( len==0)
            {
            dp[len][sum] = 0;
            return dp[len][sum];
        }
            
        if(dp[len][sum]!=-1)
            return dp[len][sum];
            
        if(arr[len]<=sum){
            
         dp[len][sum]=Math.max(part(arr,len-1, sum-arr[len],dp),  part(arr,len-1,sum,dp));
        return dp[len][sum];
        }
        else{
            
             dp[len][sum]= part(arr,len-1,sum,dp);
            return dp[len][sum];
            
        }
        }
	
	
}

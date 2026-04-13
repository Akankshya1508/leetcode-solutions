class Solution {
    public int rob(int[] nums) 
    {
        int n=nums.length;
        int prev1=nums[0];
        int prev2=-1;
        for(int ind=1;ind<n;ind++)
        {
            int npick=0+prev1;
            int pick=nums[ind];

            if(ind>1)
            pick+=prev2;

        int curr=Math.max(pick,npick);

        prev2=prev1;
        prev1=curr;

        }
        return prev1;
        
    }
    int func(int ind, int nums[],int dp[])
    {
        if(ind==0)
        return nums[ind];
        
        if(dp[ind]!=-1)
        return dp[ind];

        int npick=0+func(ind-1,nums,dp);
        int pick=nums[ind];

        if(ind>1)
        pick+=func(ind-2,nums,dp);

        return dp[ind]=Math.max(pick,npick);
    }
}
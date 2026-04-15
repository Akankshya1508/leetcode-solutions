class Solution {
    public int rob(int[] nums) 
    {
        int n=nums.length;

        if(n==1)
        return nums[0];
        int arr1[]=new int[n-1];
        int arr2[]=new int[n-1];

        for(int i=0;i<n-1;i++)
        {
            arr1[i]=nums[i];
        }

        for(int i=1;i<n;i++)
        {
            arr2[i-1]=nums[i];
        }
        return Math.max(robb(arr1),robb(arr2));


        
    }
    public int robb(int[] nums) 
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
}
class Solution {
    public int smallestDivisor(int[] nums, int threshold) 
    {
         int low=1;
         int high=nums[0];

         for(int i:nums)
         high=Math.max(i,high);

         while(low<=high)
         {
            int mid=(high+low)/2;

            if(th(mid,nums)<=threshold)
            high=mid-1;
            else
            low=mid+1;
         }
         return low;
        
    }
    int th(int mid, int nums[])
    {
        int ans=0;

        for(int i:nums)
        {
            ans+=Math.ceil((double)i/(double)mid);
        }
        return ans;
    }
}
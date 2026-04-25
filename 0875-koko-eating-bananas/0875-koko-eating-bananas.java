class Solution {
    public int minEatingSpeed(int[] piles, int h) 
    {
        int low=1;
        int high=0;
        for(int i:piles)
        {
            high=Math.max(i,high);
        }

        while(low<=high)
        {
            int mid=(high+low)/2;

            int hours=func(mid,piles);
            if(hours<=h)
            high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    int func(int mid,int arr[])
    {
        int ans=0;
        for(int i:arr)
        ans+=Math.ceil((double)i/(double)mid);

        return ans;
    }
}
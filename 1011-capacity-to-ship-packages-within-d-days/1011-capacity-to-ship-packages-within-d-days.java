class Solution {
    public int shipWithinDays(int[] weights, int days) 
    {
        int low=weights[0];
        int high=0;
        for(int i:weights)
        {
            low=Math.max(low,i);
            high+=i;

        }
        

        while(low<=high)
        {
            int mid=(high+low)/2;

            if(func(mid,weights)<=days)
            high=mid-1;
            else
            low=mid+1;
        }
        return low;
        
    }
    int func(int mid, int arr[])
    {
        int day=1;
        int cap=0;

        for(int i:arr)
        {
            if(cap+i<=mid)
            cap+=i;
            else
            {
                day++;
                cap=i;
            }
        }
        return day;
    }
}
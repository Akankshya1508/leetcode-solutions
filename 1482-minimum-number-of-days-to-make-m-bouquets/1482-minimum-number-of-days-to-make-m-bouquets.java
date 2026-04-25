class Solution {
    public int minDays(int[] bloomDay, int m, int k) 
    {
        int n=bloomDay.length;

        if(((long)m*k)>n)
        return -1;

        int low=bloomDay[0];
        int high=bloomDay[0];

        for(int i:bloomDay)
        {
            low=Math.min(low,i);
            high=Math.max(high,i);
        }

        while(low<=high)
        {
            int mid=(low+high)/2;

            if(possible(mid,m,k,bloomDay))
            high=mid-1;
            else
            low=mid+1;
        }
        return low;
        
    }
    boolean possible(int mid,int m, int k, int arr[])
    {
        int noB=0;
        int count=0;

        for(int i:arr)
        {
            if(mid>=i)
            count++;
            else
            {
                noB+=(count/k);
                count=0;
            }
            
        }
        noB+=(count/k);



        if(noB>=m)
        return true;
        else 
        return false;
    }
}
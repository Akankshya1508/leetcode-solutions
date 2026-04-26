class Solution {
    public int splitArray(int[] arr, int k) 
    {
          int n=arr.length;
        if(k>n)
        return -1;
        int low=arr[0];
        int high=0;
        
        for(int i:arr)
        {
            low=Math.max(low,i);
            high+=i;
        }
        
        
        while(low<=high)
        {
            int mid=(high+low)/2;
            
            if(noOfStu(arr,k,mid,n)>k)
            low=mid+1;
            else
            high=mid-1;
            
        }
        return low;
        
    }
    static int noOfStu(int arr[], int k, int mid, int n)
    {
        int student=1;
        int page=0;
        
        for(int i:arr)
        {
            if(page+i<=mid)
            {
                page+=i;
            }
            else
            {
                student+=1;
                page=i;
            }
        }
        return student;
    }
}
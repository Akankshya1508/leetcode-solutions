class Solution {
    public int[] searchRange(int[] nums, int target) 
    {
        int n=nums.length;
        

        int low=lowerBound(nums,target);
        if(low==n || nums[low]!=target)
        return new int[]{-1,-1};

        return new int[]{lowerBound(nums,target),upperBound(nums,target)-1};


        
    }
    int lowerBound(int[] arr, int target) 
    {
        
        int n=arr.length;
        
        int low=0;
        int high=n-1;
        
        while(low<=high)
        {
            int mid=(low+high)/2;
            
            if(arr[mid]>=target)
            high=mid-1;
            else 
            low=mid+1;
        }
        return low;
        
    }
    int upperBound(int[] arr, int target) 
    {
        
        int n=arr.length;
        
        int low=0;
        int high=n-1;
        
        while(low<=high)
        {
            int mid=(low+high)/2;
            
            if(arr[mid]>target)
            high=mid-1;
            else 
            low=mid+1;
        }
        return low;
    }
}
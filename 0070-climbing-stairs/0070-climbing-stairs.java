class Solution {
    public int climbStairs(int n) 
    {
        int prev2=1;
        int prev1=1;

        for(int ind=2;ind<=n;ind++)
        {
            int one=prev1;
            int two=0;
            if(ind>1)
            two=prev2;
            int curr=one+two;
            prev2=prev1;
            prev1=curr;

        }
        return prev1;
    }
}
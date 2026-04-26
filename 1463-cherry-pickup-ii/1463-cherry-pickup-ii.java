class Solution {
    public int cherryPickup(int[][] grid) 
    {
        int r = grid.length;
        int c = grid[0].length;

        int dp[][][]=new int[r][c][c];

         // 🟢 Base case: last row
        for(int col1 = 0; col1 < c; col1++)
        {
            for(int col2 = 0; col2 < c; col2++)
            {
                if(col1 == col2)
                    dp[r-1][col1][col2] = grid[r-1][col1];
                else
                    dp[r-1][col1][col2] = grid[r-1][col1] + grid[r-1][col2];
            }
        }

        // 🔁 Fill from bottom to top
        for(int row = r - 2; row >= 0; row--)
        {
            for(int col1 = 0; col1 < c; col1++)
            {
                for(int col2 = 0; col2 < c; col2++)
                {
                    int max = 0;

                    for(int d1 = -1; d1 <= 1; d1++)
                    {
                        for(int d2 = -1; d2 <= 1; d2++)
                        {
                            int newCol1 = col1 + d1;
                            int newCol2 = col2 + d2;

                            if(newCol1 >= 0 && newCol1 < c && newCol2 >= 0 && newCol2 < c)
                            {
                                int value;

                                if(col1 == col2)
                                    value = grid[row][col1];
                                else
                                    value = grid[row][col1] + grid[row][col2];

                                value += dp[row+1][newCol1][newCol2];

                                max = Math.max(max, value);
                            }
                        }
                    }

                    dp[row][col1][col2] = max;
                }
            }
        }

        // 🚀 Start positions
        return dp[0][0][c-1];
        
    }
     
}
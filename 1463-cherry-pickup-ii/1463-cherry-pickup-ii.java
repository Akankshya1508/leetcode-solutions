class Solution {
    public int cherryPickup(int[][] grid) 
    {
        int r = grid.length;
        int c = grid[0].length;

        int dp[][][] = new int[r][c][c];

        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
                Arrays.fill(dp[i][j], -1);

        return solve(0, 0, c - 1, grid,dp);
        
    }
      int solve(int row, int col1, int col2, int[][] grid,int dp[][][])
    {
        int r = grid.length;
        int c = grid[0].length;

        // ❌ Out of bounds
        if(col1 < 0 || col2 < 0 || col1 >= c || col2 >= c)
            return (int)-1e9;

        // ✅ Last row
        if(row == r - 1)
        {
            if(col1 == col2)
                return grid[row][col1];
            else
                return grid[row][col1] + grid[row][col2];
        }

        // 🔁 Memo check
        if(dp[row][col1][col2] != -1)
            return dp[row][col1][col2];

        int max = 0;

        // Try all 9 moves
        for(int d1 = -1; d1 <= 1; d1++)
        {
            for(int d2 = -1; d2 <= 1; d2++)
            {
                int value;

                if(col1 == col2)
                    value = grid[row][col1];
                else
                    value = grid[row][col1] + grid[row][col2];

                value += solve(row + 1, col1 + d1, col2 + d2, grid,dp);

                max = Math.max(max, value);
            }
        }

        return dp[row][col1][col2] = max;
    }
}
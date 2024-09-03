class Solution {
    public int findMaxFish(int[][] grid) {
        int sum=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]!=0)
                {
                    int a[]=new int[1];
                    task(grid,i,j,a);
                    sum=Math.max(sum,a[0]);
                }
            }
        }
        return sum;
    }
    public void task(int grid[][], int i, int j, int a[])
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0)
        {
            return;
        }
        a[0]+=grid[i][j];
        grid[i][j]=0;
        task(grid,i+1,j,a);
        task(grid,i-1,j,a);
        task(grid,i,j+1,a);
        task(grid,i,j-1,a);
    }
}
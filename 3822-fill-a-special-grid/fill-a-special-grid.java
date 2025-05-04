class Solution {
    public int[][] specialGrid(int N) {
        int[][] grid = new int[1][1];
        grid[0][0]=0;
        for (int level = 1; level <=N; level++) {
            int currentSize = 1 << level;
            int half = currentSize/2;
            int offset = half * half;
            int [][] newGrid = new int[currentSize][currentSize];
            for (int i = 0; i < half; i++) {
                for (int j = 0; j < half; j++) {
                    int val = grid[i][j];
                    newGrid[i][j+half] = val;
                    newGrid[i+half][j+half] = val + offset;
                    newGrid[i+half][j] = val + 2* offset;
                    newGrid[i][j]= val + 3* offset;
                }
            }
            grid = newGrid;
        }
        return grid;
    }
}
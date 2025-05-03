class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        for (int i = 1; i <= 6; i++) {
            int rotations = check(i, tops, bottoms);
            if (rotations != -1)
                return rotations;
        }
        return -1;
    }

    int check(int target, int[] tops, int[] bottoms) {
        int top = 0;
        int bottom = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            } else if (tops[i] != target) {
                top++;
            } else if(bottoms[i]!=target) {
                bottom++;
            }
        }
         return Math.min(top, bottom);

    }
}
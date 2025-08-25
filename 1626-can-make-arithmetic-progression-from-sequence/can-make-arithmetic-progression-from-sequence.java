class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff= Math.abs(arr[1]-arr[0]);
        int i=0;
        int j=0;

        while(i<arr.length -1 && j< arr.length) {
            j= i+1;
            if(Math.abs(arr[j]-arr[i]) != diff) return false;
            else {
                i++;
            }
        }
        return true;
    }
}
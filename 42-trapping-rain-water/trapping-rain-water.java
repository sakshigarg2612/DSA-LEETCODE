class Solution {
    public int trap(int[] height) {
        int n= height.length;
        int leftMax =0;
        int left =0; int rightMax=0; int right = n-1;
        int water =0;
        while(left<=right) {
            if(height[left]<height[right]){
                leftMax= Math.max(height[left],leftMax);
                water = water + leftMax- height[left];
                left++;
            } else if(height[left]>height[right]) {
                rightMax= Math.max(rightMax,height[right]);
                water = water + rightMax-height[right];
                right--;
            } else {
                rightMax= Math.max(rightMax,height[right]);
                right--;
            }
        }
        return water;
    }
}
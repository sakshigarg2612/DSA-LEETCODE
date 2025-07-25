class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set=  new HashSet<>();
        int max=Integer.MIN_VALUE;
        for(int num : nums) {
            if(num>=0) {
            set.add(num);
            } else {
                max= Math.max(max,num);
            }
        }
        int sum =0;
        for(Integer num : set) {
            sum = sum + num;
        }
        return set.isEmpty()?max:sum;
    }
}
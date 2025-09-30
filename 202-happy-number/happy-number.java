class Solution {
    public boolean isHappy(int n) {
    HashSet<Integer> set = new HashSet<>();
    int square= n;
    while(square!=1 && !set.contains(square)) {
        set.add(square);
        square= findSquare(square);
    }
    return square ==1;
    }

    public int findSquare(int n) {
        int sum =0;
        while(n>0){
            int d= n%10;
            sum = sum + d*d;
            n= n/10;
        }
        return sum;
    }
}
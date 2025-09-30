class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        int maxLength =1;
        int length=1;
        HashSet<Character> set = new HashSet<>();
        int i=0;
        while(i<s.length()){
            set.add(s.charAt(i));
            int j=i+1;
            while(j<s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                length++;
                j=j+1;
            }
            i=i+1;
            maxLength = Math.max(maxLength,length);
            length=1;
            set.clear();
        }
        return maxLength;
    }
}
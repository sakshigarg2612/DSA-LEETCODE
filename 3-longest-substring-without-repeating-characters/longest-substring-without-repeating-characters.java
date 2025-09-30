class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        int maxLength =0;
        HashMap<Character,Integer> lastSeen = new HashMap<>();
        int left=0;
        for(int right=0; right <s.length();right++) {
            if(lastSeen.containsKey(s.charAt(right))) {
                left= Math.max(left,lastSeen.get(s.charAt(right))+1);
            }
            lastSeen.put(s.charAt(right),right);
            maxLength = Math.max(maxLength, right- left+1);
        }
        return maxLength;
    }
}
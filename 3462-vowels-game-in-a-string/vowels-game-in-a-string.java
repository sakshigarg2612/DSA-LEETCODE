class Solution {
    public boolean doesAliceWin(String s) {
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int count =0;
        for(Character ch : s.toCharArray()) {
            if(vowels.contains(ch)) count++;
        }
        if(count==0) return false;
        if(count%2!=0) return true;
        else {
            return true;
        }
    }
}
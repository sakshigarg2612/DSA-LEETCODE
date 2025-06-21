class Solution {
    public int minimumDeletions(String word, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i < word.length();i++) {
            Character ch =word.charAt(i);
            freq.put(ch, freq.getOrDefault(ch,0) +1);
            set.add(ch);
        }
        int minDeletions = word.length();
        for(Character ch : set) {
            int del =0;
            for(Map.Entry<Character,Integer> entry : freq.entrySet()) {
                if(entry.getValue() < freq.get(ch)) {
                    del = del + entry.getValue();
                } else if (entry.getValue() > freq.get(ch)) {
                    if(entry.getValue() - freq.get(ch) >k) {
                        del = del+ entry.getValue() - freq.get(ch) -k;
                    }
                }
            }
            minDeletions = Math.min(minDeletions,del);
        }

        return minDeletions;
    }
}
class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet<String> set = new HashSet<>(Arrays.asList(wordlist));
        HashMap<String,List<String>> map = new HashMap<>();
        for(String word : wordlist) {
            map.put(refineWord(word), new ArrayList<>());
        }
        for(String word : wordlist) {
            List<String> list= map.get(refineWord(word));
            list.add(word);
            map.put(refineWord(word), list);
        }
        for(int i=0;i <queries.length;i++) {
            if(!set.contains(queries[i])) {
                String w= refineWord(queries[i]);
                if(!map.containsKey(w)) {
                    queries[i]= "";
                } else {
                    boolean flag= false;
                    for(String w1 : wordlist) {
                        if((queries[i].toLowerCase()).equals(w1.toLowerCase())) {
                            queries[i]=w1;
                            flag = true;
                            break;
                        }
                    }
                    queries[i] = flag?queries[i] : map.get(w).get(0);
                }
            }
        }
        return queries;
    }

    String refineWord(String word) {
        word= word.toLowerCase();
        return word.replaceAll("(?i)[aeiou]","*");
    }


}
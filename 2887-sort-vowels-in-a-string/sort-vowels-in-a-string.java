class Solution {
    public String sortVowels(String s) {
        List<Character> set = new ArrayList<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        List<Integer> indexs= new ArrayList<>();
        List<Character> alpha = new ArrayList<>();
        for(int i=0;i <s.length(); i++) {
            if(set.contains(s.charAt(i))) {
                indexs.add(i);
                alpha.add(s.charAt(i));
            }
        }
        Collections.sort(alpha);
        StringBuilder sb= new StringBuilder(s);
        int i=0;
        for(int index : indexs) {
            sb.setCharAt(index,alpha.get(i));
            i++;
        }
        return sb.toString();
    }
}
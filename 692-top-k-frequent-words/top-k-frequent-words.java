class Solution {
    class Pair {
        String word;
        int freq;

        Pair(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (b.freq - a.freq == 0) {
                return a.word.compareTo(b.word);
            }
            return b.freq - a.freq;
        });
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 1) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        List<String> result = new ArrayList<>();
        while (k > 0 && !pq.isEmpty()) {
            result.add(pq.poll().word);
            k--;
        }
        return result;
    }
}
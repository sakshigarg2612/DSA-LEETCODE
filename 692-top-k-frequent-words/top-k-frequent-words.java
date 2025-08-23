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
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: MinHeap of size k
        PriorityQueue<Map.Entry<String, Integer>> pq =
            new PriorityQueue<>((a, b) -> {
                if (a.getValue().equals(b.getValue())) {
                    // Reverse lex order for min-heap
                    return b.getKey().compareTo(a.getKey());
                }
                // Lower frequency at top
                return a.getValue() - b.getValue();
            });

        // Step 3: Push entries, maintain heap size k
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Build result in reverse order
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }
}
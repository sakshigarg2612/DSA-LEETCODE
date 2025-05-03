class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> bottomMap = new HashMap<>();
        for (int ele : tops) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        for (int ele : bottoms) {
            bottomMap.put(ele, bottomMap.getOrDefault(ele, 0) + 1);
        }
        int maxTop = 0;
        int topKey = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxTop < entry.getValue()) {
                maxTop = entry.getValue();
                topKey = entry.getKey();
            }
        }
        int maxBottom = 0;
        int bottomKey = 0;
        for (Map.Entry<Integer, Integer> entry : bottomMap.entrySet()) {
            if (maxBottom < entry.getValue()) {
                maxBottom = entry.getValue();
                bottomKey = entry.getKey();
            }
        }
        int countTop = 0;
        int topNew[] = Arrays.copyOf(tops, tops.length);
        for (int i = 0; i < tops.length; i++) {
            if (topNew[i] == topKey) {
                continue;
            }
            if (tops[i] != topKey && bottoms[i] == topKey) {
                topNew[i] = topKey;
                countTop++;
            }
        }

        if (!Arrays.stream(topNew).allMatch(x -> x == topNew[0])) {
            countTop = Integer.MAX_VALUE;
        }
        int countBottom = 0;
        for (int i = 0; i < bottoms.length; i++) {
            if (bottoms[i] != bottomKey && tops[i] == bottomKey) {
                countBottom++;
                bottoms[i] = bottomKey;
            }
        }
        if (Arrays.stream(bottoms).allMatch(x -> x == bottoms[0])) {
            return Math.min(countTop, countBottom);
        }
        if (countTop > tops.length) {
            return -1;
        }
        return countTop;
    }
}
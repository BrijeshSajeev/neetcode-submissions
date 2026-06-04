class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Count the frequency of each number
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // 2. Put all unique numbers into a List
        List<Integer> uniqueElements = new ArrayList<>(map.keySet());

        // 3. Sort the list based on their frequencies in descending order
        // (b, a) ensures descending order: higher frequency comes first
        Collections.sort(uniqueElements, (a, b) -> map.get(b) - map.get(a));

        // 4. Extract the top K elements into the required int[] array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = uniqueElements.get(i);
        }

        return result;
    }
}

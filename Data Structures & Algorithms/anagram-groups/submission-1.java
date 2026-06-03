class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            return Arrays.asList(Arrays.asList(strs[0]));
        }

        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for(String s : strs){
            int[] count = new int[26];

            for(char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Convert frequency array to a unique string key
            StringBuilder sb = new StringBuilder();
            for (int i : count) {
                sb.append('#');
                sb.append(i);
            }

            String key = sb.toString();

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}

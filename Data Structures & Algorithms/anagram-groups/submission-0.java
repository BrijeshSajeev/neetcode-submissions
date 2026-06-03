class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            return Arrays.asList(Arrays.asList(strs[0]));
        }

        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for(String s : strs){
            char[] toCharArr = s.toCharArray();
            Arrays.sort(toCharArr);

            String key = new String(toCharArr);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> st = new HashSet<>();
        int left = 0;
        int max = 0;

        // T.C => O(2n)
        for(int right =0; right<s.length(); right++){
            while(st.contains(s.charAt(right))){
                st.remove(s.charAt(left));
                left++;
            }

            st.add(s.charAt(right));
            max = Math.max(max, right - left +1);
        }
        
        return max;
    }
}

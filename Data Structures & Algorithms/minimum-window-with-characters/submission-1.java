class Solution {
    public String minWindow(String s, String t) {
        // Instead of storing every substring, expand from each starting position until we get a valid window.
        // Idea
        // For every i:
            // Start j = i
            // Expand right until all characters of t are found.
            // Update minimum length.
            // Move to next i.
        int n = s.length();

        int[] target = new int[128];

        for(char ch : t.toCharArray()) {
            target[ch]++;
        }

        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        for(int i = 0; i < n; i++) {

            int[] freq = new int[128];

            for(int j = i; j < n; j++) {

                freq[s.charAt(j)]++;

                if(contains(freq, target)) {

                    if(j - i + 1 < minLen) {
                        minLen = j - i + 1;
                        startIndex = i;
                    }

                    break;
                }
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(startIndex, startIndex + minLen);
    }

    private boolean contains(int[] freq, int[] target) {

        for(int i = 0; i < 128; i++) {
            if(freq[i] < target[i]) {
                return false;
            }
        }

        return true;
    }
}

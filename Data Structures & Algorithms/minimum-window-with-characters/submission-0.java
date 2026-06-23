class Solution {
    public String minWindow(String s, String t) {
        // Algorithm(Brute Force):
        //     1. Generate all substrings s[i...j].
        //     2. Count characters in the substring.
        //     3. Compare with character frequencies of t.
        //     4. Keep track of the smallest valid substring.

        int minLen = Integer.MAX_VALUE;
        String answer = "";

        int[] target = new int[128];

        for(char ch : t.toCharArray()) {
            target[ch]++;
        }

        for(int i = 0; i < s.length(); i++) {

            int[] freq = new int[128];

            for(int j = i; j < s.length(); j++) {

                freq[s.charAt(j)]++;

                if(isValid(freq, target)) {

                    if(j - i + 1 < minLen) {
                        minLen = j - i + 1;
                        answer = s.substring(i, j + 1);
                    }
                }
            }
        }

        return answer;
    }

    private boolean isValid(int[] freq, int[] target) {

        for(int i = 0; i < 128; i++) {
            if(freq[i] < target[i]) {
                return false;
            }
        }

        return true;
    }
}

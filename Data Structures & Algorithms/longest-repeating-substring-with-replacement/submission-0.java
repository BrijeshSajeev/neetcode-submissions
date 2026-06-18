class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int answer = 0;

        for(int i=0;i<n;i++){
            int[] freq = new int[26];

            for(int j=i;j<n;j++){
                freq[s.charAt(j) - 'A']++;

                int maxFreq = 0;
                for (int f : freq) {
                    maxFreq = Math.max(maxFreq, f);
                }

                int len = j - i + 1;

                if (len - maxFreq <= k) {
                    answer = Math.max(answer, len);
                }
            }
        }

        return answer;
    }
}

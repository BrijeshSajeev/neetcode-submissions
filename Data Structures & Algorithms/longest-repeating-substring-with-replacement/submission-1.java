class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        
        int answer = 0;
        int l = 0;
        int maxFreq = 0;


        for(int r=0;r<n;r++){
            freq[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);

            while((r - l +1) - maxFreq > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            answer = Math.max(answer, r-l+1);
        }

        return answer;
    }
}

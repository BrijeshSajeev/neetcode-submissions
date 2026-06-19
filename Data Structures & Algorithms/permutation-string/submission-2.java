class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Sliding Window
        int n = s1.length();
        int m = s2.length();

        if (n > m) return false;

        int[] target = new int[26]; 
        int[] window = new int[26];

        for(int i=0;i<n;i++){
            target[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        if(matches(target, window)) return true;

        for(int i=n;i<m;i++){
            // add new char
            window[s2.charAt(i) - 'a']++;
            // remove old one
            window[s2.charAt(i-n) - 'a']--;

            if(matches(target, window)) return true;
        }

        return false;
    }

    public boolean matches(int[] t,int[] w){
        for(int i=0;i<26;i++){
            if(t[i] != w[i]) return false;
        }
        
        return true;
    }
}

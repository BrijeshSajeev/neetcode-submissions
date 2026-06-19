class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) return false;

        int[] target = new int[26];

        for (char c : s1.toCharArray()) {
            target[c - 'a']++;
        }

        for (int i = 0; i <= m - n; i++) {
            int[] window = new int[26];

            for (int j = i; j < i + n; j++) {
                window[s2.charAt(j) - 'a']++;
            }

            if (matches(target, window)) {
                return true;
            }
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

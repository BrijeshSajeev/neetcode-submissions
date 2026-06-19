class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Generate every substring of length s1.length() from s2, 
        // sort both strings, and compare them.

        // s1 = "ab"
        // sorted(s1) = "ab"

        // Substrings of length 2 in s2:

        // "ei" -> "ei"
        // "id" -> "di"
        // "db" -> "bd"
        // "ba" -> "ab" ✓

        int n = s1.length();
        int m = s2.length();

        if (n > m) return false;

        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr1);
        String sortedS1 = new String(arr1);

        for (int i = 0; i <= m - n; i++) {
            String sub = s2.substring(i, i + n);


            char[] temp = sub.toCharArray();
            Arrays.sort(temp);

            if (sortedS1.equals(new String(temp))) {
                return true;
            }
        }

        return false;
    }
}

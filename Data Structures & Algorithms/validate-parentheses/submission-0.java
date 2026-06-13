class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case ')':
                    if (st.isEmpty() || st.pop() != '(') return false;
                    break;
                case '}':
                    if (st.isEmpty() || st.pop() != '{') return false;
                    break;
                case ']':
                    if (st.isEmpty() || st.pop() != '[') return false;
                    break;
                default:
                    st.push(c);
                    break;
            }
        }

        // Fix 4: Ensure no unmatched opening brackets remain
        return st.isEmpty();
    }
}

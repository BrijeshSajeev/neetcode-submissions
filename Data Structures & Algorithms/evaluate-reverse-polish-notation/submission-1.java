class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String c : tokens){
            switch (c) {
                case "+":
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a+b);
                    break;
                case "-":
                    int b1 = st.pop();
                    int a1 = st.pop();
                    st.push(a1 - b1);
                    break;
                case "*":
                    int b2 = st.pop();
                    int a2 = st.pop();
                    st.push(a2*b2);
                    break;
                case "/":
                    int b3 = st.pop();
                    int a3 = st.pop();
                    st.push(a3/b3);
                    break;
                default:
                    st.push(Integer.parseInt(c));
            }
        }

        return st.pop();
    }
}

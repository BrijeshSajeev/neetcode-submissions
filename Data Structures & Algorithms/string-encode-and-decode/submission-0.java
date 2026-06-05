class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str : strs){
            sb.append(str.length()).append('#').append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }

            // Convert the length substring into an integer
            int length = Integer.parseInt(str.substring(i, j));

            // Move pointer right past the '#' character
            i = j + 1;
            
            // Extract the actual string using the known length
            String s = str.substring(i, i + length);
            result.add(s);
            
            // Move pointer to the start of the next length prefix
            i += length;
        }

        return result;
    }
}

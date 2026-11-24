
class Solution {

    public String encode(java.util.List<String> strs) {

        StringBuilder encoded = new StringBuilder();

        for (String s : strs) {
            encoded.append(s.length()).append("#").append(s);
        }

        return encoded.toString();
    }

    public java.util.List<String> decode(String str) {

        java.util.List<String> decoded = new java.util.ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            int j = i;

            // Find the separator #
            while (str.charAt(j) != '#') {
                j++;
            }

            // Get the length of the string
            int length = Integer.parseInt(str.substring(i, j));

            // Move past the #
            i = j + 1;

            // Extract the original string
            String word = str.substring(i, i + length);

            decoded.add(word);

            // Move to the next encoded string
            i = i + length;
        }

        return decoded;
    }
}

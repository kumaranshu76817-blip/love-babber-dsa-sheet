public class reverse_string_03 {

    public static String stringReverse(String str) {
        str = str.trim();

        String[] word = str.split("\\s+");

        StringBuilder result = new StringBuilder();

        for (int i = word.length - 1; i >= 0; i--) {
            result.append(word[i]);

            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "my name is anssh";
        System.out.println(stringReverse(str));
    }
}


public class minimumBracketRevesal {

    public int countReversal(String s) {

        if (s.length() % 2 != 0) {
            return -1;
        }

        int open = 0;
        int close = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '{') {
                open++;
            } 
            else if (ch == '}') {

                if (open > 0) {
                    open--;
                } 
                else {
                    close++;
                }
            }
        }

        return (open + 1) / 2 + (close + 1) / 2;
    }

    public static void main(String[] args) {
        minimumBracketRevesal obj = new minimumBracketRevesal();

        System.out.println(obj.countReversal("}{"));     // 2
        System.out.println(obj.countReversal("{{{{"));   // 2
        System.out.println(obj.countReversal("{{{"));    // -1
        System.out.println(obj.countReversal("{{}"));    // -1
        System.out.println(obj.countReversal("}}{{"));   // 2
    }
}

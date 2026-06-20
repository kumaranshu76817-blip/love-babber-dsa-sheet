public class string_compresion {
    public static int compression (char [] chars){
        int readIndex = 0;
        int writeIndex = 0;

        while(readIndex < chars.length){
            char currenChar = chars[readIndex];
            int count = 0;

            while (readIndex < chars.length && currenChar == chars[readIndex]) {
                readIndex++;
                count++;
            }

            chars[writeIndex ] = currenChar;
            writeIndex++;
            
            if(count>1){
                String countstr = String.valueOf(count);
                for(char digit: countstr.toCharArray()){
                    chars[writeIndex] = digit;
                    writeIndex++;
                }
            }
        }
        return writeIndex;
    }

    public static void main(String[] args) {
        char [] s = {'a','a','b','b','c','c','c'};
        System.out.println(compression(s));
    }
}

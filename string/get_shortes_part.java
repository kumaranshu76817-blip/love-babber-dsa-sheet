public class get_shortes_part {
    
    public static float getShortesPart(String str){

        int x =0, y=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 's'){
                y--;
            }
            else if(str.charAt(i) == 'n'){
                y++;
            }
            else if(str.charAt(i) == 'w'){
                x--;
            }
            else{
                x++;
            }
        }

        int x2 = x* x;
        int y2 = y* y;

        return (float) Math.sqrt(x2 + y2);
    }

    public static void main(String[] args) {
        String str = "nnsssnn";
        
        System.out.println(getShortesPart(str));
    }
}

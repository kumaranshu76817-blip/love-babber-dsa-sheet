public class remove_all_occu {
    public  String removeString(String s,String part){
        //kab kat same 2 step karenge
        //jab kat string exist karta hai
        while (s.contains(part)) {
            //search inside part s
            int index = s.indexOf(part);
            //create a new string merging two substring left and right 
            s = s.substring(0,index) + s.substring(index,part.length() );
        }
        return s;
    }
    public static void main(String[] args) {
        String s = "ababxabyabz";
        String part = "ab";
        System.out.println(removeString(s, part));
    }
}

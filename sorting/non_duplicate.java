//in this question i solve a non duplicate element like [10,10,20,20,30,30,40,40,50,60,60] is question ko ham binary search ke theory se solve karenge 

//jaise ki 50 mera answer hai to uska next part starting index odd hoga and ending index even hoga

//also next case jab mera 50 answer hoga to pervious part starting index even hoga  and ending index odd hoga esi ke 

// jiska time complexity O(logn) aata hai is quetion me pahlem ham mid nikala ge phir uska 

//current value mangnege or uske baad 

// ok let start to code 

public class non_duplicate {

    public static int singleNonDuplicate(int[] arr) {
        int n = arr.length;

        int start = 0;
        int end = n - 1;

        // loop ko start karnenge
        // loop mera starting se ending se jayega
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // element ko define karenge

            int currentElement = arr[mid];

            int previousElement = -1;
            if (arr[mid - 1] >= 0) {
                // previous element ko deine karnege
                previousElement = arr[mid - 1];
            }

            int nextElement = -1;
            if (arr[mid + 1] < n) {
                // nextElement ko define karenge
                nextElement = arr[mid + 1];
            }

            // ab hoga surue main concept

            if (currentElement != previousElement && currentElement != nextElement) {
                // yahi mera answer hoga
                return currentElement;
            }

            // next case
            else if (currentElement != previousElement && currentElement == nextElement) {
                int statrinIndex = mid;
                if ((statrinIndex & 1) == 1) {
                    // ans mera right side me hog
                    // move to right
                    end = mid - 1;
                } else {
                    // agar ans nahi mila to
                    // move to left
                    start = mid + 1;
                }
            }

            // also next case
            else {
                if (currentElement == previousElement && currentElement != nextElement) {
                    int endingIndex = mid;
                    // ending index odd hai to hum left me ans hoga
                    if ((endingIndex & 1) == 1) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
           
        }
         return -1;
    }

    public static void main(String[] args) {
        int [] arr = {10,10,20,20,30,30,40,40,50,60,60};
        System.out.println(singleNonDuplicate(arr));
    }
}
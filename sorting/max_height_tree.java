public class max_height_tree {

    static boolean isValidAns(int[] trees, int m, int maxHeight) {
        int totalWoodCoolected = 0;
        for (int i = 0; i < trees.length; i++) {
            if (trees[i] > maxHeight) {
                //iska matlb sawblade overall treehiegh se chota hai 
                //therefore pakka katan par kuch amount pe wood dega
                int currentWoodCollected = trees[i] - maxHeight;
                totalWoodCoolected += currentWoodCollected;
            }

        }
        if (totalWoodCoolected >= m) {
            return true;
        } else {
            return false;
        }

    }

    public static int maxHeightTree(int[] trees, int m) {
        int n = trees.length;
        int start = 0;
        int maxi = -1;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (trees[i] > maxi) {
                maxi = trees[i];
            }
        }
        int end = maxi;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValidAns(trees, m, mid)) {
                // ans store kare
                ans = mid;
                // move to right
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int trees[] = { 20, 15, 10, 17 };
        int m = 7;
        System.out.println(maxHeightTree(trees, m));
    }
}

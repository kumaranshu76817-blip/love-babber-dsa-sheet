
public class N_stack_in_an_array {

    static class Nstack {
        private int[] arr;      // Stores elements of all stacks
        private int[] next;     // Stores next index / link
        private int[] top;      // Top index of each stack
        private int freeSpot;   // First available free index

        public Nstack(int N, int S) {
            arr = new int[S];
            next = new int[S];
            top = new int[N];

            // Initially, every stack is empty
            for (int i = 0; i < N; i++) {
                top[i] = -1;
            }

            // Initially, all array positions are free.
            // Link each free position to the next one.
            for (int i = 0; i < S - 1; i++) {
                next[i] = i + 1;
            }

            // Last position has no next free position
            next[S - 1] = -1;

            // Initially, index 0 is free
            freeSpot = 0;
        }

        // Push an element into the given stack
        public boolean push(int stackNum, int value) {

            // If no free space remains, stack overflow
            if (freeSpot == -1) {
                return false;
            }

            // Get the first available index
            int index = freeSpot;

            // Move freeSpot to the next free index
            freeSpot = next[index];

            // Insert the value into the array
            arr[index] = value;

            // Convert stack number (1-based) to index (0-based)
            int stackIndex = stackNum - 1;

            // Link this element to the previous top
            next[index] = top[stackIndex];

            // Make this element the new top
            top[stackIndex] = index;

            return true;
        }

        // Remove and return the top element of a stack
        public int pop(int stackNum) {

            int stackIndex = stackNum - 1;

            // If stack is empty, nothing to pop
            if (top[stackIndex] == -1) {
                return -1;
            }

            // Get the index of the top element
            int index = top[stackIndex];

            // Save the element before removing it
            int poppedElement = arr[index];

            // Update top to the previous element
            top[stackIndex] = next[index];

            // Add the removed index back to the free list
            next[index] = freeSpot;
            freeSpot = index;

            return poppedElement;
        }

        // Return the index of the top element
        public int top(int stackNum) {
            int stackIndex = stackNum - 1;

            // Empty stack has no top index
            if (top[stackIndex] == -1) {
                return -1;
            }

            // Return the top INDEX (not the stored value)
            return top[stackIndex];
        }

        // Check whether a stack is empty
        public boolean isEmpty(int stackNum) {
            int stackIndex = stackNum - 1;
            return top[stackIndex] == -1;
        }
    }

    // Main method: program execution starts here
    public static void main(String[] args) {

        // Create 3 stacks using a single array of size 6
        Nstack s = new Nstack(3, 6);

        // Push elements into different stacks
        System.out.println("Push 10 into Stack 1: " + s.push(1, 10));
        System.out.println("Push 20 into Stack 1: " + s.push(1, 20));
        System.out.println("Push 30 into Stack 2: " + s.push(2, 30));
        System.out.println("Push 40 into Stack 3: " + s.push(3, 40));

        // Check whether a stack is empty
        System.out.println("Is Stack 1 empty? " + s.isEmpty(1));
        System.out.println("Is Stack 3 empty? " + s.isEmpty(3));

        // Pop elements
        System.out.println("Pop from Stack 1: " + s.pop(1));
        System.out.println("Pop from Stack 2: " + s.pop(2));

        // Check stack after popping
        System.out.println("Pop from Stack 1: " + s.pop(1));
        System.out.println("Is Stack 1 empty? " + s.isEmpty(1));

        // Try popping from an empty stack
        System.out.println("Pop from Stack 1: " + s.pop(1));
    }
}

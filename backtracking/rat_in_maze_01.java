

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class rat_in_maze_01 {

    static boolean isSafeToMove(int newX, int newY, int n, int[][] maze, boolean[][] visted) {
        n = maze.length;

        if (newX < 0 || newX >= n || newY < 0 || newY >= n) {
            return false;
        }

        else if (maze[newX][newY] == 0) {
            return false;
        }

        else if (visted[newX][newY] == true) {
            return false;
        } else {
            return true;
        }

    }

    static void solve(int[][] maze, int srcX, int srcY, int destX, int destY, ArrayList<String> ans, boolean[][] visted,
            String path) {
        if (srcX == destX && srcY == destY) {
            ans.add(path);
            return;
        }

        visted[srcX][srcY] = true;

        int n = maze.length;

        // we go to in four direction
        // up
        int newX = srcX - 1;
        int newY = srcY;
        if (isSafeToMove(newX, newY, n, maze, visted)) {
            // baaki recursion sammabal lega
            solve(maze, newX, newY, destX, destY, ans, visted, path + "u");
        }

        // down

        newX = srcX + 1;
        newY = srcY;
        if (isSafeToMove(newX, newY, n, maze, visted)) {
            solve(maze, newX, newY, destX, destY, ans, visted, path + "d");
        }

        // left

        newX = srcX;
        newY = srcY - 1;
        if (isSafeToMove(newX, newY, n, maze, visted)) {
            solve(maze, newX, newY, destX, destY, ans, visted, path + "l");
        }

        // right
        newX = srcX;
        newY = srcY + 1;
        if (isSafeToMove(newX, newY, n, maze, visted)) {
            solve(maze, newX, newY, destX, destY, ans, visted, path + "r");
        }

        visted[srcX][srcY] = false;

    }

    public ArrayList<String> ratInMaze(int[][] maze) {
        int srcX = 0;
        int srcY = 0;

        int n = maze.length;

        int destX = n - 1;
        int destY = n - 1;

        ArrayList<String> ans = new ArrayList<>();

        boolean[][] visted = new boolean[n][n];

        String path = "";

        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return ans;
        }

        solve(maze, srcX, srcY, destX, destY, ans, visted, path);

        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        rat_in_maze_01 obj = new rat_in_maze_01();

        int[][] maze = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 }
        };

        ArrayList<String> ans = obj.ratInMaze(maze);

        System.out.println("Possible paths:");

        for (String path : ans) {
            System.out.println(path);
        }
    }
}

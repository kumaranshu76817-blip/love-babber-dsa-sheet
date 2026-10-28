
import java.util.ArrayDeque;
import java.util.Deque;

public class design_browser_history {

    static class BrowserHistory {
        Deque<String> currentHistory;
        Deque<String> forwardHistory;

        public BrowserHistory(String homepage) {
            currentHistory = new ArrayDeque<>();
            forwardHistory = new ArrayDeque<>();

            currentHistory.push(homepage);
        }

        // Visit a new website
        public void visit(String url) {
            currentHistory.push(url);

            // Clear forward history
            forwardHistory.clear();
        }

        // Go back
        public String back(int step) {
            while (step > 0 && currentHistory.size() > 1) {
                String backTab = currentHistory.pop();
                forwardHistory.push(backTab);
                step--;
            }

            return currentHistory.peek();
        }

        // Go forward
        public String forw(int step) {
            while (step > 0 && !forwardHistory.isEmpty()) {
                String forwTab = forwardHistory.pop();
                currentHistory.push(forwTab);
                step--;
            }

            return currentHistory.peek();
        }
    }

    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory("google.com");

        browser.visit("youtube.com");
        browser.visit("github.com");
        browser.visit("leetcode.com");

        System.out.println("Current: " + browser.currentHistory.peek());

        System.out.println("Back 1: " + browser.back(1));
        System.out.println("Back 1: " + browser.back(1));

        System.out.println("Forward 1: " + browser.forw(1));

        browser.visit("openai.com");

        System.out.println("Visit new site: " + browser.currentHistory.peek());
        System.out.println("Forward 1: " + browser.forw(1));
    }
}

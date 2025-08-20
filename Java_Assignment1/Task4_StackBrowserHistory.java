import java.util.Stack;

public class Task4_StackBrowserHistory {
    public static void main(String[] args) {
        BrowserHistory bh = new BrowserHistory();
        bh.visitPage("google.com");
        bh.visitPage("youtube.com");
        bh.goBack();
        bh.displayHistory();
        bh.goForward();
        bh.displayHistory();
    }
}

class BrowserHistory {
    private Stack<String> backStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();

    public BrowserHistory() {
        System.out.println("CREATE Time Complexity: O(1)");
    }

    public void visitPage(String url) {
        backStack.push(url);
        forwardStack.clear();
        System.out.println("INSERT Time Complexity: O(1)");
    }

    public void goBack() {
        if (!backStack.isEmpty()) {
            forwardStack.push(backStack.pop());
            System.out.println("DELETE Time Complexity: O(1)");
        } else {
            System.out.println("No pages to go back.");
        }
    }

    public void goForward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(forwardStack.pop());
            System.out.println("DELETE Time Complexity: O(1)");
        } else {
            System.out.println("No pages to go forward.");
        }
    }

    public void displayHistory() {
        System.out.println("Back History: " + backStack);
        System.out.println("Forward History: " + forwardStack);
    }
}

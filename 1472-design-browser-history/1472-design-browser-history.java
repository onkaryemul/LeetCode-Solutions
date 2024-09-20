/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */


// BrowserHistory class to manage the browsing functionality
class BrowserHistory {

    // TC : O(steps), where 'steps' denotes the no. of steps to move backward or forward in the browsing history
    
    // SC : O(N), where N denotes the no. of web pages visited
    
    
    /*  
        Each webpage is represented by a Node object containing the URL and the pointers to the next & previous pages, hence the complexity is proportional to the no. of web pages visited.
    */    
    
    // Node class to represent each web page in browser history
    private static class Node {
        public String url; // stores the URL of the page
        Node next; // pointer to the next page in history
        Node back; // pointer to the previous page in history
        
        // default constructor
        public Node() {
            url = "0";
            next = null;
            back = null;
        }
        
        // Constructor with url
        public Node(String url) {
            this.url = url;
            next = null;
            back = null;
        }
        
        // Constructor with url & pointers
        public Node(String url, Node next, Node back) {
            this.url = url;
            this.next = next;
            this.back = back;
        }    
    }
    
    
    private Node currentPage; // pointer to the current page being viewed
    
    // Construtor to initialize the browser history with a homepage
    public BrowserHistory(String homepage) {
        currentPage = new Node(homepage);
    }
    
    
    // Visit a new page & update the browser history
    public void visit(String url) {
        Node newNode = new Node(url);
        
        newNode.back = currentPage;
        
        currentPage.next = newNode;
        
        currentPage = newNode;
    }
    
    // function to go back a certain number of steps in history
    public String back(int steps) {
        // While there are steps & a previous page exists
        while(steps > 0 && currentPage.back != null) {
            currentPage = currentPage.back;
            steps--;
        }
        return currentPage.url;
    }
    
    
    // function to go forward a certain no. of steps in history
    public String forward(int steps) {
        // While there are steps & a next page exists
        while(steps > 0 && currentPage.next != null) {
            currentPage = currentPage.next;
            steps--;
        }
        
        return currentPage.url;
    }
    
}


/*
class BrowserHistory {
    
    private Stack<String> past;  // Backward history
    private Stack<String> future; // Forward history
    private String curr; // Current page
    
    public BrowserHistory(String homepage) {
        past = new Stack<>();
        future = new Stack<>();
        curr = homepage;
    }
    
    public void visit(String url) {
        past.push(curr);
        curr = url;
        future.clear(); // Clear forward history when a new page is visited
    }
    
    public String back(int steps) {
        while (steps > 0 && !past.isEmpty()) {
            future.push(curr);
            curr = past.pop();
            steps--;
        }
        return curr;
    }
    
    public String forward(int steps) {
        while (steps > 0 && !future.isEmpty()) {
            past.push(curr);
            curr = future.pop();
            steps--;
        }
        return curr;
    }
}
*/


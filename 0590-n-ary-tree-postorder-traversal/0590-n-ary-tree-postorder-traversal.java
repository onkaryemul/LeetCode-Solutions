/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/


class Solution {
    
    // TC : O(n)
    // SC : O(Height of the N-ary tree)
    
    // Using Iterative approach --> By using stack
    // PostOrder traversal : Left - Right - Root
    public List<Integer> postorder(Node root) {
        List<Integer> post = new ArrayList<>();
        
        // Base case
        if(root == null) {
            return post;
        }
        
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.add(root);
        
        while(!stack.isEmpty()) {
            Node curr = stack.pollLast();
            
            post.add(curr.val);
            
            // adding children from left to right 
            // so that on top, right should be popped first
            for(Node child : curr.children) {
                stack.add(child);
            }
        }
        
        Collections.reverse(post);
        
        return post;
    }
    
}


/*   
    // TC : O(n)
    // SC : O(Height of the N-ary tree)
    
    // Using Recursive approach 
    public List<Integer> postorder(Node root) {
        List<Integer> post = new ArrayList<>();
        
        return traverse(root, post);
    }

    // PostOrder traversal : Left - Right - Root
    private List<Integer> traverse(Node root, List<Integer> post) {
        // Base case
        if(root == null) {
            return post;
        }
        
        // traverse children from left to right
        for(Node child : root.children) {
            traverse(child, post);
        }
        
        post.add(root.val);
        
        return post;
    }
*/


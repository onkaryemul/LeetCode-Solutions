/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    
    // TC : O(m * n)
    // SC : O(1), not considering result matrix which we have to return
    
    // Using simple simulation
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        
        // Initialize the matrix with -1
        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }
        
        int top = 0, down = m-1;
        int left = 0, right = n-1;
        
        int dir = 0; // Direction identifier (0 : left -> right, 1 : top -> down, 2 : right -> left, 3 : down -> top)
        
        while(top <= down && left <= right && head != null) {
            if(dir == 0) { // left -> right, keeping row(top) = constant
                for(int col = left; col <= right && head != null; col++) {
                    matrix[top][col] = head.val;
                    head = head.next;
                }
                top++;
            }
            else if(dir == 1) { // top -> down, keeping col(right) = constant
                for(int row = top; row <= down && head != null; row++) {
                    matrix[row][right] = head.val;
                    head = head.next;
                }
                right--;
            }
            else if(dir == 2) { // right -> left, keeping row(down) = constant
                for(int col = right; col >= left && head != null; col--) {
                    matrix[down][col] = head.val;
                    head = head.next;
                }
                down--;
            }
            else if (dir == 3) { // down -> top, keeping col(left) = constant
                for(int row = down; row >= top && head != null; row--) {
                    matrix[row][left] = head.val;
                    head = head.next;
                }
                left++;
            }
            
            dir = (dir + 1) % 4; // Cycle through directions
        }
        
        return matrix;
    }
    
}


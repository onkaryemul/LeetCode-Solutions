class Solution {
    
    // TC : O(obstacles + commands) 
    // SC : O(obstacles)
    
    // Using Simulation
    
    // Function to return the square of maximum euclidean distance that the robot ever gets from the origin (ie. if the max. euclidean distance is 5, return 25)
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Integer> obstacleSet = new HashSet<>();
        
        for(int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + obstacle[1] * 40000); // converting 2D point (x, y) -> 1D integer using Hashing concept
        }
        
        int[][] dirs = {
                         {0, 1}, // North means +Y direction
                         {1, 0}, // East means +X direction
                         {0, -1}, // South means -Y direction
                         {-1, 0} // West means -X direction
                       };  
        
        int res = 0; // stores the maximum square of euclidean distance of robot ever from origin
        
        int x = 0, y = 0; // initial co-ordinates of robot i.e origin (0,0)
        int dir = 0; // initially, robot is facing north ie. dirs[0] = {0, 1} -> North means +Y direction
    
        
        for(int command : commands) {
            if(command == -1) { // command = -1, means "turn right" 90 degrees
                dir = (dir + 1) % 4;
            }
            else if (command == -2) { // command = -2, means "turn left" 90 degrees
                dir = (dir + 3) % 4; // important: To learn left, add (n-1) ie. (4-1) = 3 to curr dir and do modulo by  n ie. 4 
            }
            else {
                int dx = dirs[dir][0];
                int dy = dirs[dir][1];
                
                for(int step=1; step <= command; step++) {
                    int newX = x + dx;
                    int newY = y + dy;
                    
                    if(!obstacleSet.contains(newX + newY * 40000)) {
                        x = newX;
                        y = newY;
                        res = Math.max(res, (x*x + y*y));
                    } 
                    else {
                        break;
                    }
                }
            }
        }
        
        return res;
    }
    
}


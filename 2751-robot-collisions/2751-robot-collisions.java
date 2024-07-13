class Robot {
    int index;
    int position;
    int health;
    char direction;
    
    public Robot(int index, int position, int health, char direction) {
        this.index = index;
        this.position = position;
        this.health = health;
        this.direction = direction;
    }
}


class Solution {
    
    // TC : O(n*logn)
    // SC : O(n)
    
    // Using Simulation steps
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length; // = healths.length or = directions.length()
        
        List<Robot> robots = new ArrayList<>();
        for(int i=0; i < n; i++) {
            robots.add(new Robot(i, positions[i], healths[i], directions.charAt(i)));
        }
        
        robots.sort(Comparator.comparingInt(r -> r.position));
        
        Stack<Robot> stack = new Stack<>();
        for(Robot robot : robots) {
            if(robot.direction == 'R') {
                stack.push(robot);
            }
            else {
                handleCollisions(stack, robot);
            }
        }
        
        
        robots.clear();
        while(!stack.isEmpty()) {
            robots.add(stack.pop());
        }
        
        robots.sort(Comparator.comparingInt(r -> r.index));
        
        List<Integer> ans = new ArrayList<>();
        for(Robot robot : robots) {
            ans.add(robot.health);
        }
        
        return ans;
    }
    
    
    private void handleCollisions(Stack<Robot> stack, Robot robot) {
        while(!stack.isEmpty() && stack.peek().direction == 'R' && stack.peek().health < robot.health) {
            stack.pop();
            robot.health--;
        }
        
        if(!stack.isEmpty() && stack.peek().direction == 'R') {
            if(stack.peek().health == robot.health) {
                stack.pop();
            }
            else {
                stack.peek().health--;
            }
        }
        else {
            stack.push(robot);
        }
    }
    
}


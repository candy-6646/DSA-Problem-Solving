/* Rotting Oranges

So here we need to find min. time to rott all oranges

Using BFS- Putting the current rotten oranges into Queue
        new Pair(i, j, 0);
        the initial pairs in queue is the curr. rotten oranges
        A single rotten orange can make it's neighbours also rotten in 1 unit of time(t->l->b->r)
        And the rotten oranges having same time, can make their neigh. also rotten in the t+1

*/

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        //Approach is we put all rooten oranges in queue to  process them in
        //BFS manner, the last pair.t of Queue is the ans
		Queue<Pair> q = new LinkedList<>();
        int countOfOnesAndTwos = 0;
        
        //putting initial rotten oranges in Q at 0 time
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                }
                
                if(grid[i][j] == 2 || grid[i][j] == 1) 
                    countOfOnesAndTwos++;
            }
        }
        
        Pair prev = null;
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            int t = curr.t;
            countOfOnesAndTwos--;
            
            //left
            if(c-1 >= 0 && grid[r][c-1] == 1) {
                grid[r][c-1] = 2;
                q.add(new Pair(r, c-1, t+1));
            }
            //right
            if(c+1 < m && grid[r][c+1] == 1) {
                grid[r][c+1] = 2;
                q.add(new Pair(r, c+1, t+1));
            }
            //top
            if(r-1 >= 0 && grid[r-1][c] == 1) {
                grid[r-1][c] = 2;
                q.add(new Pair(r-1, c, t+1));
            }
            //bottom
            if(r+1 < n && grid[r+1][c] == 1) {
                grid[r+1][c] = 2;
                q.add(new Pair(r+1, c, t+1));
            }
            prev = curr;
        }
        
        int minutes = 0;
        if(prev != null) minutes = prev.t;
        
        //countOfOnesAndTwos == 0, means now all one's are 2, if not means all 1's are not rotten
        return countOfOnesAndTwos == 0 ? minutes:-1;
        
    }
}

class Pair {
    int r;
    int c;
    int t;
    Pair(int i, int j, int time) {
        r = i;
        c = j;
        t = time;
    }
}
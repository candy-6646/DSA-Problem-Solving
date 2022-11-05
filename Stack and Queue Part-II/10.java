/* The Celebrity Problem	
    Brute Force- O(n^2)
*/

/****************O(n)*****************/
class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
        // if anyOne is celebrity it will remain at last in st
        Stack<Integer> st = new Stack<>();
    	for(int p = 0; p < n; p++) {
    	    st.push(p);
    	}
    	
    	while(st.size() > 1) {
    	    int p1 = st.pop();
    	    int p2 = st.pop();
    	    
    	    //cheking p1 knows p2 or not
    	    if(M[p1][p2] == 1) {
    	        st.push(p2);
    	    }else {
    	        st.push(p1);
    	    }
    	}
    	
    	//In the stack the last person can be our potential answer
    	//let's check that
    	int pot = st.pop();
    	for(int j = 0; j < n; j++) {
    	    if(j == pot) continue;
    	    if(M[pot][j] == 1 || M[j][pot] == 0) return -1;
    	}
    	
    	return pot;
    }
}
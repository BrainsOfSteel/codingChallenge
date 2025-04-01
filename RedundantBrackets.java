class Tuple{
    int expLength;
    char bracket;
    
    Tuple(int x, char c){
        expLength = x;
        bracket = c;
    }
}

public class Solution {
    public int braces(String str) {
        Stack<Tuple> st = new Stack<>();
        int expLength = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '('){
                if(st.size() > 0){
                    st.peek().expLength = expLength;
                    expLength = 0;
                    st.push(new Tuple(expLength, '('));
                }
                else{
                    expLength = 0;
                    st.push(new Tuple(expLength, '('));
                }
            }
            else if(str.charAt(i) == ')'){
                Tuple t = st.pop();
                if(t.expLength == 0){
                    return 1;
                }
                if(st.size() > 0){
                    expLength = st.peek().expLength;
                }
                else{
                    expLength = 0;
                }
            }
            else{
                expLength++;
            }
            
        }
        
        return 0;
        
        
    }
}

//Check for inputs
/*Input 1:

 A = "((a+b))"
Input 2:

 A = "(a+(a+b))"
Input 3:

 A = "((a*b)+(c+d))"
*/

/*
Explanation 1:

 ((a+b)) has redundant braces so answer will be 1.
Explanation 2:

 (a+(a+b)) doesn't have have any redundant braces so answer will be 0.
Explanation 3:

 ((a*b)+(c+d)) doesn't have have any redundant braces so answer will be 0.
*/

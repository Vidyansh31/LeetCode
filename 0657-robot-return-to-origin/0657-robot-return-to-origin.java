class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        
        for(char ch : moves.toCharArray()){
            if(ch == 'U'){
                y -= 1;
            }
            else if(ch == 'D'){
                y += 1;
            }
            else if( ch == 'L'){
                x -= 1;
            }
            else if( ch == 'R'){
                x += 1;
            }
        }
        
        
        return (x == 0 && y == 0 ) ? true : false;
    }
}
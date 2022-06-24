class Solution {
    public int romanToInt(String s) {
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == 'I'){
                num += 1;
            }
            else if(ch == 'V'){
                int j = i-1;
                if(j >= 0 && s.charAt(j) == 'I'){
                    num -= 2;
                }
                num += 5;
            }
            else if(ch == 'X'){
                int j = i-1;
                if(j >= 0 && s.charAt(j) == 'I'){
                    num -= 2;
                }
                num += 10;
            }
            else if(ch == 'L'){
                int j = i-1;
                if(j >= 0 && s.charAt(j) == 'X'){
                    num -= 20;
                }
                num += 50;
            }
            else if(ch == 'C'){
                int j = i-1;
                if(j >= 0 && s.charAt(j) == 'X'){
                    num -= 20;
                }
                num += 100;
            }
            else if(ch == 'D'){
                int j = i-1;
                if(j >= 0 && s.charAt(j) == 'C'){
                    num -= 200;
                }
                num += 500;
            }
            else {
                int j = i-1;
                if(j >= 0 && s.charAt(j) == 'C'){
                    num -= 200;
                }
                num += 1000;
            }
        }
        
        return num;
    }
}
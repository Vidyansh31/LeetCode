class Solution {
    
    public boolean isRobotBounded(String instructions) {
        String currDir = "North";
        int Xo = 0;
        int Yo = 0;
        
        for(int i = 0; i < 4; i++){
            for(char ch : instructions.toCharArray()){
            if(ch == 'G'){
                if(currDir == "North"){
                    Yo += 1;
                }
                else if(currDir == "South"){
                    Yo -= 1;
                }
                else if(currDir == "West"){
                    Xo -= 1;
                }
                else{
                    Xo += 1;
                }
            }
            else if(ch == 'L'){
                if(currDir == "North"){
                    currDir = "West";
                }
                else if(currDir == "South"){
                    currDir = "East";
                }
                else if(currDir == "West"){
                    currDir = "South";
                }
                else{
                    currDir = "North";
                }
            }
            else{
                if(currDir == "North"){
                    currDir = "East";
                }
                else if(currDir == "South"){
                    currDir = "West";
                }
                else if(currDir == "West"){
                    currDir = "North";
                }
                else{
                    currDir = "South";
                }
            }
        }
        }
        
        return Xo == 0 && Yo == 0;
    }
}
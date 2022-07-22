class TextEditor {
     Stack<Character> left = new Stack<>();
     Stack<Character> right = new Stack<>();
    public TextEditor() {
        
    }
    
    public void addText(String text) {
        for(int i = 0; i < text.length(); i++){
            left.push(text.charAt(i));
        }
    }
    
    public int deleteText(int k) {
        int count = 0;
        while(left.size() > 0 && k-- > 0){
            left.pop();
            count++;
        }
        return count;
    }
    
    public String cursorLeft(int k) {
        while(left.size() > 0&&k-- > 0){
            right.push(left.pop());
        }
        
        return Kleft();
    }
    
    public String cursorRight(int k) {
        while(right.size() > 0&&k-- > 0){
            left.push(right.pop());
        }
        
        return Kleft();
    }
    
    public String Kleft(){
        StringBuilder sb = new StringBuilder();
        int k = 0;
        while(left.size() > 0 && k < 10){
            sb.append(left.pop()+"");
            k++;
        }
        
        String s = sb.reverse().toString();
        
        addText(s);
        
        return s;
        
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
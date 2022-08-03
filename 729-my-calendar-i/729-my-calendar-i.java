class MyCalendar {
    List<int[]> events;
    public MyCalendar() {
        events = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] event : events){
            if (event[0] < end && start < event[1]) return false;
        }
        events.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
class MyCalendar {
    // List to store booked intervals
    private List<int[]> events;

    public MyCalendar() {
        // Initialize an empty list to store the events
        events = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        // Check if the new event overlaps with any existing events
        for (int[] event : events) {
            int existingStart = event[0];
            int existingEnd = event[1];
            // Check for overlap
            if (start < existingEnd && end > existingStart) {
                return false; // Overlap found, cannot book the event
            }
        }
        // No overlap, so we can book the event
        events.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
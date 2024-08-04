// You are given timings of n meetings in the form of (start[i], end[i]) where start[i] is the start time of meeting i and end[i] is the finish time of meeting i. Return the maximum number of meetings that can be accommodated in a single meeting room, when only one meeting can be held in the meeting room at a particular time. 

// Note: The start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        // Array to store the meeting timings as pairs of (start, end)
        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }
        
        // Sort the meetings based on their end times
        Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting.end));
        
        // Initialize the count of meetings and the end time of the last selected meeting
        int count = 0;
        int lastEndTime = -1;
        
        // Iterate through the sorted meetings
        for (Meeting meeting : meetings) {
            if (meeting.start > lastEndTime) { // If the start time of the current meeting is after the end time of the last selected meeting
                count++;
                lastEndTime = meeting.end; // Update the end time of the last selected meeting
            }
        }
        
        return count;
    }
    
    // Helper class to store meeting timings
    private class Meeting {
        int start;
        int end;
        
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

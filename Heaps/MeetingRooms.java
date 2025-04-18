package EducativeIO.Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {
    public static int mostBooked(int[][] meetings, int rooms) {

        // Count array to track the number of meetings each room holds
        int[] count = new int[rooms];

        // Create min-heaps for available rooms and used rooms
        PriorityQueue<Integer> available = new PriorityQueue<Integer>();
        PriorityQueue<long[]> usedRooms = new PriorityQueue<long[]>(
                (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));

        // Initialize the available rooms heap
        for (int i = 0; i < rooms; i++) {
            available.offer(i);
        }

        // Sort the meetings by their start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < meetings.length; i++) {
            long start_time = meetings[i][0];
            long end_time = meetings[i][1];

            // Free up rooms that have finished their meetings by the current start time

            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start_time) {
                int room = (int) usedRooms.poll()[1];
                available.offer(room);
            }
            for (int s : available) {
                System.out.println("AVAIL " + s);
            }

            // If no rooms are available, delay the meeting until a room becomes free
            if (available.isEmpty()) {
                long end = usedRooms.peek()[0];
                int room = (int) usedRooms.poll()[1];
                end_time = end + (end_time - start_time);
                available.offer(room);
                System.out.println("end-Time " + end_time);
            }

            // Allocate the meeting to the available room with the lowest number
            int room = available.poll();
            usedRooms.offer(new long[] { end_time, room });
            count[room]++;
            System.out.println("______________________" + room + " " + end_time);
            for (int j = 0; j < count.length; j++) {
                System.out.println("Index " + j + " CountRoom " + count[j]);
            }
        }

        // Room that held the most meetings
        int maxMeetingsRoom = 0;
        for (int i = 1; i < rooms; i++) {
            if (count[i] > count[maxMeetingsRoom]) {
                maxMeetingsRoom = i;
            }
        }

        return maxMeetingsRoom;
    }

    public static void main(String[] args) {
        System.out.print("Result: " + mostBooked(new int[][] { { 0, 5 }, { 1, 6 }, { 4, 7 }, { 7, 8 }, { 8, 9 } }, 2));
    }
}

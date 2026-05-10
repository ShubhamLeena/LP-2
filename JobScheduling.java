package Practical_04;
import java.util.*;

class Job {
    char id;
    int deadline;
    int profit;

    Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobScheduling {

    public static void main(String[] args) {

        Job jobs[] = {
                new Job('A', 2, 100),
                new Job('B', 1, 19),
                new Job('C', 2, 27),
                new Job('D', 1, 25),
                new Job('E', 3, 15)
        };

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        boolean slot[] = new boolean[3];
        char result[] = new char[3];

        for (Job job : jobs) {

            for (int j = Math.min(3, job.deadline) - 1; j >= 0; j--) {

                if (!slot[j]) {
                    slot[j] = true;
                    result[j] = job.id;
                    break;
                }
            }
        }

        System.out.println("Scheduled Jobs:");

        for (char c : result) {
            System.out.print(c + " ");
        }
    }
}
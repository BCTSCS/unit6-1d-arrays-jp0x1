import java.util.Scanner;

public class UserStory {
    private String[] arenaNames;
    private int[] capacities;
    private FileOperator arenaFile;
    private FileOperator capacityFile;

    public UserStory(){
        arenaFile = new FileOperator("./arenas.txt");
        capacityFile = new FileOperator("./capacities.txt");
        arenaNames = arenaFile.toStringArray(30);
        capacities = capacityFile.toIntArray(30);
    }
    public int getMinCapacity(){
        int min = capacities[0];
        String minArena = arenaNames[0];
        for (int i=1;i<capcities.length;i++){
            if (capacities[i] < min) {
                min = capacities[i];
                minArena = arenaNames[i];
            }
        }
        System.out.println("The minimum capacity: " + minArena + "with size: "+ min);
    }
    public int getMaxCapacity(){
        int max = capacities[0];
        String maxArena = arenaNames[0];
        for (int i=1;i<capcities.length;i++){
            if (capacities[i] > max) {
                max = capacities[i];
                maxArena = arenaNames[i];
            }
        }
        System.out.println("The maximum capacity: " + maxArena + "with size: "+ max);
    }
    public double getAvgCapacity(){
        int sum = 0;
        for (int capacity: capacities){
            sum += capacity;
        }
        double avg = (double) sum / capacities.length;
        System.out.println("Average Capacity: " + String.format("%.2f", average));
        return average;
    }
    
    public double getMedianCapacity() {
        
        int[] sortedCapacities = capacities.clone();
        
        linearSort(sortedCapacities);
        
        double median;
        if (sortedCapacities.length % 2 == 0) {
            median = (double)(sortedCapacities[sortedCapacities.length/2] + 
                            sortedCapacities[sortedCapacities.length/2 - 1]) / 2;
        } else {
            median = sortedCapacities[sortedCapacities.length/2];
        }
        System.out.println("Median Capacity: " + String.format("%.2f", median));
        return median;
    }

    
    public int getModeCapacity() {
        int mode = capacities[0];
        int maxCount = 1;
        
        for (int i = 0; i < capacities.length; i++) {
            int count = 0;
            for (int j = 0; j < capacities.length; j++) {
                if (capacities[j] == capacities[i]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mode = capacities[i];
            }
        }
        System.out.println("Mode Capacity: " + mode + " (appears " + maxCount + " times)");
        return mode;
    }

    
    private void linearSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIdx = i;
            
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        UserStory analysis = new UserStory();
        
        
        System.out.println("Arena Capacity Analysis:");
        analysis.getMinCapacity();
        analysis.getMaxCapacity();
        analysis.getAverageCapacity();
        analysis.getMedianCapacity();
        analysis.getModeCapacity();
        
        
        analysis.filterArenasByCapacity(19000);
    }
}
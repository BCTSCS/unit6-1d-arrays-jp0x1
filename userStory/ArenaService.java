public class ArenaService {
    private String[] arenaNames;
    private int[] capacities;
    private FileOperator arenaFile;
    private FileOperator capacityFile;
    
    public ArenaService() {
        arenaFile = new FileOperator("./arenas.txt");
        capacityFile = new FileOperator("./capacities.txt");
        arenaNames = arenaFile.toStringArray(30);
        capacities = capacityFile.toIntArray(30);
    }
    
    public String getMinCapacity() {
        int min = capacities[0];
        String minArena = arenaNames[0];
        for (int i = 1; i < capacities.length; i++) {
            if (capacities[i] < min) {
                min = capacities[i];
                minArena = arenaNames[i];
            }
        }
        return "The minimum capacity: " + minArena + " with size: " + min;
    }
    
    public String getMaxCapacity() {
        int max = capacities[0];
        String maxArena = arenaNames[0];
        for (int i = 1; i < capacities.length; i++) {
            if (capacities[i] > max) {
                max = capacities[i];
                maxArena = arenaNames[i];
            }
        }
        return "The maximum capacity: " + maxArena + " with size: " + max;
    }
    
    public String getAvgCapacity() {
        int sum = 0;
        for (int capacity : capacities) {
            sum += capacity;
        }
        double avg = (double) sum / capacities.length;
        return "Average Capacity: " + avg;
    }
    
    public String getMedianCapacity() {
        int[] sortedCapacities = capacities.clone();
        
        linearSort(sortedCapacities);
        
        double median;
        if (sortedCapacities.length % 2 == 0) {
            median = (double)(sortedCapacities[sortedCapacities.length/2] + 
                            sortedCapacities[sortedCapacities.length/2 - 1]) / 2;
        } else {
            median = sortedCapacities[sortedCapacities.length/2];
        }
        return "Median Capacity: " + median;
    }
    
    public String getModeCapacity() {
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
        return "Mode Capacity: " + mode + " (appears " + maxCount + " times)";
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
    
    public String[] getArenaNames() {
        return arenaNames;
    }
    
    public int[] getCapacities() {
        return capacities;
    }
}
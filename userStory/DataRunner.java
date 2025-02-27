import java.util.Scanner;

public class DataRunner {
  public DataRunner {

  }
  public static String[] arenaByCapacity(int[] capacities, String[] arenas, int capacity, int flip){
    String[] greater = new String[capacities.length];
    String[] lesser = new String[capacities.length];
    // 1 for greater than, 0 for less than
   
    for(int i=0; i < capacities.length; i++){
      if (capacities[i] <= capacity){
        lesser[i] = arenas[i];
      } else {
        greater[i] = arenas[i];
      }
    }
    if (flip == 0){
      return lesser;
    } 
    return greater;
    
  }
  public static void main(String[] args) {
    FileOperator capacities = new FileOperator("./capacities.txt");
    FileOperator arenas = new FileOperator("./arenas.txt");
    input.setFile
  }
}
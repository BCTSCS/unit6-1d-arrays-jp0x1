import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
public class FileOperator {
    private Scanner fileReader;
    private File myFile; 

    public FileOperator(String filename){
        setFile(filename);
    }

    public void setFile(String filename){
        myFile = new File(filename);
        try{
            fileReader = new Scanner(myFile);
        }catch(FileNotFoundException error){
            System.out.println("File not found.");
        }
    }

    public int[] toIntArray(int size){
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = fileReader.nextInt();
        }
        return arr;
    }

    public double[] toDoubleArray(int size){
        double[] arr = new double[size];
        for(int i = 0; i< size; i++){
            arr[i] = fileReader.nextDouble();
        }
        return arr;
    }

    public String[] toStringArray(int size){
        String[] arr = new String[size];
        for(int i = 0; i < size; i++){
            arr[i] = fileReader.nextLine();
        }
        return arr;
    }

    public ArrayList<Integer> toIntList() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (fileReader.hasNextInt()){
            result.add(fileReader.nextInt());
        }
    }
    public ArrayList<String> toStringList() {
        ArrayList<String> result = new ArrayList<String>();
        while (fileReader.hasNextLine()){
            result.add(fileReader.nextLine());
        }
    }
    public ArrayList<Double> toDoubleList() {
        ArrayList<String> result = new ArrayList<String>();
        while (fileReader.hasNextDouble()){
            result.add(fileReader.nextDouble());
        }
    }
}

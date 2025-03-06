import java.io.File;
import java.io.IOException;
import java.util.*;

public class DataAnalyzer {
    public static int[] reverseList(int[] numbers) {
        int[] tempList = new int[numbers.length];
        int index = numbers.length - 1;
        int i = 0;
        while (index >= 0) {
            tempList[i] = numbers[index];
            i++;
            index--;
        }
        return tempList;
    }

    public static int searchList(int target, int[] numbers) {
        int minIndex = 0;
        int maxIndex = numbers.length - 1;
        while (minIndex <= maxIndex) {
            int middleIndex = (minIndex + maxIndex) / 2;
            if (target == numbers[middleIndex]) {
                return middleIndex;
            } else if (target > numbers[middleIndex]) {
                minIndex = middleIndex + 1;
            } else {
                maxIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    public static int searchList(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int getMax(int[] numbers) {
        int maxNum = numbers[0];
        for (int num : numbers) {
            if (num > maxNum) {
                maxNum = num;
            }
        }
        return maxNum;
    }

    public static int getMin(int[] numbers) {
        int minNum = numbers[0];
        for (int num : numbers) {
            if (num < minNum) {
                minNum = num;
            }
        }
        return minNum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(searchList(arr, 5));

        int[] newArr = reverseList(arr);
        for (int num : newArr) {
            System.out.print(num + " ");
        }
        System.out.println("");

        int[] fileArr = new int[100];
        try {
            File f = new File("numbers.txt");
            Scanner scan = new Scanner(f);
            for (int i = 0; i < 100; i++) {
                fileArr[i] = scan.nextInt();
            }
            scan.close();
        } catch (IOException e) {
            System.out.println("File not found.");
        }

        System.out.println(searchList(fileArr, 81));

        System.out.println(searchList(81, fileArr));

        int[] reverseArr = reverseList(fileArr);
        for (int num : reverseArr) {
            System.out.print(num + " ");
        }

        System.out.println("");

        BusinessApp.run();
    }
}

class User {
    private String name;
    private int age;
    private String email;
    private int[] transactions;

    public User() {
        name = "Unknown";
        age = 0;
        email = "Unknown";
        transactions = new int[0];
    }

    public User(String name, int age, String email, int[] transactions) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.transactions = transactions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int[] getTransactions() {
        return transactions;
    }

    public void setTransactions(int[] transactions) {
        this.transactions = transactions;
    }

    public int getMaxTransaction() {
        if (transactions.length == 0) return 0;
        int max = transactions[0];
        for (int num : transactions) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public int getMinTransaction() {
        if (transactions.length == 0) return 0;
        int min = transactions[0];
        for (int num : transactions) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    @Override
    public String toString() {
        return "User: " + name + "\nAge: " + age + "\nEmail: " + email +
               "\nMax Transaction: " + getMaxTransaction() +
               "\nMin Transaction: " + getMinTransaction();
    }
}

class BusinessApp {
    public static void run() {
        System.out.println("----- Running BusinessApp -----\n");

        int[] transactions = {120, 450, 230, 780, 560, 90};

        User user1 = new User("jake park", 18, "jake@example.com", transactions);

        System.out.println(user1);

        user1.setEmail("new_email@example.com");
        System.out.println("\nUpdated User Email: " + user1.getEmail());

        System.out.println("Highest Transaction: " + user1.getMaxTransaction());
        System.out.println("Lowest Transaction: " + user1.getMinTransaction());

        System.out.println("\n----- BusinessApp Execution Completed -----");
    }
}
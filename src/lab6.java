import java.util.Arrays;
import java.util.Random;

public class lab6 {
    public static void main(String[] args) {
        //Scenario 0
        int[] myArr = {4, 8, 15, 16, 23, 42};
        System.out.println("a) Length: " + myArr.length);
        System.out.println("b) First element: " + myArr[0]);
        System.out.println("c) Index of last element: " + (myArr.length - 1));
        System.out.println("d) Third element: " + myArr[2]);
        System.out.println("e) myArr[3]: " + myArr[3]);
        //System.out.println(myArr[10]);
        // Error explanation:
        // java.lang.ArrayIndexOutOfBoundsException: 10
        // This means we're trying to access index 10, which doesn't exist (only 0–5 are valid).

        //Scenario 1
        int[] oldRoster = new int[20];
        for (int i = 0; i < oldRoster.length; i++) {
            oldRoster[i] = 1000 + i;
        }
        System.out.println("Old roster: " + Arrays.toString(oldRoster));
        System.out.println("New Roster: " + Arrays.toString(expandRoster(oldRoster, 1000)));


        //Scenario 2
        Random r = new Random();
        int size = 10 + r.nextInt(11);
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(100);
        }
        System.out.println("Original array: " + Arrays.toString(arr));
        int[] rotated = rotateRight(arr);

        System.out.println("Rotated array: " + Arrays.toString(rotated));

        //Scenario 3
        String[] weatherTypes = {"Sunny", "Cloudy", "Rainy", "Stormy"};
        int counts[] = new int[4];
        int totalDays = 1000000;
        for (int i = 0; i < totalDays; i++) {
            double x = r.nextDouble();

            if (x < 0.4) {
                counts[0]++;
            } else if (x < 0.7) {
                counts[1]++;
            } else if (x < 0.9) {
                counts[2]++;
            } else {
                counts[3]++;
            }
        }
        for (int i = 0; i < weatherTypes.length; i++) {
            double percentage = (counts[i] * 100.0) / totalDays;
            System.out.printf("%s: %d (%.2f%%)%n", weatherTypes[i], counts[i], percentage);
        }
        //Scenario 4
        int[] array = new int[30];
        for(int i = 0; i<array.length ; i++){
            array[i]=r.nextInt(100)+1;
        }
        System.out.println("\nArray:");
        for(int num: array){
            System.out.println(num + " ");
        }
        System.out.println();

        int peakCount = 0;
        int tallestPeak = Integer.MIN_VALUE;

        System.out.println("Peaks: ");
        for(int i = 1;i<array.length-1;i++) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                System.out.println(array[i] + " ");
                peakCount++;
                if (array[i] > tallestPeak) {
                    tallestPeak = array[i];
                }
            }
        }
        System.out.println();
        System.out.println("Total number of peaks:  " + peakCount);
        System.out.println("Tallest peak value: " + tallestPeak);

        // Bonus Scenario
        int sum = 0;
        int [][] quizNotes = new int[5][4];
        for(int i = 0;i<quizNotes.length; i++){
            for(int j = 0;j<quizNotes[i].length;j++){
                quizNotes[i][j] = r.nextInt(0,100);
                System.out.println(quizNotes[i][j]);
                sum+=quizNotes[i][j];
            }
            int quizAverage = sum/4;
            System.out.println("The average of student "+(i+1)+" is "+quizAverage);
            sum = 0;
        }
    }

    //Scenario 1
    public static int[] expandRoster(int[] oldRoster,int newSize){
        int [] newRoster = new int[newSize];
        for (int i = 0 ;i<oldRoster.length;i++){
            newRoster[i] = oldRoster[i];
        }
        return newRoster;
    }
    //Scenario 2
    public static int[] rotateRight(int[] arr) {
        if (arr.length == 0) return arr;

        int last = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
        return arr;
    }

}

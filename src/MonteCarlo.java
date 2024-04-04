import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintStream;


public class MonteCarlo {


    public static void main(String[] args) {
        ArrayList<Double> randomVariables = new ArrayList<>();

        Simulation simulate = new Simulation();
        simulate.generateNormalRandomNumbers(randomVariables, 100000);
        simulate.makeBins(randomVariables, 11);

        print(simulate, randomVariables);
        writeToFile(simulate.makeBins(randomVariables, 11), randomVariables);

    }//end main

    //This method consolidates and prints bins and verification of distribution to console
    public static void print(Simulation simulate, ArrayList<Double> randomVariables) {

        System.out.println("Distribution: ");
        simulate.printBin();

        System.out.println("\n1 Standard Deviations from Mean: " + Metric.verifyDistribution(randomVariables, 0, 1, 1) + "%");
        System.out.println("2 Standard Deviations from Mean: " + Metric.verifyDistribution(randomVariables, 0, 1, 2) + "%");
        System.out.println("3 Standard Deviations from Mean: " + Metric.verifyDistribution(randomVariables, 0, 1, 3) + "%");

    }

    //This method consolidates and prints bins and verification of distribution to file
    public static void writeToFile(int[] bins, ArrayList<Double> arr) {

        String filePath = ("C:\\Users\\arifr\\SDL hw\\HW2\\MonteCarlo\\src\\Gaussian.txt");

        try {
            PrintStream toFile = new PrintStream(filePath);
            toFile.println("Distribution: ");
            for (Integer var : bins) {
                toFile.println(var);
            }
            toFile.println("\n1 Standard Deviations from Mean: " + Metric.verifyDistribution(arr, 0, 1, 1) + "%");
            toFile.println("2 Standard Deviations from Mean: " + Metric.verifyDistribution(arr, 0, 1, 2) + "%");
            toFile.println("3 Standard Deviations from Mean: " + Metric.verifyDistribution(arr, 0, 1, 3) + "%");


        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }


}
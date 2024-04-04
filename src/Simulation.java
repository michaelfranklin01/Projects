import java.util.ArrayList;
import java.util.Random;

public class Simulation {

private int [] bins;


 //This method populates the array with randomly distributed variables with amount specified by the int param.
 public void generateNormalRandomNumbers(ArrayList<Double> arr, int numberOfRandomVariables){

     Random rand = new Random();
    for(int i =0; i<numberOfRandomVariables; i++){

        double normalRandom = rand.nextGaussian();

        arr.add(normalRandom);

    }

 }


    //This method takes a randomly distributed populated array and number of bins
    // and calculates where the number should be distributed.
    // Returns an array with the correct distribution of bins
    public int [] makeBins(ArrayList<Double> arr, int numberOfBins){

     double binRange = (getRange(arr)/numberOfBins);


     double smallest = getMin(arr);


     this.bins = new int [numberOfBins];

     for(Double randValue : arr){

         int index = getBin(binRange, smallest, randValue);

         //adjusting for upper bound case
         if(index == numberOfBins) { index--;}

             this.bins[index]++;

     }

    return this.bins;

    }//end make bin

    //getBin() performs the calculation to find the correct distance from the smallest
    //to place the randomValue in the correct index
    public int getBin(double binSize, double min,  double randomValue){
    return  (int) Math.floor((randomValue - min) / binSize) ;

 }

    //this method prints the bin array and therefore the distribution of the bins
    public void printBin(){
        if (this.bins[0]!= 0) {
            for (Integer var : this.bins) {

                System.out.println(var);
            }
        } else{
            System.out.println("Bins are empty");
        }

    }
    //calculates the smallest value in the array
    public double getMin(ArrayList<Double> arr) {
     double smallest = 0;
     if (!arr.isEmpty()){
         smallest = arr.getFirst();
         for (Double randomValue : arr) {

             if (randomValue < smallest) {
                 smallest = randomValue;
             }
         }
    }
        return smallest;
     }

     //calculates the largest element in the array.
    public double getMax(ArrayList<Double> arr){


     double largest= 0;

        if (!arr.isEmpty()){

            largest = arr.getFirst();
            for (Double randomValue : arr) {

                if (randomValue > largest) {
                    largest = randomValue;
                }
            }
        }
        return largest;
    }
    //calculates and returns a double for the range of values within the array
    public double getRange(ArrayList<Double> arr){

     return (getMax(arr)-getMin(arr));

    }


}

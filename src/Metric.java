import java.util.ArrayList;

public class Metric {


    //this method verifies the distribution that the values follow the formula for a Gaussian distribution.
// 68% of values should fall within 1 standard deviation, 95% percent within 2, and 99% within three.
    public static String verifyDistribution(ArrayList<Double> arr, double mean, double SD,
                                            double numberOfSD) {

        double counter = 0;
        for (Double var : arr) {

            if (var <= (mean + SD * numberOfSD) && var >= (mean - SD * numberOfSD)) {
                counter++;
            }

        }

        double percentage = counter / arr.size() * 100;


        return String.format("%.3f", percentage);


    }


}

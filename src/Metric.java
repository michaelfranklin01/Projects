import java.util.ArrayList;

public class Metric {



public static String verifyDistribution(ArrayList<Double> arr, double mean, double SD,
                                        double numberOfSD){

double counter =0;
    for(Double var: arr){

        if(var <= (mean+SD*numberOfSD) && var >= (mean-SD*numberOfSD)){
            counter++;
        }

    }

    double percentage = counter / arr.size() * 100;



    return String.format("%.3f", percentage);


}




}

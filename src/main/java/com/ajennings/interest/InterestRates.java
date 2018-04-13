package com.ajennings.interest;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class InterestRates {

    private static final Double tierThreeBalance = new Double(5000.00);
    private static final Double tierTwoBalance = new Double(1000.00);
    private static final Double tierOneBalance = new Double(0.00);

    private static final Double tierOneRate = new Double(0.01);
    private static final Double tierTwoRate = new Double(0.02);
    private static final Double tierThreeRate = new Double(0.03);


    private final static LinkedHashMap<Double, Double> interestRateTiers = new LinkedHashMap<>();
    public static final int ROUNDING_SCALE = 2;

    static {
        interestRateTiers.put(tierThreeBalance, tierThreeRate);
        interestRateTiers.put(tierTwoBalance, tierTwoRate);
        interestRateTiers.put(tierOneBalance, tierOneRate);
    }

    protected double calculateInterest(double balance)
    {
        double interestEarned = 0.0;

        // get the balance and use the limit to calculate the remainder, then work out that tier on the remainder
        for (Map.Entry<Double, Double> keySet :interestRateTiers.entrySet())
        {
            double lowerLimit = keySet.getKey().doubleValue();

            if (balance > lowerLimit)
            {
                double amountOverThreshold = balance - lowerLimit;
                interestEarned += roundDouble(amountOverThreshold * keySet.getValue().doubleValue());
                balance -= amountOverThreshold;
            }
        }

        return interestEarned;
    }

    private double roundDouble(double value)
    {
        return new BigDecimal(value).setScale(ROUNDING_SCALE, BigDecimal.ROUND_CEILING).doubleValue();
    }

}

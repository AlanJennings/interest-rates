package com.ajennings.interest;

import org.junit.Test;

import static org.junit.Assert.*;

public class InterestRatesTest {

    InterestRates interestRatesTest = new InterestRates();

    @Test
    public void test_upToOneThousandReturnsTenPounds()
    {
        //Given
        double oneThousandPounds = 1000.00;

        //When
        double outputForOneThousandPounds = interestRatesTest.calculateInterest(oneThousandPounds);

        //Then
        assertEquals("10 pounds for 1000", 10.00, outputForOneThousandPounds, 0);

    }

    @Test
    public void test_upFiftyOnePenceReturnsOnePence()
    {
        //Given
        double fiftyOnePence = 0.51;

        //When
        double outputForFiftyOnePence = interestRatesTest.calculateInterest(fiftyOnePence);

        //Then
        assertEquals("1 pence for 51 pence", 0.01, outputForFiftyOnePence, 0);

    }


    @Test
    public void test_upToFifteenHundredReturnsTwentyPounds()
    {
        //Given
        double fifteenHundredPounds = 1500.00;

        //When
        double outputForFifteenHundredPounds = interestRatesTest.calculateInterest(fifteenHundredPounds);

        //Then
        assertEquals("20 pounds for 1500", 20.00, outputForFifteenHundredPounds, 0);

    }

    @Test
    public void test_upToSixThousandReturnsTwentyPounds()
    {
        //Given
        double sixThousandPounds = 6000.00;

        //When
        double outputForSixThousandPounds = interestRatesTest.calculateInterest(sixThousandPounds);

        //Then
        assertEquals("120 pounds for 6000", 120.00, outputForSixThousandPounds, 0);

    }

    @Test
    public void test_handlingOfNegativeBalance()
    {
        //Given
        double negativeValue = -1000.0;

        //When
        double outputForNegativeBalance = interestRatesTest.calculateInterest(negativeValue);

        //Then
        assertEquals("0 for negative balance", 0.00, outputForNegativeBalance, 0);
    }

    @Test
    public void test_interestOnOnePointTwoMillion()
    {
        //Given
        double onePointTwoMillion = 1200000;

        //When
        double outputForOnePointTwoMillion = interestRatesTest.calculateInterest(onePointTwoMillion);

        //Then
        assertEquals("return on 1,200,000", 35940.00, outputForOnePointTwoMillion, 0);
    }

    @Test
    public void test_fiveYearCompoundInterest_1000()
    {
        //Given
        double oneThousandPounds = 1000;
        int years = 5;

        //When
        double outputFor1000PoundsOver5Years = interestRatesTest.calculateInterest(oneThousandPounds, years);

        //Then
        assertEquals("return on 1000 over 5 years", 52.07, outputFor1000PoundsOver5Years, 0);

    }
}

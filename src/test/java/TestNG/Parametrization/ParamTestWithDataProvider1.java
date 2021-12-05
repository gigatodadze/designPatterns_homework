package TestNG.Parametrization;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParamTestWithDataProvider1 {
    private PrimeNumberChecker primeNumberChecker;

    @BeforeMethod
    public void initialize() {
        primeNumberChecker = new PrimeNumberChecker();
    }

    @DataProvider
    public static Object[] primeNumbers() {
        return new Object[] {2,3,4};
    }

    // This test will run 4 times since we have 5 parameters defined
    @Test(dataProvider = "primeNumbers")
    public void testPrimeNumberChecker(Integer inputNumber) {
        System.out.println(inputNumber + " ");
        //Assert.assertEquals(expectedResult, primeNumberChecker.validate(inputNumber));
    }
}

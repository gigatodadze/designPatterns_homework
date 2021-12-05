package TestNG.Parametrization;

import org.testng.annotations.Test;

public class DataProviderTest2 {
    // This test will run 4 times since we have 5 parameters defined
    @Test(dataProvider = "primeNumbers",dataProviderClass = ParamTestWithDataProvider1.class)
    public void testPrimeNumberChecker(Integer inputNumber) {
        System.out.println(inputNumber + " ");
        //Assert.assertEquals(expectedResult, primeNumberChecker.validate(inputNumber));
    }
}

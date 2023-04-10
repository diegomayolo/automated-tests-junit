import dm.mayolo.entities.Financing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

/**
 *
 * @author dm
 */
public class FinancingTests
{
    @Test
    public void createEntityShouldSucessWhenValidData()
    {
        //Arrange
        double totalAmount = 100000.0;
        double income = 2000.0;
        int months = 80;

        //Assert
        Assertions.assertTrue( new Financing( totalAmount, income, months ) != null );
    }

    @Test
    public void createEntityShouldThrowExceptionWhenInvalidData()
    {
        //Arrange
        double totalAmount = 100000.0;
        double income = 2000.0;
        int months = 20;

        //Assert
        Assertions.assertThrows( IllegalArgumentException.class, () -> new Financing( totalAmount, income, months ) );
    }

    @Test
    public void setTotalAmountShouldSucessWhenValidData()
    {
        //Arrange
        Financing financing = new Financing( 100000.0, 2000.0, 80 );

        //Act
        double expectedValue = 50000.0;
        financing.setTotalAmount( expectedValue );

        //Assert
        Assertions.assertEquals( expectedValue, financing.getTotalAmount() );
    }

    @Test
    public void setTotalAmountShouldThrowExceptionWhenInvalidData()
    {
        //Arrange
        Financing financing = new Financing( 100000.0, 2000.0, 80 );

        //Assert
        Assertions.assertThrows( IllegalArgumentException.class, () -> financing.setTotalAmount( 500000.0 ) );
    }

    @Test
    public void setIncomeShouldSucessWhenValidData()
    {
        //Arrange
        Financing financing = new Financing( 100000.0, 2000.0, 90 );

        //Act
        double expectedValue = 2500.0;
        financing.setIncome( expectedValue );

        //Assert
        Assertions.assertEquals( expectedValue, financing.getIncome() );
    }

    @Test
    public void setIncomeShouldThrowExceptionWhenInvalidData()
    {
        //Arrange
        Financing financing = new Financing( 100000.0, 2000.0, 80 );

        //Assert
        Assertions.assertThrows( IllegalArgumentException.class, () -> financing.setIncome( 1000.0 ) );
    }

    @Test
    public void setMonthsShouldSucessWhenValidData()
    {
        //Arrange
        Financing financing = new Financing( 100000.0, 2000.0, 80 );

        //Act
        int expectedValue = 100;
        financing.setMonths( expectedValue );

        //Assert
        Assertions.assertEquals( expectedValue, financing.getMonths() );
    }

    @Test
    public void setMonthsShouldThrowExceptionWhenInvalidData()
    {
        //Arrange
        Financing financing = new Financing( 100000.0, 2000.0, 80 );

        //Assert
        Assertions.assertThrows( IllegalArgumentException.class, () -> financing.setMonths( 10 ) );
    }

    @Test
    public void calculeEntryShouldSucess()
    {
        // Arrange
        Financing financing = new Financing( 100000.0, 2000.0, 80 );
        double expectedValue = 20000.0;

        // Act
        double entry = financing.entry();

        // Assert
        Assertions.assertEquals( expectedValue, entry );
    }

    @Test
    public void calculeQuotaShouldSucess()
    {
        // Arrange
        Financing financing = new Financing( 100000.0, 2000.0, 100 );
        double expectedValue = 800.0;

        // Act
        double quota = financing.quota();

        // Assert
        Assertions.assertEquals( expectedValue, quota );
    }
}

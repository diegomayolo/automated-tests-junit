import dm.mayolo.Account;
import factory.AccountFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author dm
 */
public class AccountTests
{
    @Test
    public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount()
    {
        // Arrange
        double amount = 200.0;
        double expectedValue = 196.0;
        Account account = AccountFactory.createEmptyAccount();

        // Act
        account.deposit( amount );

        // Assert
        Assertions.assertEquals( expectedValue, account.getBalance() );
    }

    @Test
    public void depositShouldDoNothingWhenNegativeAmount()
    {
        // Arrange
        double amount = -200.0;
        double expectedValue = 0.0;
        Account account = AccountFactory.createAccountWithBalance( expectedValue );

        // Act
        account.deposit( amount );

        // Assert
        Assertions.assertEquals( expectedValue, account.getBalance() );
    }

    @Test
    public void withdrawShouldClearBalanceAndReturnFullBalance()
    {
        // Arrange
        double initialBalance = 200.0;
        double expectedValue = 0.0;
        Account account = AccountFactory.createAccountWithBalance( initialBalance );

        // Act
        double result = account.fullWithdraw();

        // Assert
        Assertions.assertTrue( expectedValue == account.getBalance() );
        Assertions.assertTrue( initialBalance == result );
    }

    @Test
    public void withdrawShouldDecreaseBalanceWhenSufficientAmount()
    {
        // Arrange
        Account account = AccountFactory.createAccountWithBalance( 500.0 );

        // Act
        account.withdraw( 200.0 );

        // Assert
        Assertions.assertEquals( 300.0, account.getBalance() );
    }

    @Test
    public void withdrawShouldThrowExceptionWhenInsufficientAmount()
    {
        // Assert
        Assertions.assertThrows( IllegalArgumentException.class, () ->
        {
            // Arrange
            Account account = AccountFactory.createAccountWithBalance( 200.0 );

            // Act
            account.withdraw( 500.0 );
        } );
    }
}

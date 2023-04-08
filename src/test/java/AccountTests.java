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
}

package factory;

import dm.mayolo.Account;

/**
 *
 * @author dm
 */
public class AccountFactory
{
    /**
     * createAccountEmpty
     *
     * @return Account
     */
    public static Account createEmptyAccount()
    {
        return new Account( 1L, 0.0 );
    }

    /**
     * createAccountWithBalance
     *
     * @param balance double
     * @return Account
     */
    public static Account createAccountWithBalance( double balance )
    {
        return new Account( 1L, balance );
    }
}

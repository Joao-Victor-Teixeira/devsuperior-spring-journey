import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.joaodev.entities.Account;

import factory.AccountFactoty;

public class AccountTests {

    @Test
    public void depositSholdIncreaseBalanceWhenPositiveAmount(){

        double amount = 200.0;
        double expectedValue = 196.0;
        Account acc = AccountFactoty.createEmptyAccount();

        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void depositShouldDoNothingWhenNegativeAmount(){

        double expectedValue = 100.0;
        Account acc = AccountFactoty.createAccount(expectedValue);
        double amount = -200.0;

        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void fullWithdrawShouldClearBalanceAndReturnFullBalance(){

        double expectedValue = 0.0;
        double initialBalance = 800.00;
        Account acc = AccountFactoty.createAccount(initialBalance);
        
        double result = acc.fullWithdraw();

        Assertions.assertEquals(expectedValue, acc.getBalance());
        Assertions.assertTrue(result == initialBalance);
    }

    @Test
    public void withdrawShouldDecreaseBalanceWhenSufficientBalance(){

        Account acc = AccountFactoty.createAccount(800);

        acc.withdraw(500);

        Assertions.assertEquals(300, acc.getBalance());
    }

    @Test
    public void withdrawShouldThrowExcptionWhenIsufficientBallance(){

        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            Account acc = AccountFactoty.createAccount(800);
            acc.withdraw(801);
        });
    }
}

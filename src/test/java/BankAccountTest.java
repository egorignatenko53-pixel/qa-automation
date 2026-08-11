import org.example.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {
    BankAccount account;
    @BeforeEach
    public void setUp() {
        account = new BankAccount(100);
    }
    @Test
    public void testDeposit(){
        account.deposit(50);
        assertEquals(150,account.getBalance());
    }
    @Test
    public void testWithdraw(){
        account.withdraw(50);
        assertEquals(50,account.getBalance());
    }
    @Test
    public void testWithdrawToMuch(){
        assertThrows(IllegalArgumentException.class,()-> account.withdraw(200));
    }

    @Test
    public void testMultiOperations(){
        account.deposit(50);
        account.withdraw(20);
        assertEquals(130,account.getBalance());
    }
}

package bank;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTests {
    public static final String NAME = "test_Bank";
    public static final int CAPACITY = 10;
    private Bank bank;
    private Client client;

    @Before
    public void setUp(){
        bank = new Bank(NAME, CAPACITY);
        client = new Client("test_client");
    }

    @Test(expected = NullPointerException.class)
    public void test_CreatingBank_WithNullName_ShouldThrow() {
        new Bank(null, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void test_CreatingBank_WithEmptyName_ShouldThrow() {
        new Bank(" ", CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CreatingBank_WithNegativityCapacity_ShouldThrow() {
        new Bank(NAME, -1);
    }

    @Test
    public void test_CreatingBank_WithValidArguments_ShouldSucceed(){
        assertEquals(NAME, bank.getName());
        assertEquals(CAPACITY, bank.getCapacity());
    }

    @Test (expected = IllegalArgumentException.class)
    public void  test_addClient_ShouldFailWhen_CapacityReached(){
        Bank bank1=new Bank(NAME, 0);
        bank1.addClient(client);
    }

    @Test
    public void  test_addClient_Should_Correctly_Increase_ClientsCount(){
        bank.addClient(client);
        assertEquals(1, bank.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_RemoveClient_ShouldFail_WhenMissing(){
        bank.removeClient(client.getName());
    }

    @Test
    public void test_RemoveClient_Should_Decrease_ClientsCount(){
        bank.addClient(client);
        bank.removeClient(client.getName());
        assertEquals(0, bank.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_LoanWithdraw_ShouldFail_WhenMissing(){
        bank.loanWithdrawal(client.getName());
    }

    @Test
    public void test_LoanWithdraw_Should_Set_Client_Not_Approved(){
        bank.addClient(client);
        bank.loanWithdrawal(client.getName());
        assertFalse(client.isApprovedForLoan());
    }

}


import org.junit.Before;
import org.junit.Test;


import javax.crypto.interfaces.PBEKey;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class ChainblockImplTest {

    private ChainblockImpl database;
    private List<Transaction> transactions;

    @Before
    public void setUp() {
        database = new ChainblockImpl();
        transactions = createTransactions();

    }

    private List<Transaction> createTransactions() {
        return List.of(new TransactionImpl(1, TransactionStatus.UNAUTHORIZED, "Ivan", "Kaloqn", 67.89),
                new TransactionImpl(2, TransactionStatus.FAILED, "Peter", "Sofia", 100.89),
                new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "John", "Ann", 55.55),
                new TransactionImpl(4, TransactionStatus.UNAUTHORIZED, "Kaloyan", "Martin", 78.00),
                new TransactionImpl(5, TransactionStatus.UNAUTHORIZED, "Ivan", "John", 10.56)
        );
    }

    private void fillDatabase() {
        for (Transaction transaction : transactions) {
            database.add(transaction);
        }
    }


    //GET_COUNT
    @Test
    public void test_getCount_NoneEmptyDatabase() {
        fillDatabase();
        assertEquals(5, database.getCount());
    }

    @Test
    public void test_getCount_EmptyDatabase() {
        database = new ChainblockImpl();
        assertEquals(0, database.getCount());
    }

    //ADD
    @Test
    public void test_AddTransaction_Success() {
        Transaction expectedTransaction = transactions.get(0);
        database.add(expectedTransaction);
        Transaction actualTransaction = database.getById(expectedTransaction.getId());

        assertEquals("Transaction not incorrect!", expectedTransaction, actualTransaction);
        assertEquals("Count is incorrect!", 1, database.getCount());
    }

    @Test
    public void test_AddTransaction_Duplicated_ShouldNotAdd() {
        Transaction transaction = transactions.get(0);
        database.add(transaction);
        database.add(transaction);

        assertEquals("Count is incorrect!", 1, database.getCount());
    }

    //CONTAINS
    @Test
    public void test_ContainsTransaction_Exists() { //should return TRUE
        Transaction transaction1 = transactions.get(0);
        database.add(transaction1);

        assertTrue(String.format("Transaction with id %d does not exist!", transaction1.getId()), database.contains(transaction1.getId())); // contains (int id)
        assertTrue(String.format("Transaction with id %d does not exist!", transaction1.getId()), database.contains(transaction1));    // contains (TRANSACTION transaction)
    }

    @Test
    public void test_ContainsTransaction_DoesNotExists() { //should return FALSE
        Transaction transaction1 = transactions.get(0);
        assertFalse(database.contains(transaction1.getId()));
        assertFalse(database.contains(transaction1));
    }

    //CHANGE_TRANSACTION_STATUS
    @Test
    public void test_ChangeTransactionStatus_Transaction_Exists() {
        fillDatabase();
        database.changeTransactionStatus(1, TransactionStatus.SUCCESSFUL);

        assertEquals(TransactionStatus.SUCCESSFUL, database.getById(1).getStatus());
    }


    @Test(expected = IllegalArgumentException.class)
    public void test_ChangeTransactionStatus_Transaction_NonExist() {
        fillDatabase();
        database.changeTransactionStatus(100, TransactionStatus.FAILED);
    }

    //REMOVE_TRANSACTION_BY_ID
    @Test
    public void test_RemoveTransaction_Exists() {
        fillDatabase();
        database.removeTransactionById(1);

        assertEquals(4, database.getCount());
        assertFalse(database.contains(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveTransaction_NonExist() {
        fillDatabase();
        database.removeTransactionById(50);
    }

    //GET_BY_ID
    @Test
    public void test_GetById_Transaction_Exists() {
        fillDatabase();
        Transaction actualTransaction = database.getById(1);

        assertEquals(1, actualTransaction.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetById_Transaction_NonExist() {
        fillDatabase();
        database.getById(100);
    }

    //GET_BY_TRANSACTION_STATUS
    @Test
    public void test_GetByTransactionStatus_Exists() {
        fillDatabase();
        List<Transaction> result = new ArrayList<>();

        database.getByTransactionStatus(TransactionStatus.UNAUTHORIZED)
                .forEach(result::add);

        Transaction transaction1 = result.get(0);
        Transaction transaction2 = result.get(1);
        Transaction transaction3 = result.get(2);

        assertEquals(4, transaction1.getId());
        assertEquals(1, transaction2.getId());
        assertEquals(5, transaction3.getId());

        result.forEach(transaction -> assertEquals(TransactionStatus.UNAUTHORIZED, transaction.getStatus()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetByTransactionStatus_NonExists() {
        fillDatabase();
        database.getByTransactionStatus(TransactionStatus.ABORTED);

    }

    //GET_BY_SENDERS_WITH_TRANSACTION_STATUS
    @Test
    public void test_GetBySendersWithTransactionStatus_Exist() {
        fillDatabase();

        database.getByTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetBySendersWithTransactionStatus_NonExist() {
        fillDatabase();

        database.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    //GET_ALL_SENDERS_WITH_TRANSACTION_STATUS
    @Test
    public void test_GetAllSendersWithTransactionStatus_Exist() {
        fillDatabase();

        Iterable<String> transactions = database.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
        List<String> senders = StreamSupport.stream(transactions.spliterator(), false).collect(Collectors.toList());

        String sender1 = senders.get(0);
        String sender2 = senders.get(1);
        String sender3 = senders.get(2);

        assertEquals("Ivan" , sender1);
        assertEquals("Ivan", sender2);
        assertEquals("Kaloyan", sender3);

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetAllSendersWithTransactionStatus_NonExist() {
        fillDatabase();

        database.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
    }
}

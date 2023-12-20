package p01_Database;


import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;


public class DatabaseTest {
    public static final Integer[] EXPECTED_ELEMENTS = {1, 2, 3, 4, 5};
    public static final int EXPECTED_LENGTH = EXPECTED_ELEMENTS.length;
    public static final int EXPECTED_INDEX = EXPECTED_LENGTH - 1;
    public static final Integer EXPECTED_LAST_ELEMENT = EXPECTED_ELEMENTS[3];
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(EXPECTED_ELEMENTS);
    }

    @Test
    public void test_Constructor_Should_Create_CorrectObject() throws OperationNotSupportedException {

        Integer[] actualElements = database.getElements();
        int actualSize = actualElements.length;
        int actualIndex = actualSize - 1;

        assertEquals(EXPECTED_ELEMENTS, actualElements);
        assertEquals(EXPECTED_LENGTH, actualSize);
        assertEquals(EXPECTED_INDEX, actualIndex);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Constructor_ShouldThrowException_WhenElements_AreGreater_Than16() throws OperationNotSupportedException {
        Integer[] elements = new Integer[17];
        database = new Database(elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Constructor_ShouldThrowException_WhenElementsAreZero() throws OperationNotSupportedException {
        database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Add_Null_ShouldThrow() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void test_Add_Number_OnTheLastPosition_ofDatabase() throws OperationNotSupportedException {
        database.add(7);
        Integer[] elements = database.getElements();
        int actualSize = elements.length;

        assertEquals(Integer.valueOf(7), elements[actualSize - 1]);

    }

    @Test
    public void test_Add_ShouldIncreaseSize_WhenAddElement() throws OperationNotSupportedException {
        database.add(7);
        Integer[] elements = database.getElements();
        int actualSize = elements.length;

        assertEquals(EXPECTED_LENGTH + 1, actualSize);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Remove_ShouldThrow_WhenDatabaseEmpty() throws OperationNotSupportedException {
        for (int i = 0; i <= EXPECTED_LENGTH; i++) {
            database.remove();

        }
    }

    @Test
    public void test_Remove_ShouldRemove_Successfully() throws OperationNotSupportedException {

        database.remove();
        Integer[] elements = database.getElements();
        Integer actualLastElement = elements[elements.length - 1];

        assertEquals(EXPECTED_LAST_ELEMENT, actualLastElement);
    }

    @Test
    public void test_Remove_Should_DecreaseSize_When_RemoveElement() throws OperationNotSupportedException {

        database.remove();
        int actualSize = database.getElements().length;

        assertEquals(EXPECTED_LENGTH - 1, actualSize);
    }


}

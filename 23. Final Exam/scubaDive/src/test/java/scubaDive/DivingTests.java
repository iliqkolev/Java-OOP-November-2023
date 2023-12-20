package scubaDive;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.print.attribute.standard.MediaSize;

import static org.junit.Assert.*;

public class DivingTests {

    public static final String NAME = "Ivan";
    public static final int CAPACITY = 10;
    public static final int OXYGEN = 5;
    private Diving diving;
    private DeepWaterDiver deepWaterDiver;

    @Before
    public void setUp(){
        this.diving = new Diving(NAME, CAPACITY);
        this.deepWaterDiver = new DeepWaterDiver(NAME, OXYGEN);

    }

    @Test (expected = NullPointerException.class)
    public void test_CreatingDiving_WithNullName_ShouldThrow(){
        new Diving(null, CAPACITY);
    }

    @Test (expected = NullPointerException.class)
    public void test_CreatingDiving_WithEmptyName_ShouldThrow(){
        new Diving("   ", CAPACITY);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_CreatingDiving_WithNegativityCapacity_ShouldThrow(){
        new Diving(NAME, -1);
    }

    @Test
    public void test_CreatingDiving_WithValidArguments_ShouldSucceed(){
        assertEquals(NAME, diving.getName());
        assertEquals(CAPACITY, diving.getCapacity());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_addDeepWaterDiver_ShouldFailWhen_CapacityReached(){
        Diving diving1 = new Diving(NAME, 0);
        diving1.addDeepWaterDiver(deepWaterDiver);
    }

    @Test
    public void test_addDeepWaterDiver_ShouldCorrectly_Increase_CapacityCount(){
        diving.addDeepWaterDiver(deepWaterDiver);
        assertEquals(1, diving.getCount());
    }


}

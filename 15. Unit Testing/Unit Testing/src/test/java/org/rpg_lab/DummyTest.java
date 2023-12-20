package org.rpg_lab;

import org.junit.Before;
import org.junit.Test;

import java.security.spec.ECParameterSpec;

import static org.junit.Assert.*;

public class DummyTest {
    private static final int HEALTH = 100;
    private static final int EXPERIENCE = 200;
    private static final int ATTACK = 10;
    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void setUp() {
        this.dummy = new Dummy(HEALTH, EXPERIENCE);
        this.deadDummy = new Dummy(0, EXPERIENCE);
    }

    @Test
    public void test_Dummy_LoseHealth_WhenAlive_And_Attacked() {
        dummy.takeAttack(ATTACK);
        assertEquals(HEALTH - ATTACK, dummy.getHealth());
    }

    @Test (expected = IllegalStateException.class)
    public  void test_Dummy_CannotBeAttacked_WhenDead(){
        deadDummy.takeAttack(ATTACK);
    }

    @Test
    public void test_Dummy_GivesExperience_WhenDead(){
        int actualXP = deadDummy.giveExperience();
        assertEquals(EXPERIENCE, actualXP);
    }

    @Test(expected = IllegalStateException.class)
    public void test_Dummy_GivesExperience_Throws_WhenAlive(){
        dummy.giveExperience();
    }

    @Test
    public void test_Dummy_IsDead_WhenHealth_isZero(){
        assertTrue(deadDummy.isDead());
    }

    @Test
    public void test_Dummy_IsDead_WhenHealth_isBelowZero(){
         assertTrue(new Dummy(-1,1).isDead());
    }

    @Test
    public void test_Dummy_IsAlive_WhenHealth_isAboveZero(){
        assertFalse(new Dummy(1,1).isDead());
    }

}
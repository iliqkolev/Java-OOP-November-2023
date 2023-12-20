package org.rpg_lab;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HeroTest {
    private static final int EXPERIENCE=200;

    @Test
    public void test_Hero_Gets_Experience_When_TargetDies(){
        Weapon weapon= mock(Weapon.class);

        Target target = mock(Target.class);

        when(target.isDead()).thenReturn(true);
        when(target.giveExperience()).thenReturn(EXPERIENCE);

        org.rpg_lab.Hero hero=new org.rpg_lab.Hero("Pointer", weapon);

        hero.attack(target);

        assertEquals(EXPERIENCE, hero.getExperience());

    }

}
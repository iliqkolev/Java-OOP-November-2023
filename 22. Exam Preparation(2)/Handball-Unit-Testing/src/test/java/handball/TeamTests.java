package handball;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTests {

    public static final String NAME = "test_unit";
    public static final int POSITION = 1;
    private Team team;
    private HandballPlayer handballPlayer;

    @Before
    public void setUp(){
        team = new Team(NAME, POSITION);
        handballPlayer = new HandballPlayer("test_handballPlayer");
    }


    @Test (expected = NullPointerException.class)
    public void test_CreatingTeam_WithNullName_ShouldThrow(){
        new Team(null, POSITION);
    }

    @Test (expected = NullPointerException.class)
    public void test_CreatingTeam_WithEmptyName_ShouldThrow(){
        new Team("  ", 5);
    }


    @Test (expected =  IllegalArgumentException.class)
    public void test_CreatingTeam_WithNegativityPosition_ShouldThrow(){
        new Team(NAME, -5);
    }

    @Test
    public void test_CreatingTeam_WithValidArguments_Successfully(){
        assertEquals(NAME, team.getName());
        assertEquals(POSITION, team.getPosition());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_addHandBallPlayer_ShouldFailWhen_CapacityReached(){
        Team team1 = new Team(NAME, 0);
        team1.add(handballPlayer);
    }

    @Test
    public void test_addHandBallPlayer_Should_Correctly_Increase_HandBallPlayersCount(){
        team.add(handballPlayer);
        assertEquals(1, team.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_RemoveHandBallPlayer_ShouldFail_WhenMissing(){
        team.remove(team.getName());
    }

    @Test
    public void test_RemoveHandBallPlayer_Should_Decrease_ClientsCount(){
        team.add(handballPlayer);
        team.remove(handballPlayer.getName());
        assertEquals(0, team.getCount());
    }

    @Test (expected =  IllegalArgumentException.class)
    public void test_playerForAnotherTeam_ShouldFail_WhenMissing(){
        team.playerForAnotherTeam(team.getName());
    }

    @Test
    public void test_playerForAnotherTeam_Should_Set_HandBallPlayer_Not_Active(){
        team.add(handballPlayer);
        team.playerForAnotherTeam(handballPlayer.getName());
        assertFalse(handballPlayer.isActive());
    }


}

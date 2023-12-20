import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public  Team(String name){
        this.name=name;
        this.players=new ArrayList<>();
    }

    public void setName(String name) {
        Validator.validateString(name,"Name cannot be empty");
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void addPlayer(Player player){
        players.add(player);
    }

    public void  removePlayer(String name){
        boolean isRemoved = players.removeIf(player -> player.getName().equals(name));
        if (!isRemoved){
            throw new IllegalArgumentException("Player " + name + " is not in " + this.name + " team.");
        }
    }

    public double getRating(){
             return players.stream().mapToDouble( Player::overallSkill).average().orElse(0.00);
    }
}

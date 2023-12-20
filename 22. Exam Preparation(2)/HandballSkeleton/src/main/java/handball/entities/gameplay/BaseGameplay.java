package handball.entities.gameplay;

import handball.common.StringUtils;
import handball.entities.equipment.Equipment;
import handball.entities.team.Team;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static handball.common.ExceptionMessages.GAMEPLAY_NAME_NULL_OR_EMPTY;

public class BaseGameplay implements Gameplay {
    private String name;
    private int capacity;
    private Collection<Equipment> equipments;
    private Collection<Team> teams;


    public BaseGameplay(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.equipments = new ArrayList<>();
        this.teams = new ArrayList<>();
    }


    @Override
    public int allProtection() {
        return equipments.stream()
                         .mapToInt(Equipment::getProtection)
                         .sum();
    }

    @Override
    public void addTeam(Team team) {
        teams.add(team);
    }

    @Override
    public void removeTeam(Team team) {
        teams.remove(team);
    }

    @Override
    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    @Override
    public void teamsInGameplay() {
        this.teams.forEach(Team::play);
    }

    @Override
    public Collection<Team> getTeam() {
        return Collections.unmodifiableCollection(this.teams);
    }

    @Override
    public Collection<Equipment> getEquipments() {
        return  Collections.unmodifiableCollection(this.equipments);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (StringUtils.NullOrWhiteSpace(name)){
            throw new NullPointerException(GAMEPLAY_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();

        String team = this.teams.isEmpty() ? "Team: none" : "Team:";

        sb.append(this.name).append(" ").append(this.getClass().getSimpleName());
        sb.append(System.lineSeparator());
        sb.append(team);
        this.teams.forEach(t -> sb.append(" " + t.getName()));
        sb.append(System.lineSeparator());
        sb.append("Equipment: ")
        .append(this.equipments.size())
        .append(", ")
        .append("Protection: ")
        .append(allProtection());

        return sb.toString();
    }
}

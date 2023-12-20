package SortByNameAndAge_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstTeam;
    private List<Person> reverseTeam;

    public Team(String name) {
        setName(name);
        this.firstTeam=new ArrayList<>();
        this.reverseTeam=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
    }

    public List<Person> getReverseTeam() {
        return Collections.unmodifiableList(reverseTeam);
    }

    public void addPlayer(Person person){
        if (person.getAge() < 40){
            firstTeam.add(person);
        }else{
            reverseTeam.add(person);
        }
    }

}

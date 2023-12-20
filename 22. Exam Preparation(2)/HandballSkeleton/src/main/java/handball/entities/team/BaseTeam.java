package handball.entities.team;

import handball.common.StringUtils;

import static handball.common.ExceptionMessages.*;

public abstract class BaseTeam implements Team{
    private String name;
    private String country;
    private int advantage;

    public BaseTeam(String name, String country, int advantage) {
        setName(name);
        setCountry(country);
        setAdvantage(advantage);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (StringUtils.NullOrWhiteSpace(name)){
            throw new NullPointerException(TEAM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (StringUtils.NullOrWhiteSpace(country)){
            throw new NullPointerException(TEAM_COUNTRY_NULL_OR_EMPTY);
        }
        this.country = country;
    }

    @Override
    public int getAdvantage() {
        return advantage;
    }

    public void setAdvantage(int advantage) {
        if (advantage <= 0){
            throw new IllegalArgumentException(TEAM_ADVANTAGE_BELOW_OR_EQUAL_ZERO);
        }
        this.advantage = advantage;
    }
}

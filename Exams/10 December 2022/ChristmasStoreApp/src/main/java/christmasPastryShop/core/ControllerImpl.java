package christmasPastryShop.core;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.common.enums.DelicacyType;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import static christmasPastryShop.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static christmasPastryShop.common.OutputMessages.DELICACY_ADDED;

public class ControllerImpl implements Controller {
    private final DelicacyRepository<Delicacy> delicacyRepository;
    private final CocktailRepository<Cocktail> cocktailRepository;
    private final BoothRepository<Booth> boothRepository;
    private double totalIncome;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
        this.totalIncome = 0;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = delicacyRepository.getByName(name);
        if (delicacy == null) {
            DelicacyType foodType = DelicacyType.valueOf(type);
            switch (foodType) {
                case Gingerbread:
                    delicacy = new Gingerbread(name, price);
                    break;
                case Stolen:
                    delicacy = new Stolen(name, price);
                    break;
            }
        } else {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, delicacy.getClass().getSimpleName(), name));

        }
        delicacyRepository.add(delicacy);
        return String.format(DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail= cocktailRepository.getByName(name);

        return null;
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        //TODO
        return null;
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        //TODO
        return null;
    }

    @Override
    public String leaveBooth(int boothNumber) {
        //TODO
        return null;
    }

    @Override
    public String getIncome() {
        //TODO
        return null;
    }
}

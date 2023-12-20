package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CocktailRepositoryImpl implements CocktailRepository{
    private Collection<Cocktail> cocktails;

    public CocktailRepositoryImpl(Collection<Cocktail> models) {
        this.cocktails = new ArrayList<>();
    }

    @Override
    public Object getByName(String name) {
        return this.cocktails.stream().filter(cocktail ->  cocktail.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Cocktail> getAll() {
        return Collections.unmodifiableCollection(this.cocktails);
    }

    @Override
    public void add(Object o) {
        this.cocktails.add((Cocktail) o);
    }
}

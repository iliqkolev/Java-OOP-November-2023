package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DelicacyRepositoryImpl implements DelicacyRepository{
    private Collection<Delicacy> delicacies;

    public DelicacyRepositoryImpl() {
        this.delicacies = new ArrayList<>();
    }

    @Override
    public Object getByName(String name) {
        return this.delicacies.stream().filter(delicacy -> delicacy.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableCollection(this.delicacies);
    }

    @Override
    public void add(Object o) {
        this.delicacies.add((Delicacy) o);
    }
}

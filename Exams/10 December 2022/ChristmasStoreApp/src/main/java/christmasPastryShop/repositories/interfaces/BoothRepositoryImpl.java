package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.booths.interfaces.Booth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BoothRepositoryImpl implements BoothRepository{
    private Collection<Booth> booths;

    public BoothRepositoryImpl() {
        this.booths = new ArrayList<>();
    }

    @Override
    public Object getByNumber(int number) {
        Booth booth = booths.stream().filter(b -> b.getBoothNumber() == number).findFirst().orElse(null);
        return booth;
    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableCollection(this.booths);
    }

    @Override
    public void add(Object o) {
        this.booths.add((Booth) o);
    }

}

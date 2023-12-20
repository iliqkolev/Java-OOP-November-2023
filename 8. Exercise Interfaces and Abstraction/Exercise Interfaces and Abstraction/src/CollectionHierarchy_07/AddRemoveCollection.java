package CollectionHierarchy_07;

public class AddRemoveCollection extends Collection implements AddRemovable{
    @Override
    public String remove() {
        return super.removeLast();
    }

    @Override
    public int add(String item) {
        super.addFirst(item);
        return 0;
    }
}

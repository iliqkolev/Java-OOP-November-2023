package CollectionHierarchy_07;

public class AddCollection extends Collection implements Addable{
    @Override
    public int add(String item) {
        super.addItems(item);
        return super.getItems().size() - 1;
    }
}

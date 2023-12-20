package CollectionHierarchy_07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Collection {
    private int maxSize;
    private List<String> items;

    public Collection() {
        this.items = new ArrayList<>();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public List<String> getItems() {
        return Collections.unmodifiableList(this.items);
    }
    public void addItems(String item){
        this.items.add(item);
    }
    public void addFirst(String item){
        this.items.add(0,item);
    }
    public String removeFirst(){
        return this.items.remove(0);
    }
    public String removeLast(){
        return this.items.remove(this.items.size() - 1);
    }
}

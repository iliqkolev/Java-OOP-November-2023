

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private Map<String, Product> products;
    public Instock(){
        this.products=new LinkedHashMap<>();
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public boolean contains(Product product) {
        return contains(product.getLabel());
    }

    private boolean contains(String label){
        return products.containsKey(label);
    }

    @Override
    public void add(Product product) {
    products.put(product.getLabel(), product);
    }

    @Override
    public void changeQuantity(String label, int quantity) {
        if (!contains(label)){
            throw new IllegalArgumentException();
        }

        Product product = products.get(label);
        product.setQuantity(quantity);
    }

    @Override
    public Product find(int index) {
        return products.values().stream()
                .skip(index)
                .findFirst()
                .orElseThrow(IndexOutOfBoundsException::new);
    }

    @Override
    public Product findByLabel(String label) {
        Product product = products.get(label);
        if (product == null){
            throw  new IllegalArgumentException();
        }

        return product;
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        return products.values().stream().sorted(Comparator.comparing(Product::getLabel))
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return products.values().stream()
                .filter( p -> p.getPrice() > lo && p.getPrice() <= hi)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return products.values().stream()
                .filter(p -> p.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (products.size() < count){
            return new ArrayList<>();
        }

        return products.values().stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return products.values().stream()
                .filter(p -> p.getQuantity() == quantity)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return products.values().iterator();
    }
}

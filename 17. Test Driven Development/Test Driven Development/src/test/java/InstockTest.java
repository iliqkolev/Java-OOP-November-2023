import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class InstockTest {
    public static final String LABEL = "test_label";
    public static final double PRICE = 15.00;
    public static final int QUANTITY = 10;
    public static final double DUPLICATED_PRICE = 13.99;
    public static final double BEGIN = 32.99;
    public static final double END = 99.99;

    private Instock instock;
    private Product product;

    @Before
    public void setUp() {
        this.instock = new Instock();
        this.product = new Product(LABEL, PRICE, QUANTITY);
    }

    @Test
    public void test_Contains_Returns_CorrectResult() {
        instock.add(product);
        assertTrue(instock.contains(product));
        assertFalse(instock.contains(new Product("not_added", PRICE, QUANTITY)));
    }

    @Test
    public void test_Returns_CorrectResult() {
        assertEquals(0, instock.getCount());
        instock.add(product);
        assertEquals(1, instock.getCount());
    }

    @Test
    public void test_ChangeQuantity_AppliesNewQuantity_When_ProductPresent() {
        instock.add(product);
        int expectedQuantity = QUANTITY * 2;
        instock.changeQuantity(product.getLabel(), expectedQuantity);
        assertEquals(expectedQuantity, product.getQuantity());

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_ChangeQuantity_Throws_When_ProductNotPresent() {
        instock.changeQuantity(product.getLabel(), QUANTITY);
    }

    @Test
    public void test_FindByIndex_ShouldReturn_ProductInInsertionOrder() {
        List<Product> products = addProducts();
        int index = 3;
        String expectedLabel = products.get(index).getLabel();
        Product product = instock.find(index);

        assertNotNull(product);

        String actualLabel = product.getLabel();
        assertEquals(expectedLabel, actualLabel);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_FindByIndex_ShouldThrow_When_IndexOutOfBounds() {
        instock.find(instock.getCount() + 1);
    }

    @Test
    public void test_FindByLabel_Should_Return_ProductWithMatchingLabel() {
        instock.add(product);
        Product foundProduct = instock.findByLabel(product.getLabel());
        assertNotNull(foundProduct);
        assertEquals(product.getLabel(), foundProduct.getLabel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_FindByLabel_Throw_WhenLabelIsMissing() {
        instock.findByLabel(product.getLabel());
    }

    @Test
    public void test_FindFirstByAlphabeticalOrder_ShouldReturn_CorrectCountProduct() {
        int count = addProducts().size() - 2;
        List<Product> products = toList(instock.findFirstByAlphabeticalOrder(count));
        assertEquals(count, products.size());
    }

    @Test
    public void test_FindFirstByAlphabeticalOrder_ShouldReturn_ProductsOrderByLabel() {
        List<Product> expectedProducts = addProducts().stream().sorted(Comparator.comparing(Product::getLabel)).collect(Collectors.toList());
        List<Product> actualProducts = toList(instock.findFirstByAlphabeticalOrder(expectedProducts.size()));
        assertProductsListEqual(expectedProducts, actualProducts);

    }


    @Test
    public void test_FindFirstByAlphabeticalOrder_ShouldReturn_EmptySet_When_CountIsTooLarge() {
        List<Product> products = toList(instock.findFirstByAlphabeticalOrder(1));
        assertTrue(products.isEmpty());
    }

    @Test
    public void test_FindAllInRange_ShouldReturn_CorrectRange() {
        addProducts();
        List<Product> products = toList(instock.findAllInRange(BEGIN, END));
        products.stream()
                .mapToDouble(Product::getPrice)
                .forEach(p -> assertTrue(p > BEGIN && p <= END));
    }

    @Test
    public void test_FindAllInRange_ShouldReturnIn_DescendingOrder() {
        double begin = 32.99;
        double end = 99.99;
        List<Product> expectedProducts = addProducts()
                .stream()
                .filter(p -> p.getPrice() > begin && p.getPrice() <= end)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());
        List<Product> actualProducts = toList(instock.findAllInRange(begin, end));
        assertProductsListEqual(expectedProducts, actualProducts);
    }

    @Test
    public void test_FindAllInRange_ShouldReturn_EmptySet_When_NoneMatches() {
        double maxPrice = addProducts().stream()
                .mapToDouble(Product::getPrice)
                .max()
                .orElse(0.00);

        List<Product> products = toList(instock.findAllInRange(maxPrice, maxPrice + 1));
        assertTrue(products.isEmpty());
    }


    @Test
    public void test_FindAllByPrice_ShouldReturn_MatchingPricesOnly() {
        addProducts();
        List<Product> products = toList(instock.findAllByPrice(DUPLICATED_PRICE));
        products.forEach(p -> assertEquals(DUPLICATED_PRICE, p.getPrice(), 0.00));
    }

    @Test
    public void test_FindAllByPrice_ShouldReturn_EmptySet_When_NoMatches() {
        addProducts();
        List<Product> products = toList(instock.findAllByPrice(100));
        assertTrue(products.isEmpty());
    }


    @Test
    public void test_FindAllByQuantity_ShouldReturn_MatchingQuantityOnly() {
        addProducts();
        List<Product> products = toList(instock.findAllByQuantity(QUANTITY));
        products.forEach(p -> assertEquals(QUANTITY, p.getQuantity()));
    }

    @Test
    public void test_FindAllByQuantity_ShouldReturn_EmptySet_When_NoMatches() {
        addProducts();
        List<Product> products = toList(instock.findAllByQuantity(100));
        assertTrue(products.isEmpty());
    }


    @Test
    public void test_findFirstMostExpensiveProducts_ShouldReturn_CorrectCountOfProducts() {
        addProducts();
        int count = 3;
        List<Product> products = toList(instock.findFirstMostExpensiveProducts(count));
        assertEquals(count, products.size());
    }


    @Test
    public void test_findFirstMostExpensiveProducts_ShouldReturn_MostExpensiveProducts() {
        int count = 3;
        List<Product> expectedProducts = addProducts().stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(count)
                .collect(Collectors.toList());
        List<Product> actualProducts = toList(instock.findFirstMostExpensiveProducts(count));
        assertEquals(expectedProducts.size(), actualProducts.size());
        for (int e = 0; e < expectedProducts.size(); e++) {
            double expectedPrice = expectedProducts.get(e).getPrice();
            double actualPrice = actualProducts.get(e).getPrice();
            assertEquals(expectedPrice, actualPrice, 0.00);
        }
    }

    @Test
    public void test_findFirstMostExpensiveProducts_ShouldReturn_EmptySet_IfCountIsLargerThanSize() {
        int size = addProducts().size();
        List<Product> products = toList(instock.findFirstMostExpensiveProducts(size + 1));
        assertTrue(products.isEmpty());
    }


    @Test
    public void test_Iterator_ReturnsAllProducts(){
        List<Product> expectedProducts = addProducts();
        Iterator<Product> iterator = instock.iterator();
        assertNotNull(iterator);
        Iterable<Product> iterable = () -> iterator;
        List<Product> actualProducts = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
        assertProductsListEqual(expectedProducts, actualProducts);
    }





















    private static void assertProductsListEqual(List<Product> expectedProducts, List<Product> actualProducts) {
        assertEquals(expectedProducts.size(), actualProducts.size());

        for (int i = 0; i < expectedProducts.size(); i++) {
            String expectedLabel = expectedProducts.get(i).getLabel();
            String actualLabel = actualProducts.get(i).getLabel();
            assertEquals(expectedLabel, actualLabel);
        }
    }

    private List<Product> addProducts() {
        List<Product> products = List.of(
                new Product("test_label_1", DUPLICATED_PRICE, 50),
                new Product("test_label_3", 14.50, QUANTITY),
                new Product("test_label_6", BEGIN, QUANTITY),
                new Product("test_label_4", 69.69, 50),
                new Product("test_label_7", DUPLICATED_PRICE, QUANTITY),
                new Product("test_label_2", 32.79, 50),
                new Product("test_label_5", END, 50),
                new Product("test_label_8", 9.99, 50)
        );

        products.forEach(instock::add);

        return products;
    }


    private List<Product> toList(Iterable<Product> iterable) {
        assertNotNull(iterable);
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

}

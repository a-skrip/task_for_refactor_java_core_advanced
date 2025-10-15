package repository;

import exceptions.ProductNotFoundException;
import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemsRepository {
    private final static List<Item> items = new ArrayList<>();

    public static List<Item> getAllItems() {
        return Collections.unmodifiableList(items);
    }

    public static Boolean addItem(Item item) {
        return items.add(item);
    }

    public static Boolean remove(Item item) {
        return items.remove(item);
    }

    public static Item findItemByArticle(String article) {
        return items.stream().filter(item -> item.getArticle().equals(article))
                .findFirst().orElseThrow(() -> new ProductNotFoundException("Товар с указанным артикулом не найден"));
    }
}

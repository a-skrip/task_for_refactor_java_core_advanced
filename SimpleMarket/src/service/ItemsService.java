package service;

import enums.ItemType;
import exceptions.ProductNotFoundException;
import model.*;
import repository.ItemsRepository;

import java.util.Scanner;

public class ItemsService {
    private final Scanner scanner = new Scanner(System.in);

    public void loadItem() {
        System.out.println("Введите номер товара: ");
        Integer itemType = scanner.nextInt();
        Item item = createNewItem(itemType);

        System.out.println("Введите артикул товара: ");
        String article = scanner.next();
        item.setArticle(article);

        addItemToRepo(item);
    }

    private Item createNewItem(Integer itemType) {
        return switch (ItemType.getByNumber(itemType)) {
            case KNIFE -> new Knife();
            case CHAIR -> new Chair();
            case PLATE -> new Plate();
            default -> throw new ProductNotFoundException("Товара с таким номером не существует");
        };
    }

    public void addItemToRepo(Item item) {
        ItemsRepository.addItem(item)
        System.out.printf("Товар с артикулом %s добавлен на склад \n", item.getArticle());
    }

    public void getAll() {
        System.out.println(ItemsRepository.getAllItems());
    }

    public Boolean remove() {
        System.out.println("Введите артикул товара: ");
        String article = scanner.next();
        Item item = ItemsRepository.findItemByArticle(article);
        return ItemsRepository.remove(item);
    }

    public void change() {
        System.out.println("Введите текущий артикул:");
        String currentArticle = scanner.next();
        Item item = ItemsRepository.findItemByArticle(currentArticle);

        System.out.println("Введите новый артикул:");
        String newArticle = scanner.next();
        item.setArticle(newArticle);

        System.out.printf("Артикул изменен с %s на %s", currentArticle, newArticle);
    }
}

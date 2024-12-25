import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }

    static List<Object> goods = new ArrayList<>();

    private enum goodsType {
        KNIFE(1),
        PLATE(2),
        TABLE(3),
        CHAIR(4);

        goodsType(int inventNumber) {
            this.inventNumber = inventNumber;
        }

        public Integer getInventNumber() {
            return inventNumber;
        }

        private final Integer inventNumber;
    }

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input) {
                case "/load":
                    Object objectToAdd;
                    System.out.println("Введите номер товара: ");
                    Integer input1 = scanner.nextInt();
                    if (input.equals(goodsType.KNIFE.getInventNumber())) {
                        objectToAdd = new Knife();
                    } else if (input.equals(goodsType.PLATE.getInventNumber())) {
                        objectToAdd = new Plate();
                    } else if (input.equals(goodsType.CHAIR.getInventNumber())) {
                        objectToAdd = new Chair();
                    } else {
                        objectToAdd = null;
                    }

                    System.out.println("Введите артикул товара: ");
                    String input2 = scanner.nextLine();

                    if (objectToAdd instanceof Knife) {
                        ((Knife) objectToAdd).setArticle(input2);
                    } else if (objectToAdd instanceof Plate) {
                        ((Plate) objectToAdd).setArticle(input2);
                    } else if (objectToAdd instanceof Chair) {
                        ((Chair) objectToAdd).setArticle(input2);
                    }

                    goods.add(input1);
                    System.out.println("Товар добавлен в корзину");
                case "/getAll": {
                    System.out.println(Arrays.asList(goods));
                }
                case "/remove": {
                    System.out.println("Введите артикул товара: ");
                    input1 = scanner.nextInt();

                    for (Object obj : goods) {
                        if (obj instanceof Knife) {
                            if(((Knife) obj).getArticle().equals(input1)) {
                                goods.remove(obj);
                                System.out.println("Товар с артикулом " + ((Knife) obj).getArticle() + " удален");
                            }
                        }
                        if (obj instanceof Plate) {
                            if(((Plate) obj).getArticle().equals(input1)) {
                                goods.remove(obj);
                                System.out.println("Товар с артикулом " + ((Plate) obj).getArticle() + " удален");
                            }
                        }
                        if (obj instanceof Chair) {
                            if(((Chair) obj).getArticle().equals(input1)) {
                                goods.remove(obj);
                                System.out.println("Товар с артикулом " + ((Chair) obj).getArticle() + " удален");
                            }
                        }
                    }
                }
                case "/change": {
                    System.out.println("Введите текущий артикул:");
                    String x = scanner.nextLine();
                    for (Object obj : goods) {
                        if (obj instanceof Knife) {
                            if(((Knife) obj).getArticle().equals(x)) {
                                ((Knife) obj).setArticle(x);
                                System.out.println("Артикул изменен на " + x);
                            }
                        }
                        if (obj instanceof Plate) {
                            if(((Plate) obj).getArticle().equals(x)) {
                                ((Plate) obj).setArticle(x);
                                System.out.println("Артикул изменен на " + x);
                            }
                        }
                        if (obj instanceof Chair) {
                            if(((Chair) obj).getArticle().equals(x)) {
                                ((Chair) obj).setArticle(x);
                                System.out.println("Артикул изменен на " + x);
                            }
                        }
                    }
                }
            }
        }
    }
}
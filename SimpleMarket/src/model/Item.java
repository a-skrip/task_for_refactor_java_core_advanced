package model;

public abstract class Item {
    private String article;

    public Item() {

    }

    @Override
    public String toString() {
        return "Товар: " + this.getClass().getSimpleName() + " Артикул: " + article + "\n";
    }

    public Item(String article) {
        this.article = article;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}

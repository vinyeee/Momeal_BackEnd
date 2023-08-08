package dev.likelion.momeal.dto;

public class MenuDto {
    private Long id;
    private String title;
    private int price;
    private String picture;
    private int amount;
    private int boardId;

    public MenuDto() {
    }

    public MenuDto(Long id, String title, int price, String picture, int amount, int boardId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.picture = picture;
        this.amount = amount;
        this.boardId = boardId;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "MenuDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                ", amount=" + amount +
                ", boardId=" + boardId +
                '}';
    }
}

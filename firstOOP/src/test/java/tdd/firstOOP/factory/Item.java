package tdd.firstOOP.factory;

public class Item {

    private int itemNum;
    private String itemName;
    private static Item item;

    public Item(int itemNum, String itemName) {
        this.itemNum = itemNum;
        this.itemName = itemName;
    }

    public static Item of(int itemNum, String itemName) {
        Item.item = new Item(itemNum, itemName);
        return Item.item;
    }
}

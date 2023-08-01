package tdd.firstOOP.factory;

import java.util.List;

public class Question {

    private int qId;
    private String qName;
    private List<Item> items;

    public Question(int qId, String qName, List<Item> items) {
        this.qId = qId;
        this.qName = qName;
        this.items = items;
    }
}

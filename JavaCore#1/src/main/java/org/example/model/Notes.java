package org.example.model;

public class Notes {

    private String id = "";
    private String head;
    private String text;

    public Notes(String head, String text) {
        this("", head, text);
    }

    public Notes(String id, String head, String text) {
        this.id = id;
        this.head = head;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return  "id='" + id + '\'' +
                ", head='" + head + '\'' +
                ", text='" + text ;
    }
}

package com.example.sweater.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Message extends BaseEntity{
    @Column(name = "text")
    private String text;
    @Column(name = "tag")
    private String tag;


    public Message(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }

    public Message() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Message message = (Message) o;
        return Objects.equals(getId(), message.getId()) &&
                Objects.equals(getText(), message.getText()) &&
                Objects.equals(getTag(), message.getTag());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getText(), getTag());
    }
}

package com.example.hibernatetests.data.bears.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "BEAR_TOY")
public class BearToy {

    @EmbeddedId
    private BearToyPK embeddedId;

    @Column
    private String name;

    public BearToyPK getEmbeddedId() {
        return embeddedId;
    }

    public void setEmbeddedId(BearToyPK embeddedId) {
        this.embeddedId = embeddedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BearToy bearToy = (BearToy) o;

        if (embeddedId != null ? !embeddedId.equals(bearToy.embeddedId) : bearToy.embeddedId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return embeddedId != null ? embeddedId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BearToy{" +
                "embeddedId=" + embeddedId +
                ", name='" + name + '\'' +
                '}';
    }
}

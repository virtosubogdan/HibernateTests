package com.example.hibernatetests.data.bears.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "BABY_BEAR")
public class BabyBear {

    @EmbeddedId
    private BabyBearPK embeddedId;

    @Column
    private String name;

    @OneToMany(mappedBy = "embeddedId.babyBear", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BearToy> bearToys = new LinkedHashSet<>();

    @OneToMany(mappedBy = "babyBear")
    private Set<DeerFriend> deerFriends;

    public BabyBearPK getEmbeddedId() {
        return embeddedId;
    }

    public void setEmbeddedId(BabyBearPK embeddedId) {
        this.embeddedId = embeddedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BearToy> getBearToys() {
        return bearToys;
    }

    public void setBearToys(Set<BearToy> bearToys) {
        this.bearToys = bearToys;
    }

    public Set<DeerFriend> getDeerFriends() {
        return deerFriends;
    }

    public void setDeerFriends(Set<DeerFriend> deerFriends) {
        this.deerFriends = deerFriends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BabyBear babyBear = (BabyBear) o;

        if (embeddedId != null ? !embeddedId.equals(babyBear.embeddedId) : babyBear.embeddedId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return embeddedId != null ? embeddedId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BabyBear{" +
                "embeddedId=" + embeddedId +
                ", name='" + name + '\'' +
                ", bearToys=" + bearToys +
                '}';
    }
}

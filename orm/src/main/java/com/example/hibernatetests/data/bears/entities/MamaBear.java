package com.example.hibernatetests.data.bears.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "MAMA_BEAR")
public class MamaBear {

    @EmbeddedId
    private MamaBearPK embeddedId;

    @Column
    private String name;

    @OneToMany(mappedBy = "embeddedId.mamaBear", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BabyBear> babyBears = new LinkedHashSet<>();

    public MamaBearPK getEmbeddedId() {
        return embeddedId;
    }

    public void setEmbeddedId(MamaBearPK embeddedId) {
        this.embeddedId = embeddedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BabyBear> getBabyBears() {
        return babyBears;
    }

    public void setBabyBears(Set<BabyBear> babyBears) {
        this.babyBears = babyBears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MamaBear mamaBear = (MamaBear) o;

        if (embeddedId != null ? !embeddedId.equals(mamaBear.embeddedId) : mamaBear.embeddedId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return embeddedId != null ? embeddedId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MamaBear{" +
                "embeddedId=" + embeddedId +
                ", name='" + name + '\'' +
                '}';
    }
}

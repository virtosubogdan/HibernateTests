package com.example.hibernatetests.data.bears.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "PAPA_BEAR")
public class PapaBear {

    @EmbeddedId
    private PapaBearPK embeddedId;

    @Column
    private String name;

    @OneToMany(mappedBy="embeddedId.papaBear", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<MamaBear> mamaBears = new LinkedHashSet<MamaBear>();

    public PapaBearPK getEmbeddedId() {
        return embeddedId;
    }

    public void setEmbeddedId(PapaBearPK embeddedId) {
        this.embeddedId = embeddedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MamaBear> getMamaBears() {
        return mamaBears;
    }

    public void setMamaBears(Set<MamaBear> mamaBears) {
        this.mamaBears = mamaBears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PapaBear papaBear = (PapaBear) o;

        if (embeddedId != null ? !embeddedId.equals(papaBear.embeddedId) : papaBear.embeddedId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return embeddedId != null ? embeddedId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PapaBear{" +
                "embeddedId=" + embeddedId +
                ", name='" + name + '\'' +
                '}';
    }
}

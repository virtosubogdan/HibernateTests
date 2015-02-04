package com.example.hibernatetests.data.bears.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by bogdan.virtosu on 04.02.2015.
 */
@Entity
@Table(name = "PAPA_BEAR")
public class PapaBear {

    @EmbeddedId
    private PapaBearPK embeddedId;

    public PapaBearPK getEmbeddedId() {
        return embeddedId;
    }

    public void setEmbeddedId(PapaBearPK embeddedId) {
        this.embeddedId = embeddedId;
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
                '}';
    }
}

package com.example.hibernatetests.data.bears.entities;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class BabyBearPK implements Serializable {

    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name = "BEAR_CONTEXT_ID", referencedColumnName = "BEAR_CONTEXT_ID"),
            @JoinColumn(name = "PAPA_BEAR_ID", referencedColumnName = "PAPA_BEAR_ID"),
            @JoinColumn(name = "MAMA_BEAR_ID", referencedColumnName = "MAMA_BEAR_ID")
    })
    private MamaBear mamaBear;

    @Column(name = "BABY_BEAR_ID")
    private Long babyBearId;

    public MamaBear getMamaBear() {
        return mamaBear;
    }

    public void setMamaBear(MamaBear mamaBear) {
        this.mamaBear = mamaBear;
    }

    public Long getBabyBearId() {
        return babyBearId;
    }

    public void setBabyBearId(Long babyBearId) {
        this.babyBearId = babyBearId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BabyBearPK that = (BabyBearPK) o;

        if (babyBearId != null ? !babyBearId.equals(that.babyBearId) : that.babyBearId != null) return false;
        if (mamaBear != null ? !mamaBear.equals(that.mamaBear) : that.mamaBear != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mamaBear != null ? mamaBear.hashCode() : 0;
        result = 31 * result + (babyBearId != null ? babyBearId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BabyBearPK{" +
                "mamaBear=" + mamaBear +
                ", babyBearId=" + babyBearId +
                '}';
    }
}

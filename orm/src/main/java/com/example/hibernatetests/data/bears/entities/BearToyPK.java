package com.example.hibernatetests.data.bears.entities;


import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class BearToyPK implements Serializable {

    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name = "BEAR_CONTEXT_ID", referencedColumnName = "BEAR_CONTEXT_ID"),
            @JoinColumn(name = "PAPA_BEAR_ID", referencedColumnName = "PAPA_BEAR_ID"),
            @JoinColumn(name = "MAMA_BEAR_ID", referencedColumnName = "MAMA_BEAR_ID"),
            @JoinColumn(name = "BABY_BEAR_ID", referencedColumnName = "BABY_BEAR_ID")
    })
    private BabyBear babyBear;

    @Column(name="BEAR_TOY_ID")
    private Long bearToyId;

    public BabyBear getBabyBear() {
        return babyBear;
    }

    public void setBabyBear(BabyBear babyBear) {
        this.babyBear = babyBear;
    }

    public Long getBearToyId() {
        return bearToyId;
    }

    public void setBearToyId(Long bearToyId) {
        this.bearToyId = bearToyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BearToyPK bearToyPK = (BearToyPK) o;

        if (babyBear != null ? !babyBear.equals(bearToyPK.babyBear) : bearToyPK.babyBear != null) return false;
        if (bearToyId != null ? !bearToyId.equals(bearToyPK.bearToyId) : bearToyPK.bearToyId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = babyBear != null ? babyBear.hashCode() : 0;
        result = 31 * result + (bearToyId != null ? bearToyId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BearToyPK{" +
                "babyBear=" + babyBear +
                ", bearToyId=" + bearToyId +
                '}';
    }
}

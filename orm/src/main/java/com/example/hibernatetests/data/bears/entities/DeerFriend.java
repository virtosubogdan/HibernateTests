package com.example.hibernatetests.data.bears.entities;

import javax.persistence.*;

@Entity(name = "DEER_FRIEND")
public class DeerFriend {

    @Id
    @Column(name = "DEER_ID")
    private Long deerId;

    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name = "BEAR_CONTEXT_ID", referencedColumnName = "BEAR_CONTEXT_ID"),
            @JoinColumn(name = "PAPA_BEAR_ID", referencedColumnName = "PAPA_BEAR_ID"),
            @JoinColumn(name = "MAMA_BEAR_ID", referencedColumnName = "MAMA_BEAR_ID"),
            @JoinColumn(name = "BABY_BEAR_ID", referencedColumnName = "BABY_BEAR_ID")
    })
    private BabyBear babyBear;

    public Long getDeerId() {
        return deerId;
    }

    public void setDeerId(Long deerId) {
        this.deerId = deerId;
    }

    public BabyBear getBabyBear() {
        return babyBear;
    }

    public void setBabyBear(BabyBear babyBear) {
        this.babyBear = babyBear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeerFriend that = (DeerFriend) o;

        if (deerId != null ? !deerId.equals(that.deerId) : that.deerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return deerId != null ? deerId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "DeerFriend{" +
                "deerId=" + deerId +
                ", babyBear=" + babyBear +
                '}';
    }
}

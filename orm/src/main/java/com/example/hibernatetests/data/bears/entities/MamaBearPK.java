package com.example.hibernatetests.data.bears.entities;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class MamaBearPK implements Serializable {

    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name = "BEAR_CONTEXT_ID", referencedColumnName = "BEAR_CONTEXT_ID"),
            @JoinColumn(name = "PAPA_BEAR_ID", referencedColumnName = "PAPA_BEAR_ID")
    })
    private PapaBear papaBear;

    @Column(name = "MAMA_BEAR_ID")
    private Long mamaBearId;

    public PapaBear getPapaBear() {
        return papaBear;
    }

    public void setPapaBear(PapaBear papaBear) {
        this.papaBear = papaBear;
    }

    public Long getMamaBearId() {
        return mamaBearId;
    }

    public void setMamaBearId(Long mamaBearId) {
        this.mamaBearId = mamaBearId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MamaBearPK that = (MamaBearPK) o;

        if (mamaBearId != null ? !mamaBearId.equals(that.mamaBearId) : that.mamaBearId != null) return false;
        if (papaBear != null ? !papaBear.equals(that.papaBear) : that.papaBear != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = papaBear != null ? papaBear.hashCode() : 0;
        result = 31 * result + (mamaBearId != null ? mamaBearId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MamaBearPK{" +
                "papaBear=" + papaBear +
                ", mamaBearId=" + mamaBearId +
                '}';
    }
}

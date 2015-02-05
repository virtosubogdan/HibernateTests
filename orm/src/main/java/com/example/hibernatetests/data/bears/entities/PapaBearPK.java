package com.example.hibernatetests.data.bears.entities;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class PapaBearPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "BEAR_CONTEXT_ID", referencedColumnName = "BEAR_CONTEXT_ID")
    private BearContext bearContext;

    @Column(name = "PAPA_BEAR_ID")
    private Long papaBearId;

    public BearContext getBearContext() {
        return bearContext;
    }

    public void setBearContext(BearContext bearContext) {
        this.bearContext = bearContext;
    }

    public Long getPapaBearId() {
        return papaBearId;
    }

    public void setPapaBearId(Long papaBearId) {
        this.papaBearId = papaBearId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PapaBearPK that = (PapaBearPK) o;

        if (bearContext != null ? !bearContext.equals(that.bearContext) : that.bearContext != null) return false;
        if (papaBearId != null ? !papaBearId.equals(that.papaBearId) : that.papaBearId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bearContext != null ? bearContext.hashCode() : 0;
        result = 31 * result + (papaBearId != null ? papaBearId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PapaBearPK{" +
                "bearContext=" + bearContext +
                ", papaBearId=" + papaBearId +
                '}';
    }
}

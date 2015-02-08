package com.example.hibernatetests.data.bears.to;

import java.util.HashSet;
import java.util.Set;

public class MamaBearTO {

    private Long bearContextId;

    private Long papaBearId;

    private Long mamaBearId;

    private String name;

    private Set<BabyBearTO> babyBearTOs = new HashSet<>();

    public MamaBearTO() {
    }

    public MamaBearTO(Long bearContextId, Long papaBearId, Long mamaBearId, String name) {
        this.bearContextId = bearContextId;
        this.papaBearId = papaBearId;
        this.mamaBearId = mamaBearId;
        this.name = name;
    }

    public Long getBearContextId() {
        return bearContextId;
    }

    public void setBearContextId(Long bearContextId) {
        this.bearContextId = bearContextId;
    }

    public Long getPapaBearId() {
        return papaBearId;
    }

    public void setPapaBearId(Long papaBearId) {
        this.papaBearId = papaBearId;
    }

    public Long getMamaBearId() {
        return mamaBearId;
    }

    public void setMamaBearId(Long mamaBearId) {
        this.mamaBearId = mamaBearId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BabyBearTO> getBabyBearTOs() {
        return babyBearTOs;
    }

    public void setBabyBearTOs(Set<BabyBearTO> babyBearTOs) {
        this.babyBearTOs = babyBearTOs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MamaBearTO that = (MamaBearTO) o;

        if (bearContextId != null ? !bearContextId.equals(that.bearContextId) : that.bearContextId != null)
            return false;
        if (mamaBearId != null ? !mamaBearId.equals(that.mamaBearId) : that.mamaBearId != null) return false;
        if (papaBearId != null ? !papaBearId.equals(that.papaBearId) : that.papaBearId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bearContextId != null ? bearContextId.hashCode() : 0;
        result = 31 * result + (papaBearId != null ? papaBearId.hashCode() : 0);
        result = 31 * result + (mamaBearId != null ? mamaBearId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MamaBearTO{" +
                "bearContextId=" + bearContextId +
                ", papaBearId=" + papaBearId +
                ", mamaBearId=" + mamaBearId +
                ", name='" + name + '\'' +
                '}';
    }
}

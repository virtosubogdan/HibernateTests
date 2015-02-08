package com.example.hibernatetests.data.bears.to;

import java.util.HashSet;
import java.util.Set;

public class BabyBearTO {

    private Long bearContextId;

    private Long papaBearId;

    private Long mamaBearId;

    private Long babyBearId;

    private String name;

    private Set<BearToyTO> bearToyTOs = new HashSet<>();

    public BabyBearTO() {
    }

    public BabyBearTO(Long bearContextId, Long papaBearId, Long mamaBearId, Long babyBearId, String name) {
        this.bearContextId = bearContextId;
        this.papaBearId = papaBearId;
        this.mamaBearId = mamaBearId;
        this.babyBearId = babyBearId;
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

    public Long getBabyBearId() {
        return babyBearId;
    }

    public void setBabyBearId(Long babyBearId) {
        this.babyBearId = babyBearId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BearToyTO> getBearToyTOs() {
        return bearToyTOs;
    }

    public void setBearToyTOs(Set<BearToyTO> bearToyTOs) {
        this.bearToyTOs = bearToyTOs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BabyBearTO that = (BabyBearTO) o;

        if (babyBearId != null ? !babyBearId.equals(that.babyBearId) : that.babyBearId != null) return false;
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
        result = 31 * result + (babyBearId != null ? babyBearId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BabyBearTO{" +
                "name='" + name + '\'' +
                ", babyBearId=" + babyBearId +
                ", mamaBearId=" + mamaBearId +
                ", papaBearId=" + papaBearId +
                ", bearContextId=" + bearContextId +
                '}';
    }
}

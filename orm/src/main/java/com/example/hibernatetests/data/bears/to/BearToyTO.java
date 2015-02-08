package com.example.hibernatetests.data.bears.to;


public class BearToyTO {

    private Long bearContextId;

    private Long papaBearId;

    private Long mamaBearId;

    private Long babyBearId;

    private Long bearToyId;

    private String name;

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

    public Long getBearToyId() {
        return bearToyId;
    }

    public void setBearToyId(Long bearToyId) {
        this.bearToyId = bearToyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BearToyTO bearToyTO = (BearToyTO) o;

        if (babyBearId != null ? !babyBearId.equals(bearToyTO.babyBearId) : bearToyTO.babyBearId != null) return false;
        if (bearContextId != null ? !bearContextId.equals(bearToyTO.bearContextId) : bearToyTO.bearContextId != null)
            return false;
        if (bearToyId != null ? !bearToyId.equals(bearToyTO.bearToyId) : bearToyTO.bearToyId != null) return false;
        if (mamaBearId != null ? !mamaBearId.equals(bearToyTO.mamaBearId) : bearToyTO.mamaBearId != null) return false;
        if (papaBearId != null ? !papaBearId.equals(bearToyTO.papaBearId) : bearToyTO.papaBearId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bearContextId != null ? bearContextId.hashCode() : 0;
        result = 31 * result + (papaBearId != null ? papaBearId.hashCode() : 0);
        result = 31 * result + (mamaBearId != null ? mamaBearId.hashCode() : 0);
        result = 31 * result + (babyBearId != null ? babyBearId.hashCode() : 0);
        result = 31 * result + (bearToyId != null ? bearToyId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BearToyTO{" +
                "bearContextId=" + bearContextId +
                ", papaBearId=" + papaBearId +
                ", mamaBearId=" + mamaBearId +
                ", babyBearId=" + babyBearId +
                ", bearToyId=" + bearToyId +
                ", name='" + name + '\'' +
                '}';
    }
}

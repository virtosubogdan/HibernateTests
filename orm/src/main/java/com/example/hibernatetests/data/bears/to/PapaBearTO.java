package com.example.hibernatetests.data.bears.to;


import java.util.HashSet;
import java.util.Set;

public class PapaBearTO {

    private Long bearContextId;

    private Long papaBearId;

    private String name;

    private Set<MamaBearTO> mamaBearTOs = new HashSet<>();

    public PapaBearTO() {
    }

    public PapaBearTO(Long bearContextId, Long papaBearId, String name) {
        this.bearContextId = bearContextId;
        this.papaBearId = papaBearId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MamaBearTO> getMamaBearTOs() {
        return mamaBearTOs;
    }

    public void setMamaBearTOs(Set<MamaBearTO> mamaBearTOs) {
        this.mamaBearTOs = mamaBearTOs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PapaBearTO that = (PapaBearTO) o;

        if (bearContextId != null ? !bearContextId.equals(that.bearContextId) : that.bearContextId != null)
            return false;
        if (papaBearId != null ? !papaBearId.equals(that.papaBearId) : that.papaBearId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bearContextId != null ? bearContextId.hashCode() : 0;
        result = 31 * result + (papaBearId != null ? papaBearId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PapaBearTO{" +
                "name='" + name + '\'' +
                ", papaBearId=" + papaBearId +
                ", bearContextId=" + bearContextId +
                '}';
    }
}


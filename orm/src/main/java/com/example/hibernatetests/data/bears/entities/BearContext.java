package com.example.hibernatetests.data.bears.entities;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by bogdan.virtosu on 04.02.2015.
 */
@Entity
@Table(name = "BEAR_CONTEXT")
public class BearContext {

    @Id
    @Column(name = "BEAR_CONTEXT_ID")
    private Long bearContextId;

    @OneToMany(mappedBy = "embeddedId.bearContext")
    private Set<PapaBear> papaBears;

    public Long getBearContextId() {
        return bearContextId;
    }

    public void setBearContextId(Long bearContextId) {
        this.bearContextId = bearContextId;
    }

    public Set<PapaBear> getPapaBears() {
        return papaBears;
    }

    public void setPapaBears(Set<PapaBear> papaBears) {
        this.papaBears = papaBears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BearContext that = (BearContext) o;

        if (bearContextId != null ? !bearContextId.equals(that.bearContextId) : that.bearContextId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return bearContextId != null ? bearContextId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BearContext{" +
                "bearContextId=" + bearContextId +
                '}';
    }
}

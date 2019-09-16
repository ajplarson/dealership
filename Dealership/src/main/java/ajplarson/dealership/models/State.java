package ajplarson.dealership.models;

import java.util.Objects;

/**
create table state(
    stateId int primary key AUTO_INCREMENT,
    abbr varchar(10) not null,
    name varchar(30) not null
);
 */
public class State {
    private int stateId;
    private String abbr;
    private String name;

    public State() {
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.stateId;
        hash = 59 * hash + Objects.hashCode(this.abbr);
        hash = 59 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final State other = (State) obj;
        if (this.stateId != other.stateId) {
            return false;
        }
        if (!Objects.equals(this.abbr, other.abbr)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
}

package org.example;

import java.io.Serializable;
import java.util.Objects;

public class Fine implements Comparable<Fine>, Serializable {
    private String type;
    private int sum;

    public Fine(String type) {
        this.type = type;
    }

    public Fine(String type, int sum) {
        this.type = type;
        this.sum = sum;
    }

    public String getType() {
        return type;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fine)) return false;
        Fine fine = (Fine) o;
        return  type.equals(fine.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return type + ", сумма = " + sum;
    }

    @Override
    public int compareTo(Fine o) {
        return type.compareTo(o.type);
    }
}

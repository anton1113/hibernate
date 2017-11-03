package entities;

import javax.persistence.*;

/**
 *
 * @author arash
 */
@Entity
@Table(name = "prime")
public class Prime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Prime() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prime prime = (Prime) o;

        return id.equals(prime.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

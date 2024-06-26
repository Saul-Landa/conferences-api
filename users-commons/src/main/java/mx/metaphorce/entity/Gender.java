package mx.metaphorce.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "genders")
public class Gender implements Serializable {
    private static final long serialVersionUID = 6151999669160362512L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

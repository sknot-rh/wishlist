package ua.ciklum.stkn.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
public class Product extends AuditableEntity {

    @NotNull
    @Length(min = 3, max = 30)
    String code;

    public Product(String code) {
        this.code = code;
    }

    public Product() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
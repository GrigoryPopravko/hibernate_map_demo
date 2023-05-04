package by.itacademy.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Embeddable
public class InternationalCarNumber implements Serializable {

    public static final long serialVersionUID = 1L;

    private String number;
    private String state;
}

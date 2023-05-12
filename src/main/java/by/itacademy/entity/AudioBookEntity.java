package by.itacademy.entity;

import by.itacademy.entity.enam.Format;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@NoArgsConstructor
@DiscriminatorValue("audio")
public class AudioBookEntity extends BookEntity {

    @Enumerated(value = EnumType.STRING)
    @Column(name = "format")
    public Format format;

    @Builder
    public AudioBookEntity(Long id, String title, List<AuthorEntity> authors, Format format) {
        super(id, title, authors);
        this.format = format;
    }
}

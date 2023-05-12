package by.itacademy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@DiscriminatorValue("printed")
public class PrintedBookEntity extends BookEntity {

    @Column(name = "pages")
    public Integer pages;

    @Builder
    public PrintedBookEntity(Long id, String title, List<AuthorEntity> authors, Integer pages) {
        super(id, title, authors);
        this.pages = pages;
    }
}

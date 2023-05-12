package by.itacademy.dao;

import by.itacademy.entity.AudioBookEntity;
import by.itacademy.entity.BookEntity;
import by.itacademy.entity.PrintedBookEntity;
import by.itacademy.entity.enam.Format;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class BookDaoTest {

    @Test
    public void saveBookTest() {
        try (var sessionFactory = new Configuration().configure().buildSessionFactory();
             var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();

            AudioBookEntity audioBook = AudioBookEntity.builder()
                    .title("Crime and Punishment")
                    .format(Format.MP3)
                    .build();

            PrintedBookEntity printedBook = PrintedBookEntity.builder()
                    .title("Crime and Punishment")
                    .pages(400)
                    .build();

            session.persist(audioBook);
            session.persist(printedBook);

            session.flush();
            session.clear();

            BookEntity audioBookEntity = session.get(BookEntity.class, 1L);
            PrintedBookEntity printedBookEntity = session.get(PrintedBookEntity.class, 2L);

            transaction.commit();
            System.out.println();
        }
    }
}

package by.itacademy;

import by.itacademy.entity.BookEntity;
import org.hibernate.cfg.Configuration;

public class HibernateRunner {
    public static void main(String[] args) {
        try (var sessionFactory = new Configuration().configure().buildSessionFactory();
             var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();


            BookEntity book = session.get(BookEntity.class, 1L);
            book.getAuthors().forEach(System.out::println);

            transaction.commit();
        }
    }
}
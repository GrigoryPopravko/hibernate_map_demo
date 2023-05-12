package by.itacademy;

import by.itacademy.entity.Address;
import by.itacademy.entity.UserEntity;
import org.hibernate.cfg.Configuration;

public class HibernateRunner {
    public static void main(String[] args) {
        try (var sessionFactory = new Configuration().configure().buildSessionFactory();
             var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();

            UserEntity ryhor = UserEntity.builder()
                    .email("ryhorpaprauka@gmail.com")
                    .password("1234")
                    .address(Address.builder()
                            .city("Minsk")
                            .street("Pushkinskaya")
                            .house("26")
                            .flat("35")
                            .build())
                    .build();

            session.persist(ryhor);
            session.clear();
            UserEntity userEntity = session.get(UserEntity.class, 4L);


            transaction.commit();
        }
    }
}
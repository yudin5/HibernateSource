import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSession()) {
            // Сохраняем в БД новых пользователей
            session.beginTransaction();

            Person person = new Person();
            person.setName("Hiber 1");
            person.setSurname("Chaynikov 1");
            person.setAge(10);

            session.saveOrUpdate(person);

            person = new Person();
            person.setName("Hiber 2");
            person.setSurname("Chaynikov 2");
            person.setAge(20);

            session.saveOrUpdate(person);

            person = new Person();
            person.setName("Hiber 3");
            person.setSurname("Chaynikov 3");
            person.setAge(30);

            session.saveOrUpdate(person);

            session.getTransaction().commit();
        } catch (Throwable cause) {
            cause.printStackTrace();
        }

        // Читаем из БД всех пользователей
        List<Person> list = null;

        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            Query query = session.createQuery("FROM Person");
            list = (List<Person>) query.list();

            session.getTransaction().commit();
        } catch (Throwable cause) {
            cause.printStackTrace();
        }

        if (list != null && !list.isEmpty()) {
            for (Person person : list) {
                System.out.println(person);
            }
        }
    }
}

package controle;

import modelo.Vitima;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistencia.PersistenciaHibernate;

import java.util.List;

public class AppDAO<T> implements DAO<T> {

    @Override
    public void insert(T element) {
        Transaction transaction = null;
        try(Session session = PersistenciaHibernate.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(element);

            transaction.commit();
        }

        catch (Exception e){
            if (transaction != null)
                transaction.rollback();

            e.printStackTrace();
        }
    }

    @Override
    public boolean update(T element) {
        Transaction transaction = null;
        try(Session session = PersistenciaHibernate.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.update(element);

            transaction.commit();

            return true;
        }
        catch (Exception e){
            if (transaction != null)
                transaction.rollback();

            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(T element) {
        Transaction transaction = null;
        try(Session session = PersistenciaHibernate.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(element);

            transaction.commit();

            return true;
        }
        catch (Exception e){
            if (transaction != null)
                transaction.rollback();

            e.printStackTrace();
            return false;
        }
    }

    @Override
    public T getById(int id, Class<T> tClass) {
        Transaction transaction = null;
        try(Session session = PersistenciaHibernate.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            T returnElement = session.get(tClass, id);

            transaction.commit();

            return returnElement;
        }
        catch (Exception e){
            if (transaction != null)
                transaction.rollback();

            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> getAll(Class<T> tClass) {
        try(Session session = PersistenciaHibernate.getSessionFactory().openSession()){
            return session.createQuery("from " + tClass.getSimpleName(), tClass).list();
        }
    }
}

package controle;

import modelo.Vitima;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistencia.PersistenciaHibernate;

import java.util.List;

public class VitimaDAO {
    public void insert(Vitima v){
        Transaction transaction = null;
        try(Session session = PersistenciaHibernate.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(v);

            transaction.commit();
        }

        catch (Exception e){
            if (transaction != null)
                transaction.rollback();

            e.printStackTrace();
        }
    }

    public List<Vitima> getVitimas() {
        try(Session session = PersistenciaHibernate.getSessionFactory().openSession()){
            return session.createQuery("from Vitima", Vitima.class).list();
        }
    }
}

package ru.ystu.cmis.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.ystu.cmis.domain.Fruit;
import ru.ystu.cmis.util.DbUtil;

import java.util.List;

public class CatalogRepository {
    public Fruit getFruitsById(Integer id){
        Fruit fruit = null;
        try (Session session = DbUtil.getSessionFactory().openSession()) {
            fruit = session.byId(Fruit.class).load(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return fruit;
    }

    public void createFruits(String name, Integer price, Integer count){
        Transaction transaction = null;
        try (Session session = DbUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(new Fruit(name, price, count));
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateFruits(Integer id, String name, Integer price, Integer count){
        Transaction transaction = null;
        try (Session session = DbUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Fruit fruit = session.byId(Fruit.class).load(id);
            fruit.setName(name);
            fruit.setPrice(price);
            fruit.setCount(count);
            session.update(fruit);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Fruit> getFruitsList(){
        try (Session session = DbUtil.getSessionFactory().openSession()) {
            List<Fruit> list = session.createQuery("SELECT G FROM Fruit G", Fruit.class).list();
            if (list != null)
                return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteFruits(Integer id){
        Transaction transaction = null;
        try (Session session = DbUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Fruit fruit = session.byId(Fruit.class).load(id);
            session.delete(fruit);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}

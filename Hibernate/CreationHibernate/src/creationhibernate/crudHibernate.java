/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creationhibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author denos
 */
public class crudHibernate {
    
    SessionFactory sessionFactory;
    
    //public void crudHibernate(){
    void crearSession(){    
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Song.class);
        this.sessionFactory = configuration.buildSessionFactory();
        //return sessionFactory;
    }
    
    public List<Song> ListarTodo(){    
        try(Session session = this.sessionFactory.openSession()){
            session.beginTransaction();
            List<Song> canciones = session.createQuery("from Song", Song.class).list();
            session.close();
            return canciones;
        }
    }
    
    void crearCancion(String songName, String artist) {
        try (Session session = this.sessionFactory.openSession()) {
            session.beginTransaction();

            Song nuevo = new Song();
            nuevo.setSongName(songName);
            nuevo.setArtist(artist);

            session.save(nuevo);
            session.getTransaction().commit();
            session.close();
        }
    }
    
    void actualizarProducto(int id, String songName, String artist) {
        try (Session session = this.sessionFactory.openSession()) {
            session.beginTransaction();

            // Obtener el producto a actualizar
            Song cancion = session.get(Song.class, id);

            // Actualizar los campos
            if (cancion != null) {
                cancion.setSongName(songName);
                cancion.setArtist(artist);
            }

            session.getTransaction().commit();
            session.close();
        }
    }
    
    void eliminarProducto(int id) {
        try (Session session = this.sessionFactory.openSession()) {
            session.beginTransaction();

            // Obtener el producto a eliminar
            Song cancion = session.get(Song.class, id);

            // Eliminar el producto
            if (cancion != null) {
                session.delete(cancion);
            }
            session.getTransaction().commit();
            session.close();
        }
    }
    
    void cerrar(){
        this.sessionFactory.close();
    }
}

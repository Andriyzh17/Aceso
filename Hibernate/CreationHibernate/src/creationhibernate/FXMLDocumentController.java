/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package creationhibernate;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.sound.midi.ShortMessage;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
/**
 *
 * @author denos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        crudHibernate prueba = new crudHibernate();
        prueba.crearSession();
        List<Song> artistas = prueba.ListarTodo();
        
        for (Song artista:artistas){
            System.out.println(artista.getArtist());
        }
        
        prueba.ListarTodo();
        prueba.crearCancion("Hola","Mundo");
        prueba.ListarTodo();
//        prueba.actualizarProducto(5, "Shape of You", "Luis");
//        prueba.ListarTodo();
//        prueba.eliminarProducto(5);
//        prueba.ListarTodo();
//        prueba.cerrar();
        
    }    
    
}

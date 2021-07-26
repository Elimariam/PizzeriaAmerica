/////////////////////////////////////////
// Estudiante: Elizabeth Montes de Oca
// Asignatura: Lenguaje de Programación de la Web I
// Profesor: Julio Castillo
/////////////////////////////////////////

package PizzeriaAmerica;

import javax.swing.JFrame;

public class Pizzeria{
    
    // METODO CONSTRUCTOR
    public Pizzeria() {         
        JFrame pizzeria = new JFrame("Pizzeria");
        // INSTANCIAMOS LA GUI
        GUIPizzeria gui = new GUIPizzeria(pizzeria);
        // EDITAMOS LAS PROPIEDADES DE LA APP
        pizzeria.setTitle("Pizzería");
        pizzeria.setSize(700,550);
        pizzeria.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        pizzeria.setVisible(true);
    }
    
    public static void main(String[] args) {
        // INSTANCIAMOS LA APP
        Pizzeria aplicacion = new Pizzeria();
    }
}

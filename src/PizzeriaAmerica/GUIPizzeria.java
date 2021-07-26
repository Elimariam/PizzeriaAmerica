/////////////////////////////////////////
// Estudiante: Elizabeth Montes de Oca
// Asignatura: Lenguaje de Programación de la Web I
// Profesor: Julio Castillo
/////////////////////////////////////////

package PizzeriaAmerica;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.FlowLayout; 
import java.awt.GridLayout;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel; 
import javax.swing.JTextField; 
import javax.swing.JRadioButton; 
import javax.swing.JFrame; 
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class GUIPizzeria {
    // DECLARAMOS LOS ATRIBUTOS DE LA GUI
    private JLabel lblTipoPizza, lblIngredientes, lblAdicionales, lblNombre, lblApellido, lblDireccion;
    private JTextField fldNombre, fldApellido;
    private JTextArea fldDireccion;
    private ImageIcon iconoPizzaPequena, iconoPizzaMediana, iconoPizzaGrande;
    private JRadioButton btnPequena, btnMediana, btnGrande;
    private JButton btnEnviar;
    private ButtonGroup btnTamano;
    private JPanel panelNorte, panelCentro, panelSur, 
            panelTipoPizza, panelIngredientes, panelAdicionales,
            panelNombre, panelApellido, panelDireccion;
    private BorderLayout esquemaBorder;   
    private JList listaTipoPizza, listaIngredientes, listaAdicionales;
    private JScrollPane scrollTipoPizza, scrollIngredientes, scrollAdicionales;
    
    // DECLARAMOS LOS MENUES
    private String tipos [ ] = {"Americana", "Margarita", "Napolitana"};
    private String ingredientes [] = {"Queso", "Jamón"};
    private String ingAmericana [] = {"Queso A", "Jamón A"};
    private String ingAAA [] = {"Queso A", "Jamón A"};
    private String ingBBB [] = {"Queso B", "Jamón B"};
    private String ingCCC [] = {"Queso C", "Jamón C"};
    private String adicionales [] = {"Queso", "Anchoas", "Jamón", "Pimentón", "Tocineta", "Salchichón"};
    
    /* EN EL METODO inicializarGUI INSTANCIAMOS LOS PANELES Y COMPONENTES
    *  SE USA UN BORDER LAYOUT PARA EL FRAME Y EN CADA REGIÓN SE AGREGA UN PANEL
    */
    private void inicializarGUI(JFrame frame){
        // CONSTRUIMOS EL PANEL NORTE
        iconoPizzaPequena = new ImageIcon("pizza_pequena.jpg");        
        iconoPizzaMediana = new ImageIcon("pizza_mediana.jpg");
        iconoPizzaGrande = new ImageIcon("pizza_grande.jpg");

        btnPequena = new JRadioButton ("Pequeña", new ImageIcon("pizza_pequena.jpg"));
        btnPequena.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPequena.setVerticalTextPosition(SwingConstants.BOTTOM);

        btnMediana = new JRadioButton ("Mediana", iconoPizzaMediana);
        btnMediana.setHorizontalTextPosition(SwingConstants.CENTER);
        btnMediana.setVerticalTextPosition(SwingConstants.BOTTOM);

        btnGrande = new JRadioButton ("Grande", iconoPizzaGrande);
        btnGrande.setHorizontalTextPosition(SwingConstants.CENTER);
        btnGrande.setVerticalTextPosition(SwingConstants.BOTTOM);
        
        // USAMOS UN ButtonGroup PARA SELECCIONAR SOLO UN TAMAÑO DE PIZZA
        btnTamano = new ButtonGroup ();
        btnTamano.add( btnPequena );
        btnTamano.add( btnMediana );		
        btnTamano.add( btnGrande );	

        panelNorte = new JPanel();
        panelNorte.add(btnPequena);
        panelNorte.add(btnMediana);
        panelNorte.add(btnGrande);

        // CONSTRUIMOS EL PANEL CENTRO QUE A SU VEZ ES UN BORDERLAYOUT
        lblTipoPizza = new JLabel("Tipo:");
        listaTipoPizza =  new JList(tipos);
        listaTipoPizza.setVisibleRowCount(4);
        listaTipoPizza.setFixedCellWidth(100);
        listaTipoPizza.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollTipoPizza = new JScrollPane(listaTipoPizza); 
        panelTipoPizza = new JPanel();
        panelTipoPizza.add(lblTipoPizza);
        panelTipoPizza.add(scrollTipoPizza);

        lblIngredientes = new JLabel("Ingredientes:");
        listaIngredientes = new JList(ingredientes);
        listaIngredientes.setVisibleRowCount(3);
        listaIngredientes.setFixedCellWidth(100);
        listaIngredientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollIngredientes = new JScrollPane(listaIngredientes); 
        panelIngredientes = new JPanel();
        panelIngredientes.add(lblIngredientes);
        panelIngredientes.add(scrollIngredientes);

        lblAdicionales = new JLabel("Ingredientes Adicionales:");
        listaAdicionales = new JList(adicionales);
        listaAdicionales.setVisibleRowCount(5);
        listaAdicionales.setFixedCellWidth(100);
        // CONFIGURAMOS LA SELECCION DE VARIOS ITEMS DE LA LISTA
        listaAdicionales.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        scrollAdicionales = new JScrollPane(listaAdicionales); 
        panelAdicionales = new JPanel();
        panelAdicionales.add(lblAdicionales);
        panelAdicionales.add(scrollAdicionales);

        panelCentro = new JPanel(new BorderLayout());
        panelCentro.add(panelTipoPizza, BorderLayout.WEST);
        panelCentro.add(panelIngredientes, BorderLayout.CENTER);
        panelCentro.add(panelAdicionales, BorderLayout.EAST);

        // CONSTRUIMOS EL PANEL SUR
        lblNombre = new JLabel("Nombre:");
        fldNombre = new JTextField("Ingrese el nombre del cliente");
        fldNombre.setColumns(40);
        panelNombre = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNombre.add(lblNombre);
        panelNombre.add(fldNombre);

        lblApellido = new JLabel("Apellido:");
        fldApellido = new JTextField("Ingrese el apellido del cliente");
        fldApellido.setColumns(40);
        panelApellido = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelApellido.add(lblApellido);
        panelApellido.add(fldApellido);

        lblDireccion = new JLabel("Dirección:");
        fldDireccion = new JTextArea("Ingrese la dirección del cliente", 3, 40);
        fldDireccion.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        panelDireccion = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelDireccion.add(lblDireccion);
        panelDireccion.add(fldDireccion);

        btnEnviar = new JButton("Enviar Pedido");

        // EN EL PANEL SUR COLOCAMOS 4 FILAS
        // Y EN CADA CELDA COLOCAMOS EL PANEL CORRESPONDIENTE
        panelSur = new JPanel(new GridLayout(4,1));
        panelSur.add(panelNombre);
        panelSur.add(panelApellido);
        panelSur.add(panelDireccion);
        panelSur.add(btnEnviar);

        // AGREGAMOS LOS PANELES A CONTENEDOR PRINCIPAL (FRAME)
        frame.add(panelNorte, BorderLayout.NORTH);
        frame.add(panelCentro, BorderLayout.CENTER);
        frame.add(panelSur, BorderLayout.SOUTH);        
    }
    
    // MÉTODO CONSTRUCTOR QUE LLAMA AL MÉTODO inicializarGUI
    GUIPizzeria(JFrame frame) {
        inicializarGUI(frame);
    }
}

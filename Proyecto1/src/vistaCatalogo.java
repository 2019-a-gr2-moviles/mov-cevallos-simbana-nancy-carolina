import javax.swing.*;
import java.awt.*;

public class vistaCatalogo {
    public  JPanel panelInicio;
    private JButton ingresarProducto;
    private JButton eliminarProductoButton;
    private JButton eliminarCategoríaButton;
    private JButton editarCategoríaButton;
    private JButton editarProductoButton;
    private JButton IngresarCategoria;
    private JPanel panelCategoria;
    private JPanel panelProducto;
    private JLabel labelCategoria;
    private JLabel labelProducto;
    private JComboBox comboCategoria;

    public  static  void main(String[]args){
        JFrame frame=new JFrame("Catalogo");
        JButton buttonAdministrador=new JButton("ADMINISTRADOR");
        JButton buttonComprador=new JButton("Comprador");
        buttonAdministrador.setBounds(100,200,100,40);
        buttonAdministrador.setBackground(Color.BLUE);
        buttonComprador.setBackground(Color.blue);
        buttonComprador.setBounds(100,200,100,40);

        frame.setContentPane(new vistaCatalogo().panelInicio);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(buttonAdministrador);
        frame.add(buttonComprador);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

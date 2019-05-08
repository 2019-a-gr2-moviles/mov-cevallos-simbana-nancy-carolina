import javax.swing.*;

public class vistaCatalogo {
    public  JPanel panelInicio;
    private JToolBar barraMenu;
    private JComboBox comboBox1;

    public  static  void main(String[]args){
        JFrame frame=new JFrame("Catalogo");

        frame.setContentPane(new vistaCatalogo().panelInicio);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}

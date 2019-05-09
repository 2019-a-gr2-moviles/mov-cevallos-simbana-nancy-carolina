import Modelo.Categoria
import Modelo.Producto
import sun.plugin.perf.PluginRollup
import java.awt.Color
import java.io.*
import javax.swing.*
import com.google.gson.Gson

fun main(args: Array<String>) {
    inicioSesion()
}

fun inicioSesion(){
    val frame = JFrame("CATALOGO")
    val panelInicio=JPanel()
    val label=JLabel("Inicio")

    val buttonAdministrador = JButton("ADMINISTRADOR")
    val buttonComprador = JButton("VER CATALOGO")


    buttonAdministrador.setBounds(100, 200, 100, 40)
    buttonAdministrador.background = Color.BLUE
    buttonComprador.background = Color.blue
    buttonComprador.setBounds(100, 200, 100, 40)

    panelInicio.add(buttonAdministrador)
    panelInicio.add(buttonComprador)

    frame.contentPane = panelInicio
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setSize(300, 200)
    frame.isResizable = false
    frame.setLocationRelativeTo(null)
    frame.isVisible = true

    val boton1 = buttonAdministrador.apply {
        addActionListener {
            Registro()
        }
    }
}


fun Registro(){
    val frame = JFrame("CATALOGO")
    val panelRegistro=JPanel()
    panelRegistro.layout = null
    val label=JLabel("Registro")
    val label2=JLabel("Código")
    val label3=JLabel("Categoria")
    val label4=JLabel("Descripción")
    val label5=JLabel("Color")
    val label6=JLabel("Precio")
    val textCodigo=JTextField()
    val textCategoria=JTextField()
    val textDescripcion=JTextField()
    val textColor=JTextField()
    val textPrecio=JTextField()
    val buttonAceptar=JButton("Aceptar")
    val buttonRegresar=JButton("Regresar")
    label.setBounds(100,10,100,20)
    label2.setBounds(10, 30, 100, 20)
    textCodigo.setBounds(90,30,200,20)
    label3.setBounds(10, 50, 100, 20)
    textCategoria.setBounds(90,50,200,20)
    label4.setBounds(10, 70, 100, 20)
    textDescripcion.setBounds(90,70,200,20)
    label5.setBounds(10, 90, 100, 20)
    textColor.setBounds(90,90,200,20)
    label6.setBounds(10, 110, 100, 20)
    textPrecio.setBounds(90,110,200,20)
    buttonAceptar.setBounds(20,130,100,20)
    buttonRegresar.setBounds(120,130,100,20)


    panelRegistro.add(label)
    panelRegistro.add(label2)
    panelRegistro.add(textCodigo)
    panelRegistro.add(label4)
    panelRegistro.add(textDescripcion)
    panelRegistro.add(label5)
    panelRegistro.add(textColor)
    panelRegistro.add(label6)
    panelRegistro.add(textPrecio)
    panelRegistro.add(buttonAceptar)
    panelRegistro.add(buttonRegresar)

    frame.contentPane = panelRegistro
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setSize(300, 200)
    frame.isResizable = false
    frame.setLocationRelativeTo(null)
    frame.isVisible = true

    buttonAceptar.apply {
        addActionListener {
            val codigo = textCodigo.text
            val categoria = textCategoria.text
            val descripcion = textDescripcion.text
            val color = textColor.text
            val precio = textPrecio.text

            val producto = Producto()
            producto.codigo = codigo
            producto.descripcion = descripcion
            producto.color = color
            producto.precio = precio
            //abrir

            val listaProductos = File("src/archivos/bdProducto.txt").readText()

            val lista = arrayListOf<Producto>()

            // biblioteca = gson.fromJson(content, Biblioteca::class.java) transforma a json
            lista.add(producto)

            //escribe en el texto

            //val content2 = File("src/archivos/bdProducto.txt").writeBytes(lista)
            val content2=ObjectOutputStream(FileOutputStream("src/archivos/bdProducto.txt"))
            content2.writeObject(lista as Serializable)
            print(content2)
        }
    }
}

fun catalogo(){

}
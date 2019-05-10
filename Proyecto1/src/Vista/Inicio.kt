
import Controlador.CategoriasBD
import Controlador.ConexionBD
import Controlador.ProductoBD
import Modelo.Categoria
import Modelo.Producto
import sun.plugin.perf.PluginRollup
import java.awt.Color
import java.awt.color.ColorSpace
import java.io.*
import javax.swing.*
import javax.swing.event.ListSelectionEvent
import javax.swing.table.DefaultTableModel
import kotlin.coroutines.coroutineContext
import kotlin.math.tan

var arregloProducto=ArrayList<Producto>()
var arregloCategoria=ArrayList<Categoria>()
val escrbiriLeer=ConexionBD()
val funcionesProducto=ProductoBD()
val funcionesCategoria=CategoriasBD()

fun main(args: Array<String>) {

    inicioSesion()
    arregloProducto=escrbiriLeer.leerArchivo()
    arregloCategoria=escrbiriLeer.leerArchivoCategoria()

}

fun inicioSesion(){
    val frame = JFrame("CATALOGO")
    val panelInicio=JPanel()
    panelInicio.layout=null
    val label=JLabel("Inicio")

    val buttonAdministrador = JButton("ADMINISTRADOR")
    val buttonComprador = JButton("VER CATALOGO")


    buttonAdministrador.setBounds(10, 30, 130, 70)
    buttonAdministrador.background = Color.BLUE
    buttonComprador.background = Color.blue
    buttonComprador.setBounds(150, 30, 130, 70)

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
    val frame=JFrame("CATALOGO")
    val panelFondo=JPanel()
    panelFondo.layout=null
    val panel=JPanel()
    panel.layout=null
    val panel2=JPanel()
    panel2.layout=null
    val botonRegresar=JButton("Regresar")
    panel.background= Color(158,188,202,101)
    panel2.background=Color(158,188,202,101)
    panel.setBounds(10,30,250,250)
    panel2.setBounds(300,30,250,250)
    botonRegresar.setBounds(250,350,100,40)
    val ingresarProducto= JButton("Ingresar Nuevo")
    val eliminarProductoButton= JButton("Eliminar Producto")
    val eliminarCategoríaButton= JButton("Eliminar Categoría")
    val editarCategoríaButton= JButton("Editar Categoría")
    val editarProductoButton= JButton("Editar Producto")
    val ingresarCategoria= JButton("Ingresar Nuevo")
    val labelCategoria= JLabel("CATEGORIAS")
    val labelProducto= JLabel("PRODUCTOS")

    panelFondo.add(botonRegresar)
    labelCategoria.setBounds(100,10,200,40)
    labelProducto.setBounds(100,10,200,40)
    ingresarCategoria.setBounds(30,60,200,40)
    ingresarProducto.setBounds(30,60,200,40)
    editarCategoríaButton.setBounds(30,110,200,40)
    editarProductoButton.setBounds(30,110,200,40)
    eliminarCategoríaButton.setBounds(30,160,200,40)
    eliminarProductoButton.setBounds(30,160,200,40)

    panel.add(labelCategoria)
    panel.add(ingresarCategoria)
    panel.add(editarCategoríaButton)
    panel.add(eliminarCategoríaButton)

    panel2.add(labelProducto)
    panel2.add(ingresarProducto)
    panel2.add(editarProductoButton)
    panel2.add(eliminarProductoButton)

    panelFondo.add(panel)
    panelFondo.add(panel2)
    frame.contentPane = panelFondo
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setSize(600, 500)
    frame.isResizable = false
    frame.setLocationRelativeTo(null)
    frame.isVisible = true

    botonRegresar.apply {
        addActionListener {
            frame.isVisible=false
        }
    }
    ingresarCategoria.apply {
        addActionListener {
            RegistroCategoria()
        }
    }
    ingresarProducto.apply {
        addActionListener {
            RegistroProducto()
        }
    }
}
fun RegistroCategoria(){
    val frame = JFrame("CATALOGO")
    val panelFondo=JPanel()
    panelFondo.layout=null
    val panelRegistro=JPanel()
    panelRegistro.layout = null
    val panelProducto=JPanel()
    panelProducto.layout=null
    val labelTitulo=JLabel("Registro Categoria")
    val labelId=JLabel("Identificador")
    val textId=JTextField()
    val labelClasificacion=JLabel("Clasificación")
    val textClasificacion=JTextField()
    val botonNuevaCategoria=JButton("Ingresar")
    val botonIngresarProductos=JButton("Ingresar Productos")
    val botonRegresar=JButton("Regresar")
    val botonNuevoProducto=JButton("Aceptar")
    val botonLimpiar=JButton("limpiar")

    labelTitulo.setBounds(100,10,50,20)
    labelId.setBounds(10, 30, 100, 20)
    textId.setBounds(90,30,200,20)
    labelClasificacion.setBounds(10, 60, 100, 20)
    textClasificacion.setBounds(90,60,200,20)
    botonNuevaCategoria.setBounds(350,60,100,20)
    botonIngresarProductos.setBounds(50,100,200,20)
    botonRegresar.setBounds(250,100,100,20)

    botonNuevoProducto.setBounds(10,10,100,20)

    panelRegistro.setBounds(0,0,500,150)
    panelProducto.setBounds(0,200,500,300)
    panelRegistro.add(labelTitulo)
    panelRegistro.add(labelId)
    panelRegistro.add(textId)
    panelRegistro.add(labelClasificacion)
    panelRegistro.add(textClasificacion)
    panelRegistro.add(botonNuevaCategoria)
    panelRegistro.add(botonIngresarProductos)
    panelRegistro.add(botonRegresar)

    panelProducto.add(botonNuevoProducto)
    panelProducto.add(botonLimpiar)
    panelProducto.isVisible=false
    panelFondo.add(panelProducto)
    panelFondo.add(panelRegistro)
    frame.contentPane = panelFondo
    frame.setSize(500, 700)
    frame.isResizable = false
    frame.setLocationRelativeTo(null)
    frame.isVisible = true

    botonNuevaCategoria.apply {
        addActionListener {
            val categoria = Categoria()
            categoria.idCategoria=textId.text
            categoria.nombreCategoria=textClasificacion.text
            //abrir
            arregloCategoria.add(categoria)
            print(arregloCategoria)
            if(escrbiriLeer.EscribiArchivoCategoria(arregloCategoria)){
                frame.isVisible=false
            }
        }
    }

    botonRegresar.apply {
        addActionListener {
            frame.isVisible=false
        }
    }

    botonIngresarProductos.apply {
        addActionListener {
            panelProducto.isVisible=true
        }
    }


}

fun RegistroProducto(){
    val frame = JFrame("CATALOGO")
    val panelFondo=JPanel()
    panelFondo.layout=null
    val panelCategoria=JPanel()
    panelCategoria.layout=null
    val panelRegistro=JPanel()
    panelRegistro.layout = null
    val comboCategoria=JComboBox<Categoria>()

    val tabla=JTable(tablaCategorias())
    tabla.setBounds(0,0,300,100)
    tabla.createDefaultColumnsFromModel()
    tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION)
    panelCategoria.add(tabla)
    val label=JLabel("Registro")
    val label2=JLabel("Código")
    val label3=JLabel("Descripción")
    val label4=JLabel("talla")
    val label5=JLabel("Color")
    val label6=JLabel("Precio")
    val textCodigo=JTextField()
    val textTalla=JTextField()
    val textDescripcion=JTextField()
    val textColor=JTextField()
    val textPrecio=JTextField()
    val buttonAceptar=JButton("Aceptar")
    val buttonRegresar=JButton("Regresar")
    label.setBounds(100,10,100,20)
    label2.setBounds(10, 30, 100, 20)
    textCodigo.setBounds(90,30,200,20)
    label3.setBounds(10, 50, 100, 20)
    textDescripcion.setBounds(90,50,200,20)
    label4.setBounds(10, 70, 100, 20)
    textTalla.setBounds(90,70,200,20)
    label5.setBounds(10, 90, 100, 20)
    textColor.setBounds(90,90,200,20)
    label6.setBounds(10, 110, 100, 20)
    textPrecio.setBounds(90,110,200,20)
    buttonAceptar.setBounds(20,130,100,20)
    buttonRegresar.setBounds(120,130,100,20)


    panelRegistro.add(label)
    panelRegistro.add(label2)
    panelRegistro.add(textCodigo)
    panelRegistro.add(label3)
    panelRegistro.add(textDescripcion)
    panelRegistro.add(label4)
    panelRegistro.add(textTalla)
    panelRegistro.add(label5)
    panelRegistro.add(textColor)
    panelRegistro.add(label6)
    panelRegistro.add(textPrecio)
    panelRegistro.add(buttonAceptar)
    panelRegistro.add(buttonRegresar)

    panelCategoria.setBounds(10,10,300,50)
    panelRegistro.setBounds(10,100,300,200)
    comboCategoria.setBounds(10,10,100,20)
    panelFondo.add(panelCategoria)
    panelFondo.add(panelRegistro)
    frame.contentPane = panelFondo
    frame.setSize(400, 300)
    frame.isResizable = false
    frame.setLocationRelativeTo(null)
    frame.isVisible = true

    buttonAceptar.apply {
        addActionListener {
            val codigo = textCodigo.text
            val descripcion = textDescripcion.text
            val talla = textTalla.text
            val color = textColor.text
            val precio = textPrecio.text

            val producto = Producto()
            val fila=tabla.selectedRow
            println(arregloCategoria[fila-1].idCategoria)
            producto.idCategoria=arregloCategoria[fila-1].idCategoria
            producto.codigo = codigo
            producto.descripcion = descripcion
            producto.talla=talla
            producto.color = color
            producto.precio = precio
            //abrir
            arregloProducto.add(producto)
            print(arregloProducto)
            if(escrbiriLeer.EscribiArchivo(arregloProducto)){
                frame.isVisible=false
            }

        }
    }

    buttonRegresar.apply {
        addActionListener {
            frame.isVisible=false
        }
    }

}

fun tablaCategorias():DefaultTableModel{
    val tm=DefaultTableModel(arrayOf(arrayOf( "Id","Nombre")), arrayOf("idCategoria", "nombreCategoria"))
    arregloCategoria.forEach{ element ->
        var arrayTemp= arrayOf( element.idCategoria, element.nombreCategoria)
        tm.addRow(arrayTemp)
    }
    return  tm
}

fun catalogo(){

}
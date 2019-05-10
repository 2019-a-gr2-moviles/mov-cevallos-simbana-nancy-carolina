
import Controlador.ConexionBD
import Modelo.Categoria
import Modelo.Producto
import java.awt.Color
import javax.swing.*
import javax.swing.table.DefaultTableModel

var arregloProducto=ArrayList<Producto>()
var arregloCategoria=ArrayList<Categoria>()
val escrbiriLeer=ConexionBD()

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
    buttonComprador.apply {
        addActionListener {
            catalogo()
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
    editarProductoButton.apply {
        addActionListener {
            editarProducto()
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

    labelTitulo.setBounds(100,10,50,20)
    labelId.setBounds(10, 30, 100, 20)
    textId.setBounds(90,30,200,20)
    labelClasificacion.setBounds(10, 60, 100, 20)
    textClasificacion.setBounds(90,60,200,20)
    botonNuevaCategoria.setBounds(350,60,100,20)
    botonIngresarProductos.setBounds(50,100,200,20)
    botonRegresar.setBounds(250,100,100,20)

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
    val botonNuevoProducto=JButton("Aceptar")
    val botonVaciar=JButton("limpiar")
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
    botonVaciar.setBounds(120,130,100,20)
    panelProducto.add(label2)
    panelProducto.add(textCodigo)
    panelProducto.add(label3)
    panelProducto.add(textDescripcion)
    panelProducto.add(label4)
    panelProducto.add(textTalla)
    panelProducto.add(label5)
    panelProducto.add(textColor)
    panelProducto.add(label6)
    panelProducto.add(textPrecio)
    panelProducto.add(buttonAceptar)


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

    buttonAceptar.apply {
        addActionListener {
            val codigo = textCodigo.text
            val descripcion = textDescripcion.text
            val talla = textTalla.text
            val color = textColor.text
            val precio = textPrecio.text

            val producto = Producto()
            producto.idCategoria=textId.text
            producto.codigo = codigo
            producto.descripcion = descripcion
            producto.talla=talla
            producto.color = color
            producto.precio = precio
            //abrir
            arregloProducto.add(producto)
            print(arregloProducto)
            if(escrbiriLeer.EscribiArchivo(arregloProducto)){
                textCodigo.text=""
                textDescripcion.text=""
                textTalla.text=""
                textColor.text=""
                textPrecio.text=""
            }
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

fun editarProducto(){
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
    panel.setBounds(0,30,250,250)
    botonRegresar.setBounds(30,350,100,40)
    val labelCategoria= JLabel("CATEGORIAS")
    val labelProducto= JLabel("PRODUCTOS")
    labelCategoria.setBounds(100,10,200,40)
    labelProducto.setBounds(100,10,200,40)

    val tablaCategorias=JTable(tablaCategorias())
    tablaCategorias.setBounds(0,0,300,100)
    tablaCategorias.createDefaultColumnsFromModel()
    tablaCategorias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION)
    val botonBuscar=JButton("Buscar Producto")
    botonBuscar.setBounds(10,200,200,20)
    panel.add(tablaCategorias)
    panel.add(botonBuscar)
    panel.add(labelCategoria)
    panelFondo.add(panel)
    panelFondo.add(botonRegresar)
    frame.contentPane = panelFondo
    frame.setSize(1000, 700)
    frame.isResizable = false
    frame.setLocationRelativeTo(null)
    frame.isVisible = true

    botonRegresar.apply {
        addActionListener {
            frame.isVisible=false
        }
    }

    botonBuscar.apply {
        addActionListener {
            val indice=tablaCategorias.selectedRow
            val id=arregloCategoria[indice-1].idCategoria
            var listaAux=ArrayList<Producto>()
            val lista=arregloProducto.filter { nuevoProducto: Producto ->
                nuevoProducto.idCategoria ==id }
            listaAux=lista as ArrayList<Producto>
            tablaFiltroProductos(listaAux)
            val tablaProd=JTable(tablaFiltroProductos(listaAux))
            tablaProd.setBounds(0,0,300,100)
            tablaProd.createDefaultColumnsFromModel()
            tablaProd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION)
            val panel2=JPanel()
            panel2.layout=null
            panel2.add(tablaProd)
            panel2.setBounds(270,30,500,200)

            val buttonEditar=JButton("Editar")
            buttonEditar.setBounds(0,150,100,20)
            panel2.add(buttonEditar)
            panelFondo.add(panel2)
            frame.contentPane=panelFondo

            buttonEditar.apply {
                addActionListener {
                    val panelRegistro=JPanel()
                    panelRegistro.layout=null
                    val label=JLabel("Registro")
                    val label2=JLabel("Código")
                    val label3=JLabel("Descripción")
                    val label4=JLabel("talla")
                    val label5=JLabel("Color")
                    val label6=JLabel("Precio")
                    val indiceProd=tablaProd.selectedRow
                    val textCodigo=JTextField()
                    val textTalla=JTextField()
                    val textDescripcion=JTextField()
                    val textColor=JTextField()
                    val textPrecio=JTextField()
                    textCodigo.text=listaAux[indiceProd-1].codigo
                    textTalla.text=listaAux[indiceProd-1].talla
                    textDescripcion.text=listaAux[indiceProd-1].descripcion
                    textColor.text=listaAux[indiceProd-1].color
                    textPrecio.text=listaAux[indiceProd-1].precio
                    val buttonAceptar=JButton("Aceptar")
                    val buttonRegresar=JButton("Regresar")
                    label.setBounds(100,10,100,20)
                    label2.setBounds(10, 40, 100, 20)
                    textCodigo.setBounds(90,40,200,20)
                    label3.setBounds(10, 60, 100, 20)
                    textDescripcion.setBounds(90,60,200,20)
                    label4.setBounds(10, 80, 100, 20)
                    textTalla.setBounds(90,80,200,20)
                    label5.setBounds(10, 100, 100, 20)
                    textColor.setBounds(90,100,200,20)
                    label6.setBounds(10, 130, 100, 20)
                    textPrecio.setBounds(90,130,200,20)
                    buttonAceptar.setBounds(20,150,100,20)
                    buttonRegresar.setBounds(120,150,100,20)

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
                    panelRegistro.setBounds(270,200,400,400)
                    panelRegistro.background= Color.WHITE

                    panelFondo.add(panelRegistro)
                    frame.contentPane=panelFondo

                    buttonAceptar.apply {
                        addActionListener {
                            val codigo = textCodigo.text
                            val descripcion = textDescripcion.text
                            val talla = textTalla.text
                            val color = textColor.text
                            val precio = textPrecio.text

                            val producto = Producto()
                            val fila=tablaCategorias.selectedRow
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

                }
            }
        }
    }

}

fun buscarIndiceProducto(codigo:String):Int{
    var indice:Int=0

    return indice
}

fun catalogo(){
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
    panel.setBounds(0,30,250,250)
    botonRegresar.setBounds(30,200,100,40)
    val labelCategoria= JLabel("CATEGORIAS")
    val labelProducto= JLabel("PRODUCTOS")
    labelCategoria.setBounds(100,10,200,40)
    labelProducto.setBounds(100,10,200,40)

    val tablaCategorias=JTable(tablaCategorias())
    tablaCategorias.setBounds(0,0,300,100)
    tablaCategorias.createDefaultColumnsFromModel()
    tablaCategorias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION)
    val botonBuscar=JButton("Buscar Producto")
    botonBuscar.setBounds(10,200,200,20)
    panel.add(tablaCategorias)
    panel.add(botonBuscar)
    panel.add(labelCategoria)
    panelFondo.add(panel)
    panelFondo.add(botonRegresar)
    frame.contentPane = panelFondo
    frame.setSize(700, 700)
    frame.isResizable = false
    frame.setLocationRelativeTo(null)
    frame.isVisible = true

    botonRegresar.apply {
        addActionListener {
            frame.isVisible=false
        }
    }

    botonBuscar.apply {
        addActionListener {
            val indice=tablaCategorias.selectedRow
            val id=arregloCategoria[indice-1].idCategoria
            var listaAux=ArrayList<Producto>()
            val lista=arregloProducto.filter { nuevoProducto: Producto ->
                nuevoProducto.idCategoria ==id }
            listaAux=lista as ArrayList<Producto>
            tablaFiltroProductos(listaAux)
            val tablaProd=JTable(tablaFiltroProductos(listaAux))
            tablaProd.setBounds(0,0,300,100)
            tablaProd.createDefaultColumnsFromModel()
            tablaProd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION)
            val panel2=JPanel()
            panel2.layout=null
            panel2.add(tablaProd)
            panel2.setBounds(270,30,500,200)

            val buttonEditar=JButton("Comprar")
            buttonEditar.setBounds(0,150,100,20)
            panel2.add(buttonEditar)
            panelFondo.add(panel2)
            frame.contentPane=panelFondo

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

fun tablaProductos():DefaultTableModel{
    val tm=DefaultTableModel(arrayOf(arrayOf( "Id","codigo","Prenda","talla","color","precio")), arrayOf("idCategoria", "codig","descripcion","talla","color","precio"))
    arregloProducto.forEach{ element ->
        var arrayTemp= arrayOf( element.idCategoria,element.codigo,element.descripcion,element.talla,element.color,element.precio)
        tm.addRow(arrayTemp)
    }
    return  tm
}

fun tablaFiltroProductos(listaTabla:ArrayList<Producto>):DefaultTableModel{
    val tm=DefaultTableModel(arrayOf(arrayOf( "Id","codigo","Prenda","talla","color","precio")), arrayOf("idCategoria", "codig","descripcion","talla","color","precio"))
    listaTabla.forEach{ element ->
        var arrayTemp= arrayOf( element.idCategoria,element.codigo,element.descripcion,element.talla,element.color,element.precio)
        tm.addRow(arrayTemp)
    }
    return  tm
}
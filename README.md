# proyecto_JAVA


## integrantes:
### Juan David Delgado 
### Nicolas Martinez
### Camila Ariza

## Organisacion Github:
### c++) 
+ la carpeta de (c++) contiene las regreciones lineales de c++, de proyectos anteriores, que se retoman para este proyecto.
### Java ) 
+ la carpeta de (java) contiene el proyecto presentado en clase, el cual imprime por consola.
### Interfaz Java )
+ la carpeta de ( Interfaz Java ) contiene los mismos archivos de la carpeta (java) sin embargo este es en formato interfas (pantalla) solo cambia el main, donde se utilizo la libreria integrada de java (swing), donde se ajusta el main para crear botones, y una pantalla, que remplasa la imprecion por consola que se utiliza en la carpeta (Java)

## readme:
+ 1) Breve vistaso Codigo:
  2) Compilacion
 ( se puede compilar todo el proyecto al compilar el archivo Main.java, ).

## explicacion:
+ El proyecto de Java se basa en crear una interfas de Gestion de producto, en donde se integre codigos de c++ de proyectos anteriroes, en este caso la interfas es en consola, y permite realisar diferentes tareas como ( agregar productos, vender productos, mostrar los productos en stok, mostrar el registro de ventas,  y realizar una regrecion lineal simple).
+ El proyecto tiene una clase "Producto" de la cual se deriban dos sub clases (alimento / electronico ) que cada una tiene atributos especificos, y heredan atributos de producto.

 ## 1) codigo:
 + Link codigo replit: (           ).
 + 
+ (se suguiere revisar el PDF adjuntado al repositorio, en donde se explica con mayor detalle el codigo).
### Producto:
+ la clase producto es una clase que tiene atributos como (nombre, cantidad, precio ).
+ ES una Clase abstracta (abstract class): lo que indica que no se puede instanciar directamente,  La clase sirve como base  para otras clases que heredarán de ella. (alimento / electronico ) 
+
+![image](https://github.com/user-attachments/assets/9add1f9b-189e-40d0-b51c-78ff2b8c1b57)
+
+ sub clase alimento:
+ esta clase ereda los atributos de producto, he tiene unos atributos especificos como meses caducidad, y estado (vendido o no).
+ 
+![image](https://github.com/user-attachments/assets/7deba667-df01-406c-8d09-df62cbf1aded)
+
+ Utiliza la palabra clave super para llamar al constructor de la clase padre (Producto), inicializando los atributos heredados (nombre, cantidad, precio).
Luego, inicializa los atributos específicos de la clase Alimento, como mesesCaducidad.
+
+


+
+ sub clase electronico:
+ tambien es una sub clase de producto, que tiene herencia de este, y en este caso tiene un atributo especifico que es de estado (nuevo o viejo ) del producto.
+
+ ![image](https://github.com/user-attachments/assets/a351da92-0620-4dd9-ad6b-567063fe36a0)
+


### menu:
+
+ ![image](https://github.com/user-attachments/assets/6c765598-b75c-4495-add7-e8966c1128b7)
+ 
+ El menu en consola permite al usuario elegir cualquier funcion del proyecto, hasta que desee acabar saliendo del programa.
+
### main:

+
+ Es atraves del main.java que se usa cada metodo como mostrar lista productos, o regrecion lineal.
+ he aqui un breve vistaso.
+
+ ![image](https://github.com/user-attachments/assets/a5b85d78-35e0-484a-8393-911edca1fb0f)
+
+ se hace uso de arraylist para arrelgo “dinamico”
+ ArrayList<Producto> productos: almacena los productos disponibles.
+ ArrayList<Producto> productosVendidos: almacena los productos que ya han sido vendidos
+ ( para mas detalles dirigase a la presentacion del proyecto, en la carpeta de presentacion).

## Regresion Lineal:
+
+ para este proyecto, se utiliso el modelo de regrecion lineal de otro proyecto de c++ elaborado por el euipo, sin embargo dicha regrecion estaba diseñada para la ser utilizada con 120 mil datos, por lo que al ser utilizada con este proyecto, dava errores, ademas de que hacia calculos inecesarios, y relisaba 20 iteraciones no nesesarias, por lo cual se adapto el codigo en java, tomando como referencia el codigo de c++. ( en el repositorio se puede observar los ejemplos en los que se baso la regrecion final de java, en c++ en la carpeta ( c++) ).
+ 
+ ![image](https://github.com/user-attachments/assets/7384cec6-e0b5-4228-be4d-7405ea201be8)
+
+ ![image](https://github.com/user-attachments/assets/07e68d0b-039e-4c63-aa1f-9f341216e841)
+
+ double[] x:   Es un arreglo que contiene los valores de la variable independiente (en este caso, las cantidades vendidas).

+ double[] y:    Es un arreglo que contiene los valores de la variable dependiente (los precios de los productos vendidos).

+ double m:    La pendiente de la recta, que determina cuánto cambia el precio por cada cambio en la cantidad.

+ double b:    El intercepto de la recta, que es el valor de y (precio) cuando x (cantidad) es 0.


+ (sugerimos revisar la presentacion ):
+ 

## compilacion:
+ 1): se puede compilar todo el proyecto al compilar el archivo Main.java,
+ 2): se puede compilar atravez de la shell, compilando el archivo Main.java, ue esta detro de las carpetas scr/java/main.






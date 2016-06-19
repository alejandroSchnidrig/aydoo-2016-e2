# aydoo-2016-e2
Trabajo Practico N°1 de la materia AYDOO

Nuestro diseño para la solución al problema planteado cuenta con varias clases, las cuales tienen diferentes responsabilidades:
*	Hemos decidimos contar con una clase abstracta Elemento de la cual heredan todos los tipos de elementos que debemos parsear de una sintaxis tipo markdown a html.
*	En nuestro Diseño cada elemento sabe como realizar este parseo a traves del método transformarContenidoMD.
*	La clase CreadorDeArchivoMD es la encargada de leer el archivo con sintaxis markdown y mientras el archivo contenga lineas este va a ir invocando el metodo de la clase FabricaDeElementos
	la cual dependiendo la entrada (un string) va a crear el elemento que le corresponda a esa Entrada. Ej: si rebibe "# titulo" creara un objeto de la clase Titulo.
*       Para resolver el diseño de los if anidados basamos nuestra solucion en el patron de diseño "chain of responsability", cada elemento contiene un atributo el cual es el proximo elemento
	que se encuentra en la cadena de responsabilidades, cada elemento cuenta con el metodo crearElemento que recibe un string, si el elemento en cuestion no es el encargado de crear el objeto
	con ese string le pedira al proximo elemento de la cadena que lo haga.Si el proximo elemento tampoco es el encargado de crear el objeto se lo pedira al proximo elemento que lo haga, asi lo
	hara cada elemento sucesivamente. Una vez que el string llegue al elemento que tenga la responsabilidad de crear el objeto, lo hara y lo retornara por la cadena a la FabricaDeElementos.
*       La clase CreadorDeArchivoHTML es la encargada de organizar los elementos seguen corresponda su orden. El metodo de la clase organizarElementos es el encargado de esta tarea. Este metodo
	cuenta con dos metodos privados organizaListas y organizaSecciones.La logica utilizada para resolver esto no es del todo de nuestro agrado, no se nos ocurrio otra forma para que quede
	mas prolijo y entendible.
*	Además se crea la clase VerificadorDeParametros, encargada de leer los parametros que recibe el programa e interpretarlo. Esta clase cuenta con varias Excepciones para poder responder
	de forma robusta antes ciertos incovenientes a la hora de ingresar los parametros como por ejemplo, no ingresar parametros, ingresar parametros invalidos, ect.


# aydoo-2016-e2
Trabajo Practico N°1 de la materia AYDOO

Nuestro diseño para la solución al problema planteado cuenta con varias clases, las cuales tienen diferentes responsabilidades:
*	Hemos decidimos contar con una clase abstracta Elemento de la cual heredan todos los tipos de elementos que debemos parsear de una sintaxis tipo markdown a html.
*	En nuestro Diseño cada elemento sabe como realizar este parseo a traves del método imprimir.
*	La clase LectorDeArchivo es la encargada de leer el archivo con sintaxis markdown y guarda cada linea como un string en una lista de strings. Esta lista la recibe la clase FabricaDeElementos, en la cual se utiliza el patrón de diseño factory method, para analizar cada linea, crear el tipo de elemento que le corresponda y guardarlo en una lista de elementos.
*	La clase OrganizadorDeElementos recibe esta lista de elementos y los organiza según las especificidades a cumplir guardando cada elemento  en un tipo archivo, el cual lo podemos imprimir obteniendo el resultado esperado tanto por la salida estándar (consola) como imprimiéndose en un archivo.md.
*	Además se crea la clase VerificadorDeParametros, encargada de leer los parametros que recibe el programa e interpretarlo.


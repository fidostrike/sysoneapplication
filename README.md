Recruitment Journey SysOne Developer Business Case
---------------------------------------------------
url swagger
http://localhost:8090/swagger-ui.html

//funcion pincipal de update sale car
http://localhost:8090/salecar/update
{
	"carId":"2","
	"optionalParts":
					[
						"ABS","LL","TC"
					]
}

Pasos para ejecucion sin eclipse (tener docker-compose instalado)

Ejecucion de la base de datos mysql
docker-compose -f docker-compose.yml up

correr el servicio a traves del dockerfile (es necesario tener el jar generado)
docker build . -t dockerfile --tag=sysone

--------------------------------------------------------------------------------------------------------------------------------------------------

Una fábrica de automóviles produce uno de sus modelos en tres variantes, llamadas sedán, coupé y familiar. Cada una tiene un precio de venta básico sin opcionales. A su vez, a cada variante se le pueden agregar opciones como techo corredizo, aire acondicionado, sistema de frenos ABS, airbag y llantas de aleación. Cada uno de estos opcionales tiene un precio que suma al básico. En este caso, cada auto vendrá caracterizado por su variante y podrá tener ninguno, uno o más opcionales.

 

Asumiendo los siguientes costos:



Básico sedán          230.000
Básico familiar        245.000
Básico coupé          270.000
Techo corredizo (TC)        12.000
Aire acondicionado (AA)  20.000
Sistemas de frenos ABS (ABS)    14.000
Airbag (AB)   7.000
Llantas de aleación (LL)   12.000
 

1)Diseñar una solución que permita calcular el costo final de un automóvil.

 

2)Desarrollar una API Rest CRUD que me permita crear, modificar, listar y eliminar objetos del tipo “Automóvil”.

 

Ej:

{

“id”: 1,

“nombre”: “Sedán”,

“opcionales”: [“TC”, “AA”, “LL”]

}

 

Las operaciones de alta/consulta deberán almacenar/mostrar el costo del mismo.

 

Se evaluará tecnologías para desarrollar dicha API Rest (Spring MVC, CXF, Jersey, etc.), su persistencia (JDBC, Spring JDBC, Hibernate, etc.) y BD de datos (MariaDB, MySQL, Oracle, MongoDB, etc.) seleccionada para la resolución del ejercicio, por otro lado se evaluarán metodologías y herramientas de deployd y  formas de exposición  ( es un plus publicar la api en la nube).



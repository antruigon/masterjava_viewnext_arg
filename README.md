
# Proyecto 2
  ## Información general
  Proyecto desarrollado en Java Enterprise usando archivos .jsp y Servlets.  

  ## Implementación
  Este proyecto consta de una página principal que nos ofrece varias opciones para interactuar con objetos de tipo Producto.

  - Búquedas: permite realizar una búsqueda de productos seleccionando una sección concreta.
  - Búsqueda (sin seccion): permite realizar una búsqueda de todos los productos disponibles.
  - Altas: permite agregar un nuevo producto
  - Eliminar: permite eliminar un producto
  - Modificación: permite modificar un producto concreto 
  
  ## Problemas en la implementación (CORREGIDOS)
  - En la Clase ServiceProductos.java se gestionan todos los métodos para la obtención, eliminación, modificación y subida de productos.
  
    Estos métodos actuan generalmente sobre una lista estática de productos disponible en la clase Producto.java y no he logrado hacer que los métodos funcionen correctamente debido a esto.

    _Estos errores han sido corregidos. No obstante, los dejamos en el README.MD para dejar constancia de ellos._

# Proyecto 3 - Final
  ## Información general
  Proyecto desarrollado con Spring Boot y Spring Data JPA que consta de 3 microservicios (hoteles, vuelos, reservas) que se relacionan entre ellos para simular una serie de funcionalidades.

  ## Implementación
  Este proyecto consta de 3 microservicios con los siguientes endpoints:
    
  ### Microservicio hoteles:
  - GET /hoteles: devuelve todos los hoteles. Se le puede pasar el parámetro "disponible" como true o false para devolver solo los disponibles o no
  - GET /hoteles/{nombre}: devuelve la información de un hotel dado su nombre
  - GET /hoteles/{categoria}: devuelve los hoteles pertenecientes a una categoría
    
  ### Microservicio vuelos:
  - GET /vuelos: devuelve todos los vuelos.
  - GET /vuelos/plazas/{plazas}: devuelve todos los vuelos disponibles, es decir, para los que hay plazas suficientes según las solicitadas
  - GET /vuelos/compañia/{compañia}: devuelve todos los vuelos de la compañia dada.
  - PUT /vuelos/{id}/{plazas}: actualiza el vuelo dado restándole las plazas dadas

  ### Microservicio reservas:
  - GET /reservas: devuelve todas las reservas
  - GET /reservas/hotel/{id}: devuelve todas las reservas de un hotel dado el id del mismo
  - GET /reservas/hotel/nombre/{nombre}: devuelve todas las reservas de un hotel dado el nombre del mismo
  - GET /reservas/vuelo/{id}: devuelve todas las reservas de un vuelo dado el id del mismo
  - GET /reservas/dni/{dni}: devuelve todas las reservas de un cliente dado su dni
  - POST /reservas: añade un registro y actualiza en vuelos según el numero de personas en la reserva
  

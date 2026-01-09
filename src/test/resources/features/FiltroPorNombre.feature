Feature: Validar servicios que traern los usuarios
  Como administrador de OrangeHRM
  Quiero obtener un usuario aleatorio y validar el filtro por nombre del directorio
  Para asegurar que el sistema muestra correctamente la informacion de los usuarios.

  @BACK
  Scenario: Obtener un usuario, y validar el filtro por nombre del directrio
    When se inicia sesion como administrador en OrangeHRM
    And se obtiene la cockie de sesion para consumor los servicios
    And se consume el servicio que lista los usuarios
    And se selecciona un usuario aleatorio de la lista
    And se consume el servicio que filtra por nombre en el directorio con el nombre del usuario seleccionado
    Then el sistema retorna la informacion correcta del usuario filtrado

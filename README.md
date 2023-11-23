# Evaluaciones Inetum

Implementar la consulta de un cliente con la siguiente casuística:
1. Si el cliente es normal le debe listar las cuentas sin detalles de movimientos
2. Si el cliente es premium le debe mostrar los detalles de la cuenta incluido los intereses
3. Para la consulta de movimientos debe tener un método independiente para poder implementar una consulta de tipo reactiva
4. Se debe validar el request del servicio con expresiones regulares considerando lo siguiente: el dni debe ser numérico con un máximo de 8 números; el correo debe estar validado con expresiones regulares de correo considerando que el subdominio debe poder tener mas de un punto (xxx@inetum.com.pe)
5. Se debe escribir en el log el dni recibido el cual debe estar enmascarado los 4 primeros dígitos.
6. Implementar la prueba unitaria
7. Debe tener dos métodos de consulta uno POST(recibe el dni y correo por body) y otro GET(recibe el correo por query parameter y el dni por path parameter)
8. La inyección de dependencia a la capa service y dao debe ser basada en constructor
9. Se debe definir el contrato open api del servicio (opcional)
10. Usar JPA para la consulta de base de datos
11. Usar Lombok para la definición de todos los objetos de intercambio de datos (DTO)
12. Definir la documentación del servicio con la anotación @Scheme


## Compilación

Usamos la versión :Gradle 7.4.2 

```bash
gradle clean build
```

## Ejecución

```bash
gradle bootRun
```

## Recomendaciones

- Esta aplicación ya contiene la BD embebida, es una H2, los registros ingresados se encuentran en el archivo schema.sql, no se recomienda editar este archivo.
- para ingresar a swagger ui deberá iniciar la aplicación y luego dirigirse a http://localhost:9091/inetum/evaluaciones/swagger-ui.html


## License

[MIT](https://choosealicense.com/licenses/mit/)
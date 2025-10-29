# Sistema de Gestión de Ventas

Sistema de gestión de ventas desarrollado en Java con Maven que permite administrar clientes, productos y facturas, además de generar reportes en formato Excel.

## Estructura del Proyecto

```
edu.utp.ingenieria.sistemaventas/
├── src/main/
│   ├── java/com/poo/edu/utp/ingenieria/sistemaventas/
│   │   ├── EduUtpIngenieriaSistemaventas.java  # Clase principal con menú
│   │   ├── modelos/                             # Entidades
│   │   │   ├── Cliente.java
│   │   │   ├── Producto.java
│   │   │   ├── Factura.java
│   │   │   ├── DetalleFactura.java
│   │   │   └── Empresa.java
│   │   ├── repositorios/                        # Acceso a datos
│   │   │   ├── ClienteRepository.java
│   │   │   ├── ProductoRepository.java
│   │   │   ├── FacturaRepository.java
│   │   │   ├── DetalleFacturaRepository.java
│   │   │   └── EmpresaRepository.java
│   │   ├── servicios/                           # Servicios de negocio
│   │   │   └── ConexionBaseDatos.java
│   │   ├── utilidades/                          # Utilidades
│   │   │   ├── Reportes.java
│   │   │   └── Configuracion.java
│   │   └── dto/                                 # Data Transfer Objects
│   │       └── FacturaProducto.java
│   └── resources/
│       └── plantillas/                          # Plantillas Excel
│           ├── plantilla_reporte_productos.xlsx
│           ├── plantilla_reporte_clientes.xlsx
│           └── plantilla_reporte_facturas.xlsx
├── reportes/                                    # Reportes generados
└── pom.xml                                      # Dependencias Maven
```

## Requisitos

- **Java**: JDK 17 o superior
- **Maven**: 3.6 o superior
- **Base de datos**: SQL Server (Express o superior)
- **IDE**: NetBeans, IntelliJ IDEA, Eclipse o VS Code

## Configuración

### Base de Datos

1. Crear base de datos `db_ventas` en SQL Server
2. Ajustar la cadena de conexión en `Configuracion.java`:
   ```java
   public static final String DB_URL = "jdbc:sqlserver://localhost\\SQLEXPRESS01;databaseName=db_ventas;integratedSecurity=true;encrypt=false";
   ```

### Plantillas de Reportes

1. Colocar las plantillas Excel en: `src/main/resources/plantillas/`
2. Los nombres deben coincidir con los definidos en `Configuracion.java`:
   - `plantilla_reporte_productos.xlsx`
   - `plantilla_reporte_clientes.xlsx`
   - `plantilla_reporte_facturas.xlsx`

### Rutas de Salida

Los reportes se generan automáticamente en el directorio `reportes/` con un timestamp:
```
reportes/reporte_productos_20251027_143025.xlsx
```

## Compilación y Ejecución

### Compilar el proyecto
```bash
mvn clean install
```

### Ejecutar desde Maven
```bash
mvn exec:java -Dexec.mainClass="com.poo.edu.utp.ingenieria.sistemaventas.EduUtpIngenieriaSistemaventas"
```

### Ejecutar desde JAR
```bash
java -jar target/edu.utp.ingenieria.sistemaventas-1.0-SNAPSHOT.jar
```

## Funcionalidades

### Menú Principal

El sistema presenta un menú interactivo en consola con las siguientes opciones:

1. **Listar Clientes**: Muestra todos los clientes registrados
2. **Listar Productos**: Muestra todos los productos disponibles
3. **Generar Reporte de Productos**: Crea un archivo Excel con los productos
4. **Buscar Facturas por Producto**: Busca facturas que contengan un producto específico
5. **Agregar Cliente**: Permite registrar un nuevo cliente
0. **Salir**: Cierra la aplicación

### Generación de Reportes

- Los reportes usan plantillas Excel predefinidas
- Se insertan datos dinámicamente en las plantillas
- Los archivos generados incluyen timestamp en el nombre
- Aplicación automática de formato (bordes, decimales, fechas)

## Dependencias Principales

```xml
<!-- Base de datos -->
<dependency>
    <groupId>com.microsoft.sqlserver</groupId>
    <artifactId>mssql-jdbc</artifactId>
    <version>11.2.0.jre17</version>
</dependency>

<!-- Reportes Excel -->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.2.4</version>
</dependency>

<!-- Reportes PDF -->
<dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>itextpdf</artifactId>
    <version>5.5.13.3</version>
</dependency>

<!-- Logging -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.20.0</version>
</dependency>
```

## Personalización

### Agregar nuevas opciones al menú

1. Editar el método `mostrarMenu()` en `EduUtpIngenieriaSistemaventas.java`
2. Agregar el case correspondiente en el switch del main
3. Implementar el método con la nueva funcionalidad

### Crear nuevos tipos de reportes

1. Crear plantilla Excel en `src/main/resources/plantillas/`
2. Agregar constante en `Configuracion.java`
3. Implementar método en `Reportes.java`
4. Agregar opción al menú

## Manejo de Errores

El sistema captura y muestra errores de forma clara:
- Clase donde ocurrió el error
- Método donde ocurrió el error
- Línea del error
- Mensaje descriptivo

## Autor

Proyecto desarrollado para el curso de Programación Orientada a Objetos (POO)  
Universidad Tecnológica del Perú (UTP)

## Licencia

Proyecto académico - Uso educativo

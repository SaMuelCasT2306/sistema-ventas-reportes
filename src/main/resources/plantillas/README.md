# Plantillas de Reportes

Este directorio contiene las plantillas Excel que se usan para generar reportes.

## Plantillas Requeridas

### 1. plantilla_reporte_productos.xlsx
**Descripción**: Plantilla para el reporte de productos

**Estructura sugerida**:
- **Fila 1**: Título del reporte (ej: "REPORTE DE PRODUCTOS")
- **Fila 2**: Información de la empresa (celda B2 o C2)
- **Fila 3**: Fecha del reporte (celda B3 o C3)
- **Filas 4-5**: Espacio/formato adicional
- **Fila 6**: Encabezados de columnas
  - Columna A: ID / Código
  - Columna B: Código Producto
  - Columna C: Nombre
  - Columna D: Precio Unitario
- **Fila 7 en adelante**: Datos (se llenan automáticamente)

### 2. plantilla_reporte_clientes.xlsx (Pendiente)
**Descripción**: Plantilla para el reporte de clientes

**Estructura sugerida**:
- Fila 6: Encabezados
  - Columna A: ID
  - Columna B: RUC
  - Columna C: Nombre
  - Columna D: Dirección

### 3. plantilla_reporte_facturas.xlsx (Pendiente)
**Descripción**: Plantilla para el reporte de facturas

## Instrucciones para Crear Plantillas

1. **Crear archivo Excel** (.xlsx) con el nombre especificado
2. **Diseñar el formato**:
   - Aplicar estilos de encabezado
   - Definir anchos de columna
   - Establecer fuentes y colores
   - Agregar logos o imágenes si es necesario
3. **Dejar la fila de datos vacía** (el sistema la llenará automáticamente)
4. **Guardar en este directorio**

## Notas Importantes

- Las plantillas deben ser archivos `.xlsx` (Excel 2007 o superior)
- No usar macros o funcionalidades complejas
- Los datos se insertarán a partir de la fila 7 por defecto
- El formato de las celdas de datos se aplicará automáticamente desde el código
- Las plantillas pueden tener múltiples hojas, pero se usa la primera por defecto

## Personalización

Si necesitas cambiar la fila de inicio de datos o las columnas, modifica el código en:
```java
Reportes.crearReportesProductos()
```

Variable `int fila = 7;` define la fila de inicio de datos.
Variable `int columnas = 4;` define el número de columnas.

# 🛒 Gestión de Clientes — Java + SQLite

Aplicación Java que gestiona una base de datos de clientes usando SQLite mediante el patrón **DAO (Data Access Object)**.

---
## 📁 Estructura del proyecto---

## 🗃️ Base de datos

Se usa **SQLite** con una base de datos local llamada `clientes.db`.

La tabla `clientes` tiene la siguiente estructura:

| Campo                | Tipo                        |
|----------------------|-----------------------------|
| id                   | INTEGER (PK, autoincrement) |
| nombre               | TEXT                        |
| email                | TEXT                        |
| telefono             | TEXT                        |
| edad                 | INTEGER                     |
| dinero_gastado       | REAL                        |
| productos_comprados  | INTEGER                     |

---

## ⚙️ Operaciones disponibles

### Escritura
1. Insertar un cliente
2. Actualizar cualquier campo de un cliente (salvo ID)
3. Borrar un cliente por ID

### Consultas
4. Obtener un cliente por ID
5. Obtener todos los clientes
6. Obtener clientes mayores de 30 años
7. Obtener clientes que han gastado más de 500€
8. Obtener clientes ordenados por dinero gastado (mayor a menor)
9. Obtener el top 3 de clientes con más productos comprados
10. Obtener la suma total de dinero gastado
11. Obtener la media de productos comprados
12. Obtener la media de dinero gastado por clientes mayores de 25 años con más de 3 productos
13. Obtener el número de clientes que han gastado más de 100€
14. Obtener el número de clientes con edad entre 30 y 50
15. Obtener clientes con gasto > 200€ ordenados por productos (ascendente)
16. Obtener el cliente más joven con gasto mayor a 400€

---

## ▶️ Ejecución

El `Main` puede ejecutarse **múltiples veces** sin alterar los resultados de las consultas, ya que el cliente usado para probar inserción, actualización y borrado se elimina al final de cada ejecución.

---

## 🛠️ Tecnologías

- Java
- SQLite (`sqlite-jdbc`)
- Patrón DAO

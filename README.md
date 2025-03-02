# Spaceship API

API REST desarrollada con Spring Boot siguiendo una arquitectura hexagonal (puertos y adaptadores).

## Requisitos Previos

- Java 21
- Maven 3.9.x
- Base de datos H2 (incluida en el proyecto)

## Estructura del Proyecto

El proyecto sigue una arquitectura hexagonal con la siguiente estructura:

```
src/main/java/com/challenge/spaceship/
├── application/             # Casos de uso
├── domain/                  # Entidades y reglas de negocio
│   ├── model/               # Modelos de dominio
│   ├── ports/               # Puertos (interfaces)
│   │   ├── input/           # Puertos de entrada
│   │   └── output/          # Puertos de salida
└── infrastructure/          # Adaptadores
    ├── input/               # Adaptadores de entrada (controllers)
    └── output/              # Adaptadores de salida (repositorios)


## Cómo Ejecutar

1. Clonar el repositorio:
```bash
git clone https://github.com/garcia-luciano/spaceship.git ó git@github.com:garcia-luciano/spaceship.git
cd spaceship
```

2. Compilar el proyecto:
```bash
./mvnw clean install
```

3. Ejecutar la aplicación:
```bash
./mvnw spring-boot:run
```

La aplicación estará disponible en `http://localhost:8080`

## Credenciales de Acceso

- Usuario: `user`
- Contraseña: `user`

## Documentación de la API

La documentación de la API está disponible a través de Swagger UI:
- URL: `http://localhost:8080/swagger-ui.html`

## Endpoints Disponibles

### Spaceships

- `POST /api/spaceships` - Crear una nueva nave espacial
- `GET /api/spaceships` - Obtener todas las naves espaciales
- `GET /api/spaceships/{id}` - Obtener una nave espacial por ID
- `PUT /api/spaceships/{id}` - Actualizar una nave espacial
- `DELETE /api/spaceships/{id}` - Eliminar una nave espacial

### Ejemplo de Payload

```json
{
  "name": "Enterprise",
  "model": "NCC-1701",
  "capacity": 1000,
  "status": "ACTIVE"
}
```

## Pruebas con cURL

1. Crear una nueva nave:
```bash
curl -X POST "http://localhost:8080/api/spaceships" \
     -H "Content-Type: application/json" \
     -u "user:user" \
     -d '{"name":"Enterprise","model":"NCC-1701","capacity":1000,"status":"ACTIVE"}'
```

2. Obtener todas las naves:
```bash
curl -X GET "http://localhost:8080/api/spaceships" -u "user:user"
```

3. Obtener una nave por ID:
```bash
curl -X GET "http://localhost:8080/api/spaceships/1" -u "user:user"
```

4. Actualizar una nave:
```bash
curl -X PUT "http://localhost:8080/api/spaceships/1" \
     -H "Content-Type: application/json" \
     -u "user:user" \
     -d '{"name":"Enterprise-A","model":"NCC-1701-A","capacity":1200,"status":"ACTIVE"}'
```

5. Eliminar una nave:
```bash
curl -X DELETE "http://localhost:8080/api/spaceships/1" -u "user:user"
```

## Base de Datos

La aplicación utiliza H2 como base de datos en memoria. Los datos se perderán cuando se reinicie la aplicación.

## Seguridad

- La aplicación utiliza autenticación básica HTTP
- Todos los endpoints requieren autenticación excepto Swagger UI
- CSRF está deshabilitado para facilitar las pruebas

## Tecnologías Utilizadas

- Spring Boot 3.4.3
- Spring Security
- Spring Data JPA
- H2 Database
- Lombok
- Springdoc OpenAPI (Swagger) 
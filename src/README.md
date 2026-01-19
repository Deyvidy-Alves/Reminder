# 📝 API de Lembretes (ToDo List)

API RESTful desenvolvida com **Java** e **Spring Boot** para
gerenciamento de lembretes e tarefas (To-Do List). O projeto implementa
operações de **CRUD** completo (Criar, Ler, Atualizar e Deletar),
seguindo boas práticas de arquitetura em camadas e princípios **SOLID**.

------------------------------------------------------------------------

## 🚀 Tecnologias Utilizadas

-   **Java 21**
-   **Spring Boot 3**
-   **Spring Data JPA (Hibernate)**
-   **PostgreSQL**
-   **Maven**
-   **Bean Validation (DTOs)**

------------------------------------------------------------------------

## ⚙️ Pré-requisitos

-   **JDK 17** ou superior\
-   **PostgreSQL** (porta padrão 5432)\
-   **Maven** (opcional, caso utilize `mvnw`)\
-   Cliente HTTP para testes (**Postman**, **Insomnia** ou **cURL**)

------------------------------------------------------------------------

## 🔧 Configuração e Instalação

### 1️⃣ Clonar o Repositório

``` bash
git clone https://github.com/seu-usuario/reminder-api.git
cd reminder-api
```

------------------------------------------------------------------------

### 2️⃣ Configurar o Banco de Dados

``` sql
CREATE DATABASE reminder_db;
```

------------------------------------------------------------------------

### 3️⃣ Configurar Credenciais

Arquivo:

``` text
src/main/resources/application.properties
```

Configuração sugerida:

``` properties
spring.datasource.url=jdbc:postgresql://localhost:5432/reminder_db
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

------------------------------------------------------------------------

### 4️⃣ Executar o Projeto

#### Via IntelliJ IDEA

-   Abrir `ReminderApplication.java`
-   Clicar em **Run** ▶️

#### Via Terminal

``` bash
mvn spring-boot:run
```

Servidor disponível em:

``` text
http://localhost:8080
```

------------------------------------------------------------------------

## 📡 Documentação da API (Endpoints)

Prefixo base:

``` text
/api/reminders
```

------------------------------------------------------------------------

### ➕ Criar Lembrete

-   **Método:** POST\
-   **URL:** `/api/reminders`

``` json
{
  "title": "Estudar Spring Boot",
  "description": "Focar na criação da API REST",
  "dueDate": "2026-12-30T18:00:00"
}
```

**Resposta:** `201 Created`

------------------------------------------------------------------------

### 📋 Listar Lembretes

-   **Método:** GET\
-   **URL:** `/api/reminders`

**Resposta:** `200 OK`

------------------------------------------------------------------------

### ✏️ Atualizar Lembrete

-   **Método:** PUT\
-   **URL:** `/api/reminders/{id}`

``` json
{
  "title": "Estudar Spring Boot Avançado",
  "description": "Agora com segurança e validações",
  "dueDate": "2026-12-31T20:00:00",
  "completed": true
}
```

**Respostas:** - `200 OK` - `404 Not Found`

------------------------------------------------------------------------

### 🗑️ Deletar Lembrete

-   **Método:** DELETE\
-   **URL:** `/api/reminders/{id}`

**Resposta:** `204 No Content`

------------------------------------------------------------------------

## 📂 Estrutura do Projeto

``` text
src/main/java/org/example/reminder
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── dto
 └── exception
```

------------------------------------------------------------------------

## 🧪 Testando com cURL

``` bash
curl -X POST http://localhost:8080/api/reminders -H "Content-Type: application/json" -d '{"title":"Teste via Terminal","dueDate":"2026-12-31T12:00:00"}'

curl http://localhost:8080/api/reminders
```

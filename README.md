# Task API

Учебный проект на Spring Boot для изучение архитектурного стилья REST API.

## О проекте

Проект реализует базовые CRUD-операции для сущности `Task`:
- создание задачи
- получение всех задач
- получение задачи по `id`
- обновление задачи
- удаление задачи

Проект использует многослойную архитектуру:
- `controller` — принимает HTTP-запросы
- `service` — содержит бизнес-логику
- `repository` — работает с базой через JPA
- `entity` — описывает модель данных
- `dto` — объекты для входящих и исходящих данных

## Стек

- Java 17
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Spring Validation
- PostgreSQL
- Lombok
- Gradle

## Сущность Task

Сущность `Task` содержит поля:
- `id` — идентификатор задачи
- `title` — название задачи
- `description` — описание задачи
- `taskStatus` — статус задачи
- `taskPriority` — приоритет задачи

Особенности:
- `id` генерируется автоматически
- `title` и `description` обязательны
- `taskStatus` и `taskPriority` сохраняются в базе как строки (`EnumType.STRING`)

## API Endpoints

### 1. Получить все задачи
**GET** `/tasks`

**Response:** `200 OK`

Пример ответа:
```json
[
  {
    "title": "Learn Swagger",
    "description": "Read OpenAPI basics",
    "taskStatus": "NEW",
    "taskPriority": "HIGH"
  }
]
```

---

### 2. Получить задачу по id
**GET** `/tasks/{id}`

**Response:**
- `200 OK` — если задача найдена
- `404 Not Found` — если задача не найдена

Пример ответа:
```json
{
  "title": "Learn Swagger",
  "description": "Read OpenAPI basics",
  "taskStatus": "NEW",
  "taskPriority": "HIGH"
}
```

---

### 3. Создать задачу
**POST** `/tasks`

Пример запроса:
```json
{
  "title": "Learn REST",
  "description": "Practice Task API",
  "taskPriority": "HIGH"
}
```

**Response:** `201 Created`

Пример ответа:
```json
{
  "title": "Learn REST",
  "description": "Practice Task API",
  "taskStatus": "NEW",
  "taskPriority": "HIGH"
}
```

---

### 4. Обновить задачу
**PUT** `/tasks/{id}`

Пример запроса:
```json
{
  "title": "Learn REST API",
  "description": "Practice CRUD and validation",
  "taskStatus": "IN_PROGRESS",
  "taskPriority": "HIGH"
}
```

**Response:**
- `200 OK` — если задача обновлена
- `404 Not Found` — если задача не найдена

Пример ответа:
```json
{
  "title": "Learn REST API",
  "description": "Practice CRUD and validation",
  "taskStatus": "IN_PROGRESS",
  "taskPriority": "HIGH"
}
```

---

### 5. Удалить задачу
**DELETE** `/tasks/{id}`

**Response:**
- `204 No Content` — если задача удалена
- `404 Not Found` — если задача не найдена

## DTO

### TaskCreateRequest
Используется при создании задачи.

Поля:
- `title`
- `description`
- `taskPriority`

### TaskUpdateRequest
Используется при обновлении задачи.

Поля:
- `title`
- `description`
- `taskStatus`
- `taskPriority`

### TaskResponse
Используется в ответах API.

- `title`
- `description`
- `taskStatus`
- `taskPriority`

## Ошибки

Если задача не найдена, сервис выбрасывает `RuntimeException` с сообщением вида:
- `Задача не найден id: {id}`

На текущем этапе это учебный рабочий вариант. В дальнейшем проект можно улучшить через:
- `ResourceNotFoundException`
- `@RestControllerAdvice`
- единый JSON-ответ для ошибок
- обработку `400 / 404 / 500`

## Как запустить

1. Создать PostgreSQL базу данных, например `taskdb`
2. Настроить подключение в `application.properties`
3. Запустить приложение
4. Проверить endpoint-ы через Postman или IntelliJ HTTP Client

Пример настроек:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/taskdb
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## Назначение проекта

Этот проект создан как учебная практика по REST API на Spring Boot и демонстрирует понимание:
- CRUD-операций
- DTO
- сервисного слоя
- работы с JPA
- работы с PostgreSQL
- базовой REST-архитектуры

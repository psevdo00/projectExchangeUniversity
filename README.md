# Документация REST API  
## "Витрина проектов"  

**Базовый URL**: `http://localhost:8080/api`  

---

## 1. Проекты (URL: `/project`)  

### 1.1 Получить проект по году создания  
**Endpoint**: `/find/By/ProjectYear/{year}`  

**Параметры**: `year (тип: int)`

**Пример запроса**:  
`
GET http://localhost:8080/api/project/find/By/ProjectYear/2024
`

**Пример ответа (200 ОК)**
```json
{
  "message": "Поиск прошел успешно!",
  "project": {
    "id": 1,
    "title": "test1",
    "info": "info test1",
    "subjectArea": "Bеб",
    "university": "ИИТ",
    "projectYear": "2024",
    "type": "ORDER",
    "flag_completed": true,
    "command": null
  }
}
```

### 1.2 Получить проект по идентификатору 
**Endpoint**: `/find/By/Id/{id}`  

**Параметры**: `id (тип: Long)`

**Пример запроса**:  
`
GET http://localhost:8080/api/project/find/By/Id/1
`

**Пример ответа (200 ОК)**
```json
{
  "message": "Поиск прошел успешно!",
  "project": {
    "id": 1,
    "title": "test1",
    "info": "info test1",
    "subjectArea": "Bеб",
    "university": "ИИТ",
    "projectYear": "2024",
    "type": "ORDER",
    "flag_completed": true,
    "command": null
  }
}
```

### 1.3 Получить все проекты 
**Endpoint**: `/find/All`  

**Параметры**: `нет`

**Пример запроса**:  
`
GET http://localhost:8080/api/project/find/All
`

**Пример ответа (200 ОК)**
```json
{
  "message": "Поиск прошел успешно!",
  "project": {
    "id": 1,
    "title": "test1",
    "info": "info test1",
    "subjectArea": "Bеб",
    "university": "ИИТ",
    "projectYear": "2024",
    "type": "ORDER",
    "flag_completed": true,
    "command": null
  },
  {
    "id": 2,
    "title": "test2",
    "info": "info test2",
    "subjectArea": "Data Mining",
    "university": "ИИТ",
    "projectYear": "2025",
    "type": "INITIATIVE",
    "flag_completed": true,
    "command": null
  }
}
```

### 1.4 Получить проект по заголовку 
**Endpoint**: `/find/By/Title/{title}`  

**Параметры**: `title (тип: String)`

**Пример запроса**:  
`
GET http://localhost:8080/api/project/find/By/Title/test1
`

**Пример ответа (200 ОК)**
```json
{
  "message": "Поиск прошел успешно!",
  "project": {
    "id": 1,
    "title": "test1",
    "info": "info test1",
    "subjectArea": "Bеб",
    "university": "ИИТ",
    "projectYear": "2024",
    "type": "ORDER",
    "flag_completed": true,
    "command": null
  }
}
```

### 1.5 Получить проект по институту
**Endpoint**: `/find/By/University/{university}`  

**Параметры**: `university (тип: String)`

**Пример запроса**:  
`
GET http://localhost:8080/api/project/find/By/University/ИИТ
`

**Пример ответа (200 ОК)**
```json
{
  "message": "Поиск прошел успешно!",
  "project": {
    "id": 1,
    "title": "test1",
    "info": "info test1",
    "subjectArea": "Bеб",
    "university": "ИИТ",
    "projectYear": "2024",
    "type": "ORDER",
    "flag_completed": true,
    "command": null
  },
  {
    "id": 2,
    "title": "test2",
    "info": "info test2",
    "subjectArea": "Data Mining",
    "university": "ИИТ",
    "projectYear": "2025",
    "type": "INITIATIVE",
    "flag_completed": true,
    "command": null
  },
  {
    "id": 3,
    "title": "test3",
    "info": "info test3",
    "subjectArea": "Data Mining",
    "university": "ИИТ",
    "projectYear": "2025",
    "type": "INITIATIVE",
    "flag_completed": true,
    "command": null
  },
  {
    "id": 4,
    "title": "test4",
    "info": "info test4",
    "subjectArea": "Data Mining",
    "university": "ИИТ",
    "projectYear": "2025",
    "type": "INITIATIVE",
    "flag_completed": true,
    "command": null
  }
}
```

### 1.6 Получить проект по тегам // Еще доработается
**Endpoint**: `/find/By/Tags`  

**Тело запроса**: 
```json
{
  "tags": ["Java", "SQL"]
}
```

**Пример запроса**:  
`
GET http://localhost:8080/api/project/find/By/Tags
`

**Пример ответа (200 ОК)**
```json
{
  "message": "Поиск прошел успешно!",
  "project": {
    "id": 1,
    "title": "test1",
    "info": "info test1",
    "subjectArea": "Bеб",
    "university": "ИИТ",
    "projectYear": "2024",
    "type": "ORDER",
    "flag_completed": true,
    "command": null
  }
}
```

### 1.7 Получить проект по активности 
**Endpoint**: `/find/By/Flag_completed/{flag}`  

**Параметры**: `flag (тип: boolean <true/false>)`

**Пример запроса**:  
`
GET http://localhost:8080/api/project/find/By/Flag_completed/true
`

**Пример ответа (200 ОК)**
```json
{
  "message": "Поиск прошел успешно!",
  "project": {
    "id": 1,
    "title": "test1",
    "info": "info test1",
    "subjectArea": "Bеб",
    "university": "ИИТ",
    "projectYear": "2024",
    "type": "ORDER",
    "flag_completed": true,
    "command": null
  }
}
```

### 1.8 Получить проект по предметной области 
**Endpoint**: `/find/By/SubjectArea/{subjectArea}`  

**Параметры**: `subjectArea (тип: String)`

**Пример запроса**:  
`
GET http://localhost:8080/api/project/find/By/SubjectArea/ИИТ
`

**Пример ответа (200 ОК)**
```json
{
  "message": "Поиск прошел успешно!",
  "project": {
    "id": 1,
    "title": "test1",
    "info": "info test1",
    "subjectArea": "Bеб",
    "university": "ИИТ",
    "projectYear": "2024",
    "type": "ORDER",
    "flag_completed": true,
    "command": null
  }
}
```

### 1.9 Получить проект по типу проекта
**Endpoint**: `/find/By/Type/{type}`  

**Параметры**: `type (тип: String)`

**Возможные значения**: `ORDER, INITIATIVE, DIGITAL_CAFEDRA, CONTEST`

**Пример запроса**:  
`
GET http://localhost:8080/api/project/find/By/Type/ORDER
`

**Пример ответа (200 ОК)**
```json
{
  "message": "Поиск прошел успешно!",
  "project": {
    "id": 1,
    "title": "test1",
    "info": "info test1",
    "subjectArea": "Bеб",
    "university": "ИИТ",
    "projectYear": "2024",
    "type": "ORDER",
    "flag_completed": true,
    "command": null
  }
}
```

### 1.10 Создание проекта
**Endpoint**: `/createProject`  

**Тело запроса**: 
```json
{
    "title": "test5",
    "info": "info test5",
    "subjectArea": "Мобильные разработки",
    "university": "ИИТ",
    "projectYear": 2023,
    "type": "INITIATIVE",
    "tags": ["React", "SQL"]
}
```
**Пример запроса**:  
`
GET http://localhost:8080/api/project/createProject
`

**Пример ответа (200 ОК)**
```json
{
    "message": "Создание проекта прошло успешно!",
    "id_project": 5
}
```

### 1.11 Обновить статус проекта
**Endpoint**: `/updateStatusProject/{id}`  

**Параметры**: `id (тип: Long)`

**Пример запроса**:  
`
PATCH http://localhost:8080/api/project/updateStatusProject/1
`

**Пример ответа (200 ОК)**
```json
{
    "message": "У проекта установлен статус Завершен!",
    "status_completed": true
}
```
или
```json
{
    "message": "У проекта установлен статус Открыт!",
    "status_completed": false
}
```

## 2. Команды (URL: /command)

### 2.1 Создание команды  
**Endpoint**: `/createCommand/{user_id}`  

**Параметры**: `user_id (тип: Long) - идентификатор пользователя, который создает команду`

**Тело запроса**: 
```json
{
    // Еще нет
}
```

**Пример запроса**:  
`
GET http://localhost:8080/api/command/createCommand/1
`

**Пример ответа (200 ОК)**
```json
{
  
}
```

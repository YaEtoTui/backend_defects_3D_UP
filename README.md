# backend_defects_3D_UP
Бэкенд по ПО для мобильного приложения(Справочник по 3D дефектам)

| API | Описание | Текст ответа |
| --- | -------- | ------------ |
| GET /api/client/defects | Получение инфы по дефектам | List<Defect> |
| GET /api/client/defects/{id} | Получение инфы по дефекту через id | Defect |
| GET /api/client/defects/picture/{id} | Получение изображения | URL |
| PUT /admin/new_file/{id} | Закидывание файла в файловую систему и обновление пути до него | URL |

id в диапазоне от 1 до 27(включительно) и картинки в таком же диапазоне

# Defect

```py
[
  {
    "name": "nameDefect",
    "description": "description",
    "reasons": "reasons",
    "solutions": "solutions",
    "picture": "путь до картинки(внутри проекта)":
  }
]
```

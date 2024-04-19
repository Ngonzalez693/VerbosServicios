# VerbosServicios

## Taller 3: Verbos HTTP

### URL

Corriendo en:

```bash
  http://localhost:8090
```
### GET
Obtiene datos del servidor, recursos o páginas web.

```http
  GET /cars/getCars
```

### POST
Envia datos al servidor, como datos de carga.
```http
  POST /cars/createCar
  {
    "name": "Mustang",
    "brand": "Ford",
    "price": "980000000"
  }
```

### PUT
Reemplaza o crea un recurso específico en el servidor.

```http
  PUT /cars/updateCar
  {
    "id": "601c71bb02cf19093493da58",
    "name": "Mustang gt",
    "brand": "Ford",
    "price": "980000000"
  }
```


### DELETE
Elimina un recurso específico en el servidor.

```http
 DELETE /cars/deleteCar/601c71bb02cf19093493da58
```

### PATCH
Modifica parcialmente un recurso en el servidor.

```http
 PATCH /cars/patchCar/601c6f9d02cf19093493da58
 {
    "name": "Mustang gt"
  }
```

### HEAD
Obtiene solo los encabezados de respuesta, verifica la disponibilidad de recursos sin descargar todo.

```http
 HEAD /cars/headerCar/601c6f9d02cf19093493da54
```

### OPTIONS
Solicita los métodos HTTP permitidos por el servidor para un recurso específico.

```http
 OPTIONS /cars/optionsCar
```
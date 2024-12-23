**Method**: Post
**JSON Body**: 
```json
{
    "routeName": "Test Route",
    "startTime": "2024-12-23T10:00:00",
    "latstart": 50.0,
    "longstart": 8.0,
    "latdest": 51.0,
    "longdest": 9.0,
    "user": { "id": 1 },
    "car": { "id": 2 }
}
```
**Explaination**:
**user** and **car** need nested  ids for quarkus to identify the already existing objects/entries in the database.
The Route should also containe a distance and endTime. Both will be calculated by the Backend and returned. (Not implemented yet)
# Responses
## 200
Returns the whole object as its saved in the DB
```json
{
    "id": 1,
    "routeName": "Test Route",
    "startTime": "2024-12-23T10:00:00",
    "endTime": "2024-12-23T12:00:00",
    "distance": 100.0,
    "latstart": 50.0,
    "longstart": 8.0,
    "latdest": 51.0,
    "longdest": 9.0,
    "user": {
        "id": 1,
        "userName": null,
        "password": null,
        "salt": null,
        "email": "jakob",
        "image": null
    },
    "car": {
        "id": 2,
        "seats": 1,
        "plate": null,
        "description": null,
        "image": null,
        "kilometerPrice": 1.0,
        "basePrice": 1.0,
        "user": {
            "id": 1,
            "userName": null,
            "password": null,
            "salt": null,
            "email": "jakob",
            "image": null
        }
    }
}
```

## 500
On Failure it will respond with some 500 code. Furthermore there is a preset Message and the Exception message.

```json
{
    "error": "Failed to create route,",
    "message": "Du Bube" //My Own Exception
}
```
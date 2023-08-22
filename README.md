 
<h1 align="center">
  VenueWizard
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=GitHub&message=@juravellar&color=66cdaa&labelColor=006400" alt="[@juravellar](https://github.com/juravellar?tab=repositories)" />
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Desafio&color=66cdaa&labelColor=006400" alt="[Desafio](https://github.com/RocketBus/quero-ser-clickbus/tree/master/testes/backend-developer)" />
</p>

# VenueWizard
Esse projeto auxilia na [CRUD](https://developer.mozilla.org/pt-BR/docs/Glossary/CRUD)  de lugares; a estrutura foi gerada através da utilização do Maven e do JDK17.

# Começando

 Para executar o projeto, será necessário instalar os seguintes programas:
 
-[Maven 4.0.0: Necessário para realizar o build do projeto Java](https://maven.apache.org/index.html)

-[JDK 17: Necessário para executar o projeto Java](https://www.oracle.com/java/technologies/downloads/#java17)

-[Eclipse: Para desenvolvimento do projeto](https://www.eclipse.org/downloads/packages/release/oxygen/3a/eclipse-ide-java-ee-developers)

A API [desse desafio](https://github.com/RocketBus/quero-ser-clickbus/tree/master/testes/backend-developer) em backend auxilia 
na [CRUD](https://developer.mozilla.org/pt-BR/docs/Glossary/CRUD) 
de lugares;

O projeto foi elaborado no vídeo: [https://youtu.be/SsWZ4O9iWuo](https://youtu.be/SsWZ4O9iWuo).

### Tecnologias usadas

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Webflux](https://docs.spring.io/spring-framework/reference/web/webflux.html)
- [Spring Data + R2DBC](https://docs.spring.io/spring-framework/reference/data-access/r2dbc.html)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Slugify](https://github.com/slugify/slugify)

### Práticas adotadas

- SOLID
- Testes automatizados
- Consultas com filtros dinâmicos usando o Query By Example
- API reativa na web e na camada de banco
- Uso de DTOs para a API
- Injeção de Dependências
- Geração automática do Swagger com a OpenAPI 3
- Geração de slugs automática com o Slugify
- Auditoria sobre criação e atualização da entidade

### Como Executar

#### Localmente
- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Executar:
```
java -jar place-service/target/place-service-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

#### Usando Docker

- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Construir a imagem:
```
./mvnw spring-boot:build-image
```
- Executar o container:
```
docker run --name place-service -p 8080:8080  -d place-service:0.0.1-SNAPSHOT
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [httpie](https://httpie.io):

- POST /places
```
http POST :8080/places name="Place" state="State"

HTTP/1.1 200 OK
Content-Length: 129
Content-Type: application/json

{
    "createdAt": "2023-04-20T19:00:07.241632",
    "name": "Place",
    "slug": "place",
    "state": "State",
    "updatedAt": "2023-04-20T19:00:07.241632"
}
```

- GET /places/{id}
```
http :8080/places/1
HTTP/1.1 200 OK
Content-Length: 129
Content-Type: application/json

{
    "createdAt": "2023-06-07T14:45:39.693689",
    "name": "Place",
    "slug": "place",
    "state": "State",
    "updatedAt": "2023-06-07T14:45:39.693689"
} 
```

- GET /places?name=?
```
http :8080/places name==PLACE
HTTP/1.1 200 OK
Content-Type: application/json
transfer-encoding: chunked

[
    {
        "createdAt": "2023-06-07T14:45:39.693689",
        "name": "Place",
        "slug": "place",
        "state": "State",
        "updatedAt": "2023-06-07T14:45:39.693689"
    }
]
```

- PATCH /places/{id}
```
http PATCH :8080/places/1 name='New Name' state='New State'
HTTP/1.1 200 OK
Content-Length: 142
Content-Type: application/json

{
    "createdAt": "2023-06-07T14:45:39.693689",
    "name": "New Name",
    "slug": "new-name",
    "state": "New State",
    "updatedAt": "2023-06-07T14:53:21.671129345"
}
```

#### GET /api/postagens 

##### recebe postagens

#### PUT /api/postagens/upvote{id}

##### Atualiza upvote do post

#### POST /api/postagens 

##### Insere novo post, 

#####  `{`

##### `"autor":"nome da pessoa",` 

#####  `"conteudo":" conteudo do post"`  

#####  `}` 



-----------

#### alterar no application.properties

-----------------

### Para ambiente de desenvolvimento, usando h2 local

```
spring.profiles.active=dev
```

------------------------

### Para ambiente de testes, usando h2 em memória

```
spring.profiles.active=test
```

-----------------------

---------------

### Para ambiente de produção (não finalizei)

```
spring.profiles.active=prod
```

-----------------



> Os testes não foram finalizados com total exatidão pois não tenho tanto domínio e precisaria de um tempo maior para aprender, no momento não posso pois estou atarefado;

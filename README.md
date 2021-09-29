# Lis Beer 🍺
<h4> 
	🚧 🚀 Em construção...  🚧
</h4>

### Tabela de conteúdos
<!--ts-->
* [Sobre](#Sobre)
* [Features](#Features)
* [Pré-Requisitos](#Pré-Requisitos)
* [Tecnologias](#tecnologias)
<!--te-->

### Sobre

<p>O Lis Beer nasseu com o objetivo de promover a conexão entre os clientes e as Beers ( Cervejas ) mais próximas de sua casa.</p>

### Features

- [ ] | Cadastro de usuário e Loja
- [ ] | Login de usuário e Loja
- [ ] | Criação de uma nova Beer ( Somente Loja - Deve ser aprovada pelo time de negócio )
- [x] | Obter informações de uma Beer pelo id
- [x] | Obter todas as Beers 
- [ ] |
- [ ] | 

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [sdkman](https://sdkman.io/install), [PostgresSQL 13](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads) e o JDK16 do Java.

Você pode instalar o java atraves do sdkman:

```bash
# openJDK 16.0.2
$ sdk install java 16.0.2-open
```
Além disto é bom ter um editor para trabalhar com o código como o [Intellij](https://www.jetbrains.com/pt-br/idea/download/) ou [VSCode](https://code.visualstudio.com/)

### 🎲 Rodando o Back End (servidor)

```bash
# Clone este repositório
$ git clone https://github.com/Jose-Isaac/lis-beer-api.git
```

```bash
Abra o projeto no intellij ou se preferir via comando line:
# Vá para a pasta desse projeto
$ cd ./lis-beer-api
```

```bash
# Instale as dependências
$ ./gradle build
```

```bash
# Crie o arquivo application.properties em
$ cd /src/main/resources
```
```bash
# Dentro do arquivo application.properties colo o seguinte conteúdo:

## default connection pool
spring.datasource.hikari.connectionTimeout=20000
spring.datasource.hikari.maximumPoolSize=5

## PostgreSQL connection
#spring.jpa.database=
spring.jpa.platform=postgres
spring.datasource.url=jdbc:postgresql://localhost:5432/DATABASE_NAME
spring.datasource.username=YOUR_POSTGRES_USERNAME
spring.datasource.password=YOUR_POSTGRES_PASSWORD

#drop n create table again, good for testing, comment this in production
spring.jpa.hibernate.ddl-auto=create
```

```bash
# O servidor inciará na porta:8080 - acesse <http://localhost:8080>
```

### 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

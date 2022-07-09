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

- [x] | Cadastro de usuário
- [ ] | Cadastro de Loja
- [x] | Obter informações de uma Beer em específico 
- [x] | Visualizar as Beers disponíveis
- [x] | Cadastrar um nova Beer
- [x] | Inserir uma nova categoria
- [ ] | Swagger

[//]: # (- [ ] | )

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [sdkman](https://sdkman.io/install), [Docker Desktop](https://www.docker.com/products/docker-desktop/) e o JDK16 do Java.

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
# Será necessãrio a criação das seguintes variáveis de ambiente:
- RDS_HOSTNAME
- RDS_PORT
- RDS_DB_NAME
- RDS_USERNAME
- RDS_PASSWORD
- JWT_SECRET

# Valores default local:
- RDS_HOSTNAME=localhost;
- RDS_PORT=5432;
- RDS_DB_NAME=lis-beer;
- RDS_USERNAME=development;
- RDS_PASSWORD=development;

- JWT_SECRET=algum-valor-seguro

# Essas variáveis são utilizadas no nosso application.properties que fica localizado em:
$ cd /src/main/resources
```

``` bash
# Você pode iniciar o banco de dados pelo docker do projeto, acesse a pasta docker:
$ cd docker

# Com o docker iniciado, rode o seguinte comando:
$ docker-compose -f docker-compose-dev up
```

```bash
O servidor inciará na porta 8080 - acesse <http://localhost:8080>
```

### 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

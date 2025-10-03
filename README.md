# 🌐 API de Blog/Rede Social (Workshop MongoDB)
Uma API RESTful robusta desenvolvida com Spring Boot e MongoDB para gerenciar usuários, posts e comentários. O projeto utiliza Docker para um ambiente de banco de dados isolado e de fácil configuração.

# 🚀 Tecnologias Utilizadas
Backend: Java 17+

Framework: Spring Boot 3

Banco de Dados: MongoDB (com Spring Data MongoDB)

Conteinerização: Docker e Docker Compose

Arquitetura: RESTful (Camadas: Resource, Service, Repository)

Modelagem de Dados: Padrão DTO e Aninhamento de Documentos (Embedded Data)

⚙️ Como Executar o Projeto
Para rodar o projeto, você precisará ter o Java 17+, Maven e o Docker instalados em sua máquina.

1. Inicializar o Banco de Dados com Docker
Utilizaremos o docker-compose.yml para subir o container do MongoDB.

Bash

# 1. Navegue até a pasta raiz do projeto
cd workShopMongoDB

# 2. Inicie o container do MongoDB em segundo plano
docker-compose up -d
O MongoDB estará acessível na porta padrão 27017. Você pode usar ferramentas como MongoDB Compass para se conectar e visualizar a estrutura dos dados.

2. Rodar a Aplicação Spring Boot
Após o container do banco estar rodando, compile e execute o projeto Spring Boot.

Bash

# 3. Compile e empacote a aplicação
mvn clean install

# 4. Execute a aplicação
mvn spring-boot:run
A aplicação estará acessível em http://localhost:8080.

# 💡 Estrutura da Modelagem de Dados (MongoDB)
Este projeto explora a flexibilidade do MongoDB utilizando o conceito de Aninhamento de Documentos para otimizar a performance de leitura.

1. Entidades Principais
User: Representa os usuários da plataforma.

Post: Representa o conteúdo publicado pelo usuário.

2. Aninhamento de Dados
Para evitar múltiplas consultas (joins) ao banco de dados, utilizamos a estratégia de Embedded Data (Dados Embutidos):

Local do Aninhamento	Dados Aninhados	Vantagem
Dentro do Post	Autor (AuthorDTO)	Garante que o nome e ID do autor sejam carregados com o post em uma única consulta.
Dentro do Post	Lista de Comentários (Comment)	Todos os comentários são carregados junto com o post, otimizando a leitura da tela de visualização do post.

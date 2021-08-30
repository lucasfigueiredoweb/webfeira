# WebFeira

API de Gerenciamento do Ciclo de vida de criação de Feiras Online.

# Tecnologias

>Java 16.0.2

>Spring Boot 2.5.4

>Maven 4.0.0

>PostgresSQL 13.4.1

>H2 Database 1.4.2

>Docker 19.03.12

>docker-compose 1.17.1

>GNU Make 4.1

>Junit 5.7.2

>Kubernetes 1.22 

# Inicialização

Os dados do arquivo “DEINFO_AB_FEIRASLIVRES_2014.csv” contidos no repositorio do projeto, na pasta data, são carregados automaticamente pelo sistema durante sua inicialização no banco de dados alvo.

# Execução

Para execução do projeto de maneira agnostica e sem se preocupar com dependencias como banco de dados Postgres, basta ter o Make instalado e executar os comandos descritos nele, exemplo:

### Limpeza dos arquivos do projeto:
`make clean`
___
### Build do Projeto:
`make build`
___
### Testes do Projeto:
`make test`
___
### Build da Imagem do Docker da aplicação:
`make docker_build`
___
### Execução dos containers da aplicação
`make docker_compose_run`
___
### Limpeza dos containers de aplicação e de banco:
`make docker_compose_clean`
___
OBS: Após a limpeza dos containers os arquivos de dados do Banco ainda poderão ser acessados em:
**/var/lib/postgresql/data/**
___
- Caso queira utilizar o processo de CI/CD via Jenkins, só criar 1 nova pipeline (testado via modo freestyle) no Jenkins e adicionar como arquivo de build o arquivo `Jenkinsfile` contido na raiz do projeto


- Caso queira utilizar o Kubernetes, utilizar o arquivo `deploy.yml` na raiz do projeto, alterando seu host para domain desejado, utilizando Traefik como Ingress Controller
# Documentação

Todos os testes realizados na aplicação foram realizados via ferramenta POSTMAN para testes de API.

https://documenter.getpostman.com/view/954685/U16bvU2e

## Logs da Aplicação

Arquivo na raiz do projeto: `ApplicationLogs.log`

## Melhorias Futuras:,
- Adicionar mais testes e tipos de testes.

- Incrementar Makefile com K8s deploy.

- Implantar em algum cloudProvider ou PaaS para utilização sem necessidade de baixar o projeto.

### Issues

Por favor verificar a seção de Issues do Github para mais informações

### Licença

MIT

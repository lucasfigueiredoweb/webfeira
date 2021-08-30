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
Caso queira utilizar o processo de CI/CD via Jenkins, só criar 1 nova pipeline (testado via modo freestyle) no Jenkins e adicionar como arquivo de build o arquivo `Jenkinsfile` contido na raiz do projeto
# Documentação

Todos os testes realizados na aplicação foram realizados via ferramenta POSTMAN para testes de API.

https://documenter.getpostman.com/view/954685/U16bvU2e

## Logs da Aplicação

Arquivo na raiz do projeto: `ApplicationLogs.log`

## Licença

MIT

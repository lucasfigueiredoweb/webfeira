# WebFeira

API de Gerenciamento do Ciclo de vida de criação de Feiras Online.

# Tecnologias

Java 16.0.2

Spring Boot 2.5.4

Maven 4.0.0

PostgresSQL 13.4.1

Docker 19.03.12

docker-compose 1.17.1

GNU Make 4.1

# Inicialização

Os dados do arquivo “DEINFO_AB_FEIRASLIVRES_2014.csv” contidos no repositorio do projeto, na pasta data, são carregados automaticamente pelo sistema durante sua inicialização no banco de dados alvo.

# Execução

Para execução do projeto de maneira agnostica e sem se preocupar com dependencias como banco de dados Postgres, basta ter o Make instalado e executar os comandos descritos nele, exemplo:

### Limpeza dos arquivos do projeto:
`make clean`

### Build do Projeto:
`make build`

### Testes do Projeto:
`make test`

### Build da Imagem do Docker da aplicação:
`make docker_build`

### Execução dos containers da aplicação construido pelo comando `make docker_build` vinculados ao banco de dados Postgres:
`make docker_compose_run`

### Limpeza dos containers de aplicação e de banco:
`make docker_compose_clean`

OBS: Após a limpeza dos containers os arquivos de dados do Banco ainda poderão ser acessados em:
**/var/lib/postgresql/data/**

# Documentação

https://documenter.getpostman.com/view/954685/U16bvU2e

## Logs da Aplicação

Arquivo: ApplicationLogs.log

## Licença

MIT

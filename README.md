# Тестовое задание для стажера Backend

## Описание
REST API для запросов к БД

## Как запустить приложение
**Перед тем, как запустить проект, убедитесь, что у вас установлен JSK 17 и >, свободны порты 8080 и 5432**
1. Склонировать данный репозиторий:

	git clone https://github.com/IgnaxA/bank-manager.git
2. Открыть терминал и зайти в корневую папку проекта
3. Собрать docker образ БД:

	docker build -f ./docker/images/docker-postgres-scripts.Dockerfile -t ignaxa/bank_manager:postgredb .
4. Запустить контейнеры:

	docker-compose -f ./docker/composes/docker-compose.yml up -d
5. В контейнере 'postgres_container' выполнить следующие команды:

	su postgres

	psql

	\i dbInit.sql

	\i dbFill.sql
6. Запустить API

После запуска проекта можно будет посмотреть swagger: 
http://localhost:8080/swagger-ui/index.html
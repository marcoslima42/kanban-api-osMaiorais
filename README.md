# kanban-api

![GitHub Repo stars](https://img.shields.io/github/stars/BrCME/kanban-api)
![GitHub watchers](https://img.shields.io/github/watchers/BrCME/kanban-api)
![GitHub forks](https://img.shields.io/github/forks/BrCME/kanban-api)
![GitHub followers](https://img.shields.io/github/followers/BrCME)

![Project Image](https://avatars.githubusercontent.com/u/161401654?v=4)

![GitHub Created At](https://img.shields.io/github/created-at/BrCME/kanban-api)
![GitHub contributors](https://img.shields.io/github/contributors-anon/BrCME/kanban-api)
![GitHub last commit](https://img.shields.io/github/last-commit/BrCME/kanban-api)
![GitHub top language](https://img.shields.io/github/languages/top/BrCME/kanban-api)
![GitHub branch status](https://img.shields.io/github/checks-status/BrCME/kanban-api/main)
![GitHub License](https://img.shields.io/github/license/BrCME/kanban-api)
![GitHub Discussions](https://img.shields.io/github/discussions/BrCME/kanban-api)
![GitHub repo size](https://img.shields.io/github/repo-size/BrCME/kanban-api)

Projeto de prática do Módulo Extra do Crash Course em tecnologia Backend.

## Descrição

Este projeto é uma api para a utilização de um quadro no formato kanban para anotações de tarefas por clientes individuais. Assim, foi escolhido a utilização do Padrão de Camadas por sua simplicidade e robustez.

## Tabela de Conteúdo

- [Status do Projeto](#status-do-projeto)
- [Pré-Requisitos](#pré-requisitos)
- [Features](#features)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Contribuição](#contribuição)

## Status do Projeto

O projeto encontra-se na Sprint Inicial, com *features* básicas para o funcionamento e teste local. É planejado que todas as tarefas possam ser cumpridas num prazo pequeno e rápido, para demonstrar um pouco do processo de desenvolvimento de software.

## Pré-Requisitos

Para conseguir utilizar esse projeto, é necessário haver na máquina de desenvolvimento alguns programas essenciais. Abaixo estarão listados formas de instalação dos mesmos, partindo do ponto de uma máquina Debian-based.

```bash
# Atualização do sistema
sudo apt-get update
sudo apt-get upgrade

# Git
sudo apt-get install -y git

# Docker
sudo apt-get install -y docker
sudo systemctl start docker
sudo systemctl enable docker
sudo usermod -aG docker $USER

# OpenJDK 21
sudo apt-get install -y openjdk-21-jdk

# Colar dentro do arquivo .bashrc
JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
export JAVA_HOME
export PATH=$PATH:$JAVA_HOME

sudo gedit ~/.bashrc

# Postman
snap install postman

# DBeaver Community Edition
sudo apt-get install -y dbeaver-ce

# Gradle
sudo apt-get install -y gradle

# Visual Studio Code
sudo snap install code --classic
```


## Features

- Sprint 1:
	- [ ] Criação de Cliente;
	- [ ] Atualização da senha do Cliente;
	- [ ] Documentação das rotas de Cliente;
- Sprint 2:
	- [ ] Deleção de Cliente;
	- [ ] Criação de Tarefa;
	- [ ] Atualização geral de Tarefa;
	- [ ] Atualização de prazo de Tarefa;
	- [ ] Deleção de Tarefa;
	- [ ] Leitura de Tarefas com filtro;
	- [ ] Documentação das rotas de Tarefa;
- Sprint 3: planejamento em progresso.


## Tecnologias Utilizadas

- DBeaver;
- Docker;
- Flyway;
- Git;
- Gradle;
- JUnit;
- Lombok;
- OpenJDK 21;
- PostgreSQL;
- Postman;
- SpringBoot;
- Swagger;
- Visual Studio Code;

## Contribuição

- ![Pedro Rabis](https://avatars.githubusercontent.com/u/42853022?v=4) - ☕ Desenvolvedor e Product Owner;

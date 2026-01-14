# DSLearn-backend 🎓

O **DSLearn** é um sistema de gerenciamento de aprendizado (Learning Management System) de alta complexidade, focado em cenários reais de plataformas de ensino modernas. O projeto desbrava o desenvolvimento de um ecossistema completo que integra cursos, turmas (ofertas), gestão de conteúdos e um fórum interativo de suporte ao aluno.

## 🚀 Sobre o Projeto
Este projeto foi desenvolvido como parte da minha especialização **Java Spring Expert**. Embora baseado em um modelo de referência, decidi expandi-lo para implementar todas as camadas web (Controllers, Services, Repositories) e evoluir a persistência de dados para um ambiente de produção real com **PostgreSQL**.

### Principais Desafios Superados
* **Modelagem de Domínio Complexo:** Implementação de uma arquitetura robusta com diversas relações e heranças.
* **Estratégia de Herança (JOINED):** Uso de herança de tabelas no JPA para as entidades `Lesson`, `Content` e `Task`, garantindo integridade e normalização no banco de dados.
* **Chaves Compostas e Integridade:** Gerenciamento técnico de chaves primárias compostas na relação de matrículas (`Enrollment`) e entregas (`Deliver`).

## 🛠️ Tecnologias Utilizadas
* **Linguagem:** Java 21
* **Framework:** Spring Boot 3.x
* **Persistência:** JPA / Hibernate
* **Banco de Dados:** H2 (Desenvolvimento) e PostgreSQL (Homologação/Real)
* **Segurança:** Spring Security com OAuth2 e JWT (RBAC - Role Based Access Control)

## 🏛️ Modelo Conceitual
O sistema baseia-se no seguinte diagrama de classes, que detalha o ecossistema de aprendizado, matrículas e interações no fórum:

![Modelo de Domínio](assets/modelo-dominio.png)


## 📁 Estrutura do Código
A estrutura segue as melhores práticas do ecossistema Spring, com pacotes bem definidos para entidades, enums e objetos de persistência (PKs):
* `com.joaodev.dslearn.entities`: Modelagem de dados.
* `com.joaodev.dslearn.entities.enums`: Definição de estados (Status de Entrega, Tipos de Recurso).
* `com.joaodev.dslearn.entities.pk`: Classes de suporte para chaves compostas.

## 🛡️ Certificação Relacionada
Este projeto é um dos pilares da minha certificação **Java Spring Expert** (200 horas), onde foram validadas competências em API REST, Segurança, TDD e Cobertura de Testes com Jacoco.

---
Desenvolvido por **João Victor Teixeira** ⚔️

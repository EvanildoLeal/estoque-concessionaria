# 🚗 Gerenciador de Estoque de Veículos

Sistema CRUD completo para gestão de concessionária, desenvolvido como projeto final.

## 🛠️ Tecnologias Utilizadas
- **Backend:** Java 17, Spring Boot, Spring Data JPA
- **Banco de Dados:** MySQL 8
- **Frontend:** HTML, CSS, JavaScript (Vanilla)
- **Ferramentas:** Maven, Git, GitHub, Postman

## ⚙️ Funcionalidades Entregues
- ✅ Cadastro de Veículos (marca, modelo, ano, cor, preço, km, status).
- ✅ Filtros dinâmicos por ano e status na tela.
- ✅ Atualização de informações (ex: mudar status para VENDIDO).
- ✅ Remoção de veículos do estoque.
- ✅ Tratamento global de exceções.

## 🚀 Como Executar o Projeto
1. Clone este repositório.
2. Crie o banco de dados no MySQL executando o script `database.sql` (fornecido no projeto).
3. No arquivo `src/main/resources/application.properties`, configure a senha do seu MySQL.
4. Rode o projeto no VS Code (ou via terminal: `./mvnw spring-boot:run`).
5. Acesse no navegador: `http://localhost:8080`

---
Desenvolvido por **Evanildo Leal** 🎓
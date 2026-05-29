# 🌕 Base Lunar API - Monitoramento de Recursos

## 📋 Descrição
API desenvolvida em **Java com Spring Boot** para controle dos recursos da base lunar.

## 👨‍🚀 Integrantes

| Nome | RM   |
|----|------|
| [Gustavo Nobre Coppola] | [561423] |
| [Pedro Augusto Pioli da Costa Duarte] | [564085]   |
| [Pedro Sinnes Martinez] | [566017]   |

## 🛠️ Tecnologias
- Java 17
- Spring Boot 3.5.14
- Spring Data JPA
- H2 Database (modo file)

## 📦 Endpoints

| Recurso | URL base |
|---------|----------|
| Sensores | `/api/sensores` |
| Reservatórios | `/api/reservatorios` |
| Energia | `/api/energia` |
| Climatização | `/api/climatizacao` |
| Alertas | `/api/alertas` |

## 🗄️ Banco de Dado
- Console H2: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:file:./data/lunarbase`
- Usuário: `sa`
- Senha: (vazio)

## ▶️ Como executar
```bash
mvn spring-boot:run
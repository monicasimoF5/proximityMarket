![img_1.png](img_1.png)

# 🛒 Proximity Market 
![CI](https://github.com/monicasimoF5/proximityMarket/actions/workflows/ci.yml/badge.svg)
---

## 📝 **Introduction**
This is a Spring Boot backend application designed to manage the products grown in the Valencian garden so that they can go from the field to the table directly. We are still at the beginning of the project and at the moment the system supports the management of **Farmers** and their **Products** through CRUD operations.

---

## 🎯 **Project objectives:**

- **Farmer Management** 
  - Add, update, delete and recover farmers.
  - Validation of unique telephone numbers and proper format.

- **Product Management** 
  - Add, update, delete and recover products.
  - Associate products with farmers.

---

## 📦 **erDiagram**
![erDiagram.jpg](utils/erDiagram.jpg)

---

## 📦 **UML Diagram**
![UMLdiagram.jpg](utils/UMLdiagram.jpg)

---

## 📊 **Broad**
![Trello.jpg](utils/Trello.jpg)

---

## 🗂️  **Files Structure**

    |--- .idea
    |--- src
        |--- main
            |--- java
                |---org.msc
                        |--- controllers
                            |--- FarmerController
                            |--- ProductController
                        |--- dtos
                            |--- FarmerRequest
                            |--- FarmerResponse
                            |--- ProductRequest
                            |--- ProductResponse
                        |--- entities
                            |--- Farmer
                            |--- Product
                        |--- exceptions
                            |--- GlobalExceptionHandler
                            |--- MarketAlreadyExistsException
                            |--- MarketExistingPhoneException
                            |--- MarketNotFoundException
                        |--- mappers
                            |--- FarmerMapper
                            |--- ProductMapper
                        |--- repositories
                            |--- FarmerRepository
                            |--- ProductRepository
                        |--- services
                            |--- FarmerService
                            |--- ProductServices
                        |--- ProximityMarketApplication
            |--- resources
                |---application.properties
        |--- test
           |--- java
               |---org.msc
                        |--- controllers
                            |--- FarmerControllerIntegrationTest

---

## UML Class Diagram

---

## 💻 Technology Stack:

<img src="https://img.shields.io/badge/Intellij%20Idea-000?logo=intellij-idea&amp;style=for-the-badge"/> 
<img src= "https://img.shields.io/badge/github-%23121011.svg?&style=for-the-badge&logo=github&logoColor=white"/> 
<img src= "https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/> <img src= "https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=Spring&logoColor=white"/> 
<img src="https://img.shields.io/badge/-Apache Maven-C71A36?style=flat&logo=apachemaven&logoColor=white"/> 
<img src="https://img.shields.io/badge/-Hibernate-59666C?style=flat&logo=hibernate&logoColor=white"/>
<img src= "https://img.shields.io/badge/-Postman-FF6C37?style=flat&logo=postman&logoColor=white"/> 
<img src="https://img.shields.io/badge/-MySQL-4479A1?style=flat&logo=mysql&logoColor=white"/>
<img src="https://img.shields.io/badge/-Docker-2496ED?style=flat&logo=docker&logoColor=white"/> 
<img src="https://img.shields.io/badge/-PostgreSQL-4169E1?style=flat&logo=postgresql&logoColor=white"/>
<img src="https://img.shields.io/badge/-Render-46E3B7?style=flat&logo=render&logoColor=white"/>
<img src="https://img.shields.io/badge/-Trello-0052CC?style=flat&logo=trello&logoColor=white"/>
<img src="https://img.shields.io/badge/Lucid-282C33?logo=lucid&logoColor=fff&style=for-the-badge"/> 
<img src="https://img.shields.io/badge/-Mermaid-FF3670?style=flat&logo=mermaid&logoColor=white"/> 

---

## 🌐 Author

### **Mònica Simó**                      
  [<img src="https://img.shields.io/badge/github-%23121011.svg?&style=for-the-badge&logo=github&logoColor=white" alt="GitHub" />](https://github.com/monicasimoF5)  
  [<img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn" />](https://www.linkedin.com/in/mónica-simó/)
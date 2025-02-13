# Payment and Library Management Project - Java EE

## 📖 Description
The **Payment and Library Management** project is a web application developed in **Java EE** that allows users to manage payments and view their video game library. Users can:
- View their video game library.
- Make payments for their shopping cart.

---

## 🛠️ Technology
This project uses the following technologies:

- **Java EE**: Business logic and data persistence development.
- **Jakarta Persistence API (JPA)**: Data persistence management.
- **Jakarta Servlet**: HTTP request management.
- **JSP (JavaServer Pages)**: Dynamic content generation.
- **CSS**: User interface design and styling.
- **Maven**: Dependency management and project building.
- **MySQL**: Storage of payment and library information.

---

## 📦 Dependencies
Main dependencies used in the project:

- `jakarta.servlet.jsp.jstl-api`: Version **3.0.0**
- `jakarta.el-api`: Version **6.0.0**
- `jakarta.persistence-api`: Version **3.1.0**
- `mysql-connector-j`: Version **8.3.0**
- `eclipselink`: Version **4.0.2**
- `jersey-container-servlet`: Version **3.1.2**

---

## 📂 Project Structure
- The main project structure is as follows:
- `src/main/java/ec/edu/epn/control` # Controllers 
- `src/main/java/ec/edu/epn/model/entities` # Models 
- `src/main/java/ec/edu/epn/model/logic` # Business Logic 
- `src/main/webapp/jsp` # Views (JSP) 
- `src/main/webapp/styles` # Styles (CSS) 
- `src/main/resources/META-INF` # Configuration (persistence.xml)

---

## 🗄️ Database Configuration
The project uses **MySQL** as the database. The configuration is located in the `persistence.xml` file, specifying:

- **Connection URL**.
- **User** and **password**.
- **JDBC Driver**.

---

## 🚀 Controllers
The main controllers are:
- `SvObservarBiblioteca.java`: Handles HTTP requests for viewing the library.
- `SvPagarCarrito.java`: Handles HTTP requests for making payments.
- `...`
---

## 🌟 Views
The views of the project are implemented with **JSP** and located in the `jsp` directory. Key views include:

- `biblioteca.jsp`
- `pagoExitoso.jsp`
- `ingresoTarjeta.jsp`
- `...`
---

## 🎨 Styles
The CSS styles are located in the `src/main/webapp/styles` directory. Main files include:

- `stylesbiblioteca.css`
- `stylespago.css`

---


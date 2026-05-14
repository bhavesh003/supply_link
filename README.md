# SupplyLink

A full-stack supply chain management web application that enables suppliers, warehouses, products, and shipments to be managed through a role-based dashboard.

---

## Overview

SupplyLink is a supply chain management platform built with an Angular frontend and a Spring Boot backend. It supports two roles — **Admin** and **User (Supplier)** — each with different levels of access to manage suppliers, warehouses, products, and shipments.

---

## Tech Stack

**Frontend**
- Angular 14
- NgRx (State Management)
- Bootstrap 5
- RxJS

**Backend**
- Java 11
- Spring Boot 2.7
- Spring Security + JWT Authentication
- Spring Data JPA
- MySQL

---

## Features

- **Role-based access control** — Admin and User (Supplier) roles with JWT-secured endpoints
- **Supplier Management** — Create, view, edit, and delete suppliers
- **Warehouse Management** — Manage warehouse capacity and assignments per supplier
- **Product Management** — Track products stored in warehouses
- **Shipment Tracking** — Monitor shipment status, source/destination, and delivery dates
- **Insurance** — Insurance records linked to shipments
- **Dashboard** — Unified view for suppliers, warehouses, and products with popup forms
- **JWT Authentication** — Stateless token-based auth with HTTP interceptors on the frontend

---

## API Endpoints

| Method | Endpoint                  | Role Required     | Description                  |
|--------|---------------------------|-------------------|------------------------------|
| POST   | `/user/login`             | Public            | Authenticate and get JWT     |
| POST   | `/user/register`          | Public            | Register a new user          |
| GET    | `/supplier`               | USER, ADMIN       | Get all suppliers            |
| GET    | `/supplier/{id}`          | USER, ADMIN       | Get supplier by ID           |
| POST   | `/supplier`               | ADMIN             | Add a new supplier           |
| PUT    | `/supplier/{id}`          | ADMIN             | Update a supplier            |
| DELETE | `/supplier/{id}`          | ADMIN             | Delete a supplier            |
| GET    | `/warehouse`              | USER, ADMIN       | Get all warehouses           |
| POST   | `/warehouse`              | ADMIN             | Add a warehouse              |
| PUT    | `/warehouse/{id}`         | ADMIN             | Update a warehouse           |
| DELETE | `/warehouse/{id}`         | ADMIN             | Delete a warehouse           |
| GET    | `/product`                | USER, ADMIN       | Get all products             |
| POST   | `/product`                | ADMIN             | Add a product                |
| GET    | `/shipment`               | USER, ADMIN       | Get all shipments            |
| POST   | `/shipment`               | ADMIN             | Create a shipment            |
| GET    | `/insurance`              | USER, ADMIN       | Get all insurance records    |

---

## Authentication

The app uses **JWT (JSON Web Token)** for authentication.

- On login, the server returns a token which is stored on the client.
- All subsequent requests attach the token via an HTTP interceptor in the `Authorization: Bearer <token>` header.
- The backend validates the token using a `JwtRequestFilter` before processing protected routes.

---
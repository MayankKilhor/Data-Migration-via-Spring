# Data Migration via Spring Boot

This Spring Boot project facilitates seamless **data migration** from an **old MySQL-based application** to a **new PostgreSQL-based application**.

## 🛠 Purpose

Due to significant changes in data models and business logic between the old and new systems, a simple dump-and-restore was not possible. This migration tool ensures that legacy data is transferred **accurately and intelligently** into the new system, enabling all APIs in the new application to work smoothly with the migrated data.

## 🔁 How It Works

The migration process is split into two key API endpoints:

### 1. **Default Configuration Setup**
- Creates all required **default entries** (e.g., system settings, roles, or master data) in the new PostgreSQL database.
- Ensures the destination schema has all necessary base configurations before importing data.

### 2. **Data Migration Endpoint**
- Extracts data from the legacy MySQL database.
- Transforms it according to the **new data model and business rules**.
- Inserts it into the new PostgreSQL structure in a format compatible with the new application logic.

## ✅ Outcome

After running the migration:
- The new system is fully populated with consistent, compatible data.
- All APIs in the new application behave as if the data was natively created in the new system.

---

## 🔧 Technologies Used
- Spring Boot
- Spring Data JPA
- MySQL (source)
- PostgreSQL (target)
- Model mappers / transformers

---

## 📦 Note

Make sure to exclude `target/` and compiled `.jar` files from version control. Use `.gitignore` to prevent large file issues with GitHub.


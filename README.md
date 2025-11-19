<div align="center">

# 🏦 Java Banking Management System

**A comprehensive Object-Oriented Banking System demonstrating the power of core OOP principles.**

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![OOP](https://img.shields.io/badge/Paradigm-OOP-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Maintained-%3F-green?style=for-the-badge)

[Report Bug] · [Request Feature]

</div>

---

## 📖 Overview
This project is a robust simulation of a banking environment built entirely in **Java**. It serves as a practical implementation of **Inheritance, Polymorphism, Encapsulation, and Abstraction**, showcasing how distinct account types interact within a unified system.

## ✨ Key Features

### 🔐 Core Operations
* **Customer Management:** Create, view, and modify customer profiles.
* **Robust Auditing:** Every deposit, withdrawal, and transfer creates a timestamped transaction record.
* **Polymorphic Behavior:** Different accounts react differently to the same withdrawal or deposit requests.

### 🚀 Advanced Capabilities
* **🔄 Inter-Account Transfers:** Seamlessly move funds between any two accounts in the system.
* **📊 System Analytics:** View aggregate data on total liquidity, customer count, and active accounts.
* **🎯 Smart Lookup:** Efficiently search for accounts using unique IDs across the entire customer base.

---

## 💼 Account Ecosystem

The system utilizes an abstract base class extended by three specialized account types.

| Feature | 🏦 Savings Account | 💳 Checking Account | 🏢 Business Account |
| :--- | :--- | :--- | :--- |
| **Best For** | Long-term growth | Daily spending | Commercial operations |
| **Key Benefit** | **Interest Accumulation** | **Overdraft Protection** | **High Volume Limits** |
| **Fee Structure** | None | Monthly Maintenance | Transaction % Fee |
| **Logic** | Calculates & applies compound interest | Allows negative balance up to a set limit | Enforces strict caps per transaction |

---

## 🛠️ Tech Stack

| Component | Technology Used |
| :--- | :--- |
| **Language** | Java (JDK 8+) |
| **Paradigm** | Object-Oriented Programming |
| **Time Mgmt** | `java.time` API (Instant/LocalDateTime) |
| **Data Structures** | Java Collections (`ArrayList`, `HashMap`) |

---

## 🚀 How to Run

### Prerequisites
* Java Development Kit (JDK) 8 or higher
* Terminal / Command Prompt **OR** Any IDE (IntelliJ, Eclipse, VS Code)

### Installation & Execution
1.  **Clone the repository**
    ```bash
    git clone [https://github.com/yourusername/banking-system.git](https://github.com/yourusername/banking-system.git)
    ```
2.  **Navigate to the directory**
    ```bash
    cd banking-system
    ```
3.  **Compile the project**
    ```bash
    javac src/*.java
    ```
4.  **Run the Main application**
    ```bash
    java src.Main
    ```

---

## 🔮 Roadmap & Future Enhancements

### Phase 1: Core Logic (✅ Completed)
- [x] Basic CRUD for Customers and Accounts
- [x] Polymorphic Transaction processing
- [x] Exception Handling for invalid funds

### Phase 2.5: Database Integration (🚧 In Progress)
- [ ] **MySQL Connectivity:** Replace ArrayLists with persistent database storage.
- [ ] **JDBC Implementation:** Write raw SQL wrappers for Java objects.
- [ ] **State Preservation:** Load/Save bank state on startup/shutdown.

### Phase 3: GUI Development (📅 Planned)
- [ ] **Java Swing / JavaFX:** Move from Console to Windowed Application.
- [ ] **Dashboards:** Visual graphs for account balances.
- [ ] **Real-time Logs:** Scrolling transaction history view.

---

<div align="center">
  <sub>Built with ❤️ using Java. Star this repo if you found it useful!</sub>
</div>

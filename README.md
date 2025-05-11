# 🛒 Magento Cucumber Automation Project

## 📌 Table of Contents

* [Project Description](#project-description)
* [Project Structure](#project-structure)
* [Technologies Used and Dependencies](#technologies-used-and-dependencies)
* [Installation](#installation)
* [Usage](#usage)
* [User Stories & Test Scenarios](#user-stories--test-scenarios)
* [Test Coverage Table](#test-coverage-table)
* [Test Reports](#test-reports)
* [Bug Reports](#bug-reports)
* [Project Team](#project-team)
* [GitHub Links](#github-links)
* [License](#license)
* [Contact](#contact)

---

## 📄 Project Description

Magento is one of the world's most popular e-commerce platforms. It offers both free (Magento Open Source) and paid (
Magento Commerce) versions. This project uses the open-source version to automate functional UI tests using **Java**, *
*Selenium WebDriver**, **Cucumber**, **TestNG**, and **Page Object Model (POM)**.

The goal is to test common user actions such as registration, login, address entry, shopping cart operations, and
placing orders on a Magento e-commerce site.

> Test Environment: [https://magento.softwaretestingboard.com](https://magento.softwaretestingboard.com)

---

### 💪 Key Features

* Cucumber with Gherkin syntax for human-readable test cases
* TestNG + XML execution with browser parameterization
* Thread-safe WebDriver management with `ThreadLocal`
* ExtentReports Integration (HTML & PDF)
* Page Object Model (POM) for modular and maintainable code
* Scenario Outline for data-driven testing
* Data Table usage for parameterized inputs

---

## 🏠 Project Structure

```plaintext
MagentoProject_Cucumber/
├── src/
│   └── test/
│       │
│       ├── java/
│       │   ├── featureFiles/                # .feature files written in Gherkin
│       │   ├── hooks/                       # Cucumber Hooks (Before/After)
│       │   ├── pages/                       # Page Object Model classes
│       │   ├── runners/                     # TestNG runner classes
│       │   │   └── XML/                     # TestNG XML configuration files
│       │   ├── stepDefinitions/             # Cucumber step definitions
│       │   └── utilities/                   # Driver, ConfigReader, ExtentReportManager, etc.
│       │
│       └── resources/                       # ExtentReports configuration
│
├── testBugReports/                          # Bug reports (if any)
├── testGifs/                                # GIFs used in reports
├── testReports/                             # Spark & PDF report output (auto-generated)
├── configuration.properties                 # General test configuration
├── pom.xml                                  # Maven build configuration
└── README.md                                # Project README
```

---

## 🧰 Technologies Used and Dependencies

| Tool/Library            | Description                     |
|-------------------------|---------------------------------|
| Java JDK 21             | Programming Language            |
| Selenium WebDriver 4.31 | Web Automation Tool             |
| Cucumber 7.20           | BDD Testing Framework           |
| TestNG 7.10             | Test Execution Engine           |
| ExtentReports           | Report Generation (HTML & PDF)  |
| Maven                   | Dependency and Build Management |
| Apache POI              | Excel Integration (optional)    |
| Git & GitHub            | Version Control                 |
| SLF4J + Log4j           | Logging Tools                   |

---

## 🚀 Installation

1. Clone the repository:
    ```bash
        git clone https://github.com/<your-username>/MagentoProject_Cucumber.git
    ```

2. Open the project in IntelliJ IDEA (or any IDE)
3. Run:
   ```bash
       mvn clean install
    ```
---

## 🛠️ Usage

* To run all tests:

    ```bash
      mvn test
    ```

* To run specific browser tests:

    * Use `singleBrowserTesting.xml` or `parallelBrowserTesting.xml`
    * Right-click the XML file and run
    * Or You can run the feature file directly by right-clicking on the feature file in the `featureFiles/` folder.

---

## 🧾 User Stories & Test Scenarios

| User Story | Description            | Status   |
|------------|------------------------|----------|
| US_701     | User Registration      | ✅ Passed |
| US_702     | User Login             | ✅ Passed |
| US_703     | Address Transactions   | ✅ Passed |
| US_704     | TAB Menu Check         | ✅ Passed |
| US_705     | Add/Remove from Cart   | ✅ Passed |
| US_706     | Product Order          | ✅ Passed |
| US_707     | Product Search by ID   | ✅ Passed |
| US_708     | Wishlist Functionality | ✅ Passed |

---

## 📊 Test Coverage Table

| Scenario               | Priority |
|------------------------|----------|
| User Registration      | High     |
| User Login             | High     |
| Address Entry          | High     |
| TAB Menu Check         | Medium   |
| Cart Operations        | Medium   |
| Product Order          | High     |
| Product Search         | Low      |
| Wishlist Functionality | Low      |

---

## 📈 Test Reports

| Report Type  | Description                         |
|--------------|-------------------------------------|
| Spark Report | Rich HTML report with screenshots   |
| PDF Report   | Printable report with scenario logs |

Find reports under:

```bash
    /testReports/SparkReport/
    /testReports/PDFReport/
```

---

## 🐞 Bug Reports

Bug tracking is handled in the GitHub Issues tab.

```bash
    /testBugReports/US_705_Cart_Issue.pdf
    /testBugReports/US_707_Search_Error.pdf
```

---

## 👥 Project Team

| Name         | Role                       | User Stories   |
|--------------|----------------------------|----------------|
| Yigit Cam    | Project Lead & QA Engineer | US_705, US_706 |
| Zafer Ataklı | QA Engineer                | US_703         |
| Nuri Öztürk  | QA Engineer                | US_707         |
| Rıfat Batır  | QA Engineer                | US_704         |
| Tugba Kilic  | QA Engineer                | US_701, US_702 |
| Azim Korkmaz | QA Engineer                | US_708         |

---

## 🔗 GitHub Links

* 📁 [Main Repository]()

**Contributors:**

* [Zafer Ataklı](https://github.com/zaferatakli)
* [Rıfat Batır](https://github.com/rftbtr)
* [Tugba Kilic](https://github.com/TugbaKilic33)
* [Nuri Öztürk](https://github.com/NuriOzturk)
* [Azim Korkmaz](https://github.com/AzimKorkmaz)
* [Yigit Cam](https://github.com/Yigit-Cam)

---

## 📜 License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).

---

## 📧 Contact

For questions or suggestions, please reach out via GitHub issues or directly to project contributors.

---


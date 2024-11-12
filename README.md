Banking Application Documentation
Overview
This project is a web-based banking application that supports core banking functions, including account management, card services, loan management, and transaction history tracking. The application offers separate dashboards for clients and employees, allowing them to access and manage various banking services. The project is structured with RESTful APIs, service layer classes for business logic, and HTML templates for the client and employee dashboards.

Project Structure
Controllers - Handles HTTP requests and responses.
Services - Business logic for processing data.
Repositories - Data access layer for interacting with the database.
DTOs - Data Transfer Objects for sending data between the server and clients.
Entities - Database table mappings.
HTML Templates - Frontend interfaces for client and employee dashboards.
1. Controllers
1.1 AccountController
Manages bank accounts.

Endpoints:
GET /api/accounts - Get all accounts.
GET /api/accounts/{id} - Get account by ID.
POST /api/accounts - Create a new account.
PUT /api/accounts/{id} - Update an account by ID.
DELETE /api/accounts/{id} - Delete an account by ID.
GET /api/accounts/by-client/{clientId} - Get accounts by client ID.
1.2 AccountTypeController
Handles account type management.

Endpoints:
GET /api/accountTypes - Get all account types.
GET /api/accountTypes/{id} - Get account type by ID.
POST /api/accountTypes - Create an account type.
PUT /api/accountTypes/{id} - Update an account type.
DELETE /api/accountTypes/{id} - Delete an account type.
1.3 CardController
Manages card operations.

Endpoints:
GET /api/cards - Get all cards.
GET /api/cards/{id} - Get card by ID.
POST /api/cards - Create a new card.
PUT /api/cards/{id} - Update a card by ID.
DELETE /api/cards/{id} - Delete a card by ID.
1.4 CardTypeController
Handles card type management.

Endpoints:
GET /api/cardTypes - Get all card types.
GET /api/cardTypes/{id} - Get card type by ID.
POST /api/cardTypes - Create a new card type.
PUT /api/cardTypes/{id} - Update a card type.
DELETE /api/cardTypes/{id} - Delete a card type.
1.5 ClientApplicationAccountController
Manages client accounts for login and authentication.

Endpoints:
GET /api/clientApplicationAccounts - Get all client accounts.
GET /api/clientApplicationAccounts/{id} - Get client account by ID.
POST /api/clientApplicationAccounts - Create a client account.
PUT /api/clientApplicationAccounts/{id} - Update client account.
DELETE /api/clientApplicationAccounts/{id} - Delete client account.
POST /api/clientApplicationAccounts/login - Authenticate a client account.
1.6 ClientController
Manages client information.

Endpoints:
GET /api/clients - Get all clients.
GET /api/clients/{id} - Get client by ID.
POST /api/clients - Create a new client.
PUT /api/clients/{id} - Update client by ID.
DELETE /api/clients/{id} - Delete client by ID.
1.7 EmployeeApplicationAccountController
Handles employee account management and login.

Endpoints:
GET /api/employeeApplicationAccounts - Get all employee accounts.
GET /api/employeeApplicationAccounts/{id} - Get employee account by ID.
POST /api/employeeApplicationAccounts - Create an employee account.
PUT /api/employeeApplicationAccounts/{id} - Update an employee account.
DELETE /api/employeeApplicationAccounts/{id} - Delete an employee account.
POST /api/employeeApplicationAccounts/login - Authenticate employee account.
1.8 EmployeeController
Handles employee information management.

Endpoints:
GET /api/employees - Get all employees.
GET /api/employees/{id} - Get employee by ID.
POST /api/employees - Create a new employee.
PUT /api/employees/{id} - Update employee by ID.
DELETE /api/employees/{id} - Delete employee by ID.
1.9 LoanController
Manages loans.

Endpoints:
GET /api/loans - Get all loans.
GET /api/loans/{id} - Get loan by ID.
POST /api/loans - Create a new loan.
PUT /api/loans/{id} - Update loan by ID.
DELETE /api/loans/{id} - Delete loan by ID.
1.10 TransactionController
Manages fund transfers.

Endpoints:
POST /api/transactions/transfer - Transfer funds between accounts.
1.11 TransactionHistoryController
Manages transaction history.

Endpoints:
GET /api/transactions - Get all transactions.
GET /api/transactions/{id} - Get transaction by ID.
POST /api/transactions - Create a new transaction.
PUT /api/transactions/{id} - Update transaction by ID.
DELETE /api/transactions/{id} - Delete transaction by ID.
2. Services
Each service class handles business logic for its respective entity. Key services include AccountService, CardService, LoanService, and TransactionHistoryService. For example, TransactionHistoryService manages the transfer process by validating accounts and updating balances.

3. Repositories
Repositories are interfaces extending JpaRepository for each entity, allowing basic CRUD operations and query methods like:

findByAccountNumber in AccountRepository
findByUsername in ClientAccountRepository
findByUsernameAndPassword in EmployeeAccountRepository
4. DTOs
DTOs encapsulate data transfer between the client and server:

AccountDTO - Data for account-related API interactions.
ClientAccountDTO - Data for client application account management.
LoanDTO - Data for loan details.
TransactionHistoryDTO - Data for transaction records.
TransferRequest - Data structure for fund transfer requests.
5. HTML Templates
5.1 client_dashboard.html
Client dashboard displays account info, cards, loans, transaction history, and a form for fund transfer.

Account Info Section: Displays client’s account details.
Cards Section: Shows the list of client’s cards.
Loans Section: Displays active loans.
Transaction History: Shows recent transactions.
Transfer Funds Section: Allows fund transfers between accounts.
5.2 client_login.html
Login page for clients. Upon successful login, redirects to client_dashboard.html.

5.3 employee_dashboard.html
Employee dashboard provides forms to manage clients, accounts, cards, and loans.

Clients Section: Add, view, and manage client information.
Accounts Section: Create new bank accounts.
Cards Section: Manage card issuance.
Loans Section: Add and view loan details.
5.4 employee_login.html
Login page for employees. Redirects to employee_dashboard.html on successful login.

5.5 login_choise.html
Initial login selection page for users to choose between client and employee login options.


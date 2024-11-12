Banking Application Documentation

This project is a web-based banking application designed to support core banking functions,
including account management, card services, loan management, and transaction history tracking. It provides separate dashboards for clients and employees to efficiently access and manage various banking services.

Project Structure
Controllers: Handle HTTP requests and responses.

Services: Contain business logic for processing data.

Repositories: Data access layer for interacting with the database.

DTOs (Data Transfer Objects): Used for sending data between the server and clients.

Entities: Database table mappings.

HTML Templates: Frontend interfaces for client and employee dashboards.

Controllers
1.1 AccountController
Manages bank accounts.

Endpoints:

GET /api/accounts - Retrieve all accounts
GET /api/accounts/{id} - Retrieve account by ID
POST /api/accounts - Create a new account
PUT /api/accounts/{id} - Update an account by ID
DELETE /api/accounts/{id} - Delete an account by ID
GET /api/accounts/by-client/{clientId} - Retrieve accounts by client ID
1.2 AccountTypeController
Manages account type data.

Endpoints:

GET /api/accountTypes - Retrieve all account types
GET /api/accountTypes/{id} - Retrieve account type by ID
POST /api/accountTypes - Create a new account type
PUT /api/accountTypes/{id} - Update an account type
DELETE /api/accountTypes/{id} - Delete an account type
1.3 CardController
Manages card-related operations.

Endpoints:

GET /api/cards - Retrieve all cards
GET /api/cards/{id} - Retrieve card by ID
POST /api/cards - Create a new card
PUT /api/cards/{id} - Update a card by ID
DELETE /api/cards/{id} - Delete a card by ID
... (continue for other controllers, following the same structure)

Services
Each service class manages business logic for its respective entity. Key services include:

AccountService: Handles account-related business logic.
CardService: Manages card-related operations.
LoanService: Manages loan processing.
TransactionHistoryService: Validates and processes fund transfers.
Repositories
Repositories are interfaces extending JpaRepository for each entity, enabling CRUD operations and custom query methods, such as:

findByAccountNumber in AccountRepository
findByUsername in ClientAccountRepository
findByUsernameAndPassword in EmployeeAccountRepository
DTOs (Data Transfer Objects)
DTOs encapsulate data for transferring between client and server:

AccountDTO: Data for account-related interactions.
ClientAccountDTO: Data for managing client accounts.
LoanDTO: Data for loan information.
TransactionHistoryDTO: Data for transaction history.
TransferRequest: Data structure for handling fund transfer requests.
HTML Templates
5.1 client_dashboard.html
Client dashboard with sections for account information, cards, loans, transaction history, and fund transfers.

Account Info Section: Displays client’s account details.
Cards Section: Lists client’s cards.
Loans Section: Shows active loans.
Transaction History: Shows recent transactions.
Transfer Funds Section: Allows fund transfers between accounts.
5.2 client_login.html
Client login page. On successful login, redirects to client_dashboard.html.

5.3 employee_dashboard.html
Employee dashboard with tools to manage clients, accounts, cards, and loans.

Clients Section: Manage client information.
Accounts Section: Create and view bank accounts.
Cards Section: Manage card issuance.
Loans Section: Add and manage loans.
(continue for other templates)

Login
Initial Login
The application provides a choice between client and employee logins through login_choise.html.

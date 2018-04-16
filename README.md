# ElectricityCompanyApp
## Description
#### 
The application have three types of users: managers, regular employees and
clients. Each user has to provide a username and a password in order to use the application.

The **client** can perform the following operations:
- Request for a new account by providing client number and personal information (name,
address, identity card number)
- Authentication
- Visualization of current bills to be payed
- Payment of bills
- Visualization of historical data
- Request for complaint with a short descriptive message about the problem
- Complete a form of complaint information once the request is accepted

An **employee** can perform the following operations:
- Update/view client information (name, identity card number, personal numerical code,
address, etc.).
- Accept a request for complaint: once a request is accepted by a staff member, a response
message should be sent to the client. The response is in fact a form containing
information about:
o detailed description of the problem
o date
o service quality: 1-10
o quick response: 1-10
o customer service quality: 1-10
- View records of complaint

The **manager** can perform the following operations:
- Add new client number - !the only user who can perform this operation! If the client
trying to register does not have a client number in the database, the registration request
will not be accepted!
- CRUD on clients’ information
- CRUD on complaint records
- Generate reports from complaint letters:
    o average notes for each quality evaluated by costumer


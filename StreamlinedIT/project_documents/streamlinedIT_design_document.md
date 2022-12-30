# StreamlinedIT Design Document

## Instructions

*The purpose of this service will be to build tickets through automation, assign those tickets to a support service 
agent, and provide a response that shows the results of ticket generation.  The service will also provide the
history of the client being serviced
.*

## *StreamlinedIT* Design

## 1. Problem Statement

Providing clean and effiecent support ticket generation and storage of data about, client support tickets, ticket 
history, support agent ticket apporpriation.


## 2. Top Questions to Resolve in Review

1. What details are the most important in the service ticket?
2. What http methods will most benefit this design plan?
3.

## 3. Use Cases

//work from here down//

This is where we work backwards from the customer and define what our customers
would like to do (and why). You may also include use cases for yourselves, or
for the organization providing the product to customers.

U1. As a [StreamlinedIT] customer, I want to create a new support ticket when I ask for support on an IT issue.

U2. As a [StreamlinedIT] customer, I want to view my support history when I log into my support page.
    
U3. ...

## 4. Project Scope

We will be building and storing a starting IT support ticket based on the details provided by the client.
We will store all service tickets for the history of both the client and the services provided by the support team.
We will store a list of all clients ensuring that a history of clients is available for search.

### 4.1. In Scope

Ideally all of them.

### 4.2. Out of Scope

There is a massive amount of possible expansion, from AI automation to layers of service data and statistical collection.
  There is even potential for regex searches through automation from keyword gathering to find information about the
keyword topic.

# 5. Proposed Architecture Overview

I will be providing 2 data tables to satisfy the design. They will each be labeled for Users, and ServiceTickets.
This will fully support our data storage needs. The initial service will take data from the client and build out a 
support ticket which will be stored in the SupportTickets table. The users data will be stored as a User in the Users table.
The users table will also hold a number of service agents which will be used by the service to provide a service agent
assignment to every support ticket.

# 6. API

## 6.1. Public Models

The service will expose a service ticket model this will hold all starting service
details about the client and progress of the service ticket.

## 6.2. *First Endpoint*

The first endpoint will be a POST.  This will build a serviceTicket object that
is then added to the Tickets table. The required data for this action will be:
ticketID, of type: String. This is the partition key for the Tickets table. 
There will be several other pieces of data in these tickets, timestamp, userId,
description of the problem. The system will return a string response notifying the
user that they have successfully made a service ticket, and give them a timeline to
expect a service agent response.  This is the expected "200" code response. There
are also "400" invalid input response, and "500" server error response. 400 is for
incompatible date, and 500 will be for a server side malfunction.

insert sequence diagram here....

## 6.3 *Second Endpoint*

The second endpoint will be a GET. This will take the userId and read and return a
list of all tickets that correspond with that userId. This will have a "200" successful
response that returns the list of all tickets connected to the userId. "400" response
referring to no tickets found for that userId. "500" response which will cover server errors.

insert sequence diagram here....

# 7. Tables

*Define the DynamoDB tables you will need for the data your service will use. It
may be helpful to first think of what objects your service will need, then
translate that to a table structure, like with the *`Playlist` POJO* versus the
`playlists` table in the Unit 3 project.*

There will be two POJOs that the service will be making use of.  First the User, which will represent the current
client that is using the service. This will either be loaded or generated depending on weather it is found 
in the user table. The second is the service ticket which will be made for each service or loaded if the service 
history is being checked. 

Users/ Partition Key: userId/ type: String, Sort Key: userTag/ type: String /// 
Tickets/ Partition Key: ticketId/ type: String


# 8. Pages

\bd-team-project-streamlinedit\project_documents\StreamlinedIT_Mock_Page_Design.png

In the mock image, several things can be seen.  First there are 3 pages, this feels
like the right amount, with a simple front page, a page to make a new service ticket,
and a final page to view a users service history. Second, there are buttons to move
from one page to the next for smooth user experience in transitioning back and forth,
from front page to the other pages. Third, there are several pieces of user date to be filled in, and 
a few that are simply filled in by the page. Overall, I am going for simplicity.


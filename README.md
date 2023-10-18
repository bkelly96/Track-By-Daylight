# Dev10-Capstone

## 1. Problem Statement

Gamers want to keep track of their personal progress when playing Dead by Daylight, they want to aggregate their data so they can analyze it. 

## 2. Technical Solution

Creating an application where a gamer can record information such as which characters they were playing, what equipment they were using, their opponents were using, and the outcome.

## 3. Glossary

>### Track By Daylight
> Website that allows the user to record their stats with characters.
> Killer - the one role in the assymetrical.
> Survivor - the many role.
> Trial - a match of Dead by Daylight where 1 Killer tries to hook 4 survivors so they do not escape. 
> Perks - the ability modifiers a player chooses when going into a game.
> Map - the location where a match is played.
> Add ons - The modifiers a Killer uses to adjust their power or a Survivor uses to adjust their item.
> Item - An object a survivor brings into a trial.
> Offering - An object any player can bring into a trial.
> PGC

## 4. High Level Requirement

>- Create a Match  (Admin, User)
>- Edit a Match (Admin)
>- Delete a Match (Admin)
>- Apply for an account (authenticated)
>- View Stats (Admin, Member)

> ### Create a Match
> - Choose their role (Survivor or Killer)
> - Choose their character
> - select the map they played
> - select their perks
> - select the enemy perks, add-ons, characters
> - select if their was anger in the Post Game Chat
> - Record additional notes

> ### Edit a Match
> **Pre-condition** Admin must be logged in

> ### Delete a Match
> **Pre-condition** Admin must be logged in

> ### Create an Account
> - Choose their username and password

> ### Log into their Account
> - Enter the Correct Username and information

> ### View their Profile information
> **Pre-condition** User must be logged in
> - Display Aggregated data, most played character, most hooked survivor.

Flesh out page, information for both roles etc.,


As a User I can Sign Up for an Account -

As a User I can Sign into an Account - 

As a User I can Record a Trial -


### Database - MySQL
> ERD - Complete Tables and Finalize [x] (2.5 hours - Actual) (2 hours Estimated)
> Create Tables [x] (1.5 hours - Actual) (2 hours Estimated)
> Populate Table with data [x] - (2 hours - Actual) (2 hours Estimated)
> Create Test Data and Set Known Good State [x] - (.5 hours - Actual) (1 hour Estimated)

### Security (3 Hours Estimate)(1.5 Hours Actual)-
> Create Repository Layer [x]
> Create JDBC Layer [x]
> Create Service Layer[x]
> Create Controller [x]
> Create App User Model [x]
> Create Jwt Converter [x]
> Create JwtRequestFilter [x]
> Create Security Config [x]

### Database Layer
> Define Models
> Understand the RowMapper

### Service Layer
### Controller Layer

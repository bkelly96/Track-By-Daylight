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
>- ERD - Complete Tables and Finalize [x]  (2 hours Estimated) (2.5 hours - Actual)
>- Create Tables [x] (2 hours Estimated)  (1.5 hours - Actual) 
>- Populate Table with data [x] - (2 hours Estimated) (2 hours - Actual) 
>- Create Test Data and Set Known Good State [x] - (1 hour Estimated) (.5 hours - Actual) 

### Security (3 Hours Estimate)(1.5 Hours Actual)
>- Create Repository Layer [x]
>- Create JDBC Layer [x]
>- Create Service Layer[x]
>- Create Controller [x]
>- Create App User Model [x]
>- Create Jwt Converter [x]
>- Create JwtRequestFilter [x]
>- Create Security Config [x]

### Create Models (2 hours Estimate) (1 Hours Actual)
>- Create Models for all Tables [x]

### Database Layer
>- Survivor Tables  [x] (2 Hours Estimate) (1.75 Hours Actual)
>- Killer Tables  [x] (1 Hour Estimate) (.6 Hours Actual)
>- Map and Trial  [x] Tables (1 Hour Estimate) (.5 Hours Actual)
>- Perk, Offering, Items, Add Ons [x] (1 Hour Esitmate) (.5 Hours Actual)


### Service Layer
>- Offering, Add On, Item, Perk [x] (1 Hour Estimate) (1.5 Hours Actual)
>- Survivor, Trial, Killer [x] (1 Hour Estimate) (.75 Hours Actual)
>- Result, 

### Controller Layer
>- Offering, Add On, Item, Perk [x] (1 Hour Estimate) (1.5 Hours Actual)
>- Killer, Trial, Survivor [x] (1 Hour Estimate) (1 Hours Actual)

### Tests (3 Hours Estimate) (2 Hours Actual)
>- Database Layer Tests [x]
>- Security Service Tests [x]

### Tricky - API Security (3 Hours Estimate) (3 Hours Actual)
>- Auth Context [x]


### Mapping Images [x] (2 Hours Estimate) (3 Hours Actual)

### Login Page Ui [x] (2 Hours Estimate) (2 Hours Actual)

### Trial Card Ui [x] (2 Hours Estimate) (3 Hours Actual)

### Find Perk by Survivor ID [x] Back End
>- Add all perks into Sql and develop query (1 hour Actual)
>- Add Controller, Service, Tests, data layer (3 Hours Estimate) (3 Hours Actual)

### Find Perk by Survivor ID []
>- Add all Images to back end [x]
>- display card for survivor perks
>- import all images into perk card
>- display perk bad on image.

### Cache Searches (4 Hours Estimate) (4 Hours Actual)
>- Create Cached Results for search to reduce workload [x] 

### Switching Images to JSON files and ID
>- Add Killers, Survivors , Perks to JSON file []
>- populate image based on killer name and pull from Json files instead of Switch []

### Host on AWS 
### Profile Page Ui [x] (2 Hours Estimate) (2 Hours Actual)

### Nav Bar Ui [x] (1 Hour Estimate) (.5 Hours Actual)


### Next Steps as of 12/26/2023
see google docs


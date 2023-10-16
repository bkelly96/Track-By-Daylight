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

As a User I can Record a Match -

User Table -
User Id -
Password - 

Matches - 
Match id - 
Userid
Map - Name
Map - Realm
Killer Character
Killer Perk 1
Killer Perk 2
Killer Perk 3
Killer Perk 4
Add on 1
Add on 2
Survivor 1 Character
S1 - Perk 1
S1 - Perk 2
S1 - Perk 3
S1 - Perk 4
Item -
Add on 1
Add on 2
Survivor 2 Character
S2 - Perk 1
S2 - Perk 2
S2 - Perk 3
S2 - Perk 4
Item -
Add on 1
Add on 2
Survivor 3 Character
S3 - Perk 1
S3 - Perk 2
S3 - Perk 3
S3 - Perk 4
Item -
Add on 1
Add on 2
Survivor 4 Character
S4 - Perk 1
S4 - Perk 2
S4 - Perk 3
S4 - Perk 4
Item -
Add on 1
Add on 2
Date -
Salt -

Matches -
Match Id - Not Null 
User Id - Not Null
Date - Not Null
Salt - yes/no

Map - 
Map Id - Not Null
Match Id - Not Null

Killer - 
Killer Id - int PK
Match Id - Not Null
Killer Name - Not Null
isPlayer - 

Perk 1 - 
Perk 2 - 
Perk 3 - 
Perk 4 - 
Offering - 
Add on 1 -
Add on 2 - 
isPlayer - 


Survivor - 
Survivor Id - int PK
Survivor Name - Not Null
Survive? - 
isPlayer -

Offering - 
Perk 1 - 
Perk 2 - 
Perk 3 - 
Perk 4 - 
Item - 
Add on 1 -
Add on 2 - 


Perk:
Match Id - Not Null 
Perk Id - int auto increment
Perk name - Varchar (exists in Tricky)

Item: 
item id - Not Null (our side)
Survivor id - Not Null (our side)
Item name - 
Add on id - 

Offerings:
Offering id - 
Offering Name - 


Addon: 
Addon id - PK Not Null (our side)
Addon Name - Not Null (Tricky Side)
Add On Role - Survivor/Killer

ERD - Complete Tables and Finalize [x] 2.5 hours - Actual

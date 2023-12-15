drop database if exists Track_By_Daylight;
create database Track_By_Daylight;
use Track_By_Daylight;


create table app_user (
    app_user_id int primary key auto_increment,
    username varchar(50) not null unique,
    password_hash varchar(2048) not null,
    enabled bit not null default(1)
);

create table app_role (
    app_role_id int primary key auto_increment,
    `name` varchar(50) not null unique
);

create table app_user_role (
    app_user_id int not null,
    app_role_id int not null,
    constraint pk_app_user_role
        primary key (app_user_id, app_role_id),
    constraint fk_app_user_role_user_id
        foreign key (app_user_id)
        references app_user(app_user_id),
	constraint fk_app_user_role_role_id
        foreign key (app_role_id)
        references app_role(app_role_id)
);

create table map (
	map_id int primary key auto_increment,
    map_name varchar(75) NOT NULL,
    realm_name varchar(75) NOT NULL
);

create table trial (
	trial_id int primary key auto_increment,
    `date` DATE NOT NULL, 
    salt boolean NOT NULL,
	app_user_id int NOT NULL, 
    map_id int NOT NULL,
    constraint fk_app_user_id
		foreign key(app_user_id)
        references app_user(app_user_id),
	constraint fk_map_trial_id
		foreign key (map_id)
        references map(map_id)
);

create table killer (
	killer_id int primary key auto_increment,
    killer_name varchar(50) NOT NULL, 
    is_player boolean NOT NULL,
	trial_id int NOT NULL, 
	constraint fk_trial_id_killer
		foreign key(trial_id)
        references trial(trial_id)
);

create table survivor (
	survivor_id int primary key auto_increment,
    survivor_name varchar(50) NOT NULL, 
    survive boolean NOT NULL,
    is_player boolean NOT NULL,
	trial_id int NOT NULL, 
	constraint fk_trial_id_survivor
		foreign key(trial_id)
        references trial(trial_id)
);

create table offering(
	offering_id int primary key auto_increment,
    offering_name varchar(50) NOT NULL
);

create table perk(
	perk_id int primary key auto_increment,
    perk_name varchar(50) NOT NULL
);

create table item(
	item_id int primary key auto_increment,
    item_name varchar(50) NOT NULL
);

create table add_on(
	add_on_id int primary key auto_increment,
    add_on_name varchar(50) NOT NULL
);

create table killer_offering(
	killer_offering_id int primary key auto_increment,
    killer_id int NOT NULL,
    offering_id int NOT NULL,
    constraint fk_offering_id_killer
		foreign key(offering_id)
        references offering(offering_id),
   constraint fk_killer_id_offering
		foreign key(killer_id)
        references killer(killer_id)
);

create table killer_perk(
	killer_perk_id int primary key auto_increment,
    killer_id int NOT NULL,
    perk_id int NOT NULL,
    constraint fk_perk_id_killer
		foreign key(perk_id)
        references perk(perk_id),
   constraint fk_killer_id_perk
		foreign key(killer_id)
        references killer(killer_id)
);

create table killer_add_on(
	killer_add_on_id int primary key auto_increment,
    killer_id int NOT NULL,
    add_on_id int NOT NULL,
	constraint fk_add_on_id_killer
		foreign key(add_on_id)
        references add_on(add_on_id),
   constraint fk_killer_id_add_on
		foreign key(killer_id)
        references killer(killer_id)
);

create table survivor_offering(
	survivor_offering_id int primary key auto_increment,
    survivor_id int NOT NULL,
    offering_id int NOT NULL,
    constraint fk_offering_id_survivor
		foreign key(offering_id)
        references offering(offering_id),
   constraint fk_survivor_id_offering
		foreign key(survivor_id)
        references survivor(survivor_id)
);

create table survivor_perk(
	survivor_perk_id int primary key auto_increment,
    survivor_id int NOT NULL,
    perk_id int NOT NULL,
    constraint fk_perk_id_survivor
		foreign key(perk_id)
        references perk(perk_id),
   constraint fk_survivor_id_perk
		foreign key(survivor_id)
        references survivor(survivor_id)
);

create table survivor_item(
	survivor_item_id int primary key auto_increment,
    survivor_id int NOT NULL,
    item_id int NOT NULL,
    constraint fk_item_id_survivor
		foreign key(item_id)
        references item(item_id),
   constraint fk_survivor_id_item
		foreign key(survivor_id)
        references survivor(survivor_id)
);

create table survivor_add_on(
	survivor_add_on_id int primary key auto_increment,
    survivor_id int NOT NULL,
    add_on_id int NOT NULL,
	constraint fk_add_on_id_survivor
		foreign key(add_on_id)
        references add_on(add_on_id),
   constraint fk_survivor_id_add_on
		foreign key(survivor_id)
        references survivor(survivor_id)
);

insert into app_role (`name`) values
    ('USER'),
    ('ADMIN');

-- passwords are set to "P@ssw0rd!"
insert into app_user (username, password_hash, enabled)
    values
    ('john@smith.com', '$2a$10$ntB7CsRKQzuLoKY3rfoAQen5nNyiC/U60wBsWnnYrtQQi8Z3IZzQa', 1),
    ('sally@jones.com', '$2a$10$ntB7CsRKQzuLoKY3rfoAQen5nNyiC/U60wBsWnnYrtQQi8Z3IZzQa', 1);

insert into app_user_role
    values
    (1, 2),
    (2, 1);

insert into map (map_name, realm_name) values
('Disturbed Ward','Asy_Asylum'),
('Mother''s Dwelling','Brl_MaHouse');
    
insert into trial (`date`, salt, app_user_id, map_id) values
('2023-10-12', true, 1, 1),
('2023-10-11', false, 2, 2);

insert into killer (killer_name, is_player, trial_id) values
('Chuckles', false, 1),
('Clown', true, 2);

insert into survivor(survivor_name, survive, is_player, trial_id) values
('Dwight', true,  true, 1),
('Claudette', false, false, 1),
('Jake', false, false, 1),
('Meg', true, false, 1), 
('Laurie', true, false, 2),
('Ace', true,  false, 2),
('Feng', false, false, 2), 
('Bill', true, false, 2);

insert into offering(offering_name) values
('Gruesome Gateau'),
('Black Salt Statuette'),
('Bound Envelope'),
('Chalk Pouch'),
('Escape! Cake'),
('Tanager Wreath'),
('Fragrant Sweet William'),
('Fresh Bog Laurel'),
('Petrified Oak'),
('Salt Pouch');

insert into perk(perk_name) values
('Ace in the Hole'),
('Adrenaline'),
('Aftercare'),
('Alert'),
('Any Means Necessary'),
('Appraisal'),
('Autodidact'),
('Background Player'),
('Balanced Landing'),
('Better than New'),
('Bite the Bullet'),
('Blast Mine'),
('Blood Pact'),
('Blood Rush'),
('Boil Over'),
('Bond'),
('Boon: Circle of Healing'),
('Boon: Dark Theory'),
('Boon: Exponential'),
('Boon: Shadow Step'),
('Borrowed Time'),
('Botany Knowledge'),
('Breakdown'),
('Breakout'),
('Buckle Up'),
('Built to Last'),
('Calm Spirit'),
('Chemical Trap'),
('Clairvoyance'),
('Corrective Action'),
('Counterforce'),
('Cut Loose'),
('Dance With Me'),
('Dark Sense'),
('Dead Hard'),
('Deception'),
('Decisive Strike'),
('Déjà Vu'),
('Deliverance'),
('Desperate Measures'),
('Detective''s Hunch'),
('Distortion'),
('Diversion'),
('Dramaturgy'),
('Empathic Connection'),
('Empathy'),
('Fast Track'),
('Flashbang'),
('Flip-Flop'),
('Fogwise'),
('For the People'),
('Friendly Competition'),
('Guardian'),
('Head On'),
('Hope'),
('Hyperfocus'),
('Inner Focus'),
('Inner Healing'),
('Iron Will'),
('Kindred'),
('Kinship'),
('Leader'),
('Left Behind'),
('Light-Footed'),
('Lightweight'),
('Lithe'),
('Low Profile'),
('Lucky Break'),
('Lucky Star'),
('Made for This'),
('Mettle of Man'),
('No Mither'),
('No One Left Behind'),
('Object of Obsession'),
('Off the Record'),
('Open-Handed'),
('Overcome'),
('Overzealous'),
('Parental Guidance'),
('Pharmacy'),
('Plot Twist'),
('Plunderer''s Instinct'),
('Poised'),
('Potential Energy'),
('Power Struggle'),
('Premonition'),
('Prove Thyself'),
('Quick & Quiet'),
('Quick Gambit'),
('Reactive Healing'),
('Reassurance'),
('Red Herring'),
('Renewal'),
('Repressed Alliance'),
('Residual Manifest'),
('Resilience'),
('Resurgence'),
('Rookie Spirit'),
('Saboteur'),
('Scavenger'),
('Scene Partner'),
('Self-Aware'),
('Self-Care'),
('Self-Preservation'),
('Situational Awareness'),
('Slippery Meat'),
('Small Game'),
('Smash Hit'),
('Sole Survivor'),
('Solidarity'),
('Soul Guard'),
('Spine Chill'),
('Sprint Burst'),
('Stake Out'),
('Streetwise'),
('Teamwork: Collective Stealth'),
('Teamwork: Power of Two'),
('Technician'),
('Tenacity'),
('This Is Not Happening'),
('Troubleshooter'),
('Unbreakable'),
('Up the Ante'),
('Urban Evasion'),
('Vigil'),
('Visionary'),
('Wake Up!'),
('We''ll Make It'),
('We''re Gonna Live Forever'),
('Windows of Opportunity'),
('Wiretap'),
('A Nurse''s Calling'),
('Agitation'),
('Alien Instinct'),
('Awakened Awareness'),
('Bamboozle'),
('Barbecue & Chilli'),
('Beast of Prey'),
('Bitter Murmur'),
('Blood Echo'),
('Blood Warden'),
('Bloodhound'),
('Brutal Strength'),
('Call of Brine'),
('Claustrophobia'),
('Corrupt Intervention'),
('Coulrophobia'),
('Coup de Grâce'),
('Dark Devotion'),
('Darkness Revealed'),
('Dead Man''s Switch'),
('Deadlock'),
('Deathbound'),
('Deerstalker'),
('Discordance'),
('Dissolution'),
('Distressing'),
('Dragon''s Grip'),
('Dying Light'),
('Enduring'),
('Eruption'),
('Fearmonger'),
('Fire Up'),
('Forced Hesitation'),
('Forced Penance'),
('Franklin''s Demise'),
('Furtive Chase'),
('Game Afoot'),
('Gearhead'),
('Genetic Limits'),
('Grim Embrace'),
('Hex: Blood Favour'),
('Hex: Crowd Control'),
('Hex: Devour Hope'),
('Hex: Face the Darkness'),
('Hex: Haunted Ground'),
('Hex: Huntress Lullaby'),
('Hex: No One Escapes Death'),
('Hex: Pentimento'),
('Hex: Plaything'),
('Hex: Retribution'),
('Hex: Ruin'),
('Hex: The Third Seal'),
('Hex: Thrill of the Hunt'),
('Hex: Undying'),
('Hoarder'),
('Hubris'),
('Hysteria'),
('I''m All Ears'),
('Infectious Fright'),
('Insidious'),
('Iron Grasp'),
('Iron Maiden'),
('Jolt'),
('Knock Out'),
('Lethal Pursuer'),
('Leverage'),
('Lightborn'),
('Machine Learning'),
('Mad Grit'),
('Make Your Choice'),
('Merciless Storm'),
('Monitor & Abuse'),
('Nemesis'),
('No Way Out'),
('Nowhere to Hide'),
('Oppression'),
('Overcharge'),
('Overwhelming Presence'),
('Play with Your Food'),
('Pop Goes the Weasel'),
('Predator'),
('Rancor'),
('Rapid Brutality'),
('Remember Me'),
('Save the Best for Last'),
('Scourge Hook: Floods of Rage'),
('Scourge Hook: Gift of Pain'),
('Scourge Hook: Hangman''s Trick'),
('Scourge Hook: Monstrous Shrine'),
('Scourge Hook: Pain Resonance'),
('Septic Touch'),
('Shadowborn'),
('Shattered Hope'),
('Sloppy Butcher'),
('Spies from the Shadows'),
('Spirit Fury'),
('Starstruck'),
('Stridor'),
('Superior Anatomy'),
('Surveillance'),
('THWACK!'),
('Terminus'),
('Territorial Imperative'),
('Thanatophobia'),
('Thrilling Tremors'),
('Tinkerer'),
('Trail of Torment'),
('Ultimate Weapon'),
('Unnerving Presence'),
('Unrelenting'),
('Whispers'),
('Zanshin Tactics');

insert into item (item_name) values
('Toolbox'),
('Broken Key'),
('Flashlight'),
('Camping Aid Kit'),
('Engineer''s Toolbox'),
('Dull Key'),
('Sport Flashlight'),
('First Aid Kit');

insert into add_on (add_on_name) values
('Honing Stone'),
('Serrated Jaws'),
('Scraps'),
('Wire Spool'),
('Prayer Rope'),
('Prayer Beads'),
('Battery'),
('Heavy Duty Battery'),
('Bandages'),
('Gel Dressings'),
('Party Bottle'),
('Smelly Inner Soles'),
('Clean Rag'),
('Grip Wrench'),
('Eroded Token'),
('Gold Token'),
('Focus Lens'),
('Wide Lens'),
('Medical Scissors'),
('Butterfly Tape');

insert into killer_offering (killer_id, offering_id) values 
(1, 1),
(2, 6);

insert into killer_perk(killer_id, perk_id) values
(1, 132),
(1, 133),
(1, 134),
(1, 135),
(2, 136),
(2, 137),
(2, 138),
(2, 139);

insert into killer_add_on(killer_id, add_on_id) values
(1, 1),
(1, 2),
(2, 11),
(2, 12);

insert into survivor_offering(survivor_id, offering_id) values
(1, 2),
(2, 3),
(3, 4),
(4, 5),
(5, 7),
(6, 8),
(7, 9),
(8, 10);

insert into survivor_perk( survivor_id, perk_id) values
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 5),
(2, 6),
(2, 7),
(2, 8),
(3, 9),
(3, 10),
(3, 11),
(3, 12),
(4, 13),
(4, 14),
(4, 15),
(4, 16),
(5, 21),
(5, 22),
(5, 23),
(5, 24),
(6, 25),
(6, 26),
(6, 27),
(6, 28),
(7, 29),
(7, 30),
(7, 31),
(7, 32),
(8, 33),
(8, 34),
(8, 35),
(8, 36);

insert into survivor_item(survivor_id, item_id) values
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8);

insert into survivor_add_on(survivor_id, add_on_id) values
(1, 3),
(1, 4),
(2, 5),
(2, 6),
(3, 7),
(3, 8),
(4, 9),
(4, 10),
(5, 13),
(5, 14),
(6, 15),
(6, 16),
(7,17),
(7, 18),
(8, 19),
(8, 20);



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

create table trial (
	trial_id int primary key auto_increment,
    `date` DATE NOT NULL, 
    salt boolean NOT NULL,
	app_user_id int NOT NULL, 
    constraint fk_app_user_id
		foreign key(app_user_id)
        references app_user(app_user_id)
);

create table map (
	map_id int primary key auto_increment,
    map_name varchar(75) NOT NULL,
    realm_name varchar(75) NOT NULL,
    trial_id int NOT NULL, 
	constraint fk_trial_id
		foreign key(trial_id)
        references trial(trial_id)
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
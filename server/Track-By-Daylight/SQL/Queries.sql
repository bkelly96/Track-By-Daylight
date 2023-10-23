use track_by_daylight_test;
set sql_safe_updates = 0;
call set_known_good_state();
set sql_safe_updates =1;

select * from survivor;

#Survivor Add On Get all
select sa.survivor_add_on_id, sa.survivor_id, sa.add_on_id, a.add_on_id, a.add_on_name 
from survivor_add_on sa
inner join add_on a on sa.add_on_id = a.add_on_id;

#Survivor Item get all
select si.survivor_item_id, si.survivor_id, si.item_id, i.item_id, i.item_name 
from survivor_item si
inner join item i on si.survivor_item_id = i.item_id;

#Survivor perk get all
select sp.survivor_perk_id, sp.survivor_id, sp.perk_id, p.perk_id, p.perk_name 
from survivor_perk sp
inner join perk p on sp.perk_id = p.perk_id;


#Survivor Offering get all
select so.survivor_offering_id, so.survivor_id, so.offering_id, o.offering_id, o.offering_name
from survivor_offering so
inner join offering o on so.offering_id = o.offering_id;

#Killer Offering get all
select ko.killer_offering_id, ko.killer_id, ko.offering_id, o.offering_id, o.offering_name
from killer_offering ko
inner join offering o on ko.offering_id = o.offering_id;

#Killer Add On Get all
select ka.killer_add_on_id, ka.killer_id, ka.add_on_id, a.add_on_id, a.add_on_name 
from killer_add_on ka
inner join add_on a on ka.add_on_id = a.add_on_id;

#Killer perk get all
select kp.killer_perk_id, kp.killer_id, kp.perk_id, p.perk_id, p.perk_name 
from killer_perk kp
inner join perk p on kp.perk_id = p.perk_id;

#Killer get killer
select killer_id, killer_name, is_player, trial_id from killer;

#Survivor get Survivor
select survivor_id, survivor_name, is_player, trial_id from survivor;

#Map get Maps
select map_id, map_name, realm_name, trial_id from map;

#Trial get Trials
select trial_id, date, salt, app_user_id from trial;

##select all trials for a user
select t.trial_id, t.date, t.salt, t.app_user_id, m.map_id, m.map_name, m.realm_name, m.trial_id
from trial t 
inner join map m on m.trial_id = t.trial_id
where t.app_user_id = 1;

## find match by id on the front end - hook up the front end and back end

## query independently, add the items by survivor, add the item by killer 1. select survivor, s item, s add on, s perk where match id = 1, reference Agency
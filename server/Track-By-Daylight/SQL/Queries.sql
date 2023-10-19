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
inner join perk p on sp.survivor_perk_id = p.perk_id;


#Survivor Offering get all
select so.survivor_offering_id, so.survivor_id, so.offering_id, o.offering_id, o.offering_name
from survivor_offering so
inner join offering o on so.offering_id = o.offering_id;

#Killer Offering get all
select so.survivor_perk_id, sp.survivor_id, sp.perk_id, p.perk_id, p.perk_name 
from survivor_perk sp
inner join perk p on sp.survivor_perk_id = p.perk_id;

#Survivor Add On Get all
select sa.survivor_add_on_id, sa.survivor_id, sa.add_on_id, a.add_on_id, a.add_on_name 
from survivor_add_on sa
inner join add_on a on sa.add_on_id = a.add_on_id;

#Survivor perk get all
select sp.survivor_perk_id, sp.survivor_id, sp.perk_id, p.perk_id, p.perk_name 
from survivor_perk sp
inner join perk p on sp.survivor_perk_id = p.perk_id;

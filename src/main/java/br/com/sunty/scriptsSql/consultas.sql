select * from category where isActive=1 order by orderToShow;
select * from sub_category where isActive=1 order by orderToShow;
select * from course where visibility="PUBLICA";
select name from sub_category where shortDescription="" or shortDescription IS NULL;
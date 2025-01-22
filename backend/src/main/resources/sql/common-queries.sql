-- List of fish with related tiers
select fish.name, tiers.name from searobin.fish
join searobin.tiers on tiers.id = fish.tier_id;

select * from searobin.fish;
select * from searobin.tiers;

select * from searobin.organization;
select * from searobin.tournaments;
select * from searobin.anglers;
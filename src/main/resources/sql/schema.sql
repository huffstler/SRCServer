-- can update schema later on to have org level rules as well as tournament level rules
drop table if exists searobin.anglers cascade;
drop table if exists searobin.catches cascade;
drop table if exists searobin.fish cascade;
drop table if exists searobin.membership cascade;
drop table if exists searobin.organization cascade;
drop table if exists searobin.tiers cascade;
drop table if exists searobin.tournaments cascade;

create table searobin.organization(
	id uuid primary key default gen_random_uuid(),
	org_name text unique not null, -- add index on this field
	created_on timestamp
);
CREATE INDEX organization_name_idx on searobin.organization (org_name);

create table searobin.tournaments (
	id uuid primary key default gen_random_uuid(),
	organization_id uuid references searobin.organization (id),
	tournament_name text not null, -- add index on this field
	start_time timestamp,
	end_time timestamp,
	created_on timestamp
	
	-- I'm thinking I want some sort of "global" score count here, 
	-- but not sure what data type to have that as yet. Maybe json blob that's
	-- calculated once, and stored here after for faster results after tourney ends.
);
CREATE INDEX tournament_name_idx on searobin.tournaments (tournament_name);

-- used for mapping anglers to tournaments and vice versa
create table searobin.membership (
	id uuid primary key default gen_random_uuid(),
	tournament_id uuid references searobin.tournaments (id),
	organization_id uuid references searobin.organization (id),
	angler_id uuid references searobin.anglers (id),
	is_org_admin boolean default 'false',
	is_tourney_admin boolean default 'false'
);

create table searobin.anglers (
	id uuid primary key default gen_random_uuid(),
	username text unique, -- add index on this field
	-- not yet. Harden the system first. firstname text,
	-- not yet. Harden the system first. lastname text,
	-- not yet. Harden the system first. phonenumber text,
	-- not yet. Harden the system first. emailaddress text,
	created_on timestamp
);
CREATE INDEX angler_name_idx on searobin.anglers (username);

create table searobin.catches (
    -- I don't think we need a new uuid for each catch. could probably make an index based on 3 or 4 other columns?
	id uuid primary key default gen_random_uuid(),
	-- maybe replace the two below with membership_id at some point?
	tournament_id uuid references searobin.tournaments (id),
	angler_id uuid references searobin.anglers (id),
	-- 
	-- membership_id uuid references searobin.membership (id),
	--
	fish_id int references searobin.fish (id),
	fish_length real,
	used_lure boolean default 'false',
	catch_time timestamp default now()
);

create table searobin.tiers(
    id integer NOT NULL DEFAULT nextval('searobin.tiers_id_seq'::regclass),
    name text COLLATE pg_catalog."default",
    CONSTRAINT tiers_pkey PRIMARY KEY (id),
    CONSTRAINT tiers_name_check CHECK (name <> ''::text)
);

create table searobin.fish (
    name text COLLATE pg_catalog."default",
    tier_id integer,
    id integer NOT NULL DEFAULT nextval('searobin.tiers_id_seq'::regclass),
    CONSTRAINT fish_pkey PRIMARY KEY (id),
    CONSTRAINT fish_tier_id_fkey FOREIGN KEY (tier_id)
        REFERENCES searobin.tiers (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

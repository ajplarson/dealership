drop database if exists dealershiptest;
create database dealershiptest;
use dealershiptest;

-- authentication START

create table `user`(
`id` int primary key auto_increment,
`username` varchar(30) not null unique,
`email` varchar(30) not null unique,
`password` varchar(100) not null,
`enabled` boolean not null,
`firstName` varchar(30) not null,
`lastName` varchar(40) not null);

create table `role`(
`id` int primary key auto_increment,
`role` varchar(30) not null
);

create table `user_role`(
`user_id` int not null,
`role_id` int not null,
primary key(`user_id`,`role_id`),
foreign key (`user_id`) references `user`(`id`),
foreign key (`role_id`) references `role`(`id`));

-- I have hashed passwords these are just for testing
insert into `user`(`id`,`username`,`password`,`enabled`, `email`, `firstName`, `lastName`)
    values(1,"admin", "password", true, "fake_email@yahoo.com", "Frank", "Jones"),
        (2,"user","password",true, "test_user_email@gmail.com", "Leslie", "Johnson"),
		(3,"sales","password",true, "test_sales_email@gmail.com", "John", "Lopez");


-- insert into `role`(`id`,`role`)
--     values(1,"ROLE_ADMIN"), (2,"ROLE_USER"), (3,"ROLE_SALES");
--     
-- insert into `user_role`(`user_id`,`role_id`)
--     values(1,1),(1,2),(1,3),(2,2),(3,1),(3,3);
   --  
-- UPDATE user SET password = '$2a$10$S8nFUMB8YIEioeWyap24/ucX.dC6v9tXCbpHjJVQUkrXlrH1VLaAS' WHERE id = 1;
-- UPDATE user SET password = '$2a$10$S8nFUMB8YIEioeWyap24/ucX.dC6v9tXCbpHjJVQUkrXlrH1VLaAS' WHERE id = 2;
-- UPDATE user SET password = '$2a$10$S8nFUMB8YIEioeWyap24/ucX.dC6v9tXCbpHjJVQUkrXlrH1VLaAS' WHERE id = 3;

-- authentication END


-- color START
create table color(
	colorId int primary key auto_increment,
    name varchar(30) not null
);

-- insert into color(name) values
-- 	('blue'), -- 1
--     ('red'), -- 2
--     ('green'), -- 3
--     ('purple'), -- 4
--     ('yellow'), -- 5
--     ('brown'), -- 6
--     ('silver'), -- 7
--     ('white'), -- 8
--     ('black'); -- 9
-- color END

-- state START
create table state(
	stateId int primary key AUTO_INCREMENT,
    abbr varchar(10) not null,
    name varchar(30) not null
);

-- INSERT INTO state (abbr, name) VALUES ('AK','Alaska');
-- INSERT INTO state (abbr, name) VALUES ('AL','Alabama');
-- INSERT INTO state (abbr, name) VALUES ('AR','Arkansas');
-- INSERT INTO state (abbr, name) VALUES ('AZ','Arizona');
-- INSERT INTO state (abbr, name) VALUES ('CA','California');
-- INSERT INTO state (abbr, name) VALUES ('CO','Colorado');
-- INSERT INTO state (abbr, name) VALUES ('CT','Connecticut');
-- INSERT INTO state (abbr, name) VALUES ('DE','Delaware');
-- INSERT INTO state (abbr, name) VALUES ('FL','Florida');
-- INSERT INTO state (abbr, name) VALUES ('GA','Georgia');
-- INSERT INTO state (abbr, name) VALUES ('HI','Hawaii');
-- INSERT INTO state (abbr, name) VALUES ('IA','Iowa');
-- INSERT INTO state (abbr, name) VALUES ('ID','Idaho');
-- INSERT INTO state (abbr, name) VALUES ('IL','Illinois');
-- INSERT INTO state (abbr, name) VALUES ('IN','Indiana');
-- INSERT INTO state (abbr, name) VALUES ('KS','Kansas');
-- INSERT INTO state (abbr, name) VALUES ('KY','Kentucky');
-- INSERT INTO state (abbr, name) VALUES ('LA','Louisiana');
-- INSERT INTO state (abbr, name) VALUES ('MA','Massachusetts');
-- INSERT INTO state (abbr, name) VALUES ('MD','Maryland');
-- INSERT INTO state (abbr, name) VALUES ('ME','Maine');
-- INSERT INTO state (abbr, name) VALUES ('MI','Michigan');
-- INSERT INTO state (abbr, name) VALUES ('MN','Minnesota');
-- INSERT INTO state (abbr, name) VALUES ('MO','Missouri');
-- INSERT INTO state (abbr, name) VALUES ('MS','Mississippi');
-- INSERT INTO state (abbr, name) VALUES ('MT','Montana');
-- INSERT INTO state (abbr, name) VALUES ('NC','North Carolina');
-- INSERT INTO state (abbr, name) VALUES ('ND','North Dakota');
-- INSERT INTO state (abbr, name) VALUES ('NE','Nebraska');
-- INSERT INTO state (abbr, name) VALUES ('NH','New Hampshire');
-- INSERT INTO state (abbr, name) VALUES ('NJ','New Jersey');
-- INSERT INTO state (abbr, name) VALUES ('NM','New Mexico');
-- INSERT INTO state (abbr, name) VALUES ('NV','Nevada');
-- INSERT INTO state (abbr, name) VALUES ('NY','New York');
-- INSERT INTO state (abbr, name) VALUES ('OH','Ohio');
-- INSERT INTO state (abbr, name) VALUES ('OK','Oklahoma');
-- INSERT INTO state (abbr, name) VALUES ('OR','Oregon');
-- INSERT INTO state (abbr, name) VALUES ('PA','Pennsylvania');
-- INSERT INTO state (abbr, name) VALUES ('RI','Rhode Island');
-- INSERT INTO state (abbr, name) VALUES ('SC','South Carolina');
-- INSERT INTO state (abbr, name) VALUES ('SD','South Dakota');
-- INSERT INTO state (abbr, name) VALUES ('TN','Tennessee');
-- INSERT INTO state (abbr, name) VALUES ('TX','Texas');
-- INSERT INTO state (abbr, name) VALUES ('UT','Utah');
-- INSERT INTO state (abbr, name) VALUES ('VA','Virginia');
-- INSERT INTO state (abbr, name) VALUES ('VT','Vermont');
-- INSERT INTO state (abbr, name) VALUES ('WA','Washington');
-- INSERT INTO state (abbr, name) VALUES ('WI','Wisconsin');
-- INSERT INTO state (abbr, name) VALUES ('WV','West Virginia');
-- INSERT INTO state (abbr, name) VALUES ('WY','Wyoming');
-- state END

-- make START
create table make(
	makeId int primary key AUTO_INCREMENT,
    name varchar(30) not null
);

-- insert into make(name) values
-- ('Honda'), -- 1
-- ('BMW'), -- 2
-- ('Nissan'), -- 3
-- ('Toyota'), -- 4
-- ('Ford'), -- 5
-- ('Chevy'), -- 6
-- ('Chrysler'), -- 7
-- ('Kia'), -- 8
-- ('Hyundai'), -- 9
-- ('Tesla'),
-- ('Volkswagen'); -- 10
-- make END

-- model START

create table model(
	modelId int primary key AUTO_INCREMENT,
    makeId int not null,
    name varchar(50) not null,
    constraint fk_make_model
		foreign key (makeId) 
        references make(makeId)
);

-- insert into model(makeId, name) values
-- 	(1, 'Accord'), -- 1
--     (1, 'Odyssey'), -- 2
--     (1, 'Civic'), -- 3
--     (4, 'RAV4'), -- 4
--     (4, 'Sienna'), -- 5
--     (5, 'F150'), -- 6
--     (4, 'Supra'), -- 7
--     (11, 'Golf'); -- 8
    
-- select * from model
-- inner join make on make.makeId = model.makeId;
-- model END

-- bodyStyle START
create table bodyStyle(
	bodyStyleId int primary key AUTO_INCREMENT,
    name varchar(50) not null
);

-- insert into bodyStyle(name) values
-- ('SUV'), -- 1
-- ('Hatchback'), -- 2
-- ('Van'), -- 3
-- ('Sedan'), -- 4
-- ('Truck'); -- 5
-- bodyStyle END 

-- vehicle START
create table vehicle(
	vehicleId int primary key AUTO_INCREMENT,
    modelId int not null, 
    vin varchar(50) not null unique,
    isNew boolean not null,
    mileage int not null default 0,
	year int not null,
    bodyStyleId int not null,
    isAutomatic boolean not null default true,
    msrp Decimal not null,
    price Decimal not null,
    exteriorColorId int not null,
    interiorColorId int not null,
    description varchar(300) not null,
    url varchar(1000) null default 'https://proxy.duckduckgo.com/iu/?u=https%3A%2F%2Fmidlandusa.com%2Fwp-content%2Fuploads%2F2016%2F11%2FProduct-image-unavailable15-600x400.jpg&f=1',
    isFeatured boolean not null default false,
    isPurchased boolean not null default false,
    constraint fk_vehicle_extcolor
		foreign key (exteriorColorId) 
        references color(colorId),
	constraint fk_vehicle_intcolor
		foreign key (interiorColorId) 
        references color(colorId),
	constraint fk_vehicle_model
		foreign key (modelId) 
        references model(modelId),
	constraint fk_vehicle_body
		foreign key (bodyStyleId) 
        references bodyStyle(bodyStyleId)
);

-- insert into vehicle(modelId, vin, isNew, mileage, year, bodyStyleId, isAutomatic, msrp, price, exteriorColorId, interiorColorId, description, isFeatured, url, isPurchased) values
-- (7, 'WDDHF8JB1CA613846', true, 0, 2020, 4, false, 55000, 50000, 7, 1, 'The brand new Toyota Supra! An absolutely incredible feat of engineering', true, 'https://cdn.motor1.com/images/mgl/YKVlj/s1/toyota-supra-lead.jpg', false),
-- (1, '1FTYR10E93PA62101', false, 251000, 2005, 4, true, 6599, 4599, 1, 9, 'An excellent Accord! We just put a new engine into this one so it should be good for a few hundred thousand miles at least!', true, 'https://content.homenetiol.com/2000292/2143540/0x0/cb74a027679348b4aecf385ae02e8a49.jpg', false),
-- (2, '1J4FJ68S9SL687085', false, 147543, 2008, 3, true, 8599, 8000, 6, 2, 'The perfect daily driver for someone that likes a LOT of space. This car is sure to please anyone with Mini-van needs.', true, 'https://www.samarins.com/reviews/img/honda_odyssey_2007_large.jpg', false),
-- (5, 'YV4940DZ4D2479390', true, 900, 2017, 1, true, 24599, 23000, 1, 2, 'No Image Available. Description pending', false, 'https://proxy.duckduckgo.com/iu/?u=https%3A%2F%2Fmidlandusa.com%2Fwp-content%2Fuploads%2F2016%2F11%2FProduct-image-unavailable15-600x400.jpg&f=1', false),
-- (6, '1FVXJLBB5VH739714', true, 0, 2017, 5, true, 14599, 13000, 9, 9, 'Test for Vehicle 4', true, 'https://proxy.duckduckgo.com/iu/?u=https%3A%2F%2Fmidlandusa.com%2Fwp-content%2Fuploads%2F2016%2F11%2FProduct-image-unavailable15-600x400.jpg&f=1', false),
-- (4, '3GTU2WECXFG214905', true, 0, 2012, 1, true, 14000, 12000, 1, 9, 'A stellar deal for a stellar car!', true, 'https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fst.motortrend.com%2Fuploads%2Fsites%2F5%2F2011%2F12%2F2012-Toyota-RAV4-Base-front-three-quarters.jpg&f=1', false),
-- (8, '1GTZ7UCAXE1162881', false, 44512, 2016, 2, false, 55000, 50000, 7, 1, 'A great hatchback. Plenty of space in the back to boot!', true, 'https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fst.automobilemag.com%2Fuploads%2Fsites%2F11%2F2016%2F11%2F2016-Volkswagen-GTI-front-three-quarter-in-motion-02.jpg&f=1', false);
-- -- select 
-- v.vin VIN,
-- v.mileage Mileage, 
-- v.isNew New,
-- make.name Make,
-- model.name Model,
-- interior.name Interior,
-- ext.name Exterior,
-- v.price Price,
-- bodyStyle.name BodyStyle
-- from vehicle v 
-- inner join model on v.modelId = model.modelId
-- inner join make on model.makeId = make.makeId
-- inner join color ext on v.exteriorColorId = ext.colorId
-- inner join color interior on v.interiorColorId = interior.colorId
-- inner join bodyStyle on v.bodyStyleId = bodyStyle.bodyStyleId
-- GROUP BY Make, Model, Price, Vin, BodyStyle, Mileage, Interior, Exterior, VIN;
-- vehicle END


-- special START
create table special(
	specialId int primary key AUTO_INCREMENT,
    title varchar(60) not null,
    description varchar(300) not null
);
-- special END

-- insert into special(title, description) values
-- ('Summer Clearance', 'EVERYTHING HAS GOT TO GO! Up to 15% off select models!'),
-- ('BOGO 50', 'Buy One Car and Get Another One at just 50% off MSRP!'),
-- ('No Down Payment', 'If you can throw the ball from 100 ft away into our basketball hoop, you have no down payment!');


-- contact START
create table contact(
	contactId int primary key AUTO_INCREMENT,
    name varchar(255) not null,
    email varchar(255) not null,
    phone varchar(50) not null,
    message varchar(300) not null
);
-- contact END

-- purchaseType START
create table purchaseType(
	purchaseTypeId int primary key AUTO_INCREMENT,
    name varchar(60) not null
);

-- insert into purchaseType(name) values
-- ('Dealer Finance'),
-- ('Bank Finance'),
-- ('Cash');
-- purchaseType END

-- sale START
create table sale(
	saleId int primary key AUTO_INCREMENT,
    userId int not null,
    vehicleId int not null,
    purchaseTypeId int not null,
    name varchar(255) not null,
    email varchar(255) not null,
    phone varchar(20) not null,
    addressOne varchar(100) not null,
    addressTwo varchar(100) default 'N/A',
    city varchar(60) not null,
    stateId int not null,
    zipcode varchar(20) not null,
    timeOfSale timestamp not null,
	constraint fk_sale_user
		foreign key (userId) 
        references user(id),
	constraint fk_sale_vehicle
		foreign key (vehicleId) 
        references vehicle(vehicleId),
	constraint fk_sale_purchaseType
		foreign key (purchaseTypeId) 
        references purchaseType(purchaseTypeId),
	constraint fk_sale_state
		foreign key (stateId) 
        references state(stateId)
);

-- insert into sale(userId, vehicleId, purchaseTypeId, name, email, phone, addressOne, city, stateId, zipcode, timeOfSale) values
-- (1, 1, 2, 'Jeb', 'jeb@gmail.com', '555-8979', '1234 Main Street', 'Edina', 17, '55331', '1990-01-01 01:00:00');
-- select saleId, userId, vehicleId, purchaseTypeId, name, email, phone, addressOne, addressTwo, city, stateId, zipcode, timeOfSale from sale;
-- inner join user on user.id = sale.saleId
-- inner join vehicle on vehicle.vehicleId = sale.vehicleId
-- inner join purchaseType on purchaseType.purchaseTypeId = sale.purchaseTypeId
-- inner join state on sale.stateId = state.stateId;

-- SELECT vehicleId, modelId, vin, isNew, mileage, year, BodyStyleId, 
-- isAutomatic, msrp, price, exteriorColorId, interiorColorId, description, url, isPurchased FROM vehicle where isNew = true;
-- sale END

-- search START
create table SEARCH(
	searchId int primary key AUTO_INCREMENT,
    make varchar(50) not null,
    model varchar(50) not null,
    minPrice int null default 0,
    maxPrice int null default 1000000,
    minYear int null default 2000,
    maxYear int null default 2020,
    year int null
);

insert into search(make, model) values
('honda', 'honda');


select 
vehicle.year,
vehicle.vehicleId,
model.name,
make.name,
vehicle.price,
vehicle.msrp,
vehicle.vin,
vehicle.description,
bodyStyle.name,
exterior.name,
interior.name,
vehicle.mileage,
vehicle.isNew,
vehicle.isAutomatic,
vehicle.url
from vehicle
inner join model on model.modelId = vehicle.modelId
inner join make on model.makeId = make.makeId
inner join color exterior on vehicle.exteriorColorId = exterior.colorId 
inner join color interior on vehicle.interiorColorId = interior.colorId
inner join bodyStyle on vehicle.bodyStyleId = bodyStyle.bodyStyleId
where model.name like '%hon%'
or make.name like '%hon%'
or vehicle.year like '%201%'
and vehicle.isPurchased = 0
order by vehicle.price DESC;


-- select vehicle.year, vehicle.vehicleId, model.name, make.name, vehicle.price, vehicle.msrp, vehicle.vin, vehicle.description, bodyStyle.name, exterior.name, interior.name, vehicle.mileage, vehicle.isNew, vehicle.isAutomatic, vehicle.url from vehicle inner join model on model.modelId = vehicle.modelId inner join make on model.makeId = make.makeId inner join color exterior on vehicle.exteriorColorId = exterior.colorId inner join color interior on vehicle.interiorColorId = interior.colorId inner join bodyStyle on vehicle.bodyStyleId = bodyStyle.bodyStyleId where model.name like '%hon%' or make.name like '%hon%' and vehicle.isPurchased = 0 order by vehicle.price DESC;
-- search END
-- select * from model inner join make on model.makeid = make.makeid where make.name = 'Honda';


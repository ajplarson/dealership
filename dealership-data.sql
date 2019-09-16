use dealership;

insert into `user`(`id`,`username`,`password`,`enabled`, `email`, `firstName`, `lastName`)
    values(1,"admin", "password", true, "fake_email@yahoo.com", "Frank", "Jones"),
        (2,"user","password",true, "test_user_email@gmail.com", "Leslie", "Johnson"),
		(3,"sales","password",true, "test_sales_email@gmail.com", "John", "Lopez");


insert into `role`(`id`,`role`)
    values(1,"ROLE_ADMIN"), (2,"ROLE_USER"), (3,"ROLE_SALES");
    
insert into `user_role`(`user_id`,`role_id`)
    values(1,1),(1,2),(1,3),(2,2),(3,1),(3,3);
    
UPDATE user SET password = '$2a$10$S8nFUMB8YIEioeWyap24/ucX.dC6v9tXCbpHjJVQUkrXlrH1VLaAS' WHERE id = 1;
UPDATE user SET password = '$2a$10$S8nFUMB8YIEioeWyap24/ucX.dC6v9tXCbpHjJVQUkrXlrH1VLaAS' WHERE id = 2;
UPDATE user SET password = '$2a$10$S8nFUMB8YIEioeWyap24/ucX.dC6v9tXCbpHjJVQUkrXlrH1VLaAS' WHERE id = 3;

-- authentication END


-- color START
insert into color(name) values
	('Blue'), -- 1
    ('Red'), -- 2
    ('Green'), -- 3
    ('Purple'), -- 4
    ('Yellow'), -- 5
    ('Brown'), -- 6
    ('Silver'), -- 7
    ('White'), -- 8
    ('Black'), -- 9
    ('Orange'); -- 10
-- color END

-- state START
INSERT INTO state (abbr, name) VALUES ('AK','Alaska');
INSERT INTO state (abbr, name) VALUES ('AL','Alabama');
INSERT INTO state (abbr, name) VALUES ('AR','Arkansas');
INSERT INTO state (abbr, name) VALUES ('AZ','Arizona');
INSERT INTO state (abbr, name) VALUES ('CA','California');
INSERT INTO state (abbr, name) VALUES ('CO','Colorado');
INSERT INTO state (abbr, name) VALUES ('CT','Connecticut');
INSERT INTO state (abbr, name) VALUES ('DE','Delaware');
INSERT INTO state (abbr, name) VALUES ('FL','Florida');
INSERT INTO state (abbr, name) VALUES ('GA','Georgia');
INSERT INTO state (abbr, name) VALUES ('HI','Hawaii');
INSERT INTO state (abbr, name) VALUES ('IA','Iowa');
INSERT INTO state (abbr, name) VALUES ('ID','Idaho');
INSERT INTO state (abbr, name) VALUES ('IL','Illinois');
INSERT INTO state (abbr, name) VALUES ('IN','Indiana');
INSERT INTO state (abbr, name) VALUES ('KS','Kansas');
INSERT INTO state (abbr, name) VALUES ('KY','Kentucky');
INSERT INTO state (abbr, name) VALUES ('LA','Louisiana');
INSERT INTO state (abbr, name) VALUES ('MA','Massachusetts');
INSERT INTO state (abbr, name) VALUES ('MD','Maryland');
INSERT INTO state (abbr, name) VALUES ('ME','Maine');
INSERT INTO state (abbr, name) VALUES ('MI','Michigan');
INSERT INTO state (abbr, name) VALUES ('MN','Minnesota');
INSERT INTO state (abbr, name) VALUES ('MO','Missouri');
INSERT INTO state (abbr, name) VALUES ('MS','Mississippi');
INSERT INTO state (abbr, name) VALUES ('MT','Montana');
INSERT INTO state (abbr, name) VALUES ('NC','North Carolina');
INSERT INTO state (abbr, name) VALUES ('ND','North Dakota');
INSERT INTO state (abbr, name) VALUES ('NE','Nebraska');
INSERT INTO state (abbr, name) VALUES ('NH','New Hampshire');
INSERT INTO state (abbr, name) VALUES ('NJ','New Jersey');
INSERT INTO state (abbr, name) VALUES ('NM','New Mexico');
INSERT INTO state (abbr, name) VALUES ('NV','Nevada');
INSERT INTO state (abbr, name) VALUES ('NY','New York');
INSERT INTO state (abbr, name) VALUES ('OH','Ohio');
INSERT INTO state (abbr, name) VALUES ('OK','Oklahoma');
INSERT INTO state (abbr, name) VALUES ('OR','Oregon');
INSERT INTO state (abbr, name) VALUES ('PA','Pennsylvania');
INSERT INTO state (abbr, name) VALUES ('RI','Rhode Island');
INSERT INTO state (abbr, name) VALUES ('SC','South Carolina');
INSERT INTO state (abbr, name) VALUES ('SD','South Dakota');
INSERT INTO state (abbr, name) VALUES ('TN','Tennessee');
INSERT INTO state (abbr, name) VALUES ('TX','Texas');
INSERT INTO state (abbr, name) VALUES ('UT','Utah');
INSERT INTO state (abbr, name) VALUES ('VA','Virginia');
INSERT INTO state (abbr, name) VALUES ('VT','Vermont');
INSERT INTO state (abbr, name) VALUES ('WA','Washington');
INSERT INTO state (abbr, name) VALUES ('WI','Wisconsin');
INSERT INTO state (abbr, name) VALUES ('WV','West Virginia');
INSERT INTO state (abbr, name) VALUES ('WY','Wyoming');
-- state END

-- make START
insert into make(name) values
('Honda'), -- 1
('BMW'), -- 2
('Nissan'), -- 3
('Toyota'), -- 4
('Ford'), -- 5
('Chevy'), -- 6
('Chrysler'), -- 7
('Kia'), -- 8
('Hyundai'), -- 9
('Tesla'), -- 10
('Volkswagen'), -- 11
('Porsche'); -- 12
-- make END

-- model START
insert into model(makeId, name) values
	(1, 'Accord'), -- 1
    (1, 'Odyssey'), -- 2
    (1, 'Civic'), -- 3
    (4, 'RAV4'), -- 4
    (4, 'Sienna'), -- 5
    (5, 'F150'), -- 6
    (4, 'Supra'), -- 7
    (11, 'Golf'), -- 8
    (3, 'GTR'), -- 9
    (12, '911 GT3 RS'), -- 10
    (2, 'M3 GTR'), -- 11
    (8, 'Stinger'); -- 12
    
    
-- select * from model
-- inner join make on make.makeId = model.makeId;
-- model END

-- bodyStyle START
insert into bodyStyle(name) values
('SUV'), -- 1
('Hatchback'), -- 2
('Van'), -- 3
('Sedan'), -- 4
('Truck'); -- 5
-- bodyStyle END 

-- vehicle START
insert into vehicle(modelId, vin, isNew, mileage, year, bodyStyleId, isAutomatic, msrp, price, exteriorColorId, interiorColorId, description, isFeatured, url, isPurchased) values
(7, 'WDDHF8JB1CA613846', true, 0, 2020, 4, false, 55000, 50000, 7, 1, 'The brand new Toyota Supra! An absolutely incredible feat of engineering', true, 'https://cdn.motor1.com/images/mgl/YKVlj/s1/toyota-supra-lead.jpg', false),
(9, '2G4WB55K321140817', true, 421, 2018, 4, false, 65000, 37500, 7, 9, 'Not much to say about this one other than WOW', true, 'https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fst.motortrend.com%2Fuploads%2Fsites%2F5%2F2017%2F11%2F2018-Nissan-GT-R-front-three-quarter.jpg&f=1', false),
(10, 'WP0AA2967MS409952', false, 43222, 2016, 4, false, 15000, 14500, 10, 9, 'This is the deal of the century! 10% of normal MSRP', true, 'https://proxy.duckduckgo.com/iu/?u=https%3A%2F%2Fmedia.ed.edmunds-media.com%2Fporsche%2F911%2F2016%2Foem%2F2016_porsche_911_coupe_gt3-rs_fq_oem_2_1280.jpg&f=1', false),
(11, '1D7RB1CT6AS248200', false, 75643, 2001, 4, true, 22000, 17655, 9, 9, 'A car modders dream! An excellent old BMW', false, 'https://proxy.duckduckgo.com/iu/?u=https%3A%2F%2Fi.pinimg.com%2Foriginals%2Fb1%2Fb6%2F31%2Fb1b6312087b014dcd167e1ef9b0a37ce.jpg&f=1', false),
(1, '1FTYR10E93PA62101', false, 251000, 2005, 4, true, 6599, 4599, 1, 9, 'An excellent Accord! We just put a new engine into this one so it should be good for a few hundred thousand miles at least!', false, 'https://content.homenetiol.com/2000292/2143540/0x0/cb74a027679348b4aecf385ae02e8a49.jpg', false),
(2, '1J4FJ68S9SL687085', false, 147543, 2008, 3, true, 8599, 8000, 6, 2, 'The perfect daily driver for someone that likes a LOT of space. This car is sure to please anyone with Mini-van needs.', false, 'https://www.samarins.com/reviews/img/honda_odyssey_2007_large.jpg', false),
(5, 'YV4940DZ4D2479390', true, 900, 2017, 3, true, 24599, 23000, 1, 2, 'No Image Available. Description pending', false, 'https://proxy.duckduckgo.com/iu/?u=https%3A%2F%2Fmidlandusa.com%2Fwp-content%2Fuploads%2F2016%2F11%2FProduct-image-unavailable15-600x400.jpg&f=1', false),
(12, '1FTRF07L82KB23073', true, 5, 2018, 4, true, 34500, 30000, 2, 9, 'This car is quite the Zinger!', false, 'https://blogmedia.dealerfire.com/wp-content/uploads/sites/434/2017/06/2018-Kia-Stinger.jpg', false),
(6, '1FVXJLBB5VH739714', true, 0, 2017, 5, true, 14599, 13000, 9, 9, 'Test for Vehicle 4', false, 'https://proxy.duckduckgo.com/iu/?u=https%3A%2F%2Fmidlandusa.com%2Fwp-content%2Fuploads%2F2016%2F11%2FProduct-image-unavailable15-600x400.jpg&f=1', false),
(4, '3GTU2WECXFG214905', false, 89342, 2012, 1, true, 14000, 12000, 1, 9, 'A stellar deal for a stellar car!', true, 'https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fst.motortrend.com%2Fuploads%2Fsites%2F5%2F2011%2F12%2F2012-Toyota-RAV4-Base-front-three-quarters.jpg&f=1', false),
(8, '1GTZ7UCAXE1162881', false, 44512, 2016, 2, false, 35000, 28000, 2, 9, 'A great hatchback. Plenty of space in the back to boot!', true, 'https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fst.automobilemag.com%2Fuploads%2Fsites%2F11%2F2016%2F11%2F2016-Volkswagen-GTI-front-three-quarter-in-motion-02.jpg&f=1', false);
-- vehicle END


-- special START
insert into special(title, description) values
('Summer Clearance', 'EVERYTHING HAS GOT TO GO! Up to 15% off select models! Come in and buy a new or used car while supplies last.'),
('BOGO 50', 'Buy One Car and Get Another One at 50% off MSRP! We are bringing back the BOGO with this hot deal'),
('No Down Payment', 'If you can throw the ball from 100 ft away into our basketball hoop, you have no down payment!');
-- special END

-- contact START

-- contact END

-- purchaseType START
insert into purchaseType(name) values
('Dealer Finance'),
('Bank Finance'),
('Cash');
-- purchaseType END

-- sale START
insert into sale(userId, vehicleId, purchaseTypeId, name, email, phone, addressOne, city, stateId, zipcode, timeOfSale) values
(1, 1, 2, 'Jeb', 'jeb@gmail.com', '555-8979', '1234 Main Street', 'Edina', 17, '55331', '1990-01-01 01:00:00');
-- sale END

-- search START
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
where (model.name like '%hon%'
or make.name like '%hon%'
or vehicle.year like '%201%')
and vehicle.isPurchased = 0
and vehicle.isNew = 1

order by vehicle.price DESC;


SELECT model.modelId, model.makeId, model.name FROM model inner join make on make.makeId = model.makeId where make.name = 'Toyota';


-- select vehicle.year, vehicle.vehicleId, model.name, make.name, vehicle.price, vehicle.msrp, vehicle.vin, vehicle.description, bodyStyle.name, exterior.name, interior.name, vehicle.mileage, vehicle.isNew, vehicle.isAutomatic, vehicle.url from vehicle inner join model on model.modelId = vehicle.modelId inner join make on model.makeId = make.makeId inner join color exterior on vehicle.exteriorColorId = exterior.colorId inner join color interior on vehicle.interiorColorId = interior.colorId inner join bodyStyle on vehicle.bodyStyleId = bodyStyle.bodyStyleId where model.name like '%hon%' or make.name like '%hon%' and vehicle.isPurchased = 0 order by vehicle.price DESC;
-- search END
-- select * from model inner join make on model.makeid = make.makeid where make.name = 'Honda';

select * from user;
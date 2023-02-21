CREATE TABLE product_photos (
id serial NOT NULL,
file_name varchar(255) NOT NULL,
fk_laptop_id integer,
fk_smartphone_id integer,
fk_headset_id integer,
fk_camera_id integer,
fk_category_name varchar(255) NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (fk_laptop_id) REFERENCES laptops (id),
FOREIGN KEY (fk_smartphone_id) REFERENCES smartphones (id),
FOREIGN KEY (fk_headset_id) REFERENCES headsets (id),
FOREIGN KEY (fk_camera_id) REFERENCES cameras (id),
FOREIGN KEY (fk_category_name) REFERENCES categories (name)
);





INSERT INTO product_photos (file_name, fk_headset_id, fk_category_name)
VALUES ('headset1_1.png',1,'Headsets'),
('headset1_2.png',1,'Headsets'),
('headset1_3.png',1,'Headsets'),
('headset2_1.png',2,'Headsets'),
('headset2_2.png',2,'Headsets'),
('headset2_3.png',2,'Headsets'),
('headset3_1.png',3,'Headsets'),
('headset3_2.png',3,'Headsets'),
('headset3_3.png',3,'Headsets'),
('headset4_1.png',4,'Headsets'),
('headset4_2.png',4,'Headsets'),
('headset4_3.png',4,'Headsets'),
('headset5_1.png',5,'Headsets'),
('headset5_2.png',5,'Headsets'),
('headset5_3.png',5,'Headsets'),
('headset6_1.png',6,'Headsets'),
('headset6_2.png',6,'Headsets'),
('headset6_3.png',6,'Headsets'),
('headset7_1.png',7,'Headsets'),
('headset7_2.png',7,'Headsets'),
('headset7_3.png',7,'Headsets'),
('headset8_1.png',8,'Headsets'),
('headset8_2.png',8,'Headsets'),
('headset8_3.png',8,'Headsets'),
('headset9_1.png',9,'Headsets'),
('headset9_2.png',9,'Headsets'),
('headset9_3.png',9,'Headsets'),
('headset10_1.png',10,'Headsets'),
('headset10_2.png',10,'Headsets'),
('headset10_3.png',10,'Headsets');






INSERT INTO smartphones (GeneralDescription, technicalDescription, name, sku, weight, width, height, depth, manufacturer, fk_category_name, price, color, model, quantity, ean, storage, screen_size, operating_system, camera_resolution)
VALUES
       ( ),
       (, ),
       (, ),
       (, ),
       (, ),
       (, ),
       (, ),
       (,),
              (,);





INSERT INTO headsets (GeneralDescription, technicalDescription, name, sku, weight, width, height, depth, manufacturer, fk_category_name, price, color, model, quantity, ean, )
VALUES
(, ),
(, ),
(, ),
(, ),
(, ),
(, ),
(, ),
(, ),
(, ),
('A high-performance headset for competitive gaming.', 'Features large 50mm drivers, low latency audio, and a durable design.', 'CompeteMaster Headset', 'CM333', 0.7, 7, 8, 9, 'Kappa Corp.', 'Headsets', 100.0, 'Red', 'CM1', 1000, 1234567890123, );

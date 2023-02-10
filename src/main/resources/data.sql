INSERT INTO categories (name)
VALUES ('Laptops');

INSERT INTO categories (name)
VALUES ('Smartphones');

INSERT INTO categories (name)
VALUES ('Headsets');

INSERT INTO categories (name)
VALUES ('Cameras');


INSERT INTO laptops (GeneralDescription, technicalDescription, name, sku, weight, width, height, depth, manufacturer, fk_category_name, price, color, model, quantity, ean, processor, ram, storage, screen_size, operating_system)
VALUES ('A high-performance laptop', 'Intel Core i7, 8GB RAM, 512GB SSD', 'MacBook Pro', 'MBP001', 2.0, 14.1, 0.6, 9.5, 'Apple', 'Laptops', 1499.99, 'Gray', 'MacBook Pro 16"', 10, 1234567890124, 'Intel Core i7', 8, 512, 16.0, 'macOS');

INSERT INTO laptops (GeneralDescription, technicalDescription, name, sku, weight, width, height, depth, manufacturer, fk_category_name, price, color, model, quantity, ean, processor, ram, storage, screen_size, operating_system)
VALUES ('A budget laptop', 'Intel Core i5, 8GB RAM, 256GB SSD', 'IdeaPad', 'IDP001', 1.7, 13.3, 0.7, 9.0, 'Lenovo', 'Laptops', 499.99, 'Black', 'IdeaPad S145', 20, 1234567890125, 'Intel Core i5', 8, 256, 15.6, 'Windows 10');

INSERT INTO laptops (GeneralDescription, technicalDescription, name, sku, weight, width, height, depth, manufacturer, fk_category_name, price, color, model, quantity, ean, processor, ram, storage, screen_size, operating_system)
VALUES ('A gaming laptop', 'Intel Core i7, 16GB RAM, 512GB SSD', 'Predator', 'PRD001', 3.5, 15.6, 1.0, 11.0, 'Acer', 'Laptops', 1299.99, 'Red', 'Predator Triton 500', 15, 1234567890126, 'Intel Core i7', 16, 512, 15.6, 'Windows 10');

INSERT INTO laptops (GeneralDescription, technicalDescription, name, sku, weight, width, height, depth, manufacturer, fk_category_name, price, color, model, quantity, ean, processor, ram, storage, screen_size, operating_system)
VALUES ('A budget laptop', 'Intel Celeron, 4GB RAM, 128GB SSD', 'Stream', 'STR001', 1.5, 11.6, 0.7, 8.0, 'HP', 'Laptops', 299.99, 'White', 'Stream 11 Pro', 30, 1234567890127, 'Intel Celeron', 4, 128, 11.6, 'Chrome OS');


INSERT INTO laptops (GeneralDescription, technicalDescription, name, sku, weight, width, height, depth, manufacturer, fk_category_name, price, color, model, quantity, ean, processor, ram, storage, screen_size, operating_system)
VALUES ('High performance laptop', 'Has a fast processor and dedicated graphics card', 'Performance Laptop', 'perf-laptop-1', 2.2, 14, 9, 0.9, 'Dell', 'Laptops', 1500, 'Black', 'Dell-Performance-1', 10, 123456789, 'i7', 16, 256, 15, 'Windows 10');

INSERT INTO laptops (GeneralDescription, technicalDescription, name, sku, weight, width, height, depth, manufacturer, fk_category_name, price, color, model, quantity, ean, processor, ram, storage, screen_size, operating_system)
VALUES ('Thin and lightweight laptop', 'Has a long battery life and thin design', 'Ultraportable Laptop', 'ultra-laptop-1', 1.2, 12, 8, 0.7, 'Apple', 'Laptops', 2000, 'Gray', 'Apple-Ultraportable-1', 20, 987654321, 'i5', 8, 128, 13, 'MacOS');

INSERT INTO laptops (GeneralDescription, technicalDescription, name, sku, weight, width, height, depth, manufacturer, fk_category_name, price, color, model, quantity, ean, processor, ram, storage, screen_size, operating_system)
VALUES ('Affordable laptop for everyday use', 'Has basic specifications for office and internet use', 'Budget Laptop', 'budget-laptop-1', 2, 13, 9, 0.8, 'HP', 'Laptops', 500, 'Red', 'HP-Budget-1', 30, 111111111, 'i3', 4, 128, 14, 'Windows 10');

INSERT INTO laptops (GeneralDescription, technicalDescription, name, sku, weight, width, height, depth, manufacturer, fk_category_name, price, color, model, quantity, ean, processor, ram, storage, screen_size, operating_system)
VALUES ('High performance laptop for gaming', 'Has a fast processor and dedicated graphics card for gaming', 'Gaming Laptop', 'gaming-laptop-1', 2.5, 15, 10, 1, 'MSI', 'Laptops', 1700, 'Colorful', 'MSI-Gaming-1', 5, 222222222, 'i7', 16, 512, 17, 'Windows 10');

INSERT INTO laptops (GeneralDescription, technicalDescription, name, sku, weight, width, height, depth, manufacturer, fk_category_name, price, color, model, quantity, ean, processor, ram, storage, screen_size, operating_system)
VALUES ('Thin and stylish laptop', 'Has a premium design and long battery life', 'Stylish Laptop', 'stylish-laptop-1', 1.5, 13, 8, 0.8, 'Lenovo', 'Laptops', 1400, 'White', 'Lenovo-Stylish-1', 15, 333333333, 'i5', 8, 256, 14, 'Windows 10');


INSERT INTO product_photos (file_name, fk_laptop_id, fk_category_name)
VALUES ('laptop1_1.png',1,'Laptops'),
('laptop1_2.png',1,'Laptops'),
('laptop1_3.png',1,'Laptops'),
('laptop2_1.png',2,'Laptops'),
('laptop2_2.png',2,'Laptops'),
('laptop2_3.png',2,'Laptops'),
('laptop3_1.png',3,'Laptops'),
('laptop3_2.png',3,'Laptops'),
('laptop3_3.png',3,'Laptops'),
('laptop4_1.png',4,'Laptops'),
('laptop4_2.png',4,'Laptops'),
('laptop4_3.png',4,'Laptops'),
('laptop5_1.png',5,'Laptops'),
('laptop5_2.png',5,'Laptops'),
('laptop5_3.png',5,'Laptops'),
('laptop6_1.png',6,'Laptops'),
('laptop6_2.png',6,'Laptops'),
('laptop6_3.png',6,'Laptops'),
('laptop7_1.png',7,'Laptops'),
('laptop7_2.png',7,'Laptops'),
('laptop7_3.png',7,'Laptops'),
('laptop8_1.png',8,'Laptops'),
('laptop8_2.png',8,'Laptops'),
('laptop8_3.png',8,'Laptops'),
('laptop9_1.png',9,'Laptops'),
('laptop9_2.png',9,'Laptops'),
('laptop9_3.png',9,'Laptops');

INSERT INTO smartphones (GeneralDescription, technicalDescription, name, sku, weight, width, height, depth, manufacturer, fk_category_name, price, color, model, quantity, ean, storage, screen_size, operating_system, camera_resolution)
VALUES ('Stylish and powerful smartphone', 'Quad-core processor, 4GB RAM, 64GB storage, 6.1-inch display', 'Phone1', 'P1SKU', 170, 75, 150, 8, 'Brand1', 'Smartphones', 500, 'Black', 'Model1', 10, 123456789012, 64, 6.1, 'Android', 12),
       ('Sleek smartphone with high-end features', 'Octa-core processor, 6GB RAM, 128GB storage, 6.5-inch display', 'Phone2', 'P2SKU', 200, 80, 160, 9, 'Brand2', 'Smartphones', 600, 'Silver', 'Model2', 20, 123456789013, 128, 6.5, 'iOS', 16),
       ('High-performance smartphone for demanding users', 'Hexa-core processor, 8GB RAM, 256GB storage, 6.7-inch display', 'Phone3', 'P3SKU', 220, 85, 170, 10, 'Brand3', 'Smartphones', 700, 'Gold', 'Model3', 30, 123456789014, 256, 6.7, 'Android', 20),
       ('Sturdy smartphone with long battery life', 'Quad-core processor, 4GB RAM, 64GB storage, 5.5-inch display', 'Phone4', 'P4SKU', 150, 70, 140, 7, 'Brand4', 'Smartphones', 450, 'Gray', 'Model4', 40, 123456789015, 64, 5.5, 'iOS', 10),
       ('Affordable smartphone with basic features', 'Dual-core processor, 2GB RAM, 32GB storage, 5.0-inch display', 'Phone5', 'P5SKU', 120, 60, 130, 6, 'Brand5', 'Smartphones', 300, 'Pink', 'Model5', 50, 123456789016, 32, 5.0, 'Android', 8),
       ('High-end smartphone with premium features', 'Octa-core processor, 6GB RAM, 128GB storage, 6.2-inch display', 'Phone6', 'P6SKU', 210, 75, 155, 9, 'Brand6', 'Smartphones', 650, 'Red', 'Model6', 60, 123456789017, 128, 6.2, 'iOS', 18),
       ('Compact smartphone with modern design', 'Quad-core processor, 4GB RAM, 64GB storage, 5.0-inch display', 'Phone7', 'P7SKU', 140, 65, 135, 7, 'Brand7', 'Smartphones', 400, 'Green', 'Model7', 70, 123456789018, 64, 5.0, 'Android', 12),
       ('High-quality smartphone with advanced features', 'Hexa-core processor, 8GB RAM, 256GB storage, 6.5-inch display', 'Phone8', 'P8SKU', 215, 75, 165, 10, 'Brand8', 'Smartphones', 700, 'Blue', 'Model8', 80, 123456789019, 256, 6.5, 'iOS', 12),
       ('Top-performing smartphone with long battery life','Snapdragon 835 processor, 8GB RAM, 256GB storage, 5100mAh battery','Smartphone 6','SP6-01',195,80,170,11,'Manufacturer 6','Smartphones',799.99,'Gold','SM-06',150,8675314,256,6.7,'Android 9',20),
              ('High-quality smartphone with advanced features','Snapdragon 720 processor, 6GB RAM, 128GB storage, 4600mAh battery','Smartphone 7','SP7-01',180,75,165,10,'Manufacturer 7','Smartphones',599.99,'Gray','SM-07',100,8675315,128,6.6,'Android 8',24);

INSERT INTO cameras (GeneralDescription, technicalDescription, name, sku, weight, width, height, depth, manufacturer, fk_category_name, price, color, model, quantity, ean, optical_zoom, recording_resolution, screen_size, connection_type, video_resolution, storage)
VALUES
('A high-quality digital camera perfect for capturing memories on the go', '16.0 Megapixel CMOS sensor, 1080p HD video recording, 3x optical zoom', 'EOS Rebel T6', '1234-5678-9123', 0.5, 12.7, 7.8, 4.5, 'Canon', 'Cameras', 499.99, 'Black', 'T6', 10, 1234567890123, 3, '1080', 2.7, 'Usb', '1080', 32),
('A compact camera that fits in your pocket and delivers high-quality photos', '20.1 Megapixel CCD sensor, 720p HD video recording, 5x optical zoom', 'Cybershot WX220', '2345-6789-0123', 0.3, 9.2, 5.5, 2.7, 'Sony', 'Cameras', 199.99, 'Red', 'WX220', 15, 2345678901234, 5, '720', 2.7, 'Usb', '720', 16),
('A high-end camera for professional photographers', '36.3 Megapixel CMOS sensor, 4K UHD video recording, 8x optical zoom', 'Nikon D850', '3456-7890-1234', 1.3, 15.0, 10.0, 7.0, 'Nikon', 'Cameras', 2999.99, 'Black', 'D850', 5, 3456789012345, 8, '4K', 3.2, 'Wifi', '4K', 128),
('A mirrorless camera that offers advanced features for photography enthusiasts', '24.2 Megapixel CMOS sensor, 1080p HD video recording, 4x optical zoom', 'Olympus PEN E-PL9', '4567-8901-2345', 0.7, 12.0, 6.5, 3.5, 'Olympus', 'Cameras', 999.99, 'Silver', 'E-PL9', 8, 4567890123456, 4, '1080', 3.0, 'Wifi', '1080', 64),
('A rugged and waterproof camera for outdoor adventures', '16.0 Megapixel CMOS sensor, 720p HD video recording, 2x optical zoom', 'GoPro HERO7', '5678-9012-3456', 0.4, 4.0, 3.0, 2.0, 'GoPro', 'Cameras', 299.99, 'Black', 'HERO7', 12, 5678901234567, 2, '720', 2.0, 'Wifi', '720', 128),
('A camera with a large viewfinder for easy framing and focusing', '12.3 Megapixel CCD sensor, 1080p HD video recording, 4x optical zoom', 'Fujifilm X-T3', '6789-0123-4567', 0.8, 13.0, 8.0, 4.5, 'Fujifilm', 'Cameras', 1499.99, 'Silver', 'X-T3', 6, 6789012345678, 4, '1080', 3.0, 'Wifi', '1080', 64),
('A compact and lightweight camera with a high-quality lens', '20.0 Megapixel CMOS sensor, 720p HD video recording, 3x optical zoom', 'Canon PowerShot SX620 HS', '7890-1234-5678', 0.3, 9.0, 5.5, 2.5, 'Canon', 'Cameras', 299.99, 'Black', 'SX620 HS', 20, 7890123456789, 3, '720', 2.7, 'Usb', '720', 32),
('A camera with a fast autofocus system for capturing action shots', '24.2 Megapixel CMOS sensor, 1080p HD video recording, 5x optical zoom', 'Sony Alpha a6400', '8901-2345-6789', 0.8, 12.0, 7.0, 4.0, 'Sony', 'Cameras', 999.99, 'Silver', 'a6400', 10, 8901234567890, 5, '1080', 3.0, 'Wifi', '1080', 128),
('A camera with a high-resolution touch screen for easy navigation', '16.0 Megapixel CCD sensor, 720p HD video recording, 4x optical zoom', 'Nikon COOLPIX B500', '9012-3456-7890', 0.5, 11.0, 6.5, 4.0, 'Nikon', 'Cameras', 199.99, 'Red', 'B500', 15, 9012345678901, 4, '720', 3.0, 'Wifi', '720', 64),
('A high-end camera for astrophotography with a fast lens and low-light capabilities', '36.3 Megapixel CMOS sensor, 4K UHD video recording, 12x optical zoom', 'Canon EOS Ra', '0123-4567-8901', 1.5, 15.5, 10.5, 7.5, 'Canon', 'Cameras', 3999.99, 'Black', 'EOS Ra', 5, 1234567890123, 12, '4K', 3.2, 'Wifi', '4K', 128);





INSERT INTO product_photos (file_name, fk_smartphone_id, fk_category_name)
VALUES ('smartphone1_1.png',1,'Smartphones'),
('smartphone1_2.png',1,'Smartphones'),
('smartphone1_3.png',1,'Smartphones'),
('smartphone2_1.png',2,'Smartphones'),
('smartphone2_2.png',2,'Smartphones'),
('smartphone2_3.png',2,'Smartphones'),
('smartphone3_2.png',3,'Smartphones'),
('smartphone3_3.png',3,'Smartphones'),
('smartphone4_1.png',4,'Smartphones'),
('smartphone4_2.png',4,'Smartphones'),
('smartphone4_3.png',4,'Smartphones'),
('smartphone5_1.png',5,'Smartphones'),
('smartphone5_2.png',5,'Smartphones'),
('smartphone5_3.png',5,'Smartphones'),
('smartphone6_1.png',6,'Smartphones'),
('smartphone6_2.png',6,'Smartphones'),
('smartphone6_3.png',6,'Smartphones'),
('smartphone7_1.png',7,'Smartphones'),
('smartphone7_2.png',7,'Smartphones'),
('smartphone7_3.png',7,'Smartphones'),
('smartphone8_1.png',8,'Smartphones'),
('smartphone8_2.png',8,'Smartphones'),
('smartphone8_3.png',8,'Smartphones'),
('smartphone9_1.png',9,'Smartphones'),
('smartphone9_2.png',9,'Smartphones'),
('smartphone9_3.png',9,'Smartphones'),
('smartphone10_1.png',10,'Smartphones'),
('smartphone10_2.png',10,'Smartphones'),
('smartphone10_3.png',10,'Smartphones');

INSERT INTO headsets (GeneralDescription, technicalDescription, name, sku, weight, width, height, depth, manufacturer, fk_category_name, price, color, model, quantity, ean, speaker_dimensions, cable_length, bluetooth, microphone_dimensions)
VALUES
('This headset provides clear audio quality and comfort.', 'Features 40mm drivers, noise cancelling technology, and a padded headband.', 'ClearComfort Headset', 'CC123', 0.5, 6, 7, 8, 'Acme Inc.', 'Headsets', 50.0, 'Black', 'CC1', 100, 1234567890123, 40, 2.0, 'Yes', '6mm'),
('A wireless headset with a stylish design.', 'Features Bluetooth connectivity, noise cancelling technology, and a lightweight construction.', 'StyleCom Wireless Headset', 'SC456', 0.4, 5.5, 6.5, 7.5, 'Beta Corp.', 'Headsets', 70.0, 'Silver', 'SC1', 200, 2345678901234, 30, 1.5, 'Yes', '4mm'),
('A budget-friendly headset with good sound quality.', 'Features 30mm drivers, a comfortable headband, and a cable with in-line controls.', 'ValueSound Headset', 'VS789', 0.3, 6, 7, 8, 'Gamma Ltd.', 'Headsets', 20.0, 'Red', 'VS1', 300, 3456789012345, 20, 2.5, 'No', '5mm'),
('A high-end gaming headset with immersive audio.', 'Features 50mm drivers, 7.1 surround sound technology, and a customizable RGB lighting system.', 'GameMaster Headset', 'GM321', 0.6, 7, 8, 9, 'Delta Inc.', 'Headsets', 120.0, 'Black', 'GM1', 400, 4567890123456, 50, 3.0, 'Yes', '7mm'),
('A compact and portable headset for on-the-go use.', 'Features 20mm drivers, a foldable design, and a built-in microphone.', 'GoCom Headset', 'GC654', 0.2, 5, 6, 7, 'Epsilon LLC.', 'Headsets', 30.0, 'Blue', 'GC1', 500, 5678901234567, 10, 1.0, 'No', '3mm'),
('A comfortable headset with a focus on call quality.', 'Features a noise cancelling microphone, comfortable ear cups, and a flexible headband.', 'CallCom Headset', 'CC987', 0.5, 6, 7, 8, 'Zeta Corp.', 'Headsets', 40.0, 'Black', 'CC2', 600, 6789012345678, 20, 2.0, 'No', '4mm'),
('A premium headset with crystal clear audio.', 'Features 45mm drivers, a leather headband, and a detachable microphone.', 'AudioMaster Headset', 'AM765', 0.7, 7, 8, 9, 'Eta Inc.', 'Headsets', 90.0, 'Brown', 'AM1', 700, 7890123456789, 30, 2.5, 'Yes', '6mm'),
('A durable and rugged headset for outdoor use.', 'Features water-resistant design, heavy-duty construction, and a secure fit.', 'OutdoorCom Headset', 'OC111', 0.6, 6, 7, 8, 'Theta Ltd.', 'Headsets', 50.0, 'Green', 'OC1', 800, 8901234567890, 40, 3.0, 'No', '5mm'),
('A versatile headset with multiple connectivity options.', 'Features wired and wireless connectivity, a comfortable fit, and a built-in microphone.', 'VersaCom Headset', 'VC222', 0.5, 5.5, 6.5, 7.5, 'Iota Inc.', 'Headsets', 60.0, 'Black', 'VC1', 900, 9012345678901, 35, 2.0, 'Yes', '4mm'),
('A high-performance headset for competitive gaming.', 'Features large 50mm drivers, low latency audio, and a durable design.', 'CompeteMaster Headset', 'CM333', 0.7, 7, 8, 9, 'Kappa Corp.', 'Headsets', 100.0, 'Red', 'CM1', 1000, 1234567890123, 50, 3.0, 'Yes', '7mm');

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

INSERT INTO product_photos (file_name, fk_camera_id, fk_category_name)
VALUES ('camera1_1.png',1,'Cameras'),
('camera1_2.png',1,'Cameras'),
('camera1_3.png',1,'Cameras'),
('camera2_1.png',2,'Cameras'),
('camera2_2.png',2,'Cameras'),
('camera2_3.png',2,'Cameras'),
('camera3_2.png',3,'Cameras'),
('camera3_3.png',3,'Cameras'),
('camera4_1.png',4,'Cameras'),
('camera4_2.png',4,'Cameras'),
('camera4_3.png',4,'Cameras'),
('camera5_1.png',5,'Cameras'),
('camera5_2.png',5,'Cameras'),
('camera5_3.png',5,'Cameras'),
('camera6_1.png',6,'Cameras'),
('camera6_2.png',6,'Cameras'),
('camera6_3.png',6,'Cameras'),
('camera7_1.png',7,'Cameras'),
('camera7_2.png',7,'Cameras'),
('camera7_3.png',7,'Cameras'),
('camera8_1.png',8,'Cameras'),
('camera8_2.png',8,'Cameras'),
('camera8_3.png',8,'Cameras'),
('camera9_1.png',9,'Cameras'),
('camera9_2.png',9,'Cameras'),
('camera9_3.png',9,'Cameras'),
('camera10_1.png',10,'Cameras'),
('camera10_2.png',10,'Cameras'),
('camera10_3.png',10,'Cameras');
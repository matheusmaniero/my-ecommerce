CREATE TABLE categories (
id serial NOT NULL,
name varchar(255),
UNIQUE(name),
PRIMARY KEY(id)
);

CREATE DOMAIN colors AS VARCHAR(255) CHECK (value IN ('Black', 'White', 'Gray', 'Lightgray', 'Red', 'Yellow', 'Green', 'Blue', 'Colorful', 'Pink', 'Silver', 'Gold','Brown'));
CREATE DOMAIN connection_types AS VARCHAR(255) CHECK (value IN ('Usb', 'Wifi', 'Usbwifi'));


CREATE TABLE laptops (
id serial NOT NULL,
generalDescription text NOT NULL,
technicalDescription text NOT NULL,
name varchar(255) NOT NULL,
sku varchar(255) NOT NULL,
weight double precision NOT NULL,
width double precision NOT NULL,
height double precision NOT NULL,
depth double precision NOT NULL,
manufacturer varchar(255) NOT NULL,
fk_category_name varchar(255) NOT NULL,
price double precision NOT NULL,
color colors NOT NULL,
model varchar(255) NOT NULL,
quantity integer NOT NULL,
ean bigint NOT NULL,
processor varchar(255) NOT NULL,
ram integer NOT NULL,
storage integer NOT NULL,
screen_size double precision NOT NULL,
operating_system varchar(255) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (fk_category_name) REFERENCES categories (name)
);


CREATE TABLE smartphones (
id serial NOT NULL,
GeneralDescription text NOT NULL,
technicalDescription text NOT NULL,
name varchar(255) NOT NULL,
sku varchar(255) NOT NULL,
weight double precision NOT NULL,
width double precision NOT NULL,
height double precision NOT NULL,
depth double precision NOT NULL,
manufacturer varchar(255) NOT NULL,
fk_category_name varchar(255) NOT NULL,
price double precision NOT NULL,
color colors NOT NULL,
model varchar(255) NOT NULL,
quantity integer NOT NULL,
ean bigint NOT NULL,
storage integer NOT NULL,
screen_size double precision NOT NULL,
operating_system varchar(255) NOT NULL,
camera_resolution integer NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (fk_category_name) REFERENCES categories (name)
);


CREATE TABLE headsets (
id serial NOT NULL,
GeneralDescription text NOT NULL,
technicalDescription text NOT NULL,
name varchar(255) NOT NULL,
sku varchar(255) NOT NULL,
weight double precision NOT NULL,
width double precision NOT NULL,
height double precision NOT NULL,
depth double precision NOT NULL,
manufacturer varchar(255) NOT NULL,
fk_category_name varchar(255) NOT NULL,
price double precision NOT NULL,
color colors NOT NULL,
model varchar(255) NOT NULL,
quantity integer NOT NULL,
ean bigint NOT NULL,
speaker_dimensions integer NOT NULL,
cable_length double precision NOT NULL,
bluetooth varchar(3) NOT NULL,
microphone_dimensions varchar(255),
PRIMARY KEY (id),
FOREIGN KEY (fk_category_name) REFERENCES categories (name)
);

CREATE TABLE cameras (
id serial NOT NULL,
GeneralDescription text NOT NULL,
technicalDescription text NOT NULL,
name varchar(255) NOT NULL,
sku varchar(255) NOT NULL,
weight double precision NOT NULL,
width double precision NOT NULL,
height double precision NOT NULL,
depth double precision NOT NULL,
manufacturer varchar(255) NOT NULL,
fk_category_name varchar(255) NOT NULL,
price double precision NOT NULL,
color colors NOT NULL,
model varchar(255) NOT NULL,
quantity integer NOT NULL,
ean bigint NOT NULL,
optical_zoom integer NOT NULL,
recording_resolution varchar(255) NOT NULL,
screen_size double precision NOT NULL,
connection_type connection_types NOT NULL,
video_resolution varchar(255) NOT NULL,
storage integer NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (fk_category_name) REFERENCES categories (name)
);



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


CREATE TABLE categories (
id serial NOT NULL,
name varchar(255),
PRIMARY KEY(id)
);

CREATE DOMAIN colors AS VARCHAR(255) CHECK (value IN ('Black', 'White', 'Gray', 'Lightgray', 'Red', 'Yellow', 'Green', 'Blue', 'Colorful', 'Pink', 'Silver', 'Gold','Brown'));
CREATE DOMAIN connection_types AS VARCHAR(255) CHECK (value IN ('Usb', 'Wifi', 'Usbwifi'));

CREATE TABLE products (
id serial NOT NULL,
general_description text NOT NULL,
technical_description text NOT NULL,
name varchar(255) NOT NULL,
sku varchar(255) NOT NULL,
weight double precision NOT NULL,
width double precision NOT NULL,
height double precision NOT NULL,
depth double precision NOT NULL,
manufacturer varchar(255) NOT NULL,
fk_category_id integer NOT NULL,
price double precision NOT NULL,
color colors NOT NULL,
model varchar(255) NOT NULL,
quantity integer NOT NULL,
ean bigint NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (fk_category_id) REFERENCES categories (id)
);

CREATE TABLE laptops (
fk_product_id integer NOT NULL,
processor varchar(255) NOT NULL,
ram integer NOT NULL,
storage integer NOT NULL,
screen_size double precision NOT NULL,
operating_system varchar(255) NOT NULL,
FOREIGN KEY (fk_product_id) REFERENCES products (id)
);


CREATE TABLE smartphones (
fk_product_id integer NOT NULL,
storage integer NOT NULL,
screen_size double precision NOT NULL,
operating_system varchar(255) NOT NULL,
camera_resolution integer NOT NULL,
FOREIGN KEY (fk_product_id) REFERENCES products (id)
);


CREATE TABLE headsets (
fk_product_id integer NOT NULL,
speaker_dimensions integer NOT NULL,
cable_length double precision NOT NULL,
bluetooth varchar(3) NOT NULL,
microphone_dimensions varchar(255),
FOREIGN KEY (fk_product_id) REFERENCES products (id)
);

CREATE TABLE cameras (
fk_product_id integer NOT NULL,
optical_zoom integer NOT NULL,
recording_resolution varchar(255) NOT NULL,
screen_size double precision NOT NULL,
connection_type connection_types NOT NULL,
video_resolution varchar(255) NOT NULL,
storage integer NOT NULL,
FOREIGN KEY (fk_product_id) REFERENCES products (id)
);

CREATE TABLE product_photos (
fk_product_id integer NOT NULL,
file_name varchar(255) NOT NULL,
FOREIGN KEY (fk_product_id) REFERENCES products (id)
);

CREATE TABLE promotions (
id serial NOT NULL,
name varchar(255),
description varchar(255),
discount_rate double precision NOT NULL,
start_date TIMESTAMP WITH TIME ZONE NOT NULL,
end_date TIMESTAMP WITH TIME ZONE NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE promotion_category (
id serial NOT NULL,
fk_category_id integer NOT NULL,
fk_promotion_id integer NOT NULL,
FOREIGN KEY (fk_category_id) REFERENCES categories (id),
FOREIGN KEY (fk_promotion_id) REFERENCES promotions (id)
);




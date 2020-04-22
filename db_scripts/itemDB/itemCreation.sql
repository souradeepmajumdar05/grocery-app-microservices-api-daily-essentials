create database itemdb;
CREATE TABLE `item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `category` enum('DAIRY','CEREALS','FRUITS','VEGETABLES','OILS','SPICES','MEDICINE','MEATSANDFISH','EGGS') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `itemdetails` varchar(255) NOT NULL,
  `image_url` varchar(255) NOT NULL,
  `first_enrollement_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `in_stock` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
CREATE TABLE `itemcatalog` (
  `id` int NOT NULL AUTO_INCREMENT,
  `item_id` int DEFAULT NULL,
  `price` int NOT NULL,
  `currency_short` enum('INR','USD') DEFAULT NULL,
  `qty` int NOT NULL,
  `qty_type` enum('gm','kg','l','kl','psc') DEFAULT NULL,
  `time_of_entry` timestamp NOT NULL,
  `time_of_expire` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `itemid` (`item_id`),
  CONSTRAINT `itemcatalog_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


-- SELECT * FROM item where inStock=true;
----item---

INSERT INTO item (id, name, category, itemdetails,imageUrl,instock)
VALUES (1, 'rice', 'CEREALS','Basmati Rice','E:\microservice\dailyEssential\photo\India-Gate-Classic-Basmati-Rice-Long-Grain1kg.jpg',true);
commit;

INSERT INTO item (id, name, category, itemdetails,imageUrl,instock)
VALUES (2, 'dal', 'CEREALS','moong gal','E:\microservice\dailyEssential\photo\India-Gate-Classic-dal1kg.jpg',true);
commit;

INSERT INTO item (id, name, category, itemdetails,imageUrl,instock)
VALUES (3, 'fortune oil', 'OILS','moong gal','E:\microservice\dailyEssential\photo\fortune_oil.jpg',false);
commit;

----- item  catalog
ALTER TABLE itemcatalog CHANGE currency_short currency_short ENUM('INR','USD');
ALTER TABLE itemcatalog CHANGE qty_type qty_type ENUM('gm','kg','l','kl','psc');
INSERT INTO itemdb.itemcatalog (itemid, price, currency_short, qty, qty_type, time_of_entry, time_of_expire)
VALUES(1, 10, 'INR', 1000, 'kg',CURRENT_TIME(), TIMESTAMP(curdate(), curtime()) );
commit;


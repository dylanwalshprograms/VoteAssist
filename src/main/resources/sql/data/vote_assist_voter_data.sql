-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: vote-assist-db.cnfszczk1v4t.us-east-2.rds.amazonaws.com    Database: vote_assist
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Dumping data for table `voter_data`
--

LOCK TABLES `voter_data` WRITE;
/*!40000 ALTER TABLE `voter_data` DISABLE KEYS */;
INSERT INTO `voter_data` VALUES (1,'902 Royal Ave','Royal Oak',NULL,NULL,NULL,'Dilbur',NULL,'Dilbur, back at it again','cocktail','666-666-6666',NULL,'MI',_binary '','48073',_binary ''),(2,'902 Royal Ave','Royal Oak',NULL,NULL,NULL,'Wilbur',NULL,'Better than Dilbur','none','555-555-5555',NULL,'MI',_binary '','48073',NULL),(3,'901 S Miami Ave','Miami',NULL,NULL,NULL,'Florida Man',NULL,'','dem','555-555-5555',NULL,'FL',NULL,'33130',NULL),(4,'135 W Bay St','Savannah',NULL,NULL,NULL,'Tim White',NULL,'','dem','666-666-6666',NULL,'GA',NULL,'31401',NULL),(5,'3451 SpringHill Ave','Mobile',NULL,NULL,NULL,'Tide Jones',NULL,'','repub','555-555-5555',NULL,'AL',NULL,'36608',NULL),(8,'61 Highland Ave','Dexter',NULL,NULL,NULL,'Sailor',NULL,'was the champion of justice and test',NULL,'123-456-7878',NULL,'ME',_binary '','04930',NULL),(9,'9 Meadow Crest Ln','Waterbury',NULL,NULL,NULL,'Syrup Lad',NULL,'Sticky',NULL,'232-323-2323',NULL,'VT',NULL,'05676',NULL),(10,'822 Grace St','Baldwin',NULL,NULL,NULL,'Yorker',NULL,'Loves the Yankees',NULL,'111-111-1110',NULL,'NY',NULL,'11510',NULL),(11,'947 Virgina Ave','Lancaster',NULL,NULL,NULL,'Philly Bro',NULL,'A bro from Philly',NULL,'000-000-4789',NULL,'PA',NULL,'17603',NULL),(12,'205 Bay View Ave','Providence',NULL,NULL,NULL,'Accent Lady',NULL,'Loves seafood',NULL,'236-528-7491',NULL,'RI',NULL,'02905',NULL),(13,'200 S Oklahoma Ave','Oklahoma City',NULL,NULL,NULL,'Sooner Guy',NULL,'',NULL,'666-666-6666',NULL,'OK',_binary '','73104',NULL),(14,'1120 W 6th St','Los Angeles',NULL,NULL,NULL,'Minerva Franks',NULL,'','Democratic','555-555-5555',NULL,'CA',_binary '',NULL,NULL),(15,'203 E Speedway Blvd','Tuscon',NULL,NULL,NULL,'Homer Ulysses',NULL,'Nice guy, calming voice','Democratic','555-555-5555',NULL,'AZ',_binary '',NULL,NULL),(16,'1309 N Main St','Roswell',NULL,NULL,NULL,'Ursula F. Omar',NULL,'','Space','555-555-5555',NULL,'NM',_binary '',NULL,NULL),(17,'7260 Rainbow Blvd','Las Vegas',NULL,NULL,NULL,'Howard Hues',NULL,'','Republican','555-555-5555',NULL,'NV',_binary '',NULL,NULL),(18,'5151 S State St','Murray',NULL,NULL,NULL,'Matt Parker',NULL,'','Democratic','555-555-5555',NULL,'UT',_binary '',NULL,NULL),(19,'800 5th Ave L901','Seattle',NULL,NULL,NULL,'Erin Brockovich',NULL,'','Democrat','555-555-5555',NULL,'WA',NULL,'98104',NULL),(20,'3875 S Bond Ave','Portland',NULL,NULL,NULL,'Forest Gump',NULL,'','Jenny','555-555-5555',NULL,'OR',NULL,'97239',NULL),(21,'2203 Montana Ave','Billings',NULL,NULL,NULL,'Woody',NULL,'','none','555-555-5555',NULL,'MT',NULL,'59101',NULL),(22,'121 N 9th St','Boise',NULL,NULL,NULL,'Mr. Anderson',NULL,'',NULL,'555-555-5555',NULL,'ID',NULL,'93702',NULL),(23,'2111 Central Ave','Cheyenne',NULL,NULL,NULL,'John Wick',NULL,'',NULL,'555-555-5555',NULL,'WY',NULL,'82001',NULL);
/*!40000 ALTER TABLE `voter_data` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-20 11:13:52

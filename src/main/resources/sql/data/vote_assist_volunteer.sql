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
-- Dumping data for table `volunteer`
--

LOCK TABLES `volunteer` WRITE;
/*!40000 ALTER TABLE `volunteer` DISABLE KEYS */;
INSERT INTO `volunteer` VALUES (1,_binary '','Dylan Walsh','password','dylpickle'),(2,NULL,'William Trigona','Trig','Trigger93'),(3,_binary '','Tom','tomiscool','thomasjrowland'),(4,NULL,'Samwise','password','samiswise'),(5,NULL,'Sean Buck','javaIsCool!','srbuck'),(6,NULL,'jeffiman','mrmanniman','mrmantheman'),(7,_binary '','Billy','billy','Trig93'),(8,_binary '','Ash','password','Ash'),(9,NULL,'Triggy Trig','trig','Trig'),(10,NULL,'Trig','ha','Gotteem'),(11,NULL,'William Trigona','trig','Trig1992'),(12,NULL,'Billy','Billy','BillyBoy'),(13,NULL,'Billy','Billy','BillyBob'),(14,NULL,'Bob','Billy','BobBilly'),(15,NULL,'Willy','billyiscool','WillyBob'),(16,NULL,'Thomas','tomiscool','tomiscool'),(17,NULL,'Bill','billy','Willis'),(18,NULL,'tonka','tonka','tonka'),(19,NULL,'Ashley Newman','password','Dottee');
/*!40000 ALTER TABLE `volunteer` ENABLE KEYS */;
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

-- Dump completed on 2020-06-20 11:13:50

-- MySQL dump 10.13  Distrib 5.6.24, for linux-glibc2.5 (x86_64)
--
-- Host: 127.0.0.1    Database: UserManagement
-- ------------------------------------------------------
-- Server version	5.6.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Address`
--

DROP TABLE IF EXISTS `Address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Address` (
  `id` bigint(20) NOT NULL,
  `doorNo` varchar(10) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `city` bigint(20) DEFAULT NULL,
  `pinCode` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `city` (`city`),
  CONSTRAINT `Address_ibfk_3` FOREIGN KEY (`city`) REFERENCES `City` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Address`
--

LOCK TABLES `Address` WRITE;
/*!40000 ALTER TABLE `Address` DISABLE KEYS */;
INSERT INTO `Address` VALUES (4864032682897231586,'34','iyappa',2,'577201'),(4920123496808882575,'3113','1333',1,'1333'),(5892820266968850187,'656563','35656',2,'346666'),(6149390639135217941,'43','Shiva beedhi',2,'577201'),(6247752153448252461,'43','aiyappa swami',2,'577201'),(6355970920743921911,'56464','6646',1,'4444566'),(6449060448290472875,'34','Iyyappa swamy street',1,'577201'),(6800442759295732088,'44','Shiva temple',5,'577201'),(7554353486760810339,'qrerq','rrr',2,'q534535'),(7810482647223117490,'24','shiva sreet',2,'577201'),(8314533358066210822,'43','aiyappa swamy',2,'577201'),(8784842439327045525,'etertert','555',1,'35553'),(8792855596106712328,'355555','35',2,'35555555'),(9041272538975981616,'4346463','6663',1,'65665');
/*!40000 ALTER TABLE `Address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `City`
--

DROP TABLE IF EXISTS `City`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `City` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `state` bigint(20) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_City_1_idx` (`state`),
  CONSTRAINT `fk_City_1` FOREIGN KEY (`state`) REFERENCES `State` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `City`
--

LOCK TABLES `City` WRITE;
/*!40000 ALTER TABLE `City` DISABLE KEYS */;
INSERT INTO `City` VALUES (1,'Mysore','Mysore',1,1),(2,'Shivamogga','Shivamogga',1,1),(3,'Madikeri','Madikeri',1,1),(4,'Tumkuru','Tumukuru',1,0),(5,'Hasana','Hasana',1,1);
/*!40000 ALTER TABLE `City` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Country`
--

DROP TABLE IF EXISTS `Country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Country` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Country`
--

LOCK TABLES `Country` WRITE;
/*!40000 ALTER TABLE `Country` DISABLE KEYS */;
INSERT INTO `Country` VALUES (1,'INDIA','Yoga',1),(2,'USA','Military',1),(3,'CHINA','Kugfu',0),(4,'RUSSIA','Putin',1);
/*!40000 ALTER TABLE `Country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `State`
--

DROP TABLE IF EXISTS `State`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `State` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `country` bigint(20) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_State_1_idx` (`country`),
  CONSTRAINT `fk_State_1` FOREIGN KEY (`country`) REFERENCES `Country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `State`
--

LOCK TABLES `State` WRITE;
/*!40000 ALTER TABLE `State` DISABLE KEYS */;
INSERT INTO `State` VALUES (1,'Karnataka','Karnataka',1,1),(2,'Kerala','Kerala',1,0),(3,'Punjab','Punjab',1,1),(4,'Gujrath','Gujrath',1,1),(5,'Tamilnadu','Tamilnadu',1,1);
/*!40000 ALTER TABLE `State` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `id` bigint(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `dob` varchar(45) DEFAULT NULL,
  `mobileNumber` varchar(13) DEFAULT NULL,
  `emailId` varchar(45) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `addressId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mobileNumber_UNIQUE` (`mobileNumber`),
  UNIQUE KEY `emailId_UNIQUE` (`emailId`),
  UNIQUE KEY `UK_kdy7231aflvkulvq0ds8o2lu1` (`emailId`),
  UNIQUE KEY `UK_a3li2vohw27l1xmqhy59c9po2` (`mobileNumber`),
  KEY `fk_User_1_idx` (`addressId`),
  CONSTRAINT `fk_User_1` FOREIGN KEY (`addressId`) REFERENCES `Address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (4638671675160920784,'ewewr','wrewer','2017-08-29T18:30:00.000Z','453454543534',NULL,1,9041272538975981616),(5043511867692036945,'Jamal','ijaoisda','2017-08-29T18:30:00.000Z','2245544466',NULL,1,7554353486760810339),(5344626490606160889,'mah','retere','27/09/2017','3534535',NULL,1,8784842439327045525),(7298865563781658009,'234','222222','2017-08-30T18:30:00.000Z','2444',NULL,1,8792855596106712328),(7747863814044198736,'33324','3322','2017-08-29T18:30:00.000Z','322323',NULL,1,4920123496808882575),(7817856778974061146,'ewrwew','rrrw','2017-08-30T18:30:00.000Z','rrrwr',NULL,1,5892820266968850187),(8152911188409599547,'454353','565636','2017-08-31T18:30:00.000Z','66635656','mahes@gg.cc',1,6355970920743921911);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-09 21:39:07

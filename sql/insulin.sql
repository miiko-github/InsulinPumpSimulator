CREATE DATABASE  IF NOT EXISTS `insulinpump` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `insulinpump`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: insulinpump
-- ------------------------------------------------------
-- Server version	5.6.15

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
-- Table structure for table `carbohydrates_intake`
--
-- fifth starts
DROP TABLE IF EXISTS `CARBOHYDRATE_INTAKE_HISTORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CARBOHYDRATE_INTAKE_HISTORY` (
  `carbohydrate_intake_id` varchar(10) NOT NULL,
  `carbohydrate_amount` varchar(10) DEFAULT NULL,
  `time` date DEFAULT NULL,
  PRIMARY KEY (`carbohydrate_intake_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carbohydrates_intake`
--

LOCK TABLES `CARBOHYDRATE_INTAKE_HISTORY` WRITE;
/*!40000 ALTER TABLE `CARBOHYDRATE_INTAKE_HISTORY` DISABLE KEYS */;
INSERT INTO `CARBOHYDRATE_INTAKE_HISTORY` VALUES (1,'10.2','2013-12-18 06:30:00');
/*!40000 ALTER TABLE `CARBOHYDRATE_INTAKE_HISTORY` ENABLE KEYS */;
UNLOCK TABLES;
-- fifth ends
--
-- Table structure for table `glucose_level`
--
-- fourth starts

DROP TABLE IF EXISTS `GLUCOSE_LEVEL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GLUCOSE_LEVEL` (
  `glucose_level_id` int NOT NULL,
  `glucose_level_reading` varchar(45) NOT NULL,
  `time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`glucose_level_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Dumping data for table `glucose_level`
--

LOCK TABLES `GLUCOSE_LEVEL` WRITE;
/*!40000 ALTER TABLE `GLUCOSE_LEVEL` DISABLE KEYS */;
INSERT INTO `GLUCOSE_LEVEL` VALUES (1,'30','2013-12-18 01:30:00'),(2,'30','2013-12-18 01:30:00');
/*!40000 ALTER TABLE `GLUCOSE_LEVEL` ENABLE KEYS */;
UNLOCK TABLES;

-- fourth end
--
-- Table structure for table `insulin_delivered`
--
-- sixth table
DROP TABLE IF EXISTS `INSULIN_DELIVERED`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `INSULIN_DELIVERED` (
  `insulin_delivered_id` int,
  `insulin_amount` double DEFAULT NULL,
  `time`  varchar(40) DEFAULT NULL,
  `dosage_type` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`insulin_delivered_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insulin_delivered`
--

LOCK TABLES `INSULIN_DELIVERED` WRITE;
/*!40000 ALTER TABLE `INSULIN_DELIVERED` DISABLE KEYS */;
INSERT INTO `INSULIN_DELIVERED` VALUES (1,12.3,'2013-12-18 01:00:00','basal');
/*!40000 ALTER TABLE `INSULIN_DELIVERED` ENABLE KEYS */;
UNLOCK TABLES;
-- sixth table ends
--
-- Table structure for table `profile`
--
-- first starts
DROP TABLE IF EXISTS `BASAL_PROFILE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BASAL_PROFILE` (
  `basal_profile_id` int,
  `basal_start_time` datetime DEFAULT NULL,
  `basal_end_time` datetime default null,
  `insulin_amount` varchar(10),
  `pofile_name` varchar(45) NOT NULL,
  PRIMARY KEY (`basal_profile_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `BASAL_PROFILE` WRITE;
/*!40000 ALTER TABLE `BASAL_PROFILE` DISABLE KEYS */;
INSERT INTO `BASAL_PROFILE` VALUES (1,'2013-12-18 01:00:00','2013-12-19 01:00:00','1.1','p1'),(2,'2013-12-18 01:00:00','2013-12-19 01:00:00','1.1','p2');
/*!40000 ALTER TABLE `BASAL_PROFILE` ENABLE KEYS */;
UNLOCK TABLES;

-- first ends
-- seconds starts
DROP TABLE IF EXISTS `BASAL_PROFILE_STATUS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BASAL_PROFILE_STATUS` (
  `profile_status_id` int,
  `status` varchar(45) ,
  `profile_name` varchar(45),
 
  PRIMARY KEY (`profile_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `BASAL_PROFILE_STATUS` WRITE;
/*!40000 ALTER TABLE `BASAL_PROFILE_STATUS` DISABLE KEYS */;
INSERT INTO `BASAL_PROFILE_STATUS` VALUES (1,'ON','sameer'),(2,'ON','amul');
/*!40000 ALTER TABLE `BASAL_PROFILE_STATUS` ENABLE KEYS */;
UNLOCK TABLES;
-- second ends
------


--
-- Table structure for table `userinfo`
--
-- seventh starts
DROP TABLE IF EXISTS `USER_INFO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_INFO` (
  `user_info_id` int,
  `user_name` varchar(45),
  `gender` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `insulin_type` varchar(10) NOT NULL,
  `weight` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `USER_INFO` WRITE;
/*!40000 ALTER TABLE `USER_INFO` DISABLE KEYS */;
INSERT INTO `USER_INFO` VALUES (1,'person1','m',35,'1',68);
/*!40000 ALTER TABLE `USER_INFO` ENABLE KEYS */;
UNLOCK TABLES;

-- seventh ends
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-18  1:32:37

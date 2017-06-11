CREATE DATABASE  IF NOT EXISTS `event_management` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `event_management`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: event_management
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `CUSTOMER_EVENT_REQUEST`
--

DROP TABLE IF EXISTS `CUSTOMER_EVENT_REQUEST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CUSTOMER_EVENT_REQUEST` (
  `CUSTOMER_EVENT_REQUEST_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `BUDGET` bigint(20) DEFAULT NULL,
  `EXPECTATIONS` varchar(255) DEFAULT NULL,
  `EVENT_ID` bigint(20) NOT NULL,
  `FACILITY_ID` bigint(20) NOT NULL,
  `USER_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`CUSTOMER_EVENT_REQUEST_ID`),
  KEY `FK_buj4w4ppqhsnl4113qtqoy9d1` (`EVENT_ID`),
  KEY `FK_7ukvrouid7nwoxsvv43fwiv31` (`FACILITY_ID`),
  KEY `FK_opv82tv91c7vfcloplpepccyh` (`USER_ID`),
  CONSTRAINT `FK_7ukvrouid7nwoxsvv43fwiv31` FOREIGN KEY (`FACILITY_ID`) REFERENCES `FACILITY` (`FACILITY_ID`),
  CONSTRAINT `FK_buj4w4ppqhsnl4113qtqoy9d1` FOREIGN KEY (`EVENT_ID`) REFERENCES `EVENT` (`EVENT_ID`),
  CONSTRAINT `FK_opv82tv91c7vfcloplpepccyh` FOREIGN KEY (`USER_ID`) REFERENCES `USER` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOMER_EVENT_REQUEST`
--

LOCK TABLES `CUSTOMER_EVENT_REQUEST` WRITE;
/*!40000 ALTER TABLE `CUSTOMER_EVENT_REQUEST` DISABLE KEYS */;
/*!40000 ALTER TABLE `CUSTOMER_EVENT_REQUEST` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-11 18:34:47

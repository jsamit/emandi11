-- MySQL dump 10.13  Distrib 5.6.47, for Linux (x86_64)
--
-- Host: localhost    Database: emandi11
-- ------------------------------------------------------
-- Server version	5.6.47

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
-- Table structure for table `consumers`
--

DROP TABLE IF EXISTS `consumers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consumers` (
  `consumer_id` int(11) NOT NULL AUTO_INCREMENT,
  `consumer_address` varchar(255) DEFAULT NULL,
  `consumer_city` varchar(20) DEFAULT NULL,
  `consumer_company` varchar(100) DEFAULT NULL,
  `consumer_contact` varchar(13) DEFAULT NULL,
  `consumer_email` varchar(30) NOT NULL,
  `consumer_name` varchar(30) NOT NULL,
  `consumer_pancard` varchar(10) NOT NULL,
  `consumer_password` varchar(255) NOT NULL,
  `consumer_pincode` varchar(6) DEFAULT NULL,
  `consumer_state` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`consumer_id`),
  UNIQUE KEY `UK_gaxykst6gxi3jmlkh29369c5e` (`consumer_email`),
  UNIQUE KEY `UK_c71xpx14xjvb4kvg43p38tpvk` (`consumer_pancard`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumers`
--

LOCK TABLES `consumers` WRITE;
/*!40000 ALTER TABLE `consumers` DISABLE KEYS */;
INSERT INTO `consumers` VALUES (1,'789456w','amit','anit@gmail.com','cdac','delhi','7869451230','rewa','up','789654','qwerty');
/*!40000 ALTER TABLE `consumers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumers_requirement`
--

DROP TABLE IF EXISTS `consumers_requirement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consumers_requirement` (
  `requirement_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_expected_date` date DEFAULT NULL,
  `product_category` varchar(50) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_quality` varchar(255) DEFAULT NULL,
  `product_quantity` varchar(255) DEFAULT NULL,
  `consumer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`requirement_id`),
  KEY `FKkuovmx8vwsbfaxad7h7tanq8e` (`consumer_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumers_requirement`
--

LOCK TABLES `consumers_requirement` WRITE;
/*!40000 ALTER TABLE `consumers_requirement` DISABLE KEYS */;
INSERT INTO `consumers_requirement` VALUES (1,'2020-12-08','kharif','rice','poor','2',1),(2,'2020-12-08','kharif','wheat','poor','2',1);
/*!40000 ALTER TABLE `consumers_requirement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `farmer_product`
--

DROP TABLE IF EXISTS `farmer_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `farmer_product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_category` varchar(50) DEFAULT NULL,
  `product_price` double DEFAULT NULL,
  `product_quality` varchar(255) DEFAULT NULL,
  `product_quantity` int(11) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `farmer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FK2h4dlvynu9bds4w3fdkw242sn` (`farmer_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farmer_product`
--

LOCK TABLES `farmer_product` WRITE;
/*!40000 ALTER TABLE `farmer_product` DISABLE KEYS */;
INSERT INTO `farmer_product` VALUES (1,'rabi',4500,'poor',4,'rice',1),(2,'rabi001',4500,'poor',4,'rice',2),(3,'rabi003',4500,'poor',4,'rice',3),(4,'rabi005',4500,'poor',4,'rice',2),(5,'rabi002',4500,'poor',4,'rice',1),(6,'rabi002',4500,'poor',4,'wheat',1);
/*!40000 ALTER TABLE `farmer_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `farmers`
--

DROP TABLE IF EXISTS `farmers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `farmers` (
  `farmer_id` int(11) NOT NULL AUTO_INCREMENT,
  `farmer_address` varchar(255) DEFAULT NULL,
  `farmer_adhaarid` varchar(12) NOT NULL,
  `farmer_city` varchar(20) DEFAULT NULL,
  `farmer_contact` varchar(13) NOT NULL,
  `farmer_email` varchar(50) NOT NULL,
  `farmer_name` varchar(60) NOT NULL,
  `farmer_password` varchar(255) NOT NULL,
  `farmer_pincode` varchar(6) DEFAULT NULL,
  `farmer_state` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`farmer_id`),
  UNIQUE KEY `UK_r58lrpkji6g0j0dwjf2oo491y` (`farmer_adhaarid`),
  UNIQUE KEY `UK_kocbxqgxypa8iwbslgst9uywx` (`farmer_contact`),
  UNIQUE KEY `UK_qwjsbimw2kyy7vnhkcv9bmi0` (`farmer_email`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farmers`
--

LOCK TABLES `farmers` WRITE;
/*!40000 ALTER TABLE `farmers` DISABLE KEYS */;
INSERT INTO `farmers` VALUES (1,'pune','789654','lucknow','7894561230','ankur@gmail.com','ankur','676','789654','mp'),(2,'pune','789656','lucknow','7894561235','ankur01@gmail.com','ankur','676','789655','mp'),(3,'pune','783654','lucknow','7894541235','ankur02@gmail.com','ankur','676','789655','mp');
/*!40000 ALTER TABLE `farmers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-30 22:41:21

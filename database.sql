-- MySQL dump 10.13  Distrib 5.5.21, for Win32 (x86)
--
-- Host: localhost    Database: murach
-- ------------------------------------------------------
-- Server version	5.5.21

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
-- Table structure for table `download`
--

DROP TABLE IF EXISTS `download`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `download` (
  `DownloadID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `DownloadDate` datetime NOT NULL,
  `DownloadFilename` varchar(30) NOT NULL,
  `ProductCode` varchar(10) NOT NULL,
  PRIMARY KEY (`DownloadID`),
  KEY `UserID` (`UserID`),
  CONSTRAINT `download_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `download`
--

LOCK TABLES `download` WRITE;
/*!40000 ALTER TABLE `download` DISABLE KEYS */;
INSERT INTO `download` VALUES (1,1,'2007-05-01 00:00:00','jr01_so_long.mp3','jr01'),(2,1,'2012-03-06 20:05:50','jr01_filter.mp3','jr01'),(3,2,'2012-03-06 20:05:50','jr01_filter.mp3','jr01'),(4,3,'2012-03-06 20:05:50','jr01_so_long.mp3','jr01');
/*!40000 ALTER TABLE `download` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movies` (
  `MovieID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MovieName` varchar(500) NOT NULL,
  `Year` int(10) unsigned NOT NULL,
  `Description` varchar(5000) NOT NULL,
  PRIMARY KEY (`MovieID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (6,'Transformers 2: Dark Side of the Night or something',2010,'Fuck if I know, I heard it was awful'),(7,'Citizen Kane',1930,'Time travelling media mogul Fernando Kane writes stories about his travels atop the majestic spacecraft Rosebud in this heartwarming romp.'),(8,'The Dark Knight',2008,'The Joker\'s wreaking havoc on Gotham and Batman isn\'t happy about it'),(9,'Toy Story',1995,'A new toy joins a bunch of them and Woody isn\'t happy about it'),(10,'Toy Story 2',2001,'Woody\'s gonna be a bigshot toy in Japan and Buzzy isn\'t happy about it'),(11,'Toy Story 3',2011,'Andy\'s moving to college and the toys aren\'t happy about it'),(15,'Titanic',1999,'The fantastic voyage of this famous unsinkable ship. No icebergs here!'),(19,'Inception',2010,'BRWWWWWWWAAAAAAAAAAAAAWWWWWWWWMMMMMM'),(21,'Star Trek 2: The Wrath of Khan',1978,'test');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reviews` (
  `MovieID` int(10) unsigned NOT NULL,
  `UserID` int(10) unsigned NOT NULL,
  `ReviewText` varchar(5000) NOT NULL,
  `Rating` int(10) unsigned NOT NULL,
  `Score` int(10) unsigned NOT NULL,
  PRIMARY KEY (`MovieID`,`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT INTO `reviews` VALUES (7,1,'An overrated film. I understand its importance from a historical and photographical standpoint, but what it has in originality it lacks in entertainment value. It has a powerful message which is sure to make the most hardened of film snobs weep with joy, however the regular viewer will be unentertained by this drab setpiece focusing on the life of a boring old man.',0,0);
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(50) DEFAULT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `EmailAddress` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'John','Smith','jsmith@gmail.com'),(2,'Andrea','Steelman','andi@murach.com'),(3,'Joel','Murach','joelmurach@yahoo.com'),(4,'testy','testerson','test@test');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userpass`
--

DROP TABLE IF EXISTS `userpass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userpass` (
  `Username` varchar(15) NOT NULL,
  `Password` varchar(15) NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userpass`
--

LOCK TABLES `userpass` WRITE;
/*!40000 ALTER TABLE `userpass` DISABLE KEYS */;
INSERT INTO `userpass` VALUES ('andrea','sesame'),('anne','sesame'),('joel','sesame');
/*!40000 ALTER TABLE `userpass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userrole`
--

DROP TABLE IF EXISTS `userrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userrole` (
  `Username` varchar(15) NOT NULL,
  `Rolename` varchar(15) NOT NULL,
  PRIMARY KEY (`Username`,`Rolename`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userrole`
--

LOCK TABLES `userrole` WRITE;
/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
INSERT INTO `userrole` VALUES ('andrea','programmer'),('andrea','service'),('joel','programmer');
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `UserID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) NOT NULL,
  `EmailAddress` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Permission` int(10) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'MikeOShay','mike1022_@hotmail.com','admin',1),(2,'xXxKyle547xXx','iamkyle@gmail.gov','burkinafaso',1),(3,'LittleShelly','john@neopets.net','ilovelucy',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-04-09 23:15:11

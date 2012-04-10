-- MySQL dump 10.13  Distrib 5.5.22, for Win64 (x86)
--
-- Host: localhost    Database: murach
-- ------------------------------------------------------
-- Server version	5.5.22

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `download`
--

LOCK TABLES `download` WRITE;
/*!40000 ALTER TABLE `download` DISABLE KEYS */;
INSERT INTO `download` VALUES (1,1,'2007-05-01 00:00:00','jr01_so_long.mp3','jr01'),(2,1,'2012-03-06 19:56:56','jr01_filter.mp3','jr01'),(3,2,'2012-03-06 19:56:56','jr01_filter.mp3','jr01'),(4,3,'2012-03-06 19:56:56','jr01_so_long.mp3','jr01');
/*!40000 ALTER TABLE `download` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movies` (
  `MovieID` int(11) NOT NULL AUTO_INCREMENT,
  `MovieName` varchar(50) DEFAULT NULL,
  `Year` varchar(50) DEFAULT NULL,
  `Description` text,
  PRIMARY KEY (`MovieID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'Casablanca','1942','They\'re in Casablanca.'),(2,'Citizen Kane','1941','Rosebud.'),(3,'Transformers','2006','Explosions.'),(4,'The Walk','2015','They walked.'),(5,'Schindler\'s List','2000','There was a list.'),(6,'The Rugrats Movie','2001','They crawl.'),(7,'Plan 9 From OuterSpace','1983','Plan 8 failed.');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pendinguser`
--

DROP TABLE IF EXISTS `pendinguser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pendinguser` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `EmailAddress` varchar(45) NOT NULL,
  `URL` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pendinguser`
--

LOCK TABLES `pendinguser` WRITE;
/*!40000 ALTER TABLE `pendinguser` DISABLE KEYS */;
/*!40000 ALTER TABLE `pendinguser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reviews` (
  `ReviewID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `MovieID` int(11) NOT NULL,
  `ReviewText` text,
  `Rating` varchar(50) DEFAULT NULL,
  `Score` int(11) DEFAULT NULL,
  `Flag` binary(1) DEFAULT NULL,
  PRIMARY KEY (`ReviewID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT INTO `reviews` VALUES (1,1,1,'I had never heard of this before because there was no advertisements for it. Anyway, the movie made no sense, had terrible production values (Black and White? What is this? 1941?) and I was not given a reviewers package. This gets my worst score ever','3',0,NULL),(2,1,2,'This movie was boooooring. There were no explosions and it turned out it was all about a sled. What the hell is that supposed to even mean? My advice, watch Transformers 3 instead, its REAL art','1',0,NULL),(3,2,1,'This is the most cliched love story I have seen since Twilight. At the end, they tried to go against the grain by having it not end well, but lets face it, that is a half-assed way of making things interesting. PLEASE SUBSCRIBE TO MY YOUTUBE ACCOUNT AND HELP ME BECOME A YOUTUBE PARTNER','4',0,NULL),(4,2,2,'I have never seen a more boring movie. I was expecting Nazis getting blown up, instead its about love and how war effects people. I was not expecthing this and I want my refund. Go see Transformers instead, its got romance that I can relate with.','2',0,NULL),(5,2,3,'You cannot silence my entry! My excellent reviews, which can be seen at my blog, was deleted in a foul act of censorship. My loyal fanbase, please attack this site!','2',0,NULL),(6,1,3,'Nope.','2',0,NULL),(7,3,1,'This movie is amazing. It killed my family. I love it.','5',0,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'John','Smith','jsmith@gmail.com'),(2,'Andrea','Steelman','andi@murach.com'),(3,'Joel','Murachn','joelmurach@yahoo.com');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userrole`
--

LOCK TABLES `userrole` WRITE;
/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
INSERT INTO `userrole` VALUES ('/l/lII<E','ReviewCreator'),('andrea','programmer'),('andrea','service'),('Jason','ReviewCreator'),('joel','programmer'),('Kyle','ReviewCreator'),('Mike','ReviewCreator'),('newTest','ReviewCreator'),('PaidReviewer','ReviewCreator'),('Sheldon','ReviewCreator');
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(50) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `EmailAddress` varchar(50) DEFAULT NULL,
  `Permission` int(11) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'/l/lII<E','insecure','ReviewsRock@hotmail.com',NULL),(2,'PaidReviewer','shill','WillAdvertiseForFood@gmail.com',NULL),(3,'Sheldon','Sheldon','randommeteor@live.ca',NULL),(4,'Kyle','Kyle','randommeteor@live.ca',NULL),(5,'Jason','Jason','randommeteor@live.ca',NULL),(6,'Mike','Mike','randommeteor@live.ca',NULL);
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

-- Dump completed on 2012-04-10 11:51:04

-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: servlet_ipldb
-- ------------------------------------------------------
-- Server version	8.0.41

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

--
-- Table structure for table `ipl`
--

DROP TABLE IF EXISTS `ipl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ipl` (
  `PlayerId` int NOT NULL,
  `PlayerName` varchar(45) NOT NULL,
  `PlayerAge` varchar(45) NOT NULL,
  `PlayerNationality` varchar(45) NOT NULL,
  `PlayerIplTeam` varchar(45) NOT NULL,
  `PlayerSalary` int NOT NULL,
  PRIMARY KEY (`PlayerId`),
  UNIQUE KEY `PlayerId_UNIQUE` (`PlayerId`),
  KEY `country_idx` (`PlayerNationality`),
  KEY `TeamName_idx` (`PlayerIplTeam`),
  CONSTRAINT `country` FOREIGN KEY (`PlayerNationality`) REFERENCES `ipl_nationalties` (`country`),
  CONSTRAINT `TeamName` FOREIGN KEY (`PlayerIplTeam`) REFERENCES `ipl_team` (`TeamName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ipl`
--

LOCK TABLES `ipl` WRITE;
/*!40000 ALTER TABLE `ipl` DISABLE KEYS */;
INSERT INTO `ipl` VALUES (101,'Mahendra Singh Dhoni','45','India','Chennai Super Kings',54000000),(102,'Virat kohli','34','India','Royal Challangers Bangaluru',2300000),(103,'Rohit Sharma','38','India','Mumbai Indians',3600000),(104,'Surya kumar yavdav','28','India','Mumbai Indians',23000000),(109,'Rachindra','23','India','Chennai Super Kings',2300000),(110,'Bhumra','29','India','Mumbai Indians',29000000),(112,'sanju samson','23','India','Rajasthan Royals',1232000),(234,'swrw','13','India','Gujarat Titans',324);
/*!40000 ALTER TABLE `ipl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ipl_nationalties`
--

DROP TABLE IF EXISTS `ipl_nationalties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ipl_nationalties` (
  `country` varchar(45) NOT NULL,
  PRIMARY KEY (`country`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ipl_nationalties`
--

LOCK TABLES `ipl_nationalties` WRITE;
/*!40000 ALTER TABLE `ipl_nationalties` DISABLE KEYS */;
INSERT INTO `ipl_nationalties` VALUES ('Afghanistan'),('Argentina'),('Austrailia'),('India'),('ireland'),('New zealand'),('Scotland'),('south africa'),('sri lanka'),('UK'),('USA'),('West indies'),('Zimbabwe');
/*!40000 ALTER TABLE `ipl_nationalties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ipl_team`
--

DROP TABLE IF EXISTS `ipl_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ipl_team` (
  `TeamName` varchar(45) NOT NULL,
  PRIMARY KEY (`TeamName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ipl_team`
--

LOCK TABLES `ipl_team` WRITE;
/*!40000 ALTER TABLE `ipl_team` DISABLE KEYS */;
INSERT INTO `ipl_team` VALUES ('Chennai Super Kings'),('Dheli Capitals'),('Gujarat Titans'),('Kolakata Knight Riders'),('Luknows Super Giants'),('Mumbai Indians'),('Panjab Kings'),('Rajasthan Royals'),('Royal Challangers Bangaluru'),('Sun Rises Hydrabad');
/*!40000 ALTER TABLE `ipl_team` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-20 12:27:30

CREATE DATABASE  IF NOT EXISTS `tpajedrez` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tpajedrez`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win32 (x86)
--
-- Host: localhost    Database: tpajedrez
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `fichas`
--

DROP TABLE IF EXISTS `fichas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fichas` (
  `nropartida` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `nombre` varchar(4) NOT NULL,
  `posx` int(11) NOT NULL,
  `posy` int(11) NOT NULL,
  `estado` tinyint(3) NOT NULL,
  PRIMARY KEY (`nropartida`,`dni`,`nombre`),
  KEY `dni_fichas_fk_idx` (`dni`),
  CONSTRAINT `dni_fichas_fk` FOREIGN KEY (`dni`) REFERENCES `jugadores` (`dni`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `nropartida_fichas_fk` FOREIGN KEY (`nropartida`) REFERENCES `partidas` (`nropartida`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fichas`
--

LOCK TABLES `fichas` WRITE;
/*!40000 ALTER TABLE `fichas` DISABLE KEYS */;
INSERT INTO `fichas` VALUES (12,1,'a1',3,8,1),(12,1,'a2',6,8,1),(12,1,'c1',2,8,1),(12,1,'c2',7,8,1),(12,1,'p1',1,7,1),(12,1,'p2',2,7,1),(12,1,'p3',3,7,1),(12,1,'p4',4,7,1),(12,1,'p5',5,7,1),(12,1,'p6',6,7,1),(12,1,'p7',7,7,1),(12,1,'p8',8,7,1),(12,1,'q',5,8,1),(12,1,'r',4,8,1),(12,1,'t1',1,8,1),(12,1,'t2',8,8,1),(12,1234,'a1',3,1,1),(12,1234,'a2',6,1,1),(12,1234,'c1',2,1,1),(12,1234,'c2',7,1,1),(12,1234,'p1',1,2,1),(12,1234,'p2',2,2,1),(12,1234,'p3',3,2,1),(12,1234,'p4',4,2,1),(12,1234,'p5',5,2,1),(12,1234,'p6',6,2,1),(12,1234,'p7',7,2,1),(12,1234,'p8',8,2,1),(12,1234,'q',4,1,1),(12,1234,'r',5,1,1),(12,1234,'t1',1,1,1),(12,1234,'t2',8,1,1),(16,1,'a1',3,1,1),(16,1,'a2',6,1,1),(16,1,'c1',2,1,1),(16,1,'c2',7,1,1),(16,1,'p1',1,2,1),(16,1,'p2',2,2,1),(16,1,'p3',3,2,1),(16,1,'p4',4,2,1),(16,1,'p5',5,2,1),(16,1,'p6',6,2,1),(16,1,'p7',7,2,1),(16,1,'p8',8,2,1),(16,1,'q',4,1,1),(16,1,'r',5,1,1),(16,1,'t1',1,1,1),(16,1,'t2',8,1,1),(16,1234,'a1',3,8,1),(16,1234,'a2',6,8,1),(16,1234,'c1',2,8,1),(16,1234,'c2',7,8,1),(16,1234,'p1',1,7,1),(16,1234,'p2',2,7,1),(16,1234,'p3',3,7,1),(16,1234,'p4',4,7,1),(16,1234,'p5',5,7,1),(16,1234,'p6',6,7,1),(16,1234,'p7',7,7,1),(16,1234,'p8',8,7,1),(16,1234,'q',5,8,1),(16,1234,'r',4,8,1),(16,1234,'t1',1,8,1),(16,1234,'t2',8,8,1);
/*!40000 ALTER TABLE `fichas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jugadores` (
  `dni` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  PRIMARY KEY (`dni`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores`
--

LOCK TABLES `jugadores` WRITE;
/*!40000 ALTER TABLE `jugadores` DISABLE KEYS */;
INSERT INTO `jugadores` VALUES (1,'rodri','asdas'),(1234,'q','qwe'),(3456,'asd','wer'),(36888066,'Samuel','Mariscal'),(37153778,'Rodrigo','Cibils');
/*!40000 ALTER TABLE `jugadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partidas`
--

DROP TABLE IF EXISTS `partidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partidas` (
  `nropartida` int(11) NOT NULL AUTO_INCREMENT,
  `dni1` int(11) NOT NULL,
  `dni2` int(11) NOT NULL,
  `turno` tinyint(1) NOT NULL,
  PRIMARY KEY (`nropartida`),
  UNIQUE KEY `nropartida_UNIQUE` (`nropartida`),
  KEY `dni1_partidas_fk_idx` (`dni1`),
  KEY `dni2_partidas_fk_idx` (`dni2`),
  CONSTRAINT `dni1_partidas_fk` FOREIGN KEY (`dni1`) REFERENCES `jugadores` (`dni`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `dni2_partidas_fk` FOREIGN KEY (`dni2`) REFERENCES `jugadores` (`dni`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partidas`
--

LOCK TABLES `partidas` WRITE;
/*!40000 ALTER TABLE `partidas` DISABLE KEYS */;
INSERT INTO `partidas` VALUES (12,1234,1,1),(16,1,1234,1);
/*!40000 ALTER TABLE `partidas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-09 19:48:54

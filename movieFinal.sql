-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: moviefinal
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `cinema`
--

DROP TABLE IF EXISTS `cinema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cinema` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(100) NOT NULL,
  `cinema_name` varchar(100) NOT NULL,
  `city` varchar(50) NOT NULL,
  `phone_number` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinema`
--

LOCK TABLES `cinema` WRITE;
/*!40000 ALTER TABLE `cinema` DISABLE KEYS */;
INSERT INTO `cinema` VALUES (1,'23 Tạ Quang Bửu','CGV','Hà Nội',123456789),(2,'69 Trần Duy Hưng','Galaxy','Hà Nội',56782319),(3,'57 Thái Hà','Quốc gia','Hà Nội',921278642);
/*!40000 ALTER TABLE `cinema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cast` varchar(50) NOT NULL,
  `content` varchar(500) NOT NULL,
  `director` varchar(50) NOT NULL,
  `duaration` int NOT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `image_src` varchar(200) DEFAULT NULL,
  `release_date` varchar(255) NOT NULL,
  `title` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Ma Dong-seok,Lee Hee-jun,Roh Jeong-eui','Sau một trận động đất chết người biến Seoul thành vùng đất hoang vô luật pháp, một thợ săn dũng cảm lao vào hành động để giải cứu một thiếu niên bị bác sĩ điên bắt cóc.','Heo Myeong-haeng',109,'Hành động ,  Khoa học viễn tưởng','https://media.themoviedb.org/t/p/original/zVMyvNowgbsBAL6O6esWfRpAcOb.jpg','26/1/2024','Badland Hunters'),(2,'Alan Tudyk,Chris Pine','Asha, một người theo chủ nghĩa lý tưởng sắc bén, đã thực hiện một điều ước mạnh mẽ đến mức nó được đáp lại bởi một thế lực vũ trụ - một quả cầu nhỏ chứa năng lượng vô biên gọi là Ngôi sao.','Chris Buck',105,'Hoạt hình ,  Gia đình ,  Giả tưởng ,  Phiêu lưu','https://media.themoviedb.org/t/p/original/AcoVfiv1rrWOmAdpnAMnM56ki19.jpg','22/11/2023','Wish '),(3,'Jason Momoa,Patrick Wilson,Amber Heard,..','Black Manta, vẫn bị thúc đẩy bởi nhu cầu trả thù cho cái chết của cha mình và nắm giữ sức mạnh của Cây đinh ba đen huyền thoại, sẽ không dừng lại ở việc hạ gục Aquaman một lần và mãi mãi.','James Wan',124,'Hành động ,  Phiêu lưu ,  Giả tưởng','https://media.themoviedb.org/t/p/original/7lTnXOy0iNtBAdRP3TZvaKJ77F6.jpg','22/12/2023','Aquaman and the Lost Kingdom'),(4,'Timothée Chalamet, Calah Lane, ...','Willy Wonka – tràn đầy ý tưởng và quyết tâm thay đổi thế giới từng miếng ngon lành – là bằng chứng cho thấy những điều tốt đẹp nhất trong cuộc sống đều bắt đầu từ một giấc mơ.','Paul King',117,'Hài kịch ,  Gia đình ,  Giả tưởng','https://media.themoviedb.org/t/p/original/qhb1qOilapbapxWQn9jtRCMwXJF.jpg','08/12/2023','Wonka'),(5,'Austin Butler, Anthony Boyle,Callum Turner,...','Trong Thế chiến thứ hai, các phi công liều mạng với Nhóm ném bom thứ 100, một tình anh em được rèn giũa bởi lòng dũng cảm, sự mất mát và chiến thắng.','John Orleansoff',123,'Chiến tranh & Chính trị ,  Kịch','https://media.themoviedb.org/t/p/original/rSAmgcoA74371rplbqM27yVsd3y.jpg','6/2/2024','Masters of the Air'),(6,'Jason Statham, Emmy Raver-Lampman','Jason Statham vào vai Adam Clay, một người nuôi ong cần mẫn và đơn độc. Anh có mối quan hệ tốt với bà chủ nhà, thậm chí coi bà như người thân duy nhất của mình. Thế nhưng, một sự kiện xảy ra khiến bà qua đời, và “người nuôi ong” Adam Clay quyết định bắt đầu kế hoạch trả thù tàn bạo của mình. Trong khi Clay vạch trần bí mật đằng sau đường dây lừa đảo cỡ lớn và bắt những kẻ có tội phải trả giá, thân phận thật của anh cũng dần được hé lộ.','David Ayer',105,'Hành động, Gay cấn','https://image.tmdb.org/t/p/w600_and_h900_bestv2/t49Kka8IDIxuweOLdPDDtYreavW.jpg','12/01/2024','Mật Vụ Ong');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  `id` int NOT NULL AUTO_INCREMENT,
  `showtime` varchar(30) NOT NULL,
  `cinema_id` int NOT NULL,
  `movie_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKuk1m56gbrdyomvctf1teeefe` (`cinema_id`),
  KEY `FKa6hosaihwhtb3scvamdyh9mlv` (`movie_id`),
  CONSTRAINT `FKa6hosaihwhtb3scvamdyh9mlv` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`),
  CONSTRAINT `FKuk1m56gbrdyomvctf1teeefe` FOREIGN KEY (`cinema_id`) REFERENCES `cinema` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'10:00',1,1),(2,'13:00',2,2),(3,'10:00',3,1),(4,'13:00',1,3),(5,'10:00',2,4),(6,'13:00',3,5),(7,'10:00',1,5),(8,'13:00',3,2),(9,'10:00',2,1),(10,'13:00',3,3),(11,'10:00',3,5),(12,'13:00',2,6);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id` int NOT NULL AUTO_INCREMENT,
  `price` varchar(200) DEFAULT NULL,
  `seat_number` varchar(100) NOT NULL,
  `status` bit(1) NOT NULL,
  `schedule_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_jccoc7noiiqqdxqptqdh76iox` (`seat_number`),
  KEY `FKdmmaqgvu0kjjlpsivmgnvurl5` (`schedule_id`),
  KEY `FKntdk71xc348htxtr66qu07goi` (`user_id`),
  CONSTRAINT `FKdmmaqgvu0kjjlpsivmgnvurl5` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`),
  CONSTRAINT `FKntdk71xc348htxtr66qu07goi` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,'90000','47',_binary '\0',3,1),(2,'90000','46',_binary '\0',3,1),(3,'90000','36',_binary '\0',3,1),(4,'90000','35',_binary '\0',3,1),(5,'90000','37',_binary '\0',3,1),(6,'80000','57',_binary '\0',2,1),(7,'80000','16',_binary '\0',4,2),(8,'90000','48',_binary '\0',5,4),(9,'80000','66',_binary '\0',5,3);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `token` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8odbn1rg5f6ing2hf4k7d6k4s` (`user_id`),
  CONSTRAINT `FK8odbn1rg5f6ing2hf4k7d6k4s` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,'2024-01-31 09:43:12.673000','anonymousUser',NULL,NULL,'5f7e0b3b-68b3-4a72-a065-86d675543449',3),(2,'2024-01-31 10:17:46.632000','anonymousUser',NULL,NULL,'2c3857df-c660-4d0b-8321-238e091d4301',4);
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `date_of_birth` datetime(6) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `full_name` varchar(100) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `phone_number` varchar(12) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_4bgmpi98dylab6qdvf9xyaxu4` (`phone_number`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,NULL,NULL,NULL,'BN',NULL,'admin@gmail.com','admin','$2a$12$nuS7FBMSpjG6ouZukabHCeKEBZZVVi/ehkw9aj1q5GCAFKPJH5RBe','123456','ADMIN','admin'),(2,NULL,NULL,NULL,NULL,'BN',NULL,'user@gmail.com','user','$2a$12$nuS7FBMSpjG6ouZukabHCeKEBZZVVi/ehkw9aj1q5GCAFKPJH5RBe','112233','USER','user'),(3,'2024-01-31 09:43:12.641000','anonymousUser',NULL,NULL,'BN',NULL,'HaNN@gmail.com','HA','$2a$10$Tz.hIpOY4.Lb4ETQj3VHk.Kccs.HaOQixOnzFt2P6wFt.n5u5t2Gi','12321121','USER','HA'),(4,'2024-01-31 10:17:46.598000','anonymousUser',NULL,NULL,'BN',NULL,'quyen@gmail.com','Quyen','$2a$10$d3QagXS1q8qmC4IMWcdYxu36v9WJtnjt/pMCR2xsDd8ptZNHI6DHO','1234566','USER','Quyen'),(5,NULL,NULL,NULL,NULL,'BN',NULL,'Quang@gmail.com','Quang','$2a$10$d3QagXS1q8qmC4IMWcdYxu36v9WJtnjt/pMCR2xsDd8ptZNHI6DHO','3216554','USER','Quang');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-01 16:17:43

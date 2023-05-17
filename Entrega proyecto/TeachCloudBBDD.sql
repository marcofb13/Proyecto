-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.33 - MySQL Community Server - GPL
-- SO del servidor:              Linux
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para teach-cloud
CREATE DATABASE IF NOT EXISTS `teach-cloud` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `teach-cloud`;

-- Volcando estructura para tabla teach-cloud.adds
CREATE TABLE IF NOT EXISTS `adds` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `province_id` int NOT NULL,
  `town_id` int NOT NULL,
  `subject_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `province_id` (`province_id`),
  KEY `town_id` (`town_id`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `adds_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `adds_ibfk_2` FOREIGN KEY (`province_id`) REFERENCES `provinces` (`id`),
  CONSTRAINT `adds_ibfk_3` FOREIGN KEY (`town_id`) REFERENCES `towns` (`id`),
  CONSTRAINT `adds_ibfk_4` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla teach-cloud.adds: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `adds` DISABLE KEYS */;
INSERT INTO `adds` (`id`, `description`, `province_id`, `town_id`, `subject_id`, `user_id`) VALUES
	(1, 'Anuncio de profesor de matemáticas con experiencia ', 1, 1, 1, 3),
	(2, 'Anuncio de profesor de física con experiencia ', 1, 1, 3, 3),
	(3, 'busco profesor de matemáticas ', 1, 1, 1, 4),
	(4, 'busco profesor de física ', 1, 1, 3, 4),
	(5, 'profesor de lengua castellana ', 2, 4, 2, 12);
/*!40000 ALTER TABLE `adds` ENABLE KEYS */;

-- Volcando estructura para tabla teach-cloud.provinces
CREATE TABLE IF NOT EXISTS `provinces` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla teach-cloud.provinces: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `provinces` DISABLE KEYS */;
INSERT INTO `provinces` (`id`, `name`) VALUES
	(1, 'Asturias'),
	(2, 'Madrid'),
	(3, 'Barcelona'),
	(4, 'Cantabria'),
	(5, 'A Coruña'),
	(6, 'Málaga'),
	(7, 'León'),
	(8, 'Cádiz'),
	(9, 'Valencia');
/*!40000 ALTER TABLE `provinces` ENABLE KEYS */;

-- Volcando estructura para tabla teach-cloud.subjects
CREATE TABLE IF NOT EXISTS `subjects` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla teach-cloud.subjects: ~12 rows (aproximadamente)
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` (`id`, `name`) VALUES
	(1, 'Matematicas'),
	(2, 'Lengua castellana'),
	(3, 'Física'),
	(4, 'Química'),
	(5, 'Inglés'),
	(6, 'Dibujo técnico'),
	(7, 'Filosofía'),
	(8, 'Historia de España'),
	(9, 'Biología'),
	(10, 'Economía de empresa'),
	(11, 'Historia del arte'),
	(12, 'Latín');
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;

-- Volcando estructura para tabla teach-cloud.towns
CREATE TABLE IF NOT EXISTS `towns` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `province_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `province_id` (`province_id`),
  CONSTRAINT `towns_ibfk_1` FOREIGN KEY (`province_id`) REFERENCES `provinces` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla teach-cloud.towns: ~30 rows (aproximadamente)
/*!40000 ALTER TABLE `towns` DISABLE KEYS */;
INSERT INTO `towns` (`id`, `name`, `province_id`) VALUES
	(1, 'Oviedo', 1),
	(2, 'Gijón', 1),
	(3, 'Avilés', 1),
	(4, 'Madrid', 2),
	(5, 'Alcorcón', 2),
	(6, 'Aranjuéz', 2),
	(7, 'Móstoles', 2),
	(8, 'Barcelona', 3),
	(9, 'Badalona', 3),
	(10, 'Viladecans', 3),
	(11, 'Santander', 4),
	(12, 'Laredo', 4),
	(13, 'Torrelavega', 4),
	(14, 'Sada', 5),
	(15, 'Lorbé', 5),
	(16, 'Arteixo', 5),
	(17, 'Coruña', 5),
	(18, 'Marbella', 6),
	(19, 'Torremolinos', 6),
	(20, 'Fuengirola', 6),
	(21, 'Cuidad de Málaga', 6),
	(22, 'León', 7),
	(23, 'Ponferrada', 7),
	(24, 'Villaquilambre', 7),
	(25, 'Algeciras', 8),
	(26, 'Cádiz', 8),
	(27, 'San Fernando', 8),
	(28, 'Valencia', 9),
	(29, 'Torrente', 9),
	(30, 'Paterna', 9);
/*!40000 ALTER TABLE `towns` ENABLE KEYS */;

-- Volcando estructura para tabla teach-cloud.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla teach-cloud.users: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `name`, `email`, `pwd`, `phone`) VALUES
	(3, 'prueba', 'prueba@mail.com', '$2a$10$xxHhebH2YZwjlA55xDJfm.ncDOZo/hPEtlcQrzopCzsToSErpIOs6', '665321222'),
	(4, 'Prueba 2', 'prueba2@mail.com', '$2a$10$xltcsATJLE.eZ8TsbSuasemIRtx86TPWQwOpjV02DnMrnAAp6oDZ.', '123456789'),
	(12, 'Demostracion ', 'demo@gmail.com', '$2a$10$9XlH6AdVDhAr84NUu.ng9eeU6MKEO.M.Nz5feN5XKJ1cofip2L9VS', '654989898');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

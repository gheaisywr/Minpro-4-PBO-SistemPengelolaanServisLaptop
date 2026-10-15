-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 15, 2026 at 03:54 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_servis_laptop`
--

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` varchar(10) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `no_telepon` varchar(15) NOT NULL,
  `alamat` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama`, `no_telepon`, `alamat`) VALUES
('P001', 'James Chao', '081234567890', 'Samarinda'),
('P002', 'Andi Pratama', '082345678901', 'Balikpapan'),
('P003', 'Ghea', '0895704176685', 'Jl. Pramuka');

-- --------------------------------------------------------

--
-- Table structure for table `perangkat`
--

CREATE TABLE `perangkat` (
  `id_perangkat` varchar(10) NOT NULL,
  `jenis_perangkat` varchar(20) NOT NULL,
  `merk` varchar(50) NOT NULL,
  `tipe` varchar(100) NOT NULL,
  `kerusakan` varchar(200) NOT NULL,
  `ukuran_layar` varchar(30) DEFAULT NULL,
  `jenis_casing` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `perangkat`
--

INSERT INTO `perangkat` (`id_perangkat`, `jenis_perangkat`, `merk`, `tipe`, `kerusakan`, `ukuran_layar`, `jenis_casing`) VALUES
('K001', 'Komputer', 'Lenovo', 'ThinkCentre', 'Komputer tidak dapat menyala', NULL, 'Tower'),
('L001', 'Laptop', 'ASUS', 'VivoBook 14', 'Keyboard beberapa tombol tidak berfungsi', '14 inci', NULL),
('L002', 'Laptop', 'LENOVO', 'ThinkPad', 'Overheating', '14 inci', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `servis`
--

CREATE TABLE `servis` (
  `id_servis` varchar(10) NOT NULL,
  `tanggal` date NOT NULL,
  `status` enum('menunggu','diproses','selesai') NOT NULL,
  `biaya` int NOT NULL,
  `id_pelanggan` varchar(10) NOT NULL,
  `id_perangkat` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `servis`
--

INSERT INTO `servis` (`id_servis`, `tanggal`, `status`, `biaya`, `id_pelanggan`, `id_perangkat`) VALUES
('S001', '2026-09-09', 'diproses', 250000, 'P001', 'L001'),
('S002', '2026-09-10', 'menunggu', 150000, 'P002', 'K001');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `perangkat`
--
ALTER TABLE `perangkat`
  ADD PRIMARY KEY (`id_perangkat`);

--
-- Indexes for table `servis`
--
ALTER TABLE `servis`
  ADD PRIMARY KEY (`id_servis`),
  ADD KEY `id_pelanggan` (`id_pelanggan`),
  ADD KEY `id_perangkat` (`id_perangkat`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `servis`
--
ALTER TABLE `servis`
  ADD CONSTRAINT `servis_ibfk_1` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`),
  ADD CONSTRAINT `servis_ibfk_2` FOREIGN KEY (`id_perangkat`) REFERENCES `perangkat` (`id_perangkat`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

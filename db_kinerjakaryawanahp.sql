-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 16, 2017 at 10:18 AM
-- Server version: 5.7.18-0ubuntu0.17.04.1
-- PHP Version: 7.0.18-0ubuntu0.17.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_kinerjakaryawanahp`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_bobotkaryawan`
--

CREATE TABLE `tbl_bobotkaryawan` (
  `id_karyawan` varchar(6) NOT NULL,
  `id_kriteria` int(11) NOT NULL,
  `id_subkriteria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_bobotkaryawan`
--

INSERT INTO `tbl_bobotkaryawan` (`id_karyawan`, `id_kriteria`, `id_subkriteria`) VALUES
('K10001', 3, 6),
('K10001', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_bobotkriteria`
--

CREATE TABLE `tbl_bobotkriteria` (
  `id_kriteria1` int(11) NOT NULL,
  `id_kriteria2` int(11) NOT NULL,
  `bobot_kriteria` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_bobotkriteria`
--

INSERT INTO `tbl_bobotkriteria` (`id_kriteria1`, `id_kriteria2`, `bobot_kriteria`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_bobotsubkriteria`
--

CREATE TABLE `tbl_bobotsubkriteria` (
  `id_subkriteria1` int(11) NOT NULL,
  `id_subkriteria2` int(11) NOT NULL,
  `id_kriteria` int(11) NOT NULL,
  `bobot_subkriteria` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_bobotsubkriteria`
--

INSERT INTO `tbl_bobotsubkriteria` (`id_subkriteria1`, `id_subkriteria2`, `id_kriteria`, `bobot_subkriteria`) VALUES
(1, 1, 1, 1),
(1, 2, 1, 3),
(2, 1, 1, 0.3333333333333333),
(1, 3, 1, 3),
(3, 1, 1, 0.3333333333333333);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_karyawan`
--

CREATE TABLE `tbl_karyawan` (
  `id_karyawan` varchar(6) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `kelamin` tinyint(1) DEFAULT '1',
  `agama` tinyint(1) DEFAULT '1',
  `tempat` varchar(10) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `alamat` text,
  `no_telp` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_karyawan`
--

INSERT INTO `tbl_karyawan` (`id_karyawan`, `nama`, `kelamin`, `agama`, `tempat`, `tgl_lahir`, `alamat`, `no_telp`) VALUES
('K10001', 'M. Tahir', 1, 1, 'Banda', '1991-09-18', 'Kukusan, Depok', '081807946651'),
('K10002', 'Aqilah F. Nisa', 2, 1, 'Watampone', '2012-01-06', 'Kukusan, Depok', '082337116611'),
('K10003', 'Adiba N. Husna', 2, 1, 'Makassar', '2015-04-16', 'Kukusan, Depok', '082337116611'),
('K10004', 'Ria Anggriani', 2, 1, 'Makassar', '1991-08-18', 'Kukusan, Depok', '082326116611');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_kriteria`
--

CREATE TABLE `tbl_kriteria` (
  `id_kriteria` int(11) NOT NULL,
  `nama_kriteria` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_kriteria`
--

INSERT INTO `tbl_kriteria` (`id_kriteria`, `nama_kriteria`) VALUES
(1, 'Disiplin'),
(3, 'Kehadiran'),
(4, 'Komunikasi');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_subkriteria`
--

CREATE TABLE `tbl_subkriteria` (
  `id_subkriteria` int(11) NOT NULL,
  `nama_subkriteria` varchar(15) NOT NULL,
  `id_kriteria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_subkriteria`
--

INSERT INTO `tbl_subkriteria` (`id_subkriteria`, `nama_subkriteria`, `id_kriteria`) VALUES
(1, 'Sangat Baik', 1),
(2, 'Baik', 1),
(3, 'Cukup', 1),
(4, 'Kurang', 1),
(5, 'Sangat Kurang', 1),
(6, 'Sangat Baik', 3),
(8, 'Baik', 3);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_karyawan`
--
ALTER TABLE `tbl_karyawan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- Indexes for table `tbl_kriteria`
--
ALTER TABLE `tbl_kriteria`
  ADD PRIMARY KEY (`id_kriteria`);

--
-- Indexes for table `tbl_subkriteria`
--
ALTER TABLE `tbl_subkriteria`
  ADD PRIMARY KEY (`id_subkriteria`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_kriteria`
--
ALTER TABLE `tbl_kriteria`
  MODIFY `id_kriteria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_subkriteria`
--
ALTER TABLE `tbl_subkriteria`
  MODIFY `id_subkriteria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

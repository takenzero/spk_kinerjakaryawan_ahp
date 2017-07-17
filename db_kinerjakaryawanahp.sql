-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 18, 2017 at 02:17 AM
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
('K10001', 1, 2),
('K10001', 4, 12),
('K10002', 3, 8),
('K10002', 1, 1),
('K10002', 4, 13),
('K10003', 1, 2),
('K10003', 3, 8),
('K10003', 4, 15),
('K10004', 1, 1),
('K10004', 3, 8),
('K10004', 4, 14);

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
(1, 1, 1),
(1, 4, 5),
(4, 1, 0.2),
(3, 3, 1),
(4, 4, 1),
(3, 1, 3),
(1, 3, 0.3333333333333333),
(4, 3, 3),
(3, 4, 0.3333333333333333);

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
(3, 1, 1, 0.3333333333333333),
(1, 5, 1, 7),
(5, 1, 1, 0.14285714285714285),
(2, 2, 1, 1),
(2, 3, 1, 3),
(3, 2, 1, 0.3333333333333333),
(1, 4, 1, 5),
(4, 1, 1, 0.2),
(2, 4, 1, 5),
(4, 2, 1, 0.2),
(2, 5, 1, 7),
(5, 2, 1, 0.14285714285714285),
(3, 3, 1, 1),
(3, 4, 1, 3),
(4, 3, 1, 0.3333333333333333),
(3, 5, 1, 5),
(5, 3, 1, 0.2),
(4, 4, 1, 1),
(4, 5, 1, 3),
(5, 4, 1, 0.3333333333333333),
(5, 5, 1, 1),
(6, 6, 3, 1),
(6, 8, 3, 3),
(8, 6, 3, 0.3333333333333333),
(6, 9, 3, 5),
(9, 6, 3, 0.2),
(6, 10, 3, 7),
(10, 6, 3, 0.14285714285714285),
(6, 11, 3, 9),
(11, 6, 3, 0.1111111111111111),
(8, 8, 3, 1),
(8, 9, 3, 3),
(9, 8, 3, 0.3333333333333333),
(8, 10, 3, 5),
(10, 8, 3, 0.2),
(8, 11, 3, 7),
(11, 8, 3, 0.14285714285714285),
(9, 9, 3, 1),
(9, 10, 3, 3),
(10, 9, 3, 0.3333333333333333),
(9, 11, 3, 5),
(11, 9, 3, 0.2),
(10, 10, 3, 1),
(10, 11, 3, 3),
(11, 10, 3, 0.3333333333333333),
(11, 11, 3, 1),
(12, 12, 4, 1),
(12, 13, 4, 3),
(13, 12, 4, 0.3333333333333333),
(12, 14, 4, 5),
(14, 12, 4, 0.2),
(12, 15, 4, 7),
(15, 12, 4, 0.14285714285714285),
(12, 16, 4, 7),
(16, 12, 4, 0.14285714285714285),
(13, 13, 4, 1),
(13, 14, 4, 3),
(14, 13, 4, 0.3333333333333333),
(13, 15, 4, 5),
(15, 13, 4, 0.2),
(13, 16, 4, 5),
(16, 13, 4, 0.2),
(14, 14, 4, 1),
(14, 15, 4, 3),
(15, 14, 4, 0.3333333333333333),
(14, 16, 4, 5),
(16, 14, 4, 0.2),
(15, 15, 4, 1),
(15, 16, 4, 3),
(16, 15, 4, 0.3333333333333333),
(16, 16, 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_hasil`
--

CREATE TABLE `tbl_hasil` (
  `id_karyawan` varchar(6) NOT NULL,
  `nilai` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_hasil`
--

INSERT INTO `tbl_hasil` (`id_karyawan`, `nilai`) VALUES
('K10001', 0.3837156271675627),
('K10002', 0.3158541784808046),
('K10003', 0.24274524740164743),
('K10004', 0.2904689671732248);

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
-- Table structure for table `tbl_nilaibobotkriteria`
--

CREATE TABLE `tbl_nilaibobotkriteria` (
  `id_kriteria` int(11) NOT NULL,
  `nilai` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_nilaibobotkriteria`
--

INSERT INTO `tbl_nilaibobotkriteria` (`id_kriteria`, `nilai`) VALUES
(1, 0.4260089686098654),
(3, 0.29147982062780264),
(4, 0.2825112107623318);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_nilaibobotsubkriteria`
--

CREATE TABLE `tbl_nilaibobotsubkriteria` (
  `id_subkriteria` int(11) NOT NULL,
  `id_kriteria` int(11) NOT NULL,
  `nilai` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_nilaibobotsubkriteria`
--

INSERT INTO `tbl_nilaibobotsubkriteria` (`id_subkriteria`, `id_kriteria`, `nilai`) VALUES
(1, 1, 0.3685571771660817),
(2, 1, 0.3168298540550527),
(3, 1, 0.18751154627748015),
(4, 1, 0.0918159985220765),
(5, 1, 0.035285423979309075),
(6, 3, 0.43607065728999395),
(8, 3, 0.28489949609612936),
(9, 3, 0.16628827731325102),
(10, 3, 0.08156597818262364),
(11, 3, 0.031175591118002107),
(12, 4, 0.43055803173471213),
(13, 4, 0.2683187733998931),
(14, 4, 0.17846318416830098),
(15, 4, 0.08753788554109469),
(16, 4, 0.035122125155999294);

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
(8, 'Baik', 3),
(9, 'Cukup', 3),
(10, 'Kurang', 3),
(11, 'Sangat Kurang', 3),
(12, 'Sangat Baik', 4),
(13, 'Baik', 4),
(14, 'Cukup', 4),
(15, 'Kurang', 4),
(16, 'Sangat Kurang', 4);

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

-- --------------------------------------------------------

--
-- Table structure for table `tbl_values`
--

CREATE TABLE `tbl_values` (
  `max_eigen_value` double NOT NULL,
  `inconsistency_index` double NOT NULL,
  `random_inconsistency` double NOT NULL,
  `inconsistency_ratio` double NOT NULL,
  `flag` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_values`
--

INSERT INTO `tbl_values` (`max_eigen_value`, `inconsistency_index`, `random_inconsistency`, `inconsistency_ratio`, `flag`, `id`) VALUES
(4.83803752625731, 0.9190187631286548, 0.58, 1.5845151088425085, 1, 0),
(5.286640083424384, 0.07166002085609602, 1.12, 0.06398216147865715, 2, 1),
(5.237475251487309, 0.05936881287182727, 1.12, 0.053007868635560056, 2, 3),
(5.3281218034055975, 0.08203045085139937, 1.12, 0.07324147397446372, 2, 4);

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
  MODIFY `id_subkriteria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

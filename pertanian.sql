-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 24 Nov 2017 pada 19.34
-- Versi Server: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pertanian`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_hasil`
--

CREATE TABLE `tb_hasil` (
  `Id_Hasil` int(11) NOT NULL,
  `Id_Kontrak` int(11) NOT NULL,
  `Nama_Petani` varchar(70) NOT NULL,
  `Luas` int(11) NOT NULL,
  `Hasil` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_hasil`
--

INSERT INTO `tb_hasil` (`Id_Hasil`, `Id_Kontrak`, `Nama_Petani`, `Luas`, `Hasil`) VALUES
(1, 1, 'Yunus', 40000, 4000),
(5, 4, 'Lahan Barat', 40000, 700),
(3, 7, 'Mei Za', 20000, 22224),
(4, 2, 'muhtar', 10000, 200),
(6, 4, 'Lahan Barat', 40000, 700),
(7, 4, 'Lahan Barat', 40000, 700),
(8, 4, 'Lahan Barat', 40000, 700),
(9, 4, 'Lahan Barat', 40000, 700),
(10, 4, 'Lahan Barat', 40000, 700),
(11, 4, 'Lahan Barat', 40000, 700),
(12, 4, 'Lahan Barat', 40000, 700),
(13, 4, 'Lahan Barat', 40000, 700),
(14, 4, 'Lahan Barat', 40000, 700),
(15, 4, 'Lahan Barat', 40000, 700),
(16, 4, 'Lahan Barat', 40000, 700),
(17, 4, 'Lahan Barat', 40000, 700),
(18, 4, 'Lahan Barat', 40000, 700),
(19, 11, 'Yunus', 10000, 100);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_kontrak`
--

CREATE TABLE `tb_kontrak` (
  `Id_Kontrak` int(11) NOT NULL,
  `Id_Petani` int(11) NOT NULL,
  `Nama_Petani` varchar(40) NOT NULL,
  `Id_Lahan` int(11) NOT NULL,
  `Nama_Lahan` varchar(40) NOT NULL,
  `Luas` double NOT NULL,
  `Pupuk` double NOT NULL,
  `Bibit` double NOT NULL,
  `Target` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_kontrak`
--

INSERT INTO `tb_kontrak` (`Id_Kontrak`, `Id_Petani`, `Nama_Petani`, `Id_Lahan`, `Nama_Lahan`, `Luas`, `Pupuk`, `Bibit`, `Target`) VALUES
(11, 1, 'Yunus', 0, 'Lahan Utara', 10000, 2850, 22.5, 20000),
(12, 2, 'muhtar', 5, 'Lahan Utara', 10000, 2850, 22.5, 20000),
(13, 7, 'Mei Za', 7, 'Lahan Bagus', 9200, 2622, 10.764, 15923);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_lahan`
--

CREATE TABLE `tb_lahan` (
  `Id_Lahan` int(11) NOT NULL,
  `Nama_Lahan` varchar(40) NOT NULL,
  `Luas` int(20) NOT NULL,
  `Alamat` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_lahan`
--

INSERT INTO `tb_lahan` (`Id_Lahan`, `Nama_Lahan`, `Luas`, `Alamat`) VALUES
(3, 'Lahan Timur', 20000, 'Jl. Sumatra'),
(4, 'Lahan Barat', 40000, 'Jl. Jawa'),
(5, 'Lahan Utara', 20000, 'Jl. Kalimantan'),
(6, 'Lahan Selatan', 7400, 'Jl. Mastrip'),
(7, 'Lahan Bagus', 9200, 'Jl. Kaliurang'),
(8, 'Lahan 2', 200000, 'JL. Suparman'),
(9, 'Lahan Besar', 70000, 'Jl. Panjaitan');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_petani`
--

CREATE TABLE `tb_petani` (
  `Id_Petani` int(11) NOT NULL,
  `Nama` varchar(40) NOT NULL,
  `TTL` varchar(70) NOT NULL,
  `Domisilin` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_petani`
--

INSERT INTO `tb_petani` (`Id_Petani`, `Nama`, `TTL`, `Domisilin`) VALUES
(1, 'Yunus', 'Jember, 20 Oktober 2009', 'Jember'),
(2, 'muhtar', 'jember', 'jember'),
(8, '', '', ''),
(4, 'Selly', 'Jakarta, 20 Juli 2007', 'Jember'),
(7, 'Mei Za', 'Jember', 'Jember');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_target`
--

CREATE TABLE `tb_target` (
  `Id_Target` int(11) NOT NULL,
  `Id_Kontrak` int(11) NOT NULL,
  `Nama_Petani` varchar(40) NOT NULL,
  `Nama_Lahan` int(11) NOT NULL,
  `Luas` int(11) NOT NULL,
  `Target` int(11) NOT NULL,
  `Id_Hasil` int(11) NOT NULL,
  `Hasil` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_user`
--

CREATE TABLE `tb_user` (
  `IdUser` int(11) NOT NULL,
  `Nama` varchar(40) NOT NULL,
  `UserName` varchar(40) NOT NULL,
  `Password` varchar(40) NOT NULL,
  `Status` varchar(40) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_user`
--

INSERT INTO `tb_user` (`IdUser`, `Nama`, `UserName`, `Password`, `Status`) VALUES
(1, 'Fiqri', 'fiqri', 'fiqri', 'Pengelolah'),
(2, 'selly', 'selly', 'selly', 'petani'),
(3, 'muhtar', 'muhtar', 'muhtar', 'pengelolah'),
(4, 'mei', 'mei', 'mei', 'Hasil'),
(5, 'Yunus', 'yunus', 'yunus', 'manager');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_hasil`
--
ALTER TABLE `tb_hasil`
  ADD PRIMARY KEY (`Id_Hasil`);

--
-- Indexes for table `tb_kontrak`
--
ALTER TABLE `tb_kontrak`
  ADD PRIMARY KEY (`Id_Kontrak`),
  ADD UNIQUE KEY `Id_Kontrak` (`Id_Kontrak`),
  ADD UNIQUE KEY `Id_Petani` (`Id_Petani`);

--
-- Indexes for table `tb_lahan`
--
ALTER TABLE `tb_lahan`
  ADD PRIMARY KEY (`Id_Lahan`);

--
-- Indexes for table `tb_petani`
--
ALTER TABLE `tb_petani`
  ADD PRIMARY KEY (`Id_Petani`);

--
-- Indexes for table `tb_target`
--
ALTER TABLE `tb_target`
  ADD PRIMARY KEY (`Id_Target`),
  ADD UNIQUE KEY `Id_Lahan` (`Id_Kontrak`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`IdUser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_hasil`
--
ALTER TABLE `tb_hasil`
  MODIFY `Id_Hasil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `tb_kontrak`
--
ALTER TABLE `tb_kontrak`
  MODIFY `Id_Kontrak` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `tb_lahan`
--
ALTER TABLE `tb_lahan`
  MODIFY `Id_Lahan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `tb_petani`
--
ALTER TABLE `tb_petani`
  MODIFY `Id_Petani` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `tb_target`
--
ALTER TABLE `tb_target`
  MODIFY `Id_Target` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `IdUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

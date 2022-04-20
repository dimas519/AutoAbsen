-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 19 Apr 2022 pada 16.10
-- Versi server: 10.4.21-MariaDB
-- Versi PHP: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+07:00";

--
-- Database: `jadwalkuliah`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `kuliah`
--

CREATE TABLE `kuliah` (
  `fkHari` int(11) NOT NULL,
  `Kuliah` varchar(20) NOT NULL,
  `Waktu` time NOT NULL,
  `role` bit(1) NOT NULL DEFAULT b'0' COMMENT '0 for student 1 for lecture'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kuliah`
--

INSERT INTO `kuliah` (`fkHari`, `Kuliah`, `Waktu`, `role`) VALUES
--TEMPLATE
--(1, 'Proyek Informatika', '10:00:00', b'0'),

COMMIT;


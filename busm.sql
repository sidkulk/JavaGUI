-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 02, 2019 at 05:48 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.1.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `busm`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_details`
--

CREATE TABLE `admin_details` (
  `id` int(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_details`
--

INSERT INTO `admin_details` (`id`, `name`, `username`, `password`) VALUES
(1, 'Endou Mamuru', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `bus_assign`
--

CREATE TABLE `bus_assign` (
  `aid` int(10) NOT NULL,
  `employee_no` varchar(100) NOT NULL,
  `bus_no` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bus_booking`
--

CREATE TABLE `bus_booking` (
  `booking_id` int(10) NOT NULL,
  `booking_user` varchar(100) NOT NULL,
  `journey_date` date NOT NULL,
  `bus_no` varchar(100) NOT NULL,
  `seat` varchar(100) NOT NULL,
  `id_no` varchar(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bus_details`
--

CREATE TABLE `bus_details` (
  `id` int(20) NOT NULL,
  `bus_no` varchar(100) NOT NULL,
  `movement` varchar(100) NOT NULL,
  `bus_source` varchar(100) NOT NULL,
  `bus_dest` varchar(100) NOT NULL,
  `depart_date` date NOT NULL,
  `depart_time` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL,
  `total_seat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bus_details`
--

INSERT INTO `bus_details` (`id`, `bus_no`, `movement`, `bus_source`, `bus_dest`, `depart_date`, `depart_time`, `price`, `total_seat`) VALUES
(19, 'MH 11 EX 1212', 'UP', 'Pune', 'Latur', '2019-10-04', '09:00', '1000', '60'),
(20, 'MH 22 XE 3222', 'UP', 'Pune', 'Amravati', '2019-10-04', '10:00', '1100', '50'),
(21, 'MH 33 TR 7333', 'UP', 'Pune', 'Yawatmal', '2019-10-04', '09:00', '1000', '50'),
(22, 'MH 04 ER 4444', 'UP', 'Pune', 'Nashik', '2019-10-04', '09:00', '1000', '50'),
(23, 'MH 05 RG 5555', 'UP', 'Pune', 'Delhi', '2019-10-04', '09:00', '3000', '50'),
(24, 'MH 06 HY 6666', 'UP', 'Pune', 'Gujrat', '2019-10-04', '09:00', '2000', '50'),
(25, 'MH 07 GH 0777', 'DOWN', 'Gujrat', 'Pune', '2019-10-04', '09:00', '2000', '50'),
(26, 'MH 08 JY 8888', 'DOWN', 'Delhi', 'Pune', '2019-10-04', '09:00', '3000', '50'),
(27, 'MH 09 UT 9999', 'DOWN', 'Nashik', 'Pune', '2019-10-04', '09:00', '1000', '50'),
(28, 'MH 10 AA 6767', 'DOWN', 'Latur', 'Pune', '2019-10-04', '09:00', '1000', '50'),
(29, 'MH 12 BB 9034', 'DOWN', 'Yawatmal', 'Pune', '2019-10-04', '09:00', '1000', '50'),
(30, 'MH 13 CC 7821', 'DOWN', 'Amravati', 'Pune', '2019-10-04', '09:00', '1000', '50'),
(31, 'MH 12 EE 6730', 'UP', 'Pune', 'Ahemdabad', '2019-10-04', '09:00', '2000', '50');

-- --------------------------------------------------------

--
-- Table structure for table `employee_details`
--

CREATE TABLE `employee_details` (
  `eid` int(10) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `phoneno1` varchar(100) NOT NULL,
  `phoneno2` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_details`
--

INSERT INTO `employee_details` (`eid`, `firstname`, `lastname`, `phoneno1`, `phoneno2`) VALUES
(4, 'Ganesh', 'Gaithonde', '7770098256', '7585234685'),
(5, 'Deepak', 'Shinde', '9875462112', '9875465212'),
(6, 'Aakash', 'Mane', '8875465215', '8754652132'),
(7, 'Saurabh', 'Ghewande', '7987987987', '9874654845');

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE `user_details` (
  `id` int(10) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email_id` varchar(100) NOT NULL,
  `mobile` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`id`, `firstname`, `lastname`, `username`, `password`, `email_id`, `mobile`) VALUES
(3, 'Saurabh', 'Padman', 'saurabhpadman', 'Saurabh@1999', 'saurabhpadman9@gmail.com', '7028743565'),
(4, 'Akash', 'Deshmukh', 'manistaRo', 'Akash@1999', 'manista.Ro@gmail.com', '7854651235'),
(5, 'Siddharth', 'Kulkarni', 'kulksud', 'MandirYahiBanega', 'kulksud@gmail.com', '8988545123'),
(6, 'Amey', 'Athavia', 'athavia.amey', 'Amey@1999', 'ameyathavia@gmail.com', '7895465123'),
(7, 'Vedant', 'Zilpilwar', 'VZraga', 'fairytale', 'vzraga@gmail.com', '8546578954'),
(8, 'Ritik', 'Varma', 'vr7Ritik', 'USAjaunga', 'vr7ritik@gmail.com', '7854587895');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_details`
--
ALTER TABLE `admin_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bus_assign`
--
ALTER TABLE `bus_assign`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `bus_booking`
--
ALTER TABLE `bus_booking`
  ADD PRIMARY KEY (`booking_id`);

--
-- Indexes for table `bus_details`
--
ALTER TABLE `bus_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee_details`
--
ALTER TABLE `employee_details`
  ADD PRIMARY KEY (`eid`);

--
-- Indexes for table `user_details`
--
ALTER TABLE `user_details`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin_details`
--
ALTER TABLE `admin_details`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `bus_assign`
--
ALTER TABLE `bus_assign`
  MODIFY `aid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `bus_booking`
--
ALTER TABLE `bus_booking`
  MODIFY `booking_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `bus_details`
--
ALTER TABLE `bus_details`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `employee_details`
--
ALTER TABLE `employee_details`
  MODIFY `eid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `user_details`
--
ALTER TABLE `user_details`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

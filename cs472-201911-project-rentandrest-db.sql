-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 24, 2019 at 05:07 PM
-- Server version: 5.7.21
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cs472-201911-project-rentandrest-db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL,
  `person_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `person_idx` (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `email`, `password`, `person_id`) VALUES
(2, 'shinobi.af@gmail.com', '$2a$07$M83W5s7MdN81fI5cw5Z3U.bilXUXwKIq9GqxGZY/xJtze5OskSJ8q', 1),
(3, 'ali@gmail.com', '$2a$07$xIQLNJgjKsDe.tpJQLI5TuzukfD5k/NPfgzvS5WV48.srtYSnBL0u', 2),
(4, 'alidk2013@gmail.com', '$2a$07$pTJTVvYpoZcIoRrrpUFTeegoVhC8p5poWQKGh1EWhgv.o8cifvch6', 3),
(5, 'aansari@mum.edu', '$2a$07$UpCUaYrNhEsjpF8Qz2.5ZeCFCq4fJYQ89Vm/zY.Cjwr2n5k/tKnj2', 2);

-- --------------------------------------------------------

--
-- Table structure for table `amenities`
--

DROP TABLE IF EXISTS `amenities`;
CREATE TABLE IF NOT EXISTS `amenities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(1024) COLLATE utf8mb4_unicode_ci NOT NULL,
  `referenceCost` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `amenities`
--

INSERT INTO `amenities` (`id`, `name`, `description`, `referenceCost`) VALUES
(1, 'Wifi', 'high speed internet access through our wireless network', '0.00'),
(2, 'Essentials', 'Towels, bed sheets, soap and toilet paper', '0.00'),
(3, 'Hot water', 'in the showers', '0.00'),
(4, 'Kitchen', 'Space where guests can cook their own meals (shared)', '0.00'),
(5, 'Hair Dryer', 'Can be borrowed when needed', '0.00'),
(6, 'Heating', 'Portable space heaters that can be rented for an additional cost', '3.00'),
(7, 'Laundry', 'Just put your clothes in a bag and we take care of that for you, it takes around one day', '3.00'),
(8, 'TV.', 'Local tv. no cable', '0.00');

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
CREATE TABLE IF NOT EXISTS `bookings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) NOT NULL,
  `guest_id` int(11) NOT NULL,
  `numberOfGuests` int(2) NOT NULL DEFAULT '1',
  `checkIn_date` date NOT NULL,
  `checkIn_time` time DEFAULT NULL,
  `checkOut_date` date NOT NULL,
  `checkOut_time` time DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `room_id_idx` (`room_id`),
  KEY `guest_id_idx` (`guest_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`id`, `room_id`, `guest_id`, `numberOfGuests`, `checkIn_date`, `checkIn_time`, `checkOut_date`, `checkOut_time`) VALUES
(5, 1, 3, 2, '2019-10-15', '10:45:00', '2019-10-20', '22:00:00'),
(6, 2, 4, 4, '2019-10-20', '10:10:00', '2019-10-25', '12:12:00'),
(7, 2, 4, 2, '2019-10-15', '12:00:00', '2019-12-02', '01:01:00'),
(8, 1, 4, 1, '2019-12-05', '10:30:00', '2019-12-15', '14:03:00'),
(10, 1, 4, 2, '2019-10-15', '23:11:00', '2019-12-02', '16:10:00'),
(11, 2, 4, 4, '2019-10-15', '22:00:00', '2019-12-15', '13:10:00'),
(13, 5, 4, 2, '2019-11-19', '13:59:00', '2019-11-25', '12:00:00'),
(14, 2, 3, 2, '2019-10-15', '01:00:00', '2019-12-02', '01:00:00'),
(15, 1, 3, 2, '2019-10-15', '01:59:00', '2019-10-25', '12:00:00'),
(16, 2, 4, 2, '2019-10-15', '01:59:00', '2019-10-25', '12:00:00'),
(17, 1, 3, 5, '2019-10-20', '19:59:00', '2019-10-22', '07:59:00'),
(18, 1, 3, 2, '2019-10-15', '00:58:00', '2019-10-25', '13:59:00'),
(19, 1, 3, 2, '2019-10-15', '00:58:00', '2019-10-25', '13:59:00'),
(20, 1, 3, 2, '2019-10-15', '00:58:00', '2019-10-25', '13:59:00'),
(21, 1, 3, 2, '2019-10-15', '00:58:00', '2019-10-25', '13:59:00'),
(22, 1, 3, 2, '2019-10-15', '01:00:00', '2019-12-15', '01:00:00'),
(23, 1, 3, 2, '2019-10-15', '01:00:00', '2019-11-02', '01:00:00'),
(24, 1, 3, 2, '2019-10-15', '01:00:00', '2019-12-15', '01:00:00'),
(25, 6, 4, 4, '2019-10-20', '01:00:00', '2019-12-02', '01:00:00'),
(26, 4, 3, 2, '2019-10-15', '12:59:00', '2019-12-15', '01:00:00'),
(27, 4, 3, 2, '2019-10-15', '12:59:00', '2019-12-15', '01:00:00'),
(28, 4, 3, 2, '2019-10-15', '12:59:00', '2019-12-15', '01:00:00'),
(29, 4, 3, 2, '2019-10-15', '12:59:00', '2019-12-15', '01:00:00'),
(30, 4, 3, 2, '2019-10-15', '12:59:00', '2019-12-15', '01:00:00'),
(31, 4, 3, 2, '2019-10-15', '12:59:00', '2019-12-15', '01:00:00'),
(32, 1, 3, 2, '2019-10-15', '12:59:00', '2019-10-25', '01:00:00'),
(33, 9, 4, 4, '2019-11-18', '01:00:00', '2019-11-24', '12:59:00'),
(34, 9, 4, 2, '2019-11-20', '01:00:00', '2019-11-27', '12:59:00'),
(35, 1, 3, 2, '2019-10-15', '13:59:00', '2019-12-02', '01:00:00'),
(37, 1, 3, 2, '2019-10-15', '12:59:00', '2019-12-15', '01:00:00'),
(38, 1, 3, 2, '2019-10-15', '01:00:00', '2019-12-12', '12:59:00'),
(39, 1, 3, 2, '2019-11-21', '05:00:00', '2019-11-25', '01:00:00'),
(40, 5, 7, 2, '2019-11-20', '22:50:00', '2019-11-28', '01:00:00'),
(41, 2, 7, 1, '2019-11-20', '03:00:00', '2019-11-25', '12:50:00'),
(42, 1, 7, 1, '2019-11-20', '01:00:00', '2019-11-25', '13:00:00'),
(43, 1, 4, 2, '2019-11-21', '12:59:00', '2019-11-24', '01:00:00'),
(44, 3, 3, 2, '2019-11-20', '01:00:00', '2019-11-24', '00:00:00'),
(45, 6, 4, 2, '2019-11-22', '01:00:00', '2019-11-24', '01:00:00'),
(46, 4, 7, 1, '2019-11-20', '01:00:00', '2019-12-22', '00:00:00'),
(47, 2, 4, 1, '2019-11-20', '01:00:00', '2019-11-22', '13:00:00'),
(48, 1, 3, 1, '2019-11-20', '01:00:00', '2019-11-25', '01:00:00'),
(49, 1, 7, 2, '2019-11-20', '12:59:00', '2019-11-22', '12:59:00'),
(50, 1, 4, 1, '2019-11-20', '12:59:00', '2019-11-25', '12:59:00'),
(51, 6, 3, 4, '2019-11-20', '12:59:00', '2019-11-25', '12:59:00'),
(52, 2, 7, 3, '2019-11-21', '01:00:00', '2019-11-23', '12:59:00'),
(53, 1, 3, 2, '2019-11-20', '01:00:00', '2019-11-25', '01:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
CREATE TABLE IF NOT EXISTS `countries` (
  `alpha3_code` varchar(3) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lang` varchar(3) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`alpha3_code`),
  KEY `language` (`lang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `countries`
--

INSERT INTO `countries` (`alpha3_code`, `name`, `lang`) VALUES
('ABW', 'Aruba', 'ENG'),
('AFG', 'Afghanistan', 'ENG'),
('AGO', 'Angola', 'ENG'),
('AIA', 'Anguilla', 'ENG'),
('ALA', 'Aland Islands', 'ENG'),
('ALB', 'Albania', 'ENG'),
('AND', 'Andorra', 'ENG'),
('ANT', 'Netherlands Antilles', 'ENG'),
('ARE', 'United Arab Emirates', 'ENG'),
('ARG', 'Argentina', 'ENG'),
('ARM', 'Armenia', 'ENG'),
('ASM', 'American Samoa', 'ENG'),
('ATA', 'Antarctica', 'ENG'),
('ATF', 'French Southern Territories', 'ENG'),
('ATG', 'Antigua and Barbuda', 'ENG'),
('AUS', 'Australia', 'ENG'),
('AUT', 'Austria', 'ENG'),
('AZE', 'Azerbaijan', 'ENG'),
('BDI', 'Burundi', 'ENG'),
('BEL', 'Belgium', 'ENG'),
('BEN', 'Benin', 'ENG'),
('BES', 'Bonaire, Saint Eustatius and Saba', 'ENG'),
('BFA', 'Burkina Faso', 'ENG'),
('BGD', 'Bangladesh', 'ENG'),
('BGR', 'Bulgaria', 'ENG'),
('BHR', 'Bahrain', 'ENG'),
('BHS', 'Bahamas', 'ENG'),
('BIH', 'Bosnia and Herzegovina', 'ENG'),
('BLM', 'Saint Barthelemy', 'ENG'),
('BLR', 'Belarus', 'ENG'),
('BLZ', 'Belize', 'ENG'),
('BMU', 'Bermuda', 'ENG'),
('BOL', 'Bolivia', 'ENG'),
('BRA', 'Brazil', 'ENG'),
('BRB', 'Barbados', 'ENG'),
('BRN', 'Brunei', 'ENG'),
('BTN', 'Bhutan', 'ENG'),
('BVT', 'Bouvet Island', 'ENG'),
('BWA', 'Botswana', 'ENG'),
('CAF', 'Central African Republic', 'ENG'),
('CAN', 'Canada', 'ENG'),
('CCK', 'Cocos Islands', 'ENG'),
('CHE', 'Switzerland', 'ENG'),
('CHL', 'Chile', 'ENG'),
('CHN', 'China', 'ENG'),
('CIV', 'Ivory Coast', 'ENG'),
('CMR', 'Cameroon', 'ENG'),
('COD', 'Democratic Republic of the Congo', 'ENG'),
('COG', 'Republic of the Congo', 'ENG'),
('COK', 'Cook Islands', 'ENG'),
('COL', 'Colombia', 'ENG'),
('COM', 'Comoros', 'ENG'),
('CPV', 'Cape Verde', 'ENG'),
('CRI', 'Costa Rica', 'ENG'),
('CUB', 'Cuba', 'ENG'),
('CUW', 'Curacao', 'ENG'),
('CXR', 'Christmas Island', 'ENG'),
('CYM', 'Cayman Islands', 'ENG'),
('CYP', 'Cyprus', 'ENG'),
('CZE', 'Czech Republic', 'ENG'),
('DEU', 'Germany', 'ENG'),
('DJI', 'Djibouti', 'ENG'),
('DMA', 'Dominica', 'ENG'),
('DNK', 'Denmark', 'ENG'),
('DOM', 'Dominican Republic', 'ENG'),
('DZA', 'Algeria', 'ENG'),
('ECU', 'Ecuador', 'ENG'),
('EGY', 'Egypt', 'ENG'),
('ERI', 'Eritrea', 'ENG'),
('ESH', 'Western Sahara', 'ENG'),
('ESP', 'Spain', 'ENG'),
('EST', 'Estonia', 'ENG'),
('ETH', 'Ethiopia', 'ENG'),
('FIN', 'Finland', 'ENG'),
('FJI', 'Fiji', 'ENG'),
('FLK', 'Falkland Islands', 'ENG'),
('FRA', 'France', 'ENG'),
('FRO', 'Faroe Islands', 'ENG'),
('FSM', 'Micronesia', 'ENG'),
('GAB', 'Gabon', 'ENG'),
('GBR', 'United Kingdom', 'ENG'),
('GEO', 'Georgia', 'ENG'),
('GGY', 'Guernsey', 'ENG'),
('GHA', 'Ghana', 'ENG'),
('GIB', 'Gibraltar', 'ENG'),
('GIN', 'Guinea', 'ENG'),
('GLP', 'Guadeloupe', 'ENG'),
('GMB', 'Gambia', 'ENG'),
('GNB', 'Guinea-Bissau', 'ENG'),
('GNQ', 'Equatorial Guinea', 'ENG'),
('GRC', 'Greece', 'ENG'),
('GRD', 'Grenada', 'ENG'),
('GRL', 'Greenland', 'ENG'),
('GTM', 'Guatemala', 'ENG'),
('GUF', 'French Guiana', 'ENG'),
('GUM', 'Guam', 'ENG'),
('GUY', 'Guyana', 'ENG'),
('HKG', 'Hong Kong', 'ENG'),
('HMD', 'Heard Island and McDonald Islands', 'ENG'),
('HND', 'Honduras', 'ENG'),
('HRV', 'Croatia', 'ENG'),
('HTI', 'Haiti', 'ENG'),
('HUN', 'Hungary', 'ENG'),
('IDN', 'Indonesia', 'ENG'),
('IMN', 'Isle of Man', 'ENG'),
('IND', 'India', 'ENG'),
('IOT', 'British Indian Ocean Territory', 'ENG'),
('IRL', 'Ireland', 'ENG'),
('IRN', 'Iran', 'ENG'),
('IRQ', 'Iraq', 'ENG'),
('ISL', 'Iceland', 'ENG'),
('ISR', 'Israel', 'ENG'),
('ITA', 'Italy', 'ENG'),
('JAM', 'Jamaica', 'ENG'),
('JEY', 'Jersey', 'ENG'),
('JOR', 'Jordan', 'ENG'),
('JPN', 'Japan', 'ENG'),
('KAZ', 'Kazakhstan', 'ENG'),
('KEN', 'Kenya', 'ENG'),
('KGZ', 'Kyrgyzstan', 'ENG'),
('KHM', 'Cambodia', 'ENG'),
('KIR', 'Kiribati', 'ENG'),
('KNA', 'Saint Kitts and Nevis', 'ENG'),
('KOR', 'South Korea', 'ENG'),
('KWT', 'Kuwait', 'ENG'),
('LAO', 'Laos', 'ENG'),
('LBN', 'Lebanon', 'ENG'),
('LBR', 'Liberia', 'ENG'),
('LBY', 'Libya', 'ENG'),
('LCA', 'Saint Lucia', 'ENG'),
('LIE', 'Liechtenstein', 'ENG'),
('LKA', 'Sri Lanka', 'ENG'),
('LSO', 'Lesotho', 'ENG'),
('LTU', 'Lithuania', 'ENG'),
('LUX', 'Luxembourg', 'ENG'),
('LVA', 'Latvia', 'ENG'),
('MAC', 'Macao', 'ENG'),
('MAF', 'Saint Martin', 'ENG'),
('MAR', 'Morocco', 'ENG'),
('MCO', 'Monaco', 'ENG'),
('MDA', 'Moldova', 'ENG'),
('MDG', 'Madagascar', 'ENG'),
('MDV', 'Maldives', 'ENG'),
('MEX', 'Mexico', 'ENG'),
('MHL', 'Marshall Islands', 'ENG'),
('MKD', 'Macedonia', 'ENG'),
('MLI', 'Mali', 'ENG'),
('MLT', 'Malta', 'ENG'),
('MMR', 'Myanmar', 'ENG'),
('MNE', 'Montenegro', 'ENG'),
('MNG', 'Mongolia', 'ENG'),
('MNP', 'Northern Mariana Islands', 'ENG'),
('MOZ', 'Mozambique', 'ENG'),
('MRT', 'Mauritania', 'ENG'),
('MSR', 'Montserrat', 'ENG'),
('MTQ', 'Martinique', 'ENG'),
('MUS', 'Mauritius', 'ENG'),
('MWI', 'Malawi', 'ENG'),
('MYS', 'Malaysia', 'ENG'),
('MYT', 'Mayotte', 'ENG'),
('NAM', 'Namibia', 'ENG'),
('NCL', 'New Caledonia', 'ENG'),
('NER', 'Niger', 'ENG'),
('NFK', 'Norfolk Island', 'ENG'),
('NGA', 'Nigeria', 'ENG'),
('NIC', 'Nicaragua', 'ENG'),
('NIU', 'Niue', 'ENG'),
('NLD', 'Netherlands', 'ENG'),
('NOR', 'Norway', 'ENG'),
('NPL', 'Nepal', 'ENG'),
('NRU', 'Nauru', 'ENG'),
('NZL', 'New Zealand', 'ENG'),
('OMN', 'Oman', 'ENG'),
('PAK', 'Pakistan', 'ENG'),
('PAN', 'Panama', 'ENG'),
('PCN', 'Pitcairn', 'ENG'),
('PER', 'Peru', 'ENG'),
('PHL', 'Philippines', 'ENG'),
('PLW', 'Palau', 'ENG'),
('PNG', 'Papua New Guinea', 'ENG'),
('POL', 'Poland', 'ENG'),
('PRI', 'Puerto Rico', 'ENG'),
('PRK', 'North Korea', 'ENG'),
('PRT', 'Portugal', 'ENG'),
('PRY', 'Paraguay', 'ENG'),
('PSE', 'Palestinian Territory', 'ENG'),
('PYF', 'French Polynesia', 'ENG'),
('QAT', 'Qatar', 'ENG'),
('REU', 'Reunion', 'ENG'),
('ROU', 'Romania', 'ENG'),
('RUS', 'Russia', 'ENG'),
('RWA', 'Rwanda', 'ENG'),
('SAU', 'Saudi Arabia', 'ENG'),
('SCG', 'Serbia and Montenegro', 'ENG'),
('SDN', 'Sudan', 'ENG'),
('SEN', 'Senegal', 'ENG'),
('SGP', 'Singapore', 'ENG'),
('SGS', 'South Georgia and the South Sandwich Islands', 'ENG'),
('SHN', 'Saint Helena', 'ENG'),
('SJM', 'Svalbard and Jan Mayen', 'ENG'),
('SLB', 'Solomon Islands', 'ENG'),
('SLE', 'Sierra Leone', 'ENG'),
('SLV', 'El Salvador', 'ENG'),
('SMR', 'San Marino', 'ENG'),
('SOM', 'Somalia', 'ENG'),
('SPM', 'Saint Pierre and Miquelon', 'ENG'),
('SRB', 'Serbia', 'ENG'),
('SSD', 'South Sudan', 'ENG'),
('STP', 'Sao Tome and Principe', 'ENG'),
('SUR', 'Suriname', 'ENG'),
('SVK', 'Slovakia', 'ENG'),
('SVN', 'Slovenia', 'ENG'),
('SWE', 'Sweden', 'ENG'),
('SWZ', 'Swaziland', 'ENG'),
('SXM', 'Sint Maarten', 'ENG'),
('SYC', 'Seychelles', 'ENG'),
('SYR', 'Syria', 'ENG'),
('TCA', 'Turks and Caicos Islands', 'ENG'),
('TCD', 'Chad', 'ENG'),
('TGO', 'Togo', 'ENG'),
('THA', 'Thailand', 'ENG'),
('TJK', 'Tajikistan', 'ENG'),
('TKL', 'Tokelau', 'ENG'),
('TKM', 'Turkmenistan', 'ENG'),
('TLS', 'East Timor', 'ENG'),
('TON', 'Tonga', 'ENG'),
('TTO', 'Trinidad and Tobago', 'ENG'),
('TUN', 'Tunisia', 'ENG'),
('TUR', 'Turkey', 'ENG'),
('TUV', 'Tuvalu', 'ENG'),
('TWN', 'Taiwan', 'ENG'),
('TZA', 'Tanzania', 'ENG'),
('UGA', 'Uganda', 'ENG'),
('UKR', 'Ukraine', 'ENG'),
('UMI', 'United States Minor Outlying Islands', 'ENG'),
('URY', 'Uruguay', 'ENG'),
('USA', 'United States', 'ENG'),
('UZB', 'Uzbekistan', 'ENG'),
('VAT', 'Vatican', 'ENG'),
('VCT', 'Saint Vincent and the Grenadines', 'ENG'),
('VEN', 'Venezuela', 'ENG'),
('VGB', 'British Virgin Islands', 'ENG'),
('VIR', 'U.S. Virgin Islands', 'ENG'),
('VNM', 'Vietnam', 'ENG'),
('VUT', 'Vanuatu', 'ENG'),
('WLF', 'Wallis and Futuna', 'ENG'),
('WSM', 'Samoa', 'ENG'),
('XKX', 'Kosovo', 'ENG'),
('YEM', 'Yemen', 'ENG'),
('ZAF', 'South Africa', 'ENG'),
('ZMB', 'Zambia', 'ENG'),
('ZWE', 'Zimbabwe', 'ENG');

-- --------------------------------------------------------

--
-- Table structure for table `guests`
--

DROP TABLE IF EXISTS `guests`;
CREATE TABLE IF NOT EXISTS `guests` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guestName` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `person_id` int(11) NOT NULL,
  `rating` int(11) DEFAULT NULL,
  `procedence` varchar(3) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `language` varchar(3) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `notes` mediumtext COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`),
  KEY `person_id_idx` (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `guests`
--

INSERT INTO `guests` (`id`, `guestName`, `person_id`, `rating`, `procedence`, `language`, `notes`) VALUES
(3, 'Alex', 1, 4, 'USA', 'eng', 'this is my first guest form USA'),
(4, 'Emma', 2, 5, 'EUA', 'Arb', 'this is my first guest form EUA'),
(5, 'assad  ASD', 5, NULL, 'usa', 'en', 'ssfsfdfgfghfghfh'),
(6, 'ali andsari', 6, 5, 'usa', 'en', 'ssfsfdfgfghfghfh'),
(7, 'Ali Ansari', 8, 5, 'Afg', 'Dr', 'this is for test'),
(8, 'Ali Ansari', 9, 5, 'usa', 'en', 'this item is edited');

-- --------------------------------------------------------

--
-- Table structure for table `languages`
--

DROP TABLE IF EXISTS `languages`;
CREATE TABLE IF NOT EXISTS `languages` (
  `alpha3_code` varchar(3) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`alpha3_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `languages`
--

INSERT INTO `languages` (`alpha3_code`, `name`) VALUES
('DEU', 'German'),
('DUT', 'Dutch'),
('ENG', 'English'),
('FRA', 'French'),
('ITA', 'Italian'),
('POR', 'Portuguese'),
('SPA', 'Spanish');

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `firstName` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `docType` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `docNumber` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`id`, `lastName`, `firstName`, `docType`, `docNumber`) VALUES
(1, 'Smith', 'Alex', 'Passport', '123123'),
(2, 'Watson', 'Emma', 'Passport', '234123'),
(3, 'ASD', 'assad', 'pass', '123123'),
(4, 'ASD', 'assad', 'pass', '123123'),
(5, 'ASD', 'assad', 'pass', '123123'),
(6, 'ASD', 'assad', 'pass', '123123'),
(7, 'Ansari', 'Ali', 'Passport', '12231'),
(8, 'Ansari', 'Ali', 'Passport', '123123'),
(9, 'Ansari', 'Ali', 'Passport', '123123');

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
CREATE TABLE IF NOT EXISTS `rooms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(3) COLLATE utf8mb4_unicode_ci NOT NULL,
  `title` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `imageUrl` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `price` decimal(5,2) DEFAULT NULL,
  `maxNumGuests` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`id`, `number`, `title`, `description`, `imageUrl`, `price`, `maxNumGuests`) VALUES
(1, '1', 'small room changed ', 'This is a room for one person edited', NULL, '34.00', 2),
(2, '2', 'big room', 'this is a room for 10 person', NULL, '80.00', 10),
(3, '3', 'Best Room', 'this is the best room of our hotel', '', '200.00', 0),
(4, '44', 'New room', 'this is new room 44', NULL, '120.00', 0),
(5, '77', 'Old Room', 'this is the old room 77', NULL, '50.00', 0),
(6, '3', 'Best Room', 'this is the best room of our hotel', '', '200.00', 0),
(7, '1', '2', 'this is the best room of our hotel', '', '200.00', 0),
(8, '55', 'bad room', 'testing new entry', '', '43.00', 2),
(9, '3', 'new room', 'new new new', '', '25.00', 2),
(10, '3', 'Best Room', 'this is the best room of our hotel', 'man-1209957_1920.jpg', '120.00', 2),
(11, '3', 'bad room', 'this is the best room of our hotel', 'lonely-3062045_1920.jpg', '34.00', 1),
(12, '3', 'bad room', 'testing new entry', 'galaxy-3608029_1920.jpg', '54.00', 2),
(13, '1', 'new room', 'testing new entry', '', '12.00', 2),
(14, '3', 'bad room', 'testing new entry', '', '43.00', 2),
(15, '3', 'Best Room', 'this is the best room of our hotel', NULL, '120.00', 5),
(16, '3', 'new room', 'testing new entry', 'S:/image\\photo', '43.00', 5),
(17, '321', 'new room', 'testing new entry', 'S:\\image\\photo', '250.00', 1),
(18, '55', 'Best Room', 'this is the best room of our hotel', 'S:\\image\\photo\\alone_boy_98love.ir_(15).jpg', '24.00', 3),
(19, '3', 'Best Room', 'this is the best room of our hotel', 'D:\\Photos\\hitman logo png - Ú«ÙˆÙˆÚ«Ù„ Ù„Ù¼ÙˆÙ†.jpeg', '70.00', 2),
(20, '3', 'Best Room', 'this is the best room of our hotel', 'D:\\Photos\\hackers sticker - Ú«ÙˆÙˆÚ«Ù„ Ù„Ù¼ÙˆÙ†.jpeg', '123.00', 2),
(21, '777', 'last room', 'testing new entry', 'D:\\Photos\\DLQKF1JVoAAOUT1.jpg', '54.00', 3),
(22, '4', 'goopd room', 'testing new entry', 'D:\\Photos\\9801403_925.jpg', '110.00', 2),
(23, '5', 'New Room', 'this is the best room of our hotel', 'D:\\Photos\\10531446981252191534.jpg', '40.00', 2);

-- --------------------------------------------------------

--
-- Table structure for table `room_amenities`
--

DROP TABLE IF EXISTS `room_amenities`;
CREATE TABLE IF NOT EXISTS `room_amenities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) NOT NULL,
  `amenity_id` int(11) NOT NULL,
  `included` enum('Y','N') COLLATE utf8mb4_unicode_ci NOT NULL,
  `shared` enum('Y','N') COLLATE utf8mb4_unicode_ci NOT NULL,
  `actualCost` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `amenity` (`amenity_id`),
  KEY `room` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

--
-- Constraints for table `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `guest_id` FOREIGN KEY (`guest_id`) REFERENCES `guests` (`id`),
  ADD CONSTRAINT `room_id` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`);

--
-- Constraints for table `countries`
--
ALTER TABLE `countries`
  ADD CONSTRAINT `language` FOREIGN KEY (`lang`) REFERENCES `languages` (`alpha3_code`);

--
-- Constraints for table `guests`
--
ALTER TABLE `guests`
  ADD CONSTRAINT `person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

--
-- Constraints for table `room_amenities`
--
ALTER TABLE `room_amenities`
  ADD CONSTRAINT `amenity` FOREIGN KEY (`amenity_id`) REFERENCES `amenities` (`id`),
  ADD CONSTRAINT `room` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

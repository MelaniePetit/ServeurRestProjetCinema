-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 23 Octobre 2017 à 18:35
-- Version du serveur :  10.1.19-MariaDB
-- Version de PHP :  5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cinema`
--

-- --------------------------------------------------------

--
-- Structure de la table `acteur`
--

CREATE TABLE `acteur` (
  `id_act` int(4) NOT NULL,
  `nom_act` varchar(20) NOT NULL,
  `pren_act` varchar(20) DEFAULT NULL,
  `date_naiss_act` date DEFAULT NULL,
  `date_deces_act` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `acteur`
--

INSERT INTO `acteur` (`id_act`, `nom_act`, `pren_act`, `date_naiss_act`, `date_deces_act`) VALUES
(1, 'Reno', 'Jean', '1948-07-30', NULL),
(2, 'Portman', 'Natalie', '1981-06-09', NULL),
(3, 'Dujardin', 'Jean', '1972-06-19', NULL),
(4, 'Bourvil', '', '1917-07-27', '1970-09-23'),
(5, 'De Funes', 'Louis', '1914-07-31', '1983-01-27'),
(6, 'Anglade', 'Jean-Hugues', '1955-07-29', NULL),
(7, 'Lambert', 'Christophe', '1957-03-29', NULL),
(9, 'Taglioni', 'Alice', '1976-07-26', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `code_cat` varchar(2) NOT NULL,
  `libelle_cat` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`code_cat`, `libelle_cat`) VALUES
('AC', 'Action'),
('CO', 'Comédie'),
('PO', 'Policier'),
('WE', 'Western');

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

CREATE TABLE `film` (
  `id_film` int(4) NOT NULL,
  `titre_film` varchar(30) NOT NULL,
  `duree_film` int(3) NOT NULL,
  `date_sortie_film` date NOT NULL,
  `budget_film` int(8) NOT NULL,
  `montant_recette_film` int(8) NOT NULL,
  `id_real` int(2) NOT NULL,
  `code_cat` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `film`
--

INSERT INTO `film` (`id_film`, `titre_film`, `duree_film`, `date_sortie_film`, `budget_film`, `montant_recette_film`, `id_real`, `code_cat`) VALUES
(1, 'Léon', 110, '1994-04-14', 17531000, 69250000, 3, 'PO'),
(2, 'Cash', 100, '2008-04-23', 18340000, 60340000, 4, 'PO'),
(3, 'La grande vadrouille', 132, '1966-12-01', 7227000, 51258000, 2, 'AC'),
(4, 'Subway', 104, '1985-04-10', 10567000, 70500000, 3, 'PO');

-- --------------------------------------------------------

--
-- Structure de la table `personnage`
--

CREATE TABLE `personnage` (
  `id_pers` int(4) NOT NULL,
  `id_film` int(4) NOT NULL,
  `id_act` int(4) NOT NULL,
  `nom_pers` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `personnage`
--

INSERT INTO `personnage` (`id_pers`, `id_film`, `id_act`, `nom_pers`) VALUES
(1, 1, 1, 'Léon'),
(2, 1, 2, 'Mathilda'),
(3, 2, 1, 'Maxime Dubreuil'),
(4, 2, 3, 'Cash'),
(5, 3, 4, 'Augustin Bouvet'),
(6, 3, 5, 'Stanislas Lefort'),
(8, 4, 6, 'Le Roller'),
(9, 4, 7, 'Fred');

-- --------------------------------------------------------

--
-- Structure de la table `realisateur`
--

CREATE TABLE `realisateur` (
  `id_real` int(2) NOT NULL,
  `nom_real` varchar(20) NOT NULL,
  `pren_real` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `realisateur`
--

INSERT INTO `realisateur` (`id_real`, `nom_real`, `pren_real`) VALUES
(1, 'Oury', 'Gérard'),
(2, 'Chabrol', 'Claude'),
(3, 'Besson', 'Luc'),
(4, 'Besnard', 'Eric');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `acteur`
--
ALTER TABLE `acteur`
  ADD PRIMARY KEY (`id_act`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`code_cat`);

--
-- Index pour la table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`id_film`),
  ADD KEY `id_real` (`id_real`),
  ADD KEY `code_cat` (`code_cat`);

--
-- Index pour la table `personnage`
--
ALTER TABLE `personnage`
  ADD PRIMARY KEY (`id_pers`),
  ADD KEY `id_film` (`id_film`),
  ADD KEY `id_act` (`id_act`);

--
-- Index pour la table `realisateur`
--
ALTER TABLE `realisateur`
  ADD PRIMARY KEY (`id_real`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `acteur`
--
ALTER TABLE `acteur`
  MODIFY `id_act` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `film`
--
ALTER TABLE `film`
  MODIFY `id_film` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `personnage`
--
ALTER TABLE `personnage`
  MODIFY `id_pers` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `realisateur`
--
ALTER TABLE `realisateur`
  MODIFY `id_real` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `FK4l42ervh2j10q1ymld7w6iii4` FOREIGN KEY (`id_real`) REFERENCES `realisateur` (`id_real`),
  ADD CONSTRAINT `FKoeh866dfavtg0jhb5ykh98lum` FOREIGN KEY (`code_cat`) REFERENCES `categorie` (`code_cat`),
  ADD CONSTRAINT `film_ibfk_1` FOREIGN KEY (`id_real`) REFERENCES `realisateur` (`id_real`),
  ADD CONSTRAINT `film_ibfk_2` FOREIGN KEY (`code_cat`) REFERENCES `categorie` (`code_cat`);

--
-- Contraintes pour la table `personnage`
--
ALTER TABLE `personnage`
  ADD CONSTRAINT `FKmo2uoqyfggnys4pgiooci3123` FOREIGN KEY (`id_act`) REFERENCES `acteur` (`id_act`),
  ADD CONSTRAINT `FKphd279kx2ai1vngr2tvxhl7iq` FOREIGN KEY (`id_film`) REFERENCES `film` (`id_film`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

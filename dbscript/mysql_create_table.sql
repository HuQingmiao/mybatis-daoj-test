drop table if exists `book`;
CREATE TABLE `book` (
                        `book_id` bigint(12) unsigned NOT NULL AUTO_INCREMENT,
                        `title` varchar(80) NOT NULL,
                        `price` double(10,2) NOT NULL,
                        `publish_time` datetime DEFAULT NULL,
                        `blob_content` longblob,
                        row_version bigint(12) unsigned not null DEFAULT 0,
                        PRIMARY KEY (`book_id`)
) ENGINE=InnoDB  DEFAULT  CHARACTER SET=utf8mb4  COLLATE=utf8mb4_general_ci;

drop table if exists `editor`;
CREATE TABLE `editor` (
                          `editor_id` bigint(12) unsigned NOT NULL AUTO_INCREMENT,
                          `name` varchar(80) NOT NULL,
                          `sex` set('m','f') DEFAULT NULL,
                          PRIMARY KEY (`editor_id`)
) ENGINE=InnoDB  DEFAULT  CHARACTER SET=utf8mb4  COLLATE=utf8mb4_general_ci;

drop table if exists `book_editor`;
CREATE TABLE `book_editor` (
                               `id` bigint(12)  unsigned NOT NULL AUTO_INCREMENT,
                               `book_id` bigint(12) unsigned NOT NULL,
                               `editor_id` bigint(12) unsigned NOT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT  CHARACTER SET=utf8mb4  COLLATE=utf8mb4_general_ci;



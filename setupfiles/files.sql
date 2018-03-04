DROP TABLE FILES;
CREATE TABLE FILES (
FILE_ID INTEGER NOT NULL AUTO_INCREMENT,
FILE_NAME VARCHAR(30) NOT NULL UNIQUE,
OWNER INTEGER NOT NULL,
DESCRIPTION VARCHAR(500) NOT NULL,
URL VARCHAR(120) NOT NULL,
PRIMARY KEY (FILE_ID));
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text01.txt', 0, 'This is a Descriptor1, This is a Descriptor1, This is a Descriptor1, This is a Descriptor1, This is a Descriptor1, This is a Descriptor1, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text01.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text02.txt', 0, 'This is a Descriptor2, This is a Descriptor2, This is a Descriptor2, This is a Descriptor2, This is a Descriptor2, This is a Descriptor2, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text02.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text03.txt', 0, 'This is a Descriptor3, This is a Descriptor3, This is a Descriptor3, This is a Descriptor3, This is a Descriptor3, This is a Descriptor3, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text03.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text04.txt', 0, 'This is a Descriptor4, This is a Descriptor4, This is a Descriptor4, This is a Descriptor4, This is a Descriptor4, This is a Descriptor4, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text04.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text05.txt', 0, 'This is a Descriptor5, This is a Descriptor5, This is a Descriptor5, This is a Descriptor5, This is a Descriptor5, This is a Descriptor5, Bla, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text05.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text06.txt', 0, 'This is a Descriptor6, This is a Descriptor6, This is a Descriptor6, This is a Descriptor6, This is a Descriptor6, This is a Descriptor6, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text06.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text07.txt', 0, 'This is a Descriptor7, This is a Descriptor7, This is a Descriptor7, This is a Descriptor7, This is a Descriptor7, This is a Descriptor7, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text07.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text08.txt', 0, 'This is a Descriptor8, This is a Descriptor8, This is a Descriptor8, This is a Descriptor8, This is a Descriptor8, This is a Descriptor8, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text08.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text09.txt', 0, 'This is a Descriptor9, This is a Descriptor9, This is a Descriptor9, This is a Descriptor9, This is a Descriptor9, This is a Descriptor9, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text09.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text10.txt', 0, 'This is a Descriptor10, This is a Descriptor10, This is a Descriptor10, This is a Descriptor10, This is a Descriptor10, This is a Descriptor10, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text10.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text11.txt', 0, 'This is a Descriptor11, This is a Descriptor11, This is a Descriptor11, This is a Descriptor11, This is a Descriptor11, This is a Descriptor11, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text11.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text12.txt', 0, 'This is a Descriptor12, This is a Descriptor12, This is a Descriptor12, This is a Descriptor12, This is a Descriptor12, This is a Descriptor12, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text12.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text13.txt', 0, 'This is a Descriptor13, This is a Descriptor13, This is a Descriptor13, This is a Descriptor13, This is a Descriptor13, This is a Descriptor13, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text13.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text14.txt', 0, 'This is a Descriptor14, This is a Descriptor14, This is a Descriptor14, This is a Descriptor14, This is a Descriptor14, This is a Descriptor14, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text14.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text15.txt', 0, 'This is a Descriptor15, This is a Descriptor15, This is a Descriptor15, This is a Descriptor15, This is a Descriptor15, This is a Descriptor15, Bla, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text15.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text16.txt', 0, 'This is a Descriptor16, This is a Descriptor16, This is a Descriptor16, This is a Descriptor16, This is a Descriptor16, This is a Descriptor16, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text16.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text17.txt', 0, 'This is a Descriptor17, This is a Descriptor17, This is a Descriptor17, This is a Descriptor17, This is a Descriptor17, This is a Descriptor17, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text17.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text18.txt', 0, 'This is a Descriptor18, This is a Descriptor18, This is a Descriptor18, This is a Descriptor18, This is a Descriptor18, This is a Descriptor18, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text18.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text19.txt', 0, 'This is a Descriptor19, This is a Descriptor19, This is a Descriptor19, This is a Descriptor19, This is a Descriptor19, This is a Descriptor19, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text19.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text20.txt', 0, 'This is a Descriptor20, This is a Descriptor20, This is a Descriptor20, This is a Descriptor20, This is a Descriptor20, This is a Descriptor20, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text20.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text21.txt', 0, 'This is a Descriptor21, This is a Descriptor21, This is a Descriptor21, This is a Descriptor21, This is a Descriptor21, This is a Descriptor21, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text21.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text22.txt', 0, 'This is a Descriptor22, This is a Descriptor22, This is a Descriptor22, This is a Descriptor22, This is a Descriptor22, This is a Descriptor22, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text22.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text23.txt', 0, 'This is a Descriptor23, This is a Descriptor23, This is a Descriptor23, This is a Descriptor23, This is a Descriptor23, This is a Descriptor23, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text23.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text24.txt', 0, 'This is a Descriptor24, This is a Descriptor24, This is a Descriptor24, This is a Descriptor24, This is a Descriptor24, This is a Descriptor24, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text24.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text25.txt', 0, 'This is a Descriptor25, This is a Descriptor25, This is a Descriptor25, This is a Descriptor25, This is a Descriptor25, This is a Descriptor25, Bla, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text25.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text26.txt', 0, 'This is a Descriptor26, This is a Descriptor26, This is a Descriptor26, This is a Descriptor26, This is a Descriptor26, This is a Descriptor26, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text26.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text27.txt', 0, 'This is a Descriptor27, This is a Descriptor27, This is a Descriptor27, This is a Descriptor27, This is a Descriptor27, This is a Descriptor27, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text27.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text28.txt', 0, 'This is a Descriptor28, This is a Descriptor28, This is a Descriptor28, This is a Descriptor28, This is a Descriptor28, This is a Descriptor28, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text28.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text29.txt', 0, 'This is a Descriptor29, This is a Descriptor29, This is a Descriptor29, This is a Descriptor29, This is a Descriptor29, This is a Descriptor29, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text29.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text30.txt', 0, 'This is a Descriptor30, This is a Descriptor30, This is a Descriptor30, This is a Descriptor30, This is a Descriptor30, This is a Descriptor30, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text30.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text31.txt', 0, 'This is a Descriptor31, This is a Descriptor31, This is a Descriptor31, This is a Descriptor31, This is a Descriptor31, This is a Descriptor31, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text31.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text32.txt', 0, 'This is a Descriptor32, This is a Descriptor32, This is a Descriptor32, This is a Descriptor32, This is a Descriptor32, This is a Descriptor32, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text32.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text33.txt', 0, 'This is a Descriptor33, This is a Descriptor33, This is a Descriptor33, This is a Descriptor33, This is a Descriptor33, This is a Descriptor33, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text33.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text34.txt', 0, 'This is a Descriptor34, This is a Descriptor34, This is a Descriptor34, This is a Descriptor34, This is a Descriptor34, This is a Descriptor34, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text34.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text35.txt', 0, 'This is a Descriptor35, This is a Descriptor35, This is a Descriptor35, This is a Descriptor35, This is a Descriptor35, This is a Descriptor35, Bla, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text35.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text36.txt', 0, 'This is a Descriptor36, This is a Descriptor36, This is a Descriptor36, This is a Descriptor36, This is a Descriptor36, This is a Descriptor36, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text36.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text37.txt', 0, 'This is a Descriptor37, This is a Descriptor37, This is a Descriptor37, This is a Descriptor37, This is a Descriptor37, This is a Descriptor37, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text37.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text38.txt', 0, 'This is a Descriptor38, This is a Descriptor38, This is a Descriptor38, This is a Descriptor38, This is a Descriptor38, This is a Descriptor38, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text38.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text39.txt', 0, 'This is a Descriptor39, This is a Descriptor39, This is a Descriptor39, This is a Descriptor39, This is a Descriptor39, This is a Descriptor39, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text39.txt');
INSERT INTO FILES(FILE_NAME, OWNER, DESCRIPTION, URL) VALUES('text40.txt', 0, 'This is a Descriptor40, This is a Descriptor40, This is a Descriptor40, This is a Descriptor40, This is a Descriptor40, This is a Descriptor40, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text40.txt');
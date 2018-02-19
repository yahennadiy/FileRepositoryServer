DROP TABLE FILES;
CREATE TABLE FILES (
ID INTEGER NOT NULL AUTO_INCREMENT,
FILE_NAME VARCHAR(20) NOT NULL UNIQUE,
DESCRIPTION VARCHAR(500) NOT NULL,
URL VARCHAR(100) NOT NULL,
PRIMARY KEY (ID));
INSERT INTO FILES(FILE_NAME, DESCRIPTION, URL) VALUES('File1.txt', 'This is a Descriptor1, This is a Descriptor1, This is a Descriptor1, This is a Descriptor1, This is a Descriptor1, This is a Descriptor1, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text1.txt');
INSERT INTO FILES(FILE_NAME, DESCRIPTION, URL) VALUES('File2.txt', 'This is a Descriptor2, This is a Descriptor2, This is a Descriptor2, This is a Descriptor2, This is a Descriptor2, This is a Descriptor2, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text2.txt');
INSERT INTO FILES(FILE_NAME, DESCRIPTION, URL) VALUES('File5.txt', 'This is a Descriptor5, This is a Descriptor5, This is a Descriptor5, This is a Descriptor5, This is a Descriptor5, This is a Descriptor5, Bla, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text5.txt');
INSERT INTO FILES(FILE_NAME, DESCRIPTION, URL) VALUES('File3.txt', 'This is a Descriptor3, This is a Descriptor3, This is a Descriptor3, This is a Descriptor3, This is a Descriptor3, This is a Descriptor3, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text3.txt');
INSERT INTO FILES(FILE_NAME, DESCRIPTION, URL) VALUES('File4.txt', 'This is a Descriptor4, This is a Descriptor4, This is a Descriptor4, This is a Descriptor4, This is a Descriptor4, This is a Descriptor4, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text4.txt');
INSERT INTO FILES(FILE_NAME, DESCRIPTION, URL) VALUES('File6.txt', 'This is a Descriptor6, This is a Descriptor6, This is a Descriptor6, This is a Descriptor6, This is a Descriptor6, This is a Descriptor6, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text6.txt');
INSERT INTO FILES(FILE_NAME, DESCRIPTION, URL) VALUES('File8.txt', 'This is a Descriptor8, This is a Descriptor8, This is a Descriptor8, This is a Descriptor8, This is a Descriptor8, This is a Descriptor8, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text8.txt');
INSERT INTO FILES(FILE_NAME, DESCRIPTION, URL) VALUES('File10.txt', 'This is a Descriptor10, This is a Descriptor10, This is a Descriptor10, This is a Descriptor10, This is a Descriptor10, This is a Descriptor10, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text10.txt');
INSERT INTO FILES(FILE_NAME, DESCRIPTION, URL) VALUES('File7.txt', 'This is a Descriptor7, This is a Descriptor7, This is a Descriptor7, This is a Descriptor7, This is a Descriptor7, This is a Descriptor7, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text7.txt');
INSERT INTO FILES(FILE_NAME, DESCRIPTION, URL) VALUES('File9.txt', 'This is a Descriptor9, This is a Descriptor9, This is a Descriptor9, This is a Descriptor9, This is a Descriptor9, This is a Descriptor9, Bla, Bla, Bla, Bla', 'file://localhost/home/hennadiy/Projects/java/FileRepositoryServer/files/text9.txt');

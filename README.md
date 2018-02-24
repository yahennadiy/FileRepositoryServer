  This is a Server`s part of client-server application using Netty, Hibernate, MySQL, C3P0 Connection Pool,
      JSON Web Token, hashing and salting password.

  The application has a file repository. Users can receive a list of files, their description and
      download the selected file.
  The test files are located in the /FileRepositoryServer/files directory.
  Downloaded files will be placed to the /FileTarget directory from the root of client`s computer.

  It is necessary:
- change hibernate.cfg.xml for your database.
- change repository.xbm.xml if you are not using MySQL.
- create a "repository" database.
- create tables USERS and FILES.
- there are schemes for filling the tables USERS and FILES in the /setupfiles directory.
- connect the netty library to the project (I used netty-4.1.19.Final).
  You can download it here: https://netty.io/downloads.html.

  The project is already working, but it still requires improvements.
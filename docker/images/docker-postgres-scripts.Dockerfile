FROM postgres 
COPY ./database/dbFill.sql ./dbFill.sql
COPY ./database/dbInit.sql ./dbInit.sql
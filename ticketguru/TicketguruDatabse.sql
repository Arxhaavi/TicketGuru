 DROP TABLE IF EXISTS appuser;
 DROP TABLE IF EXISTS event;
 DROP TABLE IF EXISTS location;
 DROP TABLE IF EXISTS postalcode;
 DROP TABLE IF EXISTS salestransaction;
 DROP TABLE IF EXISTS ticket;
 DROP TABLE IF EXISTS tickettype;

 CREATE TABLE postalcode (
     postalcode VARCHAR(5) PRIMARY KEY,
     city VARCHAR(100) NOT NULL,
     country VARCHAR(100) NOT NULL  
 );

 CREATE TABLE location (
     locationid BIGSERIAL PRIMARY KEY,
     name VARCHAR(100) NOT NULL,
     streetaddress VARCHAR(250) NOT NULL,
     capacity INTEGER NOT NULL,
     postalcode VARCHAR(5) NOT NULL,
     CONSTRAINT fk_postalcode
         FOREIGN KEY (postalcode)
         REFERENCES postalcode(postalcode)
         ON DELETE SET NULL
 );

 CREATE TABLE tickettype (
     tickettypeid BIGSERIAL PRIMARY KEY,
     tickettype VARCHAR(100) NOT NULL
 );

 CREATE TABLE salestransaction (
     transactionid BIGSERIAL PRIMARY KEY,
     transactiontime TIMESTAMP WITHOUT TIME ZONE NOT NULL,
     sum DOUBLE PRECISION NOT NULL
 );

 CREATE TABLE event (
     event_id BIGSERIAL PRIMARY KEY,
     name VARCHAR(100) NOT NULL,
     description VARCHAR(500),
     starttime TIMESTAMP WITHOUT TIME ZONE NOT NULL,
     endtime TIMESTAMP WITHOUT TIME ZONE NOT NULL,
     ticketcount INTEGER CHECK (ticketcount >= 0) NOT NULL,
     locationid BIGINT NOT NULL,  
     CONSTRAINT fk_location
         FOREIGN KEY (locationid)
         REFERENCES location(locationid)
         ON DELETE SET NULL
 );

 CREATE TABLE eventtickettype (
 eventtickettypeid BIGSERIAL PRIMARY KEY,
 tickettypeid BIGINT NOT NULL,
 event_id BIGINT NOT NULL,
 price DOUBLE PRECISION NOT NULL,
    CONSTRAINT fk_tickettype
        FOREIGN KEY (tickettypeid)
        REFERENCES tickettype(tickettypeid)
        ON DELETE SET NULL,
    CONSTRAINT fk_event
        FOREIGN KEY (event_id)
        REFERENCES event(event_id)
        ON DELETE SET NULL

 CREATE TABLE appuser (
     id BIGSERIAL PRIMARY KEY,
     username VARCHAR(100) NOT NULL,
     passwordhash VARCHAR(100) NOT NULL,
     role VARCHAR(50) NOT NULL
 );
 CREATE TABLE ticket (
     ticket_id BIGSERIAL PRIMARY KEY,
     ticketused BOOLEAN NOT NULL DEFAULT FALSE,
     code VARCHAR(16) NOT NULL,  
     transactionid BIGINT NOT NULL,
     tickettypeid BIGINT NOT NULL,
     event_id BIGINT NOT NULL,

     CONSTRAINT fk_salestransaction
         FOREIGN KEY (transactionid)
         REFERENCES salestransaction(transactionid)
         ON DELETE SET NULL,

     CONSTRAINT fk_tickettype
         FOREIGN KEY (tickettypeid)
         REFERENCES tickettype(tickettypeid)
         ON DELETE SET NULL,

     CONSTRAINT fk_event
         FOREIGN KEY (event_id)
         REFERENCES event(event_id)
         ON DELETE SET NULL
 );

 INSERT INTO Postalcode (postalcode, city, country)
 VALUES ('33100', 'Tampere', 'Suomi');

 INSERT INTO Location (name, streetaddress, postalcode, capacity)
 VALUES ('Tampere Arena', 'Hämeenkatu 30, Tampere', 1, 5000);

 INSERT INTO Event (name, description, starttime, endtime, locationid, ticketcount)
 VALUES 
     ('Jalkapallo-ottelu', 'Suomen maajoukkueen peli', '2025-06-15 18:15:00', '2025-06-15 20:15:00', 3, 2000),
     ('Super gaala', 'Juhlagaala', '2025-06-15 18:00:00', '2025-06-15 21:00:00', 3, 500);

 INSERT INTO TicketType (tickettypeid, tickettype)
 VALUES 
     ('Eläkeläinen'),
     ('Opiskelija');

 INSERT INTO Ticket (tickettypeid, event_id, code)
 VALUES
     (1, 1, 'abcdefgas1234051'),
     (2, 1, '98f3hf7asforWRj3');

INSERT INTO AppUser (username, passwordhash, role)
VALUES
    ('admin', '$2a$10$YAvqdDch33w5BecjHl6WP.LjpNaYy9jQlTcE.Krl3ib7VvzRiKUta', 'ROLE_ADMIN'),
    ('user', '$2a$10$4XXGNu904amNx2Q0tPL4OOZiLP012ULGVI2a8Em4SAJGCtQG1WBJu', 'ROLE_USER'),
    
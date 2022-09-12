use airport;


INSERT INTO location(country, city) 
VALUES
("Ukraine", "Kyiv"),
("Egypt", "Hurghada"),
("Turkey", "Istanbul"),
("Turkey", "Ankara"),
("Egypt", "Cairo"),
("Bulgaria", "Sofia");

INSERT INTO gate(gateNumber) 
VALUES
(3),(45),(67),(13),(35),(24);

INSERT INTO terminal(terminalName) 
VALUES
("D"),("A"),("C"),("L");

INSERT INTO airport(airportName, idLocationAirport, idGate, idTerminal) 
VALUES
("Borispil", 1, 2, 3),
("Zhulyany", 1, 3, 2),
("Cairo", 5, 4, 1),
("Hurghada", 2, 3, 4),
("Istanbul", 3, 5, 2),
("Ankara", 4, 1, 2);

INSERT INTO airline(nameAirline) 
VALUES
("WINDROSE"),
("Delta Air Lines");

INSERT INTO arrival(idAirportA)
VALUES
(1),(2),(4);

INSERT INTO departure(idAirport) 
VALUES
(1),(2),(6);

INSERT INTO plane(idAirline) 
VALUES
(1),(2);

INSERT INTO pilots(Pname, surname, salary, idPlane) 
VALUES
("Nastya", "Myronova", 3000, 1),
("Sergei", "Bolkun",  1000, 2),
("Maria", "Bolkun",  1000, 2);

INSERT INTO schedule_flight(duration, idDeparture, idArrival) 
VALUES
(2, 1, 2),
(3, 1, 3),
(1.5, 3, 1);

INSERT INTO flight(idAirlineF, idSchedule) 
VALUES
(2, 3),(1, 1),(2, 2),(1, 3);

INSERT INTO passengers(Pname, surname, phoneNumber, idFlight) 
VALUES
("Marina", "Savchuk", "+3809876765654", 2),
("Anna", "Nuchuk", "+3809871122654", 2),
("Diana", "Koval", "+3806754765654", 3),
("Nastya", "Myronova", "+3805076761114", 3),
("Sergei", "Bolkun", "+3809871123654", 1);

INSERT INTO baggages(idPassenger) 
VALUES
(1),(2),(3),(4);

INSERT INTO missing_baggages(idBaggage, statusB, descriptionB) 
VALUES
(1, "open", "red backpack"),
(3, "close", "-");

INSERT INTO ticket(idPassengerT, seat, price) 
VALUES
(4, "23d",200),
(2, "24B",120),
(3, "1A",100),
(1, "1C",150);




UPDATE passengers
SET email = "kovaldi221@gmail.com"
WHERE idPassenger = 2;

UPDATE ticket
SET price = 300, seat = "10D"
WHERE idTicket = 3;

UPDATE missing_baggages
SET statusB = "close"
WHERE idMissingBaggage = 1;

UPDATE pilots
SET Pname = "Kolya"
WHERE idPilot = 2;

UPDATE passengers
SET email = "nastyaM31@gmail.com"
WHERE idPassenger = 3;




SELECT *
FROM terminal
WHERE terminalName = "A";

SELECT *
FROM passengers
WHERE idFlight = 2 AND idPassenger < 2; 

SELECT *
FROM pilots 
WHERE salary < 2000 OR idPlane = 3;

SELECT *
FROM location 
WHERE city IN ("Ankara", "Istanbul");

SELECT *
FROM gate
WHERE idGate BETWEEN 4 AND 6;

SELECT *
FROM flight
ORDER BY idAirlineF;

SELECT COUNT(idPilot), idPlane
FROM pilots
GROUP BY idPlane;


#JOIN
SELECT A.airportName, L.country, L.city
FROM airport A
JOIN location L ON A.idLocationAirport  = L.idLocation;

SELECT SF.idSchedule, F.idFlight, SF.duration
FROM flight F
JOIN schedule_flight SF ON F.idSchedule = SF.idSchedule;

SELECT B.idBaggage, M.idMissingBaggage, M.statusB
FROM baggages B
LEFT JOIN missing_baggages M ON B.idBaggage = M.idBaggage;

SELECT plane.idAirline, P.Pname, P.surname, P.salary
FROM pilots P
RIGHT JOIN plane ON plane.idPlane = P.idPlane
ORDER BY P.Pname;




DELETE FROM location
WHERE idLocation = 6;

DELETE FROM passengers
WHERE idPassenger = 4;

DELETE FROM airport
WHERE idAirport = 6;

DELETE FROM terminal
WHERE idTerminal = 4;

DELETE FROM location
WHERE idLocation = 5;

-- DELETE FROM location
-- WHERE country = "Turkey"; 
-- SELECT * FROM location;
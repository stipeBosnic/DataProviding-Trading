INSERT INTO sport (sport_id, sport_name)
VALUES (1, 'Nogomet');
INSERT INTO category (category_id, category_name, sport_id)
VALUES (1, 'Hrvatska', 1);
INSERT INTO tournament (tournament_id, category_id, tournament_name)
VALUES (1, 1, '1.HNL' );
INSERT INTO markettype (market_type_id, name)
VALUES (1, 'osnovna' );
INSERT INTO marketstate (marketstate_id, market_state)
VALUES (1, 'open' );
INSERT INTO team (team_id, team_name)
VALUES (1, 'Hajduk' ),
(2, 'Dinamo' ),
(3, 'Osijek' ),
(4, 'Rijeka' ),
(5, 'Šibenik' ),
(6, 'Hrvatski Dragovoljac' ),
(7, 'Istra' ),
(8, 'Slaven Belupo' ),
(9, 'Gorica' ),
(10, 'Lokomotiva' );
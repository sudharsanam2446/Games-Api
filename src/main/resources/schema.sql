DROP TABLE IF EXISTS t_games;
 
CREATE TABLE t_games (
  games_id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(500)
);

DROP TABLE IF EXISTS t_gamers;

CREATE TABLE t_gamers (
  gamers_id INT AUTO_INCREMENT,
  name VARCHAR(250) NOT NULL,
  nick_name VARCHAR(250) ,
  gender VARCHAR(250) check(gender in ('FEMALE', 'MALE', 'TRANS', 'PERSONAL') ),
  email VARCHAR(250) PRIMARY KEY,
  geo VARCHAR(25) check(geo in ('EUROPE', 'ASIA', 'NORTH_AMERICA', 'SOUTH_AMERICA', 'AFRICA', 'AUSTRALIA', 'ANTARTICA') )
);

DROP TABLE IF EXISTS t_gamers_credits;

CREATE TABLE t_gamers_credits (
  gamers_credits_id INT AUTO_INCREMENT PRIMARY KEY,
  level VARCHAR(250) check(level in ('NOOB', 'PRO', 'INVINSIBLE') ),
  credits NUMERIC NOT NULL DEFAULT 0,
  games_id INT,
  foreign key (games_id) references t_games(games_id),
  email VARCHAR(250),
  foreign key (email) references t_gamers(email)
)


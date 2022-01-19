INSERT INTO t_games (name) VALUES ('fortnite');
INSERT INTO t_games (name) VALUES ('call of duty');
INSERT INTO t_games (name) VALUES ('dota');
INSERT INTO t_games (name) VALUES ('valhalla');
INSERT INTO t_games (name) VALUES ('amongus');

INSERT INTO t_gamers (name, nick_name, gender, email, geo) VALUES ('balaji', 'v', 'MALE', 'balaji@gmail.com', 'ASIA');
INSERT INTO t_gamers (name, nick_name, gender, email, geo) VALUES ('nihana', 'v', 'FEMALE', 'nihana@gmail.com', 'ASIA');
INSERT INTO t_gamers (name, nick_name, gender, email, geo) VALUES ('shivanya', 'v', 'FEMALE', 'shivanya@gmail.com', 'ASIA');
INSERT INTO t_gamers (name, nick_name, gender, email, geo) VALUES ('gomes', 'v', 'MALE', 'gomes@gmail.com', 'ASIA');
INSERT INTO t_gamers (name, nick_name, gender, email, geo) VALUES ('sridhar', 'v', 'MALE', 'sridhar@gmail.com', 'ASIA');
INSERT INTO t_gamers (name, nick_name, gender, email, geo) VALUES ('ram', 'v', 'MALE', 'ram@gmail.com', 'ASIA');
INSERT INTO t_gamers (name, nick_name, gender, email, geo) VALUES ('akash', 'v', 'MALE', 'akash@gmail.com', 'ASIA');
INSERT INTO t_gamers (name, nick_name, gender, email, geo) VALUES ('mustafa', 'v', 'MALE', 'mustafa@gmail.com', 'ASIA');
INSERT INTO t_gamers (name, nick_name, gender, email, geo) VALUES ('gagan', 'v', 'MALE', 'gagan@gmail.com', 'ASIA');
INSERT INTO t_gamers (name, nick_name, gender, email, geo) VALUES ('subhasis', 'v', 'MALE', 'subhasis@gmail.com', 'ASIA');


-- Game_Id 1, Balaji is the winner at PRO level
INSERT INTO t_gamers_credits (games_id, gamer_email, credits, level) VALUES (1, 'balaji@gmail.com', 500, 'PRO');
INSERT INTO t_gamers_credits (games_id, gamer_email, credits, level) VALUES (1, 'nihana@gmail.com', 300, 'PRO');
INSERT INTO t_gamers_credits (games_id, gamer_email, credits, level) VALUES (1, 'shivanya@gmail.com', 100, 'PRO');

-- Game_Id 1, Nihana is the winner at PRO level
INSERT INTO t_gamers_credits (games_id, gamer_email, credits, level) VALUES (1, 'balaji@gmail.com', 500, 'INVINSIBLE');
INSERT INTO t_gamers_credits (games_id, gamer_email, credits, level) VALUES (1, 'nihana@gmail.com', 700, 'INVINSIBLE');
INSERT INTO t_gamers_credits (games_id, gamer_email, credits, level) VALUES (1, 'shivanya@gmail.com', 100, 'INVINSIBLE');

-- Game_Id 2, Nihana is the winner at PRO level
INSERT INTO t_gamers_credits (games_id, gamer_email, credits, level) VALUES (2, 'balaji@gmail.com', 500, 'PRO');
INSERT INTO t_gamers_credits (games_id, gamer_email, credits, level) VALUES (2, 'nihana@gmail.com', 900, 'PRO');
INSERT INTO t_gamers_credits (games_id, gamer_email, credits, level) VALUES (2, 'shivanya@gmail.com', 100, 'PRO');

-- Game_Id 2, Shivanya is the winner at INVINSIBLE level
INSERT INTO t_gamers_credits (games_id, gamer_email, credits, level) VALUES (2, 'balaji@gmail.com', 500, 'INVINSIBLE');
INSERT INTO t_gamers_credits (games_id, gamer_email, credits, level) VALUES (2, 'nihana@gmail.com', 700, 'INVINSIBLE');
INSERT INTO t_gamers_credits (games_id, gamer_email, credits, level) VALUES (2, 'shivanya@gmail.com', 1000, 'INVINSIBLE');




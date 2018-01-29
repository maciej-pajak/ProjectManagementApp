INSERT INTO `project_management`.`status` (`active`, `name`, `sortOrder`) VALUES (b'1', 'initialized', '1');
INSERT INTO `project_management`.`status` (`active`, `name`, `sortOrder`) VALUES (b'1', 'started', '2');
INSERT INTO `project_management`.`status` (`active`, `name`, `sortOrder`) VALUES (b'1', 'in progress', '3');
INSERT INTO `project_management`.`status` (`active`, `name`, `sortOrder`) VALUES (b'1', 'almost done', '4');
INSERT INTO `project_management`.`status` (`active`, `name`, `sortOrder`) VALUES (b'1', 'done', '5');
INSERT INTO `project_management`.`status` (`active`, `name`, `sortOrder`) VALUES (b'1', 'closed', '6');
INSERT INTO `project_management`.`status` (`active`, `name`, `sortOrder`) VALUES (b'1', 'problem', '7');
INSERT INTO `project_management`.`status` (`active`, `name`, `sortOrder`) VALUES (b'0', 'inactive', '7');
INSERT INTO `project_management`.`status` (`active`, `name`, `sortOrder`) VALUES (b'0', 'cancelled', '7');

INSERT INTO `project_management`.`priorities` (`active`, `name`) VALUES (b'1', 'low');
INSERT INTO `project_management`.`priorities` (`active`, `name`) VALUES (b'1', 'medium');
INSERT INTO `project_management`.`priorities` (`active`, `name`) VALUES (b'1', 'high');

INSERT INTO `project_management`.`users` (`email`, `name`, `password`, `surname`) VALUES ('useremail1', 'Name1', 'pass', 'Surname1');
INSERT INTO `project_management`.`users` (`email`, `name`, `password`, `surname`) VALUES ('useremail2', 'Name1', 'pass', 'Surname2');
INSERT INTO `project_management`.`users` (`email`, `name`, `password`, `surname`) VALUES ('useremail3', 'Name1', 'pass', 'Surname3');
INSERT INTO `project_management`.`users` (`email`, `name`, `password`, `surname`) VALUES ('useremail4', 'Name1', 'pass', 'Surname4');
INSERT INTO `project_management`.`users` (`email`, `name`, `password`, `surname`) VALUES ('useremail5', 'Name1', 'pass', 'Surname5');
INSERT INTO `project_management`.`users` (`email`, `name`, `password`, `surname`) VALUES ('useremail6', 'Name1', 'pass', 'Surname6');
INSERT INTO `project_management`.`users` (`email`, `name`, `password`, `surname`) VALUES ('useremail7', 'Name1', 'pass', 'Surname7');
INSERT INTO `project_management`.`users` (`email`, `name`, `password`, `surname`) VALUES ('useremail8', 'Name1', 'pass', 'Surname8');
INSERT INTO `project_management`.`users` (`email`, `name`, `password`, `surname`) VALUES ('useremail9', 'Name1', 'pass', 'Surname9');
INSERT INTO `project_management`.`users` (`email`, `name`, `password`, `surname`) VALUES ('useremail10', 'Name1', 'pass', 'Surname10');
INSERT INTO `project_management`.`users` (`email`, `name`, `password`, `surname`) VALUES ('useremail11', 'Name1', 'pass', 'Surname11');
INSERT INTO `project_management`.`users` (`email`, `name`, `password`, `surname`) VALUES ('useremail12', 'Name1', 'pass', 'Surname12');
INSERT INTO `project_management`.`users` (`email`, `name`, `password`, `surname`) VALUES ('useremail13', 'Name1', 'pass', 'Surname13');
INSERT INTO `project_management`.`users` (`email`, `name`, `password`, `surname`) VALUES ('useremail14', 'Name1', 'pass', 'Surname14');
INSERT INTO `project_management`.`users` (`email`, `name`, `password`, `surname`) VALUES ('useremail15', 'Name1', 'pass', 'Surname15');
INSERT INTO `project_management`.`users` (`email`, `name`, `password`, `surname`) VALUES ('useremail16', 'Name1', 'pass', 'Surname16');
INSERT INTO `project_management`.`users` (`email`, `name`, `password`, `surname`) VALUES ('useremail17', 'Name1', 'pass', 'Surname17');
INSERT INTO `project_management`.`users` (`email`, `name`, `password`, `surname`) VALUES ('useremail18', 'Name1', 'pass', 'Surname18');
INSERT INTO `project_management`.`users` (`email`, `name`, `password`, `surname`) VALUES ('useremail19', 'Name1', 'pass', 'Surname19');
INSERT INTO `project_management`.`users` (`email`, `name`, `password`, `surname`) VALUES ('useremail20', 'Name1', 'pass', 'Surname20');

INSERT INTO `project_management`.`projects` (`active`, `created`, `description`, `identifier`, `name`, `url`) VALUES (b'1', NOW(), 'description1', 'temp_ident1', 'project1', 'www1');
INSERT INTO `project_management`.`projects` (`active`, `created`, `description`, `identifier`, `name`, `url`) VALUES (b'1', NOW(), 'description2', 'temp_ident2', 'project2', 'www1');
INSERT INTO `project_management`.`projects` (`active`, `created`, `description`, `identifier`, `name`, `url`) VALUES (b'1', NOW(), 'description3', 'temp_ident3', 'project3', 'www1');
INSERT INTO `project_management`.`projects` (`active`, `created`, `description`, `identifier`, `name`, `url`) VALUES (b'1', NOW(), 'description4', 'temp_ident4', 'project4', 'www1');
INSERT INTO `project_management`.`projects` (`active`, `created`, `description`, `identifier`, `name`, `url`) VALUES (b'1', NOW(), 'description5', 'temp_ident5', 'project5', 'www1');

INSERT INTO `project_management`.`projects_users` (`project_id`, `user_id`) VALUES ('1', '2');
INSERT INTO `project_management`.`projects_users` (`project_id`, `user_id`) VALUES ('1', '3');
INSERT INTO `project_management`.`projects_users` (`project_id`, `user_id`) VALUES ('1', '4');
INSERT INTO `project_management`.`projects_users` (`project_id`, `user_id`) VALUES ('1', '5');
INSERT INTO `project_management`.`projects_users` (`project_id`, `user_id`) VALUES ('1', '6');

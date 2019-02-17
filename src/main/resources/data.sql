insert into roles (id, name) values (1, 'USER');
insert into roles (id, name) values (2, 'ADMIN');

insert into users (id, create_date, email, name, nickname, password)
 values(1, now(), 'scw@gmail.com', 'seo', 'seon', '{bcrypt}$2a$10$UkBPAAk468Ir6MEACd1gXuieKCZ2qZAHcDbMER.XG4VNn.mj4MWEC');

insert into user_roles(user_id, role_id) values (1,1);
insert into user_roles(user_id, role_id) values (1,2);

insert into categories(id, name, ordering) values(1, 'IPA', 1);
insert into categories(id, name, ordering) values(2, 'Ale', 2);

insert into categories(id, name, ordering) values(3, 'Lager', 3);
insert into categories(id, name, ordering) values(4, 'Stout', 4);
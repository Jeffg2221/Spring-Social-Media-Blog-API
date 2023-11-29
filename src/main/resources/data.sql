drop table if exists message;
drop table if exists account;
create table account (
    account_id int primary key auto_increment,
    username varchar(255) unique,
    password varchar(255)
);
create table message (
    message_id int primary key auto_increment,
    posted_by int,
    message_text varchar(255),
    time_posted_epoch bigint,
    foreign key (posted_by) references  account(account_id)
);

insert into account (username, password) values ('testuser1', 'password');
insert into account (username, password) values ('testuser2', 'password');
insert into account (username, password) values ('testuser3', 'password');
insert into account (username, password) values ('testuser4', 'password');

insert into message (posted_by, message_text, time_posted_epoch) values (1,'test message 1',1669947792);
insert into message (posted_by, message_text, time_posted_epoch) values (1,'This is a test message',1669947792);
insert into message (posted_by, message_text, time_posted_epoch) values (2,'This message is being used for testing',1669947792);
insert into message (posted_by, message_text, time_posted_epoch) values (3,'test message 2',1669947792);
insert into message (posted_by, message_text, time_posted_epoch) values (4,'testing messages to make sure the queries are working properly',1669947792);
insert into message (posted_by, message_text, time_posted_epoch) values (4,'test message 3',1669947792);
insert into message (posted_by, message_text, time_posted_epoch) values (1,'test message 4',1669947792);



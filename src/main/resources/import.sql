-- Insert role
insert into role (name) values ('ROLE_USER');

-- Insert two users (passwords are both 'password')
insert into user (username,enabled,password,role_id) values ('user',true,'$2a$10$TAP9HaMPxaKzN7qkl6/RbOjDtOEs8nF4A0FSF6bG/rtUX.b0n1lt.',1);
insert into user (username,enabled,password,role_id) values ('user2',true,'$2a$10$TAP9HaMPxaKzN7qkl6/RbOjDtOEs8nF4A0FSF6bG/rtUX.b0n1lt.',1);
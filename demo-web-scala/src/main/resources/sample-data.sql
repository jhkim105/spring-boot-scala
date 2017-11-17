
-- t_user START
INSERT INTO t_user (id,name,password,username,email) VALUES (-1,'User','111111','user','user@rsupport.com');
INSERT INTO t_user (id,name,password,username,email) VALUES (-2,'Admin','111111','admin','admin@rsupport.com');
-- t_user END

-- t_user_authorities START
INSERT INTO t_user_authorities (user_id,authority) VALUES (-1,'USER');
INSERT INTO t_user_authorities (user_id,authority) VALUES (-2,'ADMIN');
-- t_user_authorities END


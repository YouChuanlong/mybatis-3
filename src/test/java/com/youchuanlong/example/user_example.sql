--
--    Copyright 2009-2018 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

DROP TABLE user
  IF EXISTS;



CREATE TABLE user (
    id     INT NOT NULL ,
    username varchar(20)
);

INSERT INTO user values(1,'ZhangSan');
INSERT INTO user values(2,'LiSi');
INSERT INTO user values(3,'WangWu');
INSERT INTO user values(4,'ZhaoLiu');
INSERT INTO user values(5,'RyanYou');

create table car (
    id  int not null ,
    plate varchar(20),
    color varchar(20),
    user_id int not null
);


INSERT INTO car values(1,'京A88888','red',1);
INSERT INTO car values(2,'京B88888','blue',1);
INSERT INTO car values(3,'京C88888','yellow',2);
INSERT INTO car values(4,'京D88888','green',2);
INSERT INTO car values(5,'京E88888','black',3);
INSERT INTO car values(6,'京F88888','white',3);
INSERT INTO car values(7,'京G88888','red',4);
INSERT INTO car values(8,'京H88888','blue',4);
INSERT INTO car values(9,'京I88888','yellow',5);
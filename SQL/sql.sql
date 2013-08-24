DELETE FROM `xindervella_VirtualCampus`.`vcUser` WHERE `uID`='213110564';

INSERT INTO `xindervella_VirtualCampus`.`vcUser` (`uID`, `uPwd`, `uRole`) VALUES ('213110561', '123456', 'student');

UPDATE `xindervella_VirtualCampus`.`vcUser` SET `uPwd`='1' WHERE `uID`='213110561';

SELECT * FROM vcStudent INNER JOIN vcClass ON sClassID=cClassID;

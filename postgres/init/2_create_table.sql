-- アカウントマスタ
--* RestoreFromTempTable
create table MST_ACCOUNTS3 (
  LOGIN_ID character varying(20) not null
  , PASSWORD TEXT not null
  , NAME_SEI character varying(20) not null
  , NAME_MEI character varying(20) not null
  , NAME_KANA_SEI character varying(60) not null
  , NAME_KANA_MEI character varying(60) not null
  , ROLE_ID character varying(20) not null
  , MAIL_ADDRESS character varying(60) not null
  , DELETE_FLAG VARCHAR(1) not null
  , CREATE_PRG_ID VARCHAR(64) not null
  , CREATE_USER_ID VARCHAR(64) not null
  , CREATE_DATETIME TIMESTAMP not null
  , UPDATE_PRG_ID VARCHAR(64) not null
  , UPDATE_USER_ID VARCHAR(64) not null
  , UPDATE_DATETIME TIMESTAMP not null
  , constraint MST_ACCOUNTS3_PKC primary key (LOGIN_ID)
) ;

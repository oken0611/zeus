--ROLE作成
CREATE ROLE dev01 WITH LOGIN PASSWORD 'dev01';
--DATABASE作成
CREATE DATABASE dev01;
--DATABASE所有者変更
ALTER DATABASE dev01 OWNER TO dev01;
--ユーザーにDBの権限をまとめて付与
GRANT ALL PRIVILEGES ON DATABASE dev01 TO dev01;

--ユーザーを切り替え
\connect dev01 dev01

-- アカウントマスタ
--* RestoreFromTempTable
create table MST_ACCOUNTS (
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
  , constraint MST_ACCOUNTS_PKC primary key (LOGIN_ID)
) ;

comment on table MST_ACCOUNTS is 'アカウントマスタ';
comment on column MST_ACCOUNTS.LOGIN_ID is 'ログインID';
comment on column MST_ACCOUNTS.PASSWORD is 'パスワード';
comment on column MST_ACCOUNTS.NAME_SEI is '氏名（性）';
comment on column MST_ACCOUNTS.NAME_MEI is '氏名（名）';
comment on column MST_ACCOUNTS.NAME_KANA_SEI is '氏名カナ（性）';
comment on column MST_ACCOUNTS.NAME_KANA_MEI is '氏名カナ（名）';
comment on column MST_ACCOUNTS.ROLE_ID is 'ロールID';
comment on column MST_ACCOUNTS.MAIL_ADDRESS is 'メールアドレス';
comment on column MST_ACCOUNTS.DELETE_FLAG is '論理削除フラグ';
comment on column MST_ACCOUNTS.CREATE_PRG_ID is '作成プログラムID';
comment on column MST_ACCOUNTS.CREATE_USER_ID is '作成者ID';
comment on column MST_ACCOUNTS.CREATE_DATETIME is '作成日時';
comment on column MST_ACCOUNTS.UPDATE_PRG_ID is '更新プログラムID';
comment on column MST_ACCOUNTS.UPDATE_USER_ID is '更新者ID';
comment on column MST_ACCOUNTS.UPDATE_DATETIME is '更新日時';

ALTER TABLE stores
ADD COLUMN phone_number varchar(11) not null;

ALTER TABLE stores
DROP COLUMN photo_url;
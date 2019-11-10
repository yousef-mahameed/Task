
INSERT INTO manufacturers (name, created_on)
  VALUES
  ('man1', CURRENT_TIME()),
  ('man2', CURRENT_TIME());

INSERT INTO cars (license_plate, manufacturer_id, seat_count, convertible, engine_type, rating, selected, created_on)
  VALUES
  ('abc-123-asd', 1, 5 , 1, 'gas' , 9.5, false, CURRENT_TIME()),
  ('abc-124-asd', 1, 5 , 1, 'gas' , 9.5, false, CURRENT_TIME()),
  ('abc-125-asd', 1, 5 , 1, 'gas' , 9.5, false, CURRENT_TIME()),
  ('abc-126-asd', 1, 5 , 1, 'gas' , 9.5, false, CURRENT_TIME());
CREATE TABLE doctor (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) not null ,
                        bmdc_no VARCHAR(20) unique not null
);

CREATE TABLE patient (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) not null ,
                         phone VARCHAR(20) unique not null
);

CREATE TABLE generic (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) unique not null

);

CREATE TABLE vendor (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) not null
);


CREATE TABLE brand (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255) not null ,
                      description TEXT,
                      generic_id INT,
                      vendor_id INT,
                      FOREIGN KEY (generic_id) REFERENCES generic(id),
                      FOREIGN KEY (vendor_id) REFERENCES vendor(id)
);

CREATE TABLE prescription (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              patient_id INT,
                              doctor_id INT,
                              location_id INT,
                              FOREIGN KEY (patient_id) REFERENCES patient(id),
                              FOREIGN KEY (doctor_id) REFERENCES doctor(id),
                              FOREIGN KEY (location_id) REFERENCES location(id)
);



CREATE TABLE location (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) unique not null ,
                          latitude DOUBLE unique not null ,
                          longitude DOUBLE unique not null
);




CREATE TABLE prescription_brand (
                                    brand_id INT,
                                    prescription_id INT,
                                   PRIMARY KEY (prescription_id, brand_id),
                                   FOREIGN KEY (prescription_id) REFERENCES prescription(id),
                                   FOREIGN KEY (brand_id) REFERENCES brand (id)
);

CREATE TABLE brand_prescription (
                                    brand_id    BIGINT NOT NULL,
                                    prescription_id BIGINT NOT NULL,
                                    CONSTRAINT pk_brand_prescription PRIMARY KEY (brand_id, prescription_id),
                                    CONSTRAINT fk_brand_id FOREIGN KEY (brand_id) REFERENCES brand(id),
                                    CONSTRAINT fk_prescription_id FOREIGN KEY (prescription_id) REFERENCES prescription(id)
);


INSERT INTO location (name, latitude, longitude) VALUES
                                             ('Gulshan-1', 23.7806615, 90.4112899),
                                             ('Banani', 23.7947552, 90.3954059),
                                             ('Dhanmondi', 23.7470303, 90.3655623),
                                             ('Mirpur-1', 23.7945624, 90.3435587),
                                             ('Uttara', 23.8766322, 90.3576884);




INSERT INTO generic (name) VALUES
                               ('Aceclofenac'),
                               ('Ambroxol-Hydrochloride'),
                               ('Amlodipine-Besylate'),
                               ('Amlodipine-Besylate-+-Atenolol'),
                               ('Amlodipine-+-Telmisartan'),
                               ('Amoxicillin-+-Clavulanic-Acid'),
                               ('Atorvastatin'),
                               ('Azithromycin'),
                               ('Baclofen'),
                               ('Bilastine'),
                               ('Bisoprolol'),
                               ('Butamirate-Citrate'),
                               ('Calcium-Carbonate-&-vitamin-D3'),
                               ('Calcium-(Coral-source)-+-Vitamin-D3'),
                               ('Calcium-Orotate'),
                               ('Carbonyl-Iron_Folic-Acid_Zinc-Sulphate'),
                               ('Cefepime');



INSERT INTO vendor (name) VALUES
                               ('ACI-Limited'),
                               ('ACME-Laboratories-Ltd'),
                               ('Ad-din-Pharmaceuticals-Ltd'),
                               ('Aexim-Pharmaceuticals-Ltd'),
                               ('Al-Madina-Pharmaceuticals-Ltd'),
                               ('Albion-Laboratories-Limited'),
                               ('Alco-Pharma-Ltd'),
                               ('Alien-Pharma'),
                               ('Alkad-Laboratories'),
                               ('Allied-Pharmaceuticals-Ltd'),
                               ('Ambee-Pharmaceuticals-Ltd'),
                               ('Amico-Laboratories-Ltd'),
                               ('Amulet-Pharmaceuticals-Ltd'),
                               ('APC-Pharma-Ltd');



INSERT INTO doctor (name, bmdc_no) VALUES
                                    ('Dr. Ashraful Islam', FLOOR(RAND() * (9999 - 1000 + 1)) + 1000),
                                    ('Dr. Zahid Hossain', FLOOR(RAND() * (9999 - 1000 + 1)) + 1000),
                                    ('Dr. Omar Ahmed', FLOOR(RAND() * (9999 - 1000 + 1)) + 1000),
                                    ('Dr. Rafi Khan', FLOOR(RAND() * (9999 - 1000 + 1)) + 1000),
                                    ('Dr. Anwar Ali', FLOOR(RAND() * (9999 - 1000 + 1)) + 1000),
                                    ('Dr. Alam Rahman', FLOOR(RAND() * (9999 - 1000 + 1)) + 1000),
                                    ('Dr. Shahid Karim', FLOOR(RAND() * (9999 - 1000 + 1)) + 1000),
                                    ('Dr. Rubel Uddin', FLOOR(RAND() * (9999 - 1000 + 1)) + 1000),
                                    ('Dr. Reza Miah', FLOOR(RAND() * (9999 - 1000 + 1)) + 1000),
                                    ('Dr. Hasan Chowdhury', FLOOR(RAND() * (9999 - 1000 + 1)) + 1000);

INSERT INTO patient (name, phone)
VALUES
    ('John Doe', '01234567890'),
    ('Alice Smith', '09876543210'),
    ('Bob Johnson', '05551234567'),
    ('Emily Brown', '05559876543'),
    ('Michael Wilson', '09998887776'),
    ('Emma Lee', '01239874560'),
    ('William Taylor', '07894561230'),
    ('Olivia Martinez', '09517534680'),
    ('James Anderson', '04561237890'),
    ('Sophia Garcia', '03692581470'),
    ('Alexander Hernandez', '07539518520'),
    ('Mia Lopez', '03216549870'),
    ('Ethan Perez', '06543219870'),
    ('Charlotte Gonzalez', '02589631470'),
    ('Daniel Ramirez', '07896541230'),
    ('Amelia Torres', '09638527410'),
    ('Matthew Flores', '01472583690'),
    ('Harper Diaz', '01593578520'),
    ('Henry Rivera', '03579514560'),
    ('Ava Cruz', '08529637410');


INSERT INTO prescription (patient_id, doctor_id, location_id)
VALUES
    (2419, 1),
    (2419, 1),
    (2419, 1),
    (2419, 1),
    (2419, 1),
    (2419, 1),
    (2419, 1),
    (2419, 1),
    (2419, 1),
    (2419, 1);

INSERT INTO brand (name,description,vendor_id, generic_id) VALUES
                                                                     ('Indever', NULL, 1, NULL),
                                                                     ('Abetis', NULL, 1, NULL),
                                                                     ('Feglo-FZ', NULL, 1, NULL),
                                                                     ('Cora-DX', NULL, 1, NULL),
                                                                     ('Acical-D', NULL, 1, NULL),
                                                                     ('Reversair', NULL,  1, NULL),
                                                                     ('Xeldrin', NULL, 1, NULL),
                                                                     ('Artica', NULL, 1, NULL),
                                                                     ('Hexisol', NULL,  1, NULL),
                                                                     ('Paricel', NULL,  1, NULL),
                                                                     ('Gabarol-CR', NULL, 1, NULL),
                                                                     ('Atasin', NULL, 1, NULL),
                                                                     ('Micoral-Gel', NULL, 1, NULL);

INSERT INTO prescription (patient_id,doctor_id,location_id)
VALUES (1, 1,1 ),
       (1, 1,1),
       (1, 1,1),
       (1, 1,1),
       (1, 1,1),
       (1, 1,1),
       (1, 1,1),
       (1, 1,1),
       (1, 1,1);

INSERT INTO prescription_brand (brand_id, prescription_id) VALUES
                                                               (1,1),
                                                               (2,1),
                                                               (3,1),
                                                               (4,1);




select count(*) from prescription_brand join prescription on prescription_brand.prescription_id = prescription.id
where brand_id = 1 and location_id = 1;




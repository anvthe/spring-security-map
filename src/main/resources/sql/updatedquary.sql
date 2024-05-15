

CREATE TABLE users (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         firstname VARCHAR(255) not null ,
                         lastname VARCHAR(255) not null ,
                         email VARCHAR(255) unique not null,
                         password VARCHAR(48) not null ,
                         role VARCHAR(20)
);


CREATE TABLE doctors (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) not null ,
                        bmdc_no VARCHAR(20) unique not null
);

CREATE TABLE patients (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) not null ,
                         phone VARCHAR(20) unique not null
);

CREATE TABLE generics (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) unique not null

);

CREATE TABLE vendors (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) not null
);


CREATE TABLE drugs (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255) not null ,
                      description TEXT,
                      generic_id INT,
                      vendor_id INT,
                      FOREIGN KEY (generic_id) REFERENCES generics(id),
                      FOREIGN KEY (vendor_id) REFERENCES vendors(id)
);

CREATE TABLE prescriptions (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              doctor_id INT,
                              patient_id INT,
                              location_id INT,
                              FOREIGN KEY (doctor_id) REFERENCES doctors(id),
                              FOREIGN KEY (patient_id) REFERENCES patients(id),
                              FOREIGN KEY (location_id) REFERENCES locations(id)
);



CREATE TABLE locations (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) unique not null ,
                          latitude DOUBLE unique not null ,
                          longitude DOUBLE unique not null
);




CREATE TABLE prescription_drugs (   id INT AUTO_INCREMENT PRIMARY KEY,
                                    prescription_id INT,
                                    drug_id INT,

                                   FOREIGN KEY (prescription_id) REFERENCES prescriptions(id),
                                   FOREIGN KEY (drug_id) REFERENCES drugs(id)
);




INSERT INTO locations (location_name, latitude, longitude) VALUES
                                             ('Gulshan-1', 23.7806615, 90.4112899),
                                             ('Banani', 23.7947552, 90.3954059),
                                             ('Dhanmondi', 23.7470303, 90.3655623),
                                             ('Mirpur-1', 23.7945624, 90.3435587),
                                             ('Uttara', 23.8766322, 90.3576884);




INSERT INTO generics (name) VALUES
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



INSERT INTO vendors (name) VALUES
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



INSERT INTO doctors (name, doctor_bmdc) VALUES
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

INSERT INTO patients (name, phone)
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


INSERT INTO prescriptions (doctor_id, patient_id, location_id)
VALUES
    (1, 1, 1),
    (2, 3, 1),
    (4, 2, 1),
    (3, 5, 2),
    (7, 6, 2),
    (3, 10, 2),
    (5, 8, 3),
    (1, 11, 3);



INSERT INTO drugs (drug_name, description, vendor_id, generic_id) VALUES
                                                                     ('Indever', n/a, 1, 1),
                                                                     ('Abetis', n/a, 1, 1),
                                                                     ('Feglo-FZ', n/a, 1, 1),
                                                                     ('Cora-DX', n/a, 1, 1),
                                                                     ('Acical-D', n/a, 2, 2),
                                                                     ('Reversair', n/a, 2, 2),
                                                                     ('Xeldrin', n/a, 2, 2),
                                                                     ('Artica', n/a, 3, 3),
                                                                     ('Hexisol', n/a, 3, 3),
                                                                     ('Paricel', n/a, 3, 3),
                                                                     ('Gabarol-CR', n/a, 4, 4),
                                                                     ('Atasin', n/a, 4, 4),
                                                                     ('Micoral-Gel', n/a, 4, 4);









/*    @Query("SELECT COUNT(p) FROM Prescription p JOIN p.drugs d JOIN p.location l WHERE d.drugName LIKE %:drugName% AND l.locationName LIKE %:locationName%")
    Long countPrescriptionsByDrugNameAndLocationName(@Param("drugName") String drugName, @Param("locationName") String locationName);*/

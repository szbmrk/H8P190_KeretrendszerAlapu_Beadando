CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       role ENUM('ADMIN', 'DOCTOR', 'PHARMACIST') NOT NULL,
                       created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE patients (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          first_name VARCHAR(255) NOT NULL,
                          last_name VARCHAR(255) NOT NULL,
                          date_of_birth DATE NOT NULL,
                          address TEXT,
                          created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE appointments (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              patient_id INT NOT NULL,
                              doctor_id INT NOT NULL,
                              appointment_date DATETIME NOT NULL,
                              status ENUM('SCHEDULED', 'COMPLETED', 'CANCELED') DEFAULT 'SCHEDULED',
                              notes TEXT,
                              FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE CASCADE,
                              FOREIGN KEY (doctor_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE prescriptions (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               appointment_id INT NOT NULL,
                               prescription_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                               details TEXT NOT NULL,
                               FOREIGN KEY (appointment_id) REFERENCES appointments(id) ON DELETE CASCADE
);

CREATE TABLE medications (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             prescription_id INT NOT NULL,
                             name VARCHAR(255) NOT NULL,
                             quantity INT NOT NULL,
                             pharmacist_id INT NOT NULL,
                             prescribed_date DATETIME,
                             FOREIGN KEY (prescription_id) REFERENCES prescriptions(id) ON DELETE CASCADE,
                             FOREIGN KEY (pharmacist_id) REFERENCES users(id) ON DELETE CASCADE
);

INSERT INTO users (username, password, email, role)
VALUES ('admin', 'admin', 'admin@example.com', 'ADMIN');

INSERT INTO users (username, password, email, role)
VALUES
    ('doc1', 'password123', 'doc1@example.com', 'DOCTOR'),
    ('doc2', 'password123', 'doc2@example.com', 'DOCTOR');

INSERT INTO users (username, password, email, role)
VALUES
    ('pharm1', 'password123', 'pharm1@example.com', 'PHARMACIST'),
    ('pharm2', 'password123', 'pharm2@example.com', 'PHARMACIST');

INSERT INTO patients (first_name, last_name, date_of_birth, address)
VALUES
    ('John', 'Doe', '1985-07-20', '123 Main St'),
    ('Jane', 'Smith', '1990-10-15', '456 Elm St');

INSERT INTO appointments (patient_id, doctor_id, appointment_date, status, notes)
VALUES
    (1, 2, '2024-12-15 10:00:00', 'SCHEDULED', 'Routine check-up'),
    (2, 3, '2024-12-16 11:00:00', 'SCHEDULED', 'Follow-up visit');

INSERT INTO prescriptions (appointment_id, prescription_date, details)
VALUES
    (1, '2024-12-15 11:00:00', 'Take one tablet daily.'),
    (2, '2024-12-16 12:00:00', 'Apply ointment twice a day.');

INSERT INTO medications (prescription_id, name, quantity, pharmacist_id, prescribed_date)
VALUES
    (1, 'Paracetamol', 10, 4, '2024-12-15 13:00:00'),
    (2, 'Antibiotic Cream', 2, 5, '2024-12-16 14:00:00');
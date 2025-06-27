CREATE TABLE table_log (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    currency VARCHAR(3) NOT NULL,
    start DATE NOT NULL,
    end DATE NOT NULL,
    curr_time DATETIME NOT NULL
);
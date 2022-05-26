CREATE TABLE contactus
(
    id      INT AUTO_INCREMENT NOT NULL,
    name    VARCHAR(100) NULL,
    email   VARCHAR(200) NULL,
    subject VARCHAR(300) NULL,
    message VARCHAR(1000) NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE news
(
    id      INT AUTO_INCREMENT NOT NULL,
    name    VARCHAR(100) NULL,
    content VARCHAR(1000) NULL,
    date    VARCHAR(50) NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE prediction
(
    id            INT AUTO_INCREMENT NOT NULL,
    type          VARCHAR(50) NULL,
    date          VARCHAR(50) NULL,
    `description` VARCHAR(300) NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE purchasedetail
(
    id              INT AUTO_INCREMENT NOT NULL,
    subscription_id INT NULL,
    status          VARCHAR(20) NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE stats
(
    id             INT AUTO_INCREMENT NOT NULL,
    name           VARCHAR(100) NULL,
    type           VARCHAR(50) NULL,
    started_at     VARCHAR(100) NULL,
    ended_at       VARCHAR(100) NULL,
    win_count      INT NULL,
    lose_count     INT NULL,
    refund_count   INT NULL,
    win_percent    DOUBLE NULL,
    min_coef       DOUBLE NULL,
    max_coef       DOUBLE NULL,
    average_coef   DOUBLE NULL,
    profit         DOUBLE NULL,
    profit_percent DOUBLE NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE subscription
(
    id         INT AUTO_INCREMENT NOT NULL,
    type       VARCHAR(50) NULL,
    user_id    INT NULL,
    started_at VARCHAR(100) NULL,
    ended_at   VARCHAR(100) NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE user
(
    id       INT AUTO_INCREMENT NOT NULL,
    username VARCHAR(100) NULL,
    password VARCHAR(100) NULL,
    email    VARCHAR(100) NULL,
    `role`   VARCHAR(100) NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

ALTER TABLE purchasedetail
    ADD CONSTRAINT purchasedetail_ibfk_1 FOREIGN KEY (subscription_id) REFERENCES subscription (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

CREATE INDEX subscription_id ON purchasedetail (subscription_id);

ALTER TABLE subscription
    ADD CONSTRAINT subscription_ibfk_1 FOREIGN KEY (user_id) REFERENCES user (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

CREATE INDEX user_id ON subscription (user_id);
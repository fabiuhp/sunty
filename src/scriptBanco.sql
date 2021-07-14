CREATE DATABASE sunty;

USE sunty;

CREATE TABLE IF NOT EXISTS instructor
(
    id   INT          NOT NULL AUTO_INCREMENT,
    name VARCHAR(250) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE
);

CREATE TABLE IF NOT EXISTS category
(
    id               INT          NOT NULL AUTO_INCREMENT,
    name             VARCHAR(250) NOT NULL,
    urlCode          VARCHAR(250) NOT NULL,
    shortDescription VARCHAR(250),
    guideText        VARCHAR(500) NULL,
    isActive         TINYINT      NOT NULL,
    orderToShow      TINYINT(250) NOT NULL,
    pathImg          VARCHAR(250) NOT NULL,
    hexHtmlColor     VARCHAR(7)   NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE,
    UNIQUE INDEX urlCode_UNIQUE (urlCode ASC) VISIBLE
);

CREATE TABLE IF NOT EXISTS sub_category
(
    id               INT          NOT NULL AUTO_INCREMENT,
    name             VARCHAR(250) NOT NULL,
    urlCode          VARCHAR(250) NOT NULL,
    shortDescription VARCHAR(250),
    guideText        VARCHAR(500) NULL,
    isActive         BOOLEAN      NOT NULL,
    orderToShow      TINYINT(250) NOT NULL,
    category_id      INT          NOT NULL,
    PRIMARY KEY (id, category_id),
    INDEX fk_sub_category_category_idx (category_id ASC) VISIBLE,
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE,
    UNIQUE INDEX urlCode_UNIQUE (urlCode ASC) VISIBLE,
    CONSTRAINT fk_sub_category_category
        FOREIGN KEY (category_id)
            REFERENCES category (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS course
(
    id                  INT          NOT NULL AUTO_INCREMENT,
    name                VARCHAR(250) NOT NULL,
    urlCode             VARCHAR(250) NOT NULL,
    timeToFinishInHours TINYINT(50)  NOT NULL,
    visibility          VARCHAR(100) NOT NULL,
    targetAudience      VARCHAR(500) NOT NULL,
    syllabus            TEXT         NOT NULL,
    developedSkills     VARCHAR(500) NOT NULL,
    instructor_id       INT          NOT NULL,
    sub_category_id     INT          NOT NULL,
    PRIMARY KEY (id, instructor_id, sub_category_id),
    INDEX fk_course_instructor_idx (instructor_id ASC) VISIBLE,
    INDEX fk_course_sub_category_idx (sub_category_id ASC) VISIBLE,
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE,
    UNIQUE INDEX urlCode_UNIQUE (urlCode ASC) VISIBLE,
    CONSTRAINT fk_course_instructor
        FOREIGN KEY (instructor_id)
            REFERENCES instructor (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT fk_course_sub_category
        FOREIGN KEY (sub_category_id)
            REFERENCES sub_category (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS section
(
    id          INT          NOT NULL AUTO_INCREMENT,
    name        VARCHAR(250) NOT NULL,
    urlCode     VARCHAR(250) NOT NULL,
    orderToShow TINYINT(250) NULL,
    isExam      BOOLEAN      NULL,
    isActive    BOOLEAN      NULL,
    course_id   INT          NOT NULL,
    PRIMARY KEY (id, course_id),
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE,
    UNIQUE INDEX urlCode_UNIQUE (urlCode ASC) VISIBLE,
    INDEX fk_section_course_idx (course_id ASC) VISIBLE,
    CONSTRAINT fk_section_course
        FOREIGN KEY (course_id)
            REFERENCES course (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS explanation
(
    id          INT          NOT NULL AUTO_INCREMENT,
    name        VARCHAR(250) NOT NULL,
    urlCode     VARCHAR(250) NOT NULL,
    isActive    VARCHAR(45)  NULL,
    orderToShow VARCHAR(45)  NULL,
    text        VARCHAR(500) NOT NULL,
    section_id  INT          NOT NULL,
    PRIMARY KEY (id, section_id),
    INDEX fk_explanation_section_idx (section_id ASC) VISIBLE,
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE,
    UNIQUE INDEX urlCode_UNIQUE (urlCode ASC) VISIBLE,
    CONSTRAINT fk_explanation_section
        FOREIGN KEY (section_id)
            REFERENCES section (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS question
(
    id           INT          NOT NULL AUTO_INCREMENT,
    name         VARCHAR(250) NOT NULL,
    urlCode      VARCHAR(250) NOT NULL,
    isActive     VARCHAR(45)  NULL,
    orderToShow  VARCHAR(45)  NULL,
    description  VARCHAR(250) NOT NULL,
    questionType VARCHAR(45)  NOT NULL,
    section_id   INT          NOT NULL,
    PRIMARY KEY (id, section_id),
    INDEX fk_question_section_idx (section_id ASC) VISIBLE,
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE,
    UNIQUE INDEX urlCode_UNIQUE (urlCode ASC) VISIBLE,
    CONSTRAINT fk_question_section
        FOREIGN KEY (section_id)
            REFERENCES section (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS video
(
    id            INT          NOT NULL AUTO_INCREMENT,
    name          VARCHAR(250) NOT NULL,
    urlCode       VARCHAR(250) NOT NULL,
    isActive      VARCHAR(45)  NULL,
    orderToShow   VARCHAR(45)  NULL,
    url           VARCHAR(250) NOT NULL,
    time          VARCHAR(45)  NULL,
    transcription VARCHAR(45)  NULL,
    section_id    INT          NOT NULL,
    PRIMARY KEY (id, section_id),
    INDEX fk_video_section_idx (section_id ASC) VISIBLE,
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE,
    UNIQUE INDEX urlCode_UNIQUE (urlCode ASC) VISIBLE,
    CONSTRAINT fk_video_section
        FOREIGN KEY (section_id)
            REFERENCES section (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS alternative
(
    id            INT UNSIGNED NOT NULL AUTO_INCREMENT,
    explanation   VARCHAR(250) NOT NULL,
    orderToShow   VARCHAR(45)  NULL,
    isCorrect     BOOLEAN      NOT NULL,
    justification VARCHAR(45)  NULL,
    question_id   INT          NOT NULL,
    PRIMARY KEY (id, question_id),
    INDEX fk_alternative_question_idx (question_id ASC) VISIBLE,
    CONSTRAINT fk_alternative_question
        FOREIGN KEY (question_id)
            REFERENCES question (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

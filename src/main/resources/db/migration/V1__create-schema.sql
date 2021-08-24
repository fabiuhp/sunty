CREATE TABLE IF NOT EXISTS instructor
(
    id   BIGINT       NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE
);

CREATE TABLE IF NOT EXISTS category
(
    id               BIGINT       NOT NULL AUTO_INCREMENT,
    name             VARCHAR(255) NOT NULL,
    urlCode          VARCHAR(255) NOT NULL,
    shortDescription VARCHAR(255) NULL,
    guideText        VARCHAR(255) NULL,
    active         BIT(1)       NOT NULL,
    orderToShow      INT          NULL,
    pathImg          VARCHAR(255) NULL,
    hexHtmlColor     VARCHAR(7)   NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE,
    UNIQUE INDEX urlCode_UNIQUE (urlCode ASC) VISIBLE
);

CREATE TABLE IF NOT EXISTS sub_category
(
    id               BIGINT       NOT NULL AUTO_INCREMENT,
    name             VARCHAR(255) NOT NULL,
    urlCode          VARCHAR(255) NOT NULL,
    shortDescription VARCHAR(255) NULL,
    guideText        VARCHAR(500) NULL,
    active         BIT(1)       NOT NULL,
    orderToShow      INT          NULL,
    category_id      BIGINT       NOT NULL,
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
    id                  BIGINT       NOT NULL AUTO_INCREMENT,
    name                VARCHAR(255) NOT NULL,
    urlCode             VARCHAR(255) NOT NULL,
    timeToFinishInHours INT          NOT NULL,
    visibility          VARCHAR(255) NULL,
    targetAudience      VARCHAR(500) NULL,
    syllabus            TEXT         NULL,
    developedSkills     TEXT         NULL,
    instructor_id       BIGINT       NOT NULL,
    subcategory_id      BIGINT       NOT NULL,
    PRIMARY KEY (id, instructor_id, subcategory_id),
    INDEX fk_course_instructor_idx (instructor_id ASC) VISIBLE,
    INDEX fk_course_subcategory_idx (subcategory_id ASC) VISIBLE,
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE,
    UNIQUE INDEX urlCode_UNIQUE (urlCode ASC) VISIBLE,
    CONSTRAINT fk_course_instructor
        FOREIGN KEY (instructor_id)
            REFERENCES instructor (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT fk_course_sub_category
        FOREIGN KEY (subcategory_id)
            REFERENCES sub_category (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS section
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL,
    urlCode     VARCHAR(255) NOT NULL,
    orderToShow INT NULL,
    isExam      BOOLEAN      NULL,
    isActive    BOOLEAN      NULL,
    course_id   BIGINT       NOT NULL,
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
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL,
    urlCode     VARCHAR(255) NOT NULL,
    isActive    VARCHAR(45)  NULL,
    orderToShow INT  NULL,
    text        VARCHAR(500) NOT NULL,
    section_id  BIGINT       NOT NULL,
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
    id           BIGINT       NOT NULL AUTO_INCREMENT,
    name         VARCHAR(255) NOT NULL,
    urlCode      VARCHAR(255) NOT NULL,
    isActive     VARCHAR(45)  NULL,
    orderToShow  INT  NULL,
    description  VARCHAR(255) NOT NULL,
    questionType VARCHAR(45)  NOT NULL,
    section_id   BIGINT       NOT NULL,
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
    id            BIGINT       NOT NULL AUTO_INCREMENT,
    name          VARCHAR(255) NOT NULL,
    urlCode       VARCHAR(255) NOT NULL,
    isActive      VARCHAR(45)  NULL,
    orderToShow   INT  NULL,
    url           VARCHAR(255) NOT NULL,
    time          VARCHAR(45)  NULL,
    transcription VARCHAR(45)  NULL,
    section_id    BIGINT       NOT NULL,
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
    id            BIGINT       NOT NULL AUTO_INCREMENT,
    explanation   VARCHAR(255) NOT NULL,
    orderToShow   INT  NULL,
    isCorrect     BOOLEAN      NOT NULL,
    justification VARCHAR(45)  NULL,
    question_id   BIGINT       NOT NULL,
    PRIMARY KEY (id, question_id),
    INDEX fk_alternative_question_idx (question_id ASC) VISIBLE,
    CONSTRAINT fk_alternative_question
        FOREIGN KEY (question_id)
            REFERENCES question (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);


CREATE TABLE IF NOT EXISTS section
(
    id          BIGINT          NOT NULL AUTO_INCREMENT,
    name        VARCHAR(250) NOT NULL,
    urlCode     VARCHAR(250) NOT NULL,
    orderToShow INT NULL,
    isExam      BOOLEAN      NULL,
    isActive    BOOLEAN      NULL,
    course_id   BIGINT          NOT NULL,
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
    id          BIGINT          NOT NULL AUTO_INCREMENT,
    name        VARCHAR(250) NOT NULL,
    urlCode     VARCHAR(250) NOT NULL,
    isActive    VARCHAR(45)  NULL,
    orderToShow INT  NULL,
    text        VARCHAR(500) NOT NULL,
    section_id  BIGINT          NOT NULL,
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
    id           BIGINT          NOT NULL AUTO_INCREMENT,
    name         VARCHAR(250) NOT NULL,
    urlCode      VARCHAR(250) NOT NULL,
    isActive     VARCHAR(45)  NULL,
    orderToShow  INT  NULL,
    description  VARCHAR(250) NOT NULL,
    questionType VARCHAR(45)  NOT NULL,
    section_id   BIGINT          NOT NULL,
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
    id            BIGINT          NOT NULL AUTO_INCREMENT,
    name          VARCHAR(250) NOT NULL,
    urlCode       VARCHAR(250) NOT NULL,
    isActive      VARCHAR(45)  NULL,
    orderToShow   INT  NULL,
    url           VARCHAR(250) NOT NULL,
    time          VARCHAR(45)  NULL,
    transcription VARCHAR(45)  NULL,
    section_id    BIGINT          NOT NULL,
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
    id            BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    explanation   VARCHAR(250) NOT NULL,
    orderToShow   INT  NULL,
    isCorrect     BOOLEAN      NOT NULL,
    justification VARCHAR(45)  NULL,
    question_id   BIGINT          NOT NULL,
    PRIMARY KEY (id, question_id),
    INDEX fk_alternative_question_idx (question_id ASC) VISIBLE,
    CONSTRAINT fk_alternative_question
        FOREIGN KEY (question_id)
            REFERENCES question (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS user
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE
);

CREATE TABLE IF NOT EXISTS profile
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(250) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE
);

CREATE TABLE IF NOT EXISTS user_profile
(
    user_id BIGINT NOT NULL,
    profile_id BIGINT NOT NULL
);
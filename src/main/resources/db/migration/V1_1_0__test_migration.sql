CREATE TABLE MsCompany (
    CompanyID CHAR(36) PRIMARY KEY,            -- UUID stored as a string with 36 characters
    Name VARCHAR(255) NOT NULL,        -- Company name, not nullable
    LogoURL VARCHAR(2048),             -- URL or path to the company logo
    Description TEXT,                  -- Company description, can be of variable length
    Location VARCHAR(255),             -- Company location
    UNIQUE KEY UQ_Name (Name),        -- Unique constraint on the Name column
    CONSTRAINT CK_Description_NotEmpty CHECK (CHAR_LENGTH(Description) > 0 OR Description IS NULL)  -- Check constraint for Description
);

CREATE TABLE Student (
    StudentID CHAR(36) PRIMARY KEY,
    NIM VARCHAR(50),
    StudentName VARCHAR(100),
    Email VARCHAR(100) NOT NULL,
    PhoneNumber VARCHAR(15) NULL,
    DateOfBirth DATE NULL,
    Major VARCHAR(50) NULL,
    Address VARCHAR(100) NULL,
    City VARCHAR(50) NULL,
    State VARCHAR(50) NULL,
    ProfilePictureLink VARCHAR(50) NULL,
    ProfileDescription TEXT,
    PersonalLink VARCHAR(100) NULL
);

CREATE TABLE JobType (
    JobTypeID CHAR(36) PRIMARY KEY,
    JobTypeName VARCHAR(50) NOT NULL
);

CREATE TABLE Skill (
    SkillID CHAR(36) PRIMARY KEY,
    SkillName VARCHAR(100) NOT NULL
);

CREATE TABLE JobVacancy (
    JobVacancyID CHAR(36) PRIMARY KEY,
    CompanyID CHAR(36),
    JobTypeID CHAR(36),
    Timestamp DATE,
    JobPosition VARCHAR(50),
    EndDatetime DATE,
    JobDescription VARCHAR(100),
    Location VARCHAR(50),
    SalaryRange VARCHAR(50),
    WorkTimeType VARCHAR(50),
    FOREIGN KEY (CompanyID) REFERENCES MsCompany(CompanyID),
    FOREIGN KEY (JobTypeID) REFERENCES JobType(JobTypeID)
);

CREATE TABLE JobApplyTransaction (
    JobVacancyID CHAR(36),
    StudentID CHAR(36),
    Notes VARCHAR(100),
    Status VARCHAR(10),
    PRIMARY KEY (JobVacancyID, StudentID),
    FOREIGN KEY (JobVacancyID) REFERENCES JobVacancy(JobVacancyID),
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID)
);

CREATE TABLE JobVacancyResponsibility (
    JobVacancyID CHAR(36),
    ResponsibilityDetail VARCHAR(100),
    PRIMARY KEY (JobVacancyID, ResponsibilityDetail),
    FOREIGN KEY (JobVacancyID) REFERENCES JobVacancy(JobVacancyID)
);

CREATE TABLE JobVacancySkill (
    JobVacancyID CHAR(36),
    SkillID CHAR(36),
    SkillDetail VARCHAR(100) NOT NULL,
    PRIMARY KEY (JobVacancyID, SkillID),
    FOREIGN KEY (JobVacancyID) REFERENCES JobVacancy(JobVacancyID),
    FOREIGN KEY (SkillID) REFERENCES Skill(SkillID)
);

CREATE TABLE ExtrasHeader (
    JobVacancyID CHAR(36),
    ExtrasTitle VARCHAR(255),
    PRIMARY KEY (JobVacancyID, ExtrasTitle),
    FOREIGN KEY (JobVacancyID) REFERENCES JobVacancy(JobVacancyID)
);

CREATE TABLE ExtrasDetail (
    JobVacancyID CHAR(36),
    ExtrasTitle VARCHAR(255),
    ExtrasDetail VARCHAR(255),
    PRIMARY KEY (JobVacancyID, ExtrasTitle, ExtrasDetail),
    FOREIGN KEY (JobVacancyID) REFERENCES JobVacancy(JobVacancyID)
);




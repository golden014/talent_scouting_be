CREATE TABLE MsCompany (
    ID CHAR(36) PRIMARY KEY,            -- UUID stored as a string with 36 characters
    Name VARCHAR(255) NOT NULL,        -- Company name, not nullable
    LogoURL VARCHAR(2048),             -- URL or path to the company logo
    Description TEXT,                  -- Company description, can be of variable length
    Location VARCHAR(255),             -- Company location
    UNIQUE KEY UQ_Name (Name),        -- Unique constraint on the Name column
    CONSTRAINT CK_Description_NotEmpty CHECK (CHAR_LENGTH(Description) > 0 OR Description IS NULL)  -- Check constraint for Description
);


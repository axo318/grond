-- Create the pipeline table
CREATE TABLE pipeline (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    description TEXT,
    instructions TEXT NOT NULL,
    repository_url TEXT
);

-- Create the build table
CREATE TABLE build (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    pipeline_id UUID NOT NULL,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP,
    status VARCHAR(255) NOT NULL,
    instructions TEXT NOT NULL,
    repository_url TEXT,
    FOREIGN KEY (pipeline_id) REFERENCES pipeline(id)
);

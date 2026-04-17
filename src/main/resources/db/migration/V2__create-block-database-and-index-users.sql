CREATE TABLE Blocks ( block_id UUID PRIMARY KEY DEFAULT gen_random_uuid(), block_name VARCHAR(255) NOT NULL, block_floor_quant INTEGER NOT NULL, block_units_per_floor INTEGER NOT NULL, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP );

CREATE INDEX idx_blocks_block_name ON blocks(block_name);

CREATE TABLE Units ( unit_id UUID PRIMARY KEY DEFAULT gen_random_uuid(), unit_name VARCHAR(255) NOT NULL, unit_block_id UUID NOT NULL, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, FOREIGN KEY (unit_block_id) REFERENCES blocks(block_id) ON DELETE CASCADE );

CREATE INDEX idx_units_block_id ON units(unit_block_id);

CREATE TABLE Workers_Blocks_relation (worker_id UUID NOT NULL, block_id UUID NOT NULL, PRIMARY KEY (worker_id, block_id), FOREIGN KEY (worker_id) REFERENCES Users(user_id) ON DELETE CASCADE, FOREIGN KEY (block_id) REFERENCES blocks(block_id) ON DELETE CASCADE);

CREATE TABLE Users_Units_relation (user_id UUID NOT NULL, unit_id UUID NOT NULL, PRIMARY KEY (user_id, unit_id), FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE, FOREIGN KEY (unit_id) REFERENCES Units(unit_id) ON DELETE CASCADE);
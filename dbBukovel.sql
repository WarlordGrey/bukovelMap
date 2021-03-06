
DROP TABLE IF EXISTS DEFAULT_SCHEMA.NeighborList;
DROP TABLE IF EXISTS DEFAULT_SCHEMA.NeighborNodeData;
DROP TABLE IF EXISTS DEFAULT_SCHEMA.RoadData;
DROP TABLE IF EXISTS DEFAULT_SCHEMA.NodeData;

CREATE TABLE DEFAULT_SCHEMA.NodeData (
       idNodeData INTEGER NOT NULL DEFAULT 1 CONSTRAINT PK_NODEDATA PRIMARY KEY AUTOINCREMENT
     , latitude REAL
     , longitude REAL
);

CREATE TABLE DEFAULT_SCHEMA.RoadData (
       idRoadData INTEGER NOT NULL DEFAULT 1 CONSTRAINT PK_ROADDATA PRIMARY KEY AUTOINCREMENT
     , level INTEGER DEFAULT 0
     , distance REAL DEFAULT 0
     , isPassable INTEGER DEFAULT 1
);

CREATE TABLE DEFAULT_SCHEMA.NeighborNodeData (
       idNeighborNodeData INTEGER NOT NULL DEFAULT 1 CONSTRAINT PK_NEIGHBORNODEDATA PRIMARY KEY AUTOINCREMENT
     , idRoadData INTEGER NOT NULL DEFAULT 1
     , idNodeData INTEGER NOT NULL DEFAULT 1
);

CREATE TABLE DEFAULT_SCHEMA.NeighborList (
       id INTEGER NOT NULL DEFAULT 1 CONSTRAINT PK_NEIGHBORLIST PRIMARY KEY AUTOINCREMENT
     , idNodeData INTEGER NOT NULL DEFAULT 1
     , idNeighborNodeData INTEGER NOT NULL DEFAULT 1
);

ALTER TABLE DEFAULT_SCHEMA.NodeData
  ADD CONSTRAINT PK_NODEDATA
      PRIMARY KEY (idNodeData);

ALTER TABLE DEFAULT_SCHEMA.RoadData
  ADD CONSTRAINT PK_ROADDATA
      PRIMARY KEY (idRoadData);

ALTER TABLE DEFAULT_SCHEMA.NeighborNodeData
  ADD CONSTRAINT PK_NEIGHBORNODEDATA
      PRIMARY KEY (idNeighborNodeData);

ALTER TABLE DEFAULT_SCHEMA.NeighborList
  ADD CONSTRAINT PK_NEIGHBORLIST
      PRIMARY KEY (id);

ALTER TABLE DEFAULT_SCHEMA.NeighborNodeData
  ADD CONSTRAINT FK_NeighborNodeData_1
      FOREIGN KEY (idRoadData)
      REFERENCES DEFAULT_SCHEMA.RoadData (idRoadData);

ALTER TABLE DEFAULT_SCHEMA.NeighborNodeData
  ADD CONSTRAINT FK_NeighborNodeData_2
      FOREIGN KEY (idNodeData)
      REFERENCES DEFAULT_SCHEMA.NodeData (idNodeData);

ALTER TABLE DEFAULT_SCHEMA.NeighborList
  ADD CONSTRAINT FK_NeighborList_1
      FOREIGN KEY (idNodeData)
      REFERENCES DEFAULT_SCHEMA.NodeData (idNodeData);

ALTER TABLE DEFAULT_SCHEMA.NeighborList
  ADD CONSTRAINT FK_NeighborList_2
      FOREIGN KEY (idNeighborNodeData)
      REFERENCES DEFAULT_SCHEMA.NeighborNodeData (idNeighborNodeData);


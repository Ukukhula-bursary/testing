CREATE TABLE [dbo].[StudentAllocation]
(
  [ID] INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
  [StudentID] INT NOT NULL,
  [Amount] MONEY NOT NULL,
  [Year] INT NOT NULL
);
GO

ALTER TABLE [dbo].[YearlyStudentAllocation]
  ADD CONSTRAINT [FK_YearlyStudentAllocation_Student_StudentID]
      FOREIGN KEY ([StudentID])
      REFERENCES [dbo].[Student]([StudentID])
GO
/*
	Copyright ©2002-2017 Daniel P. Bullington (dpbullington@gmail.com)
	Distributed under the MIT license: http://www.opensource.org/licenses/mit-license.php
*/


SET NOCOUNT ON
GO


CREATE SCHEMA [Messaging]
GO


CREATE SCHEMA [Tracking]
GO


CREATE SCHEMA [Monitoring]
GO


CREATE TABLE [Messaging].[MessageState]
(
	[MessageStateId] [uniqueidentifier] NOT NULL,

	[MessageStateName] [nvarchar](255) NOT NULL,
	[MessageStateDesc] [nvarchar](4000) NULL,
	
	CONSTRAINT [pk_MessageState] PRIMARY KEY
	(
		[MessageStateId]
	),

	CONSTRAINT [uk_MessageState_MessageStateName] UNIQUE
	(
		[MessageStateName]
	)
)
GO


INSERT INTO [Messaging].[MessageState]
	([MessageStateId], [MessageStateName], [MessageStateDesc])
	VALUES
	('00000000-0000-0000-0000-000000000000', 'Unknown', 'The message is in an unknown or invalid state.');
INSERT INTO [Messaging].[MessageState]
	([MessageStateId], [MessageStateName], [MessageStateDesc])
	VALUES
	('987B97EF-D88F-4A3A-A5C8-872A0F1E6AA4', 'Created', 'The message has been persisted to the dropbox.');
INSERT INTO [Messaging].[MessageState]
	([MessageStateId], [MessageStateName], [MessageStateDesc])
	VALUES
	('68416F11-941D-4B16-A30C-44EAF0E1E247', 'Suspended', 'Processing was attempted on the message but a fault occured.');
INSERT INTO [Messaging].[MessageState]
	([MessageStateId], [MessageStateName], [MessageStateDesc])
	VALUES
	('{71A78253-F860-4F0A-B6CD-DA13668B0A58}', 'Processed', 'Processing completed successfully and the message is eligible for archival.');
INSERT INTO [Messaging].[MessageState]
	([MessageStateId], [MessageStateName], [MessageStateDesc])
	VALUES
	('{818DDFE9-5DEF-44D2-8DE1-8B8E9C746DA1}', 'Archived', 'Archiving was perfomed on the message text; this record is now a stub.');
GO


CREATE TABLE [Messaging].[MessageSchema]
(
	[MessageSchemaId] [uniqueidentifier] NOT NULL,

	[MessageSchemaName] [nvarchar](255) NOT NULL,
	[MessageSchemaDesc] [nvarchar](4000) NULL,
	
	CONSTRAINT [pk_MessageSchema] PRIMARY KEY
	(
		[MessageSchemaId]
	),

	CONSTRAINT [uk_MessageSchema_MessageSchemaName] UNIQUE
	(
		[MessageSchemaName]
	)
)
GO


INSERT INTO [Messaging].[MessageSchema]
	([MessageSchemaId], [MessageSchemaName], [MessageSchemaDesc])
	VALUES
	('00000000-0000-0000-0000-000000000000', 'Unknown', 'The message schema unknown or invalid.');
GO


CREATE TABLE [Messaging].[Dropbox]
(
	[DropboxId] [uniqueidentifier] NOT NULL,

	[ContentEncoding] [nvarchar](255) NULL,
	[ContentLanguage] [nvarchar](255) NULL,
	[ContentLength] [bigint] NOT NULL,
	[ContentLocation] [nvarchar](255) NULL,
	[ContentHash] [nvarchar](255) NULL,
	[ContentDisposition] [nvarchar](255) NULL,
	[ContentRange] [nvarchar](255) NULL,
	[ContentType] [nvarchar](255) NULL,

	[MessageStateId] [uniqueidentifier] NOT NULL,
	[MessageSchemaId] [uniqueidentifier] NOT NULL,
	[MessageText] [ntext] NULL,
		
	[CreationTimestamp] [datetime] NOT NULL,
	[ModificationTimestamp] [datetime] NOT NULL,
	[LogicalDelete] [bit] NOT NULL DEFAULT(0),
	
	CONSTRAINT [pk_Dropbox] PRIMARY KEY
	(
		[DropboxId]
	),

	CONSTRAINT [fk_Dropbox_MessageState] FOREIGN KEY
	(
		[MessageStateId]
	)
	REFERENCES [Messaging].[MessageState]
	(
		[MessageStateId]
	),

	CONSTRAINT [fk_Dropbox_MessageSchema] FOREIGN KEY
	(
		[MessageSchemaId]
	)
	REFERENCES [Messaging].[MessageSchema]
	(
		[MessageSchemaId]
	)
)
GO


CREATE TABLE [Messaging].[DropboxMetadata]
(
	[DropboxId] [uniqueidentifier] NOT NULL,
	[MetadataKey] [nvarchar](255) NOT NULL,
	[MetadataOrdinal] [tinyint] NOT NULL,
	[MetadataValue] [ntext] NOT NULL,
	
	CONSTRAINT [pk_DropboxMetadata] PRIMARY KEY
	(
		[DropboxId],
		[MetadataOrdinal],
		[MetadataKey]
	),

	CONSTRAINT [fk_DropboxMetadata_Dropbox] FOREIGN KEY
	(
		[DropboxId]
	)
	REFERENCES [Messaging].[Dropbox]
	(
		[DropboxId]
	)
)
GO
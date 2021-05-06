@echo off

REM
REM	Copyright ©2002-2014 Daniel Bullington (dpbullington@gmail.com)
REM	Distributed under the MIT license: http://www.opensource.org/licenses/mit-license.php
REM

set TEXTMETAL_EXE=..\..\lib\TextMetal_bin\TextMetal.exe

SET SRC_DIR=..\..\src
SET BUILD_FLAVOR_DIR=Debug
SET BUILD_TOOL_CFG=Debug

set PACKAGE_DIR=.\output\.sql_gen
set PACKAGE_DIR_EXISTS=%PACKAGE_DIR%\nul

set OBFUSCATION_CONFIGURATION_DATABASE_NAME=Ox_Config
set OBFUSCATION_CONFIGURATION_FILE_PATH=Ox_textmetal_ods_dev.json

set OBFUSCATION_SOURCE_DATABASE_NAME=textmetal_ods_dev
set OBFUSCATION_DESTINATION_DATABASE_NAME=Ox_textmetal_ods_dev


set SOURCE_ADO_NET_CONNECTION_STRING=Server=(local);Database=%OBFUSCATION_SOURCE_DATABASE_NAME%;Integrated Security=SSPI;
set DESTINATION_ADO_NET_CONNECTION_STRING=Server=(local);Database=%OBFUSCATION_DESTINATION_DATABASE_NAME%;Integrated Security=SSPI;

:pkgDir

IF NOT EXIST %PACKAGE_DIR_EXISTS% GOTO noPkgDir
goto delPkgDir

:noPkgDir
@echo Creating output directory...
mkdir "%PACKAGE_DIR%"
IF %ERRORLEVEL% NEQ 0 goto pkgError
goto pkgBuild

:delPkgDir
@echo Cleaning output directory...
del "%PACKAGE_DIR%\*.*" /Q /S
rem IF %ERRORLEVEL% NEQ 0 goto pkgError
goto pkgBuild


:pkgBuild

echo *** sql_codegen_execute1 ***
"%TEXTMETAL_EXE%" ^
	-templatefile:"sqlserver_obfuscation_tables_template.xml" ^
	-sourcefile:"%SOURCE_ADO_NET_CONNECTION_STRING%" ^
	-basedir:"%PACKAGE_DIR%" ^
	-sourcestrategy:"TextMetal.Framework.SourceModel.DatabaseSchema.Sql.SqlSchemaSourceStrategy, TextMetal.Framework.SourceModel" ^
	-strict:"true" ^
	-property:"ObfuscationDestinationDatabaseName=%OBFUSCATION_DESTINATION_DATABASE_NAME%" ^
	-property:"ConnectionType=System.Data.SqlClient.SqlConnection, System.Data, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089" ^
	-property:"DataSourceTag=net.sqlserver"
IF %ERRORLEVEL% NEQ 0 goto pkgError


echo *** sql_codegen_execute2 ***
"%TEXTMETAL_EXE%" ^
	-templatefile:"sqlserver_obfuscation_triggers_template.xml" ^
	-sourcefile:"%SOURCE_ADO_NET_CONNECTION_STRING%" ^
	-basedir:"%PACKAGE_DIR%" ^
	-sourcestrategy:"TextMetal.Framework.SourceModel.DatabaseSchema.Sql.SqlSchemaSourceStrategy, TextMetal.Framework.SourceModel" ^
	-strict:"true" ^
	-property:"ObfuscationConfigurationDatabaseName=%OBFUSCATION_CONFIGURATION_DATABASE_NAME%" ^
	-property:"ObfuscationDestinationDatabaseName=%OBFUSCATION_DESTINATION_DATABASE_NAME%" ^
	-property:"ObfuscationConfigurationFilePath=%OBFUSCATION_CONFIGURATION_FILE_PATH%" ^
	-property:"ConnectionType=System.Data.SqlClient.SqlConnection, System.Data, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089" ^
	-property:"DataSourceTag=net.sqlserver"
IF %ERRORLEVEL% NEQ 0 goto pkgError


echo *** sql_codegen_execute3 ***
"%TEXTMETAL_EXE%" ^
	-templatefile:"sqlserver_obfuscation_drops_template.xml" ^
	-sourcefile:"%DESTINATION_ADO_NET_CONNECTION_STRING%" ^
	-basedir:"%PACKAGE_DIR%" ^
	-sourcestrategy:"TextMetal.Framework.SourceModel.DatabaseSchema.Sql.SqlSchemaSourceStrategy, TextMetal.Framework.SourceModel" ^
	-strict:"true" ^
	-property:"ConnectionType=System.Data.SqlClient.SqlConnection, System.Data, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089" ^
	-property:"DataSourceTag=net.sqlserver"
IF %ERRORLEVEL% NEQ 0 goto pkgError


goto pkgSuccess


:pkgError
echo An error occured.
pause > nul
goto :eof

:pkgSuccess
echo Completed successfully.
goto :eof

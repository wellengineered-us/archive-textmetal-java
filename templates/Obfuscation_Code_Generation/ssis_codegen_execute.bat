@echo off

REM
REM	Copyright ©2002-2014 Daniel Bullington (dpbullington@gmail.com)
REM	Distributed under the MIT license: http://www.opensource.org/licenses/mit-license.php
REM

set TEXTMETAL_EXE=..\..\lib\TextMetal_bin\TextMetal.exe
set SSISSRCTODSTPKGGEN_EXE=..\..\src\TextMetal.SqlServer.SsisSrcToDstPkgGenTool\bin\Debug\SsisSrcToDstPkgGenTool.exe

set PACKAGE_DIR=.\output\.ssis_gen\config
set PACKAGE_DIR_EXISTS=%PACKAGE_DIR%\nul

set SOURCE_FILE=textmetal_ods_dev_ssisgen_cfg.txt
set DESTINATION_SERVER_NAME=(local)
set DESTINATION_DATABASE_PREFIX=Ox_

set SSIS_PACKAGE_DIR=.\output\.ssis_gen\final

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

echo *** ssis_codegen_execute1 ***
"%TEXTMETAL_EXE%" ^
	-templatefile:"ssis_srctodstpkggentool_config_template.xml" ^
	-sourcefile:"%SOURCE_FILE%" ^
	-basedir:"%PACKAGE_DIR%" ^
	-sourcestrategy:"TextMetal.Framework.SourceModel.Primative.TextSourceStrategy, TextMetal.Framework.SourceModel" ^
	-strict:"true" ^
	-debug:"false" ^
	-property:"DestinationServerName=%DESTINATION_SERVER_NAME%" ^
	-property:"DestinationDatabasePrefix=%DESTINATION_DATABASE_PREFIX%" ^
	-property:"FirstRowIsHeader=true" ^
	-property:"FieldDelimiter=|"
IF %ERRORLEVEL% NEQ 0 goto pkgError


echo *** ssis_codegen_execute2 ***
"%SSISSRCTODSTPKGGEN_EXE%" ^
	-sourcefile:"%PACKAGE_DIR%\SsisSrcToDstPkgGen.config.g.json" ^
	-basedir:"%SSIS_PACKAGE_DIR%"
IF %ERRORLEVEL% NEQ 0 goto pkgError


goto pkgSuccess


:pkgError
echo An error occured.
pause > nul
goto :eof

:pkgSuccess
echo Completed successfully.
goto :eof

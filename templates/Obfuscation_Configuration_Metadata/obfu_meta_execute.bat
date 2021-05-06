@echo off

set TEXTMETAL_EXE=..\..\lib\TextMetal_bin\TextMetal.exe

set ADO_NET_CONNECTION_STRING=Server=(local);Database=Ox_Config;Integrated Security=SSPI;

set OUTPUT_FILE_PREFIX=Ox_

echo *** obfu_meta_execute ***
"%TEXTMETAL_EXE%" ^
	-templatefile:"obfu_meta_template.xml" ^
	-sourcefile:"obfu_meta_data_source.xml" ^
	-basedir:".\output\.obfu_meta\config" ^
	-sourcestrategy:"TextMetal.Framework.SourceModel.Primative.SqlDataSourceStrategy, TextMetal.Framework.SourceModel" ^
	-strict:"true" ^
	-debug:"false" ^
	-property:"OutputFilePrefix=%OUTPUT_FILE_PREFIX%" ^
	-property:"ConnectionType=System.Data.SqlClient.SqlConnection, System.Data, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089" ^
	-property:"ConnectionString=%ADO_NET_CONNECTION_STRING%"
IF %ERRORLEVEL% NEQ 0 goto pkgError

	
goto pkgSuccess


:pkgError
echo An error occured.
pause > nul
goto :eof

:pkgSuccess
echo Completed successfully.
pause > nul
goto :eof

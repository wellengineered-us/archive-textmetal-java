/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.naming;

public interface CanonicalNamingStrategy
{
	String getCamelCase(String value);

	String getConstantCase(String value);

	String getPascalCase(String value);

	String getPluralForm(String value);

	String getSingularForm(String value);
}

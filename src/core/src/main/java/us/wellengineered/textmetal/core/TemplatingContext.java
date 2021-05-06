/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.core;

import us.wellengineered.textmetal.tokenization.WildcardTokenReplacementStrategy;
import us.wellengineered.textmetal.xmldialect.XmlName;

public interface TemplatingContext
{
	void addReference(Class<?> xmlObjectClass);

	void addReference(XmlName xmlName, Class<?> xmlObjectClass);

	void clearReferences();

	WildcardTokenReplacementStrategy getWildcardTokenReplacementStrategy();

	WildcardTokenReplacementStrategy getWildcardTokenReplacementStrategy(boolean strict);

	boolean launchDebugger();

	void setReference(Class<?> xmlObjectClass);
}

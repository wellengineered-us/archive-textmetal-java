/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.inputoutput;

import us.wellengineered.solder.polyfills.Disposable;

import java.io.Reader;
import java.util.List;
import java.util.Map;

public interface InputMechanism extends Disposable
{
	Reader getCurrentTextReader();

	Object /*Assembly*/ loadAssembly(String assemblyName);

	String loadContent(String contentName);

	Object loadSource(String sourceName, Map<String, List<String>> properties);

	Object /*TemplateXmlObject*/ loadTemplate(String templateName);
}

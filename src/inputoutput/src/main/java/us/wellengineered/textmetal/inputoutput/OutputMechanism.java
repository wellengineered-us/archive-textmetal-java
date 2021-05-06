/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.inputoutput;

import us.wellengineered.solder.polyfills.Disposable;

import java.io.Writer;
import java.util.List;
import java.util.Map;

public interface OutputMechanism extends Disposable
{
	Writer getCurrentTextWriter();

	Writer getLogTextWriter();

	void enterScope(String scopeName, boolean appendMode, Object /*Encoding*/ encoding);

	void leaveScope(String scopeName);

	void writeObject(Object obj, String objectName);
}

/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.hosting.email;

import us.wellengineered.textmetal.hosting.TextMetalHost;

public interface TextMetalEmailHost extends TextMetalHost
{
	EmailMessage host(boolean strictMatching, EmailTemplate emailTemplate, Object modelObject);
}

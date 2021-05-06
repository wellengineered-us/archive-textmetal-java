/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.hosting.email;

public final class EmailTemplate
{
	public EmailTemplate()
	{
	}

	private Object blindCarbonCopyXml;
	private Object bodyXml;
	private Object carbonCopyXml;
	private Object fromXml;
	private boolean isBodyHtml;
	private Object replyToXml;
	private Object senderXml;
	private Object subjectXml;
	private Object toXml;

	public Object getBlindCarbonCopyXml()
	{
		return this.blindCarbonCopyXml;
	}

	public void setBlindCarbonCopyXml(Object blindCarbonCopyXml)
	{
		this.blindCarbonCopyXml = blindCarbonCopyXml;
	}

	public Object getBodyXml()
	{
		return this.bodyXml;
	}

	public void setBodyXml(Object bodyXml)
	{
		this.bodyXml = bodyXml;
	}

	public Object getCarbonCopyXml()
	{
		return this.carbonCopyXml;
	}

	public void setCarbonCopyXml(Object carbonCopyXml)
	{
		this.carbonCopyXml = carbonCopyXml;
	}

	public Object getFromXml()
	{
		return this.fromXml;
	}

	public void setFromXml(Object fromXml)
	{
		this.fromXml = fromXml;
	}

	public boolean isBodyHtml()
	{
		return this.isBodyHtml;
	}

	public void setBodyHtml(boolean bodyHtml)
	{
		this.isBodyHtml = bodyHtml;
	}

	public Object getReplyToXml()
	{
		return this.replyToXml;
	}

	public void setReplyToXml(Object replyToXml)
	{
		this.replyToXml = replyToXml;
	}

	public Object getSenderXml()
	{
		return this.senderXml;
	}

	public void setSenderXml(Object senderXml)
	{
		this.senderXml = senderXml;
	}

	public Object getSubjectXml()
	{
		return this.subjectXml;
	}

	public void setSubjectXml(Object subjectXml)
	{
		this.subjectXml = subjectXml;
	}

	public Object getToXml()
	{
		return this.toXml;
	}

	public void setToXml(Object toXml)
	{
		this.toXml = toXml;
	}
}

/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.hosting.email;

public final class EmailMessage
{
	public EmailMessage()
	{
	}

	private String blindCarbonCopy;
	private String body;
	private String carbonCopy;
	private String from;
	private boolean isBodyHtml;
	private String replyTo;
	private String sender;
	private String subject;
	private String to;

	public String getBlindCarbonCopy()
	{
		return this.blindCarbonCopy;
	}

	public void setBlindCarbonCopy(String blindCarbonCopy)
	{
		this.blindCarbonCopy = blindCarbonCopy;
	}

	public String getBody()
	{
		return this.body;
	}

	public void setBody(String body)
	{
		this.body = body;
	}

	public String getCarbonCopy()
	{
		return this.carbonCopy;
	}

	public void setCarbonCopy(String carbonCopy)
	{
		this.carbonCopy = carbonCopy;
	}

	public String getFrom()
	{
		return this.from;
	}

	public void setFrom(String from)
	{
		this.from = from;
	}

	public boolean isBodyHtml()
	{
		return this.isBodyHtml;
	}

	public void setBodyHtml(boolean bodyHtml)
	{
		this.isBodyHtml = bodyHtml;
	}

	public String getReplyTo()
	{
		return this.replyTo;
	}

	public void setReplyTo(String replyTo)
	{
		this.replyTo = replyTo;
	}

	public String getSender()
	{
		return this.sender;
	}

	public void setSender(String sender)
	{
		this.sender = sender;
	}

	public String getSubject()
	{
		return this.subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getTo()
	{
		return this.to;
	}

	public void setTo(String to)
	{
		this.to = to;
	}
}
